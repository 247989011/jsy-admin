package com.macro.mall.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.mapper.*;
import com.macro.mall.common.model.*;
import com.macro.mall.portal.component.CancelOrderSender;
import com.macro.mall.portal.constant.AppOprRoleConst;
import com.macro.mall.portal.constant.OmsOrderConst;
import com.macro.mall.portal.dao.PortalOrderDao;
import com.macro.mall.portal.dao.PortalOrderItemDao;
import com.macro.mall.portal.dao.PortalProductDao;
import com.macro.mall.portal.dao.SmsCouponHistoryDao;
import com.macro.mall.portal.domain.*;
import com.macro.mall.portal.dto.*;
import com.macro.mall.portal.service.*;
import com.macro.mall.portal.service.common.OmsPortalPromotionCommon;
import com.macro.mall.portal.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 前台订单管理Service
 * Created by macro on 2018/8/30.
 */
@Service
@Slf4j
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {
    //会员相关
    @Autowired
    private UmsMemberRegisterService memberService;
    @Autowired
    private UmsMemberReceiveAddressService memberReceiveAddressService;
    @Autowired
    private UmsMemberCouponService memberCouponService;
    @Autowired
    private SmsCouponHistoryMapper couponHistoryMapper;
    @Autowired
    private SmsCouponHistoryDao couponHistoryDao;

    //订单相关
    @Autowired
    private OmsOrderMapper orderMapper;
    @Autowired
    private OmsCartItemService cartItemService;
    @Autowired
    private UmsIntegrationConsumeSettingMapper integrationConsumeSettingMapper;
    @Autowired
    private PortalOrderDao portalOrderDao;
    @Autowired
    private OmsOrderSettingMapper orderSettingMapper;
    @Autowired
    private  OmsOrderOperateHistoryMapper orderOperateHistoryMapper;

    //订单商品明细相关
    @Autowired
    private OmsOrderItemMapper orderItemMapper;
    @Autowired
    private PortalOrderItemDao orderItemDao;
    @Autowired
    private  OmsOrderItemPhysicalPicMapper orderItemPhysicalPicMapper;

    //商品相关
    @Autowired
    private PmsSkuStockMapper skuStockMapper;
    @Autowired
    private PortalProductDao portalProductDao;
    @Autowired
    private  PmsProductMapper pmsProductMapper;

    //订单发货相关
    @Autowired
    private CancelOrderSender cancelOrderSender;

    //物流相关
    @Autowired
    private LmsLogisticsModeMapper logisticsModeMapper;
    @Autowired
    private  LmsLogisticsChargeMapper logisticsChargeMapper;
    @Autowired
    private LmsLogisticsTemplateMapper logisticsTemplateMapper;
    @Autowired
    private OmsOrderLogisticsTraceLogMapper orderLogisticsTraceLogMapper;

    //支付相关
    @Autowired
    private PaymsPayModeMapper payModeMapper;
    @Autowired
    private  PaymsPayTemplateMapper payTemplateMapper;
    @Autowired
    private  PaymsPayTemplateModeRelationMapper payTemplateModeRelationMapper;

    //营销相关
    @Autowired
    private  SmsCouponMapper couponMapper;
    @Autowired
    private  SmsCouponProductRelationMapper couponProductRelationMapper;
    @Autowired
    private  SmsMarketingActivityProductRelationMapper marketingActivityProductRelationMapper;
    @Autowired
    private  SmsMarketingActivitiesMapper marketingActivitiesMapper;
    @Autowired
    private  SmsMarketingActivityRuleMapper marketingActivityRuleMapper;
    @Autowired
    private OmsPortalPromotionCommon promotionCommon;

    //redis服务相关
    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.orderId}")
    private String REDIS_KEY_PREFIX_ORDER_ID;


    @Override
    public OmsOrder getOrder(Long orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public OmsPortalOrderBasicInfoVo getOrderBasicInfo(Long orderId) {
        //定义返回值
        OmsPortalOrderBasicInfoVo orderBasicInfoVo = new OmsPortalOrderBasicInfoVo();

        //查询订单信息
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        if(order == null){
            log.error("查询订单基本信息失败{}", orderId);
            return  null;
        }
        BeanUtils.copyProperties(order, orderBasicInfoVo);

        //查询订单的商品列表
        OmsOrderItemExample itemExample = new OmsOrderItemExample();
        itemExample.createCriteria().andOrderIdEqualTo(orderId);
        List<OmsOrderItem>  omsOrderItemList =  orderItemMapper.selectByExample(itemExample);
        if(omsOrderItemList == null){
            log.error("查询订单的商品列表{}", itemExample.toString());
            return null;
        }
        orderBasicInfoVo.setOrderItemList(omsOrderItemList);

        //返回变量
        return orderBasicInfoVo;
    }

    /**
     * 大而全的订单详情接口
     * @param orderId
     * @return
     */
    @Override
    public OmsPortalOrderDetailVo getOrderDetail(Long orderId) {
        //定义返回值变量
        OmsPortalOrderDetailVo orderDetailDto = new OmsPortalOrderDetailVo();

        //获取订单信息
        OmsOrder order= orderMapper.selectByPrimaryKey(orderId);
        if(order == null){
            return null;
        }
        BeanUtils.copyProperties(order, orderDetailDto);

        //获取支付方式
        PaymsPayMode payMode = payModeMapper.selectByPrimaryKey(order.getUsedPayModeId());
        if(payMode == null){
            return null;
        }
        orderDetailDto.setPayMode(payMode);

        //获取支付模板
        PaymsPayTemplate payTemplate = payTemplateMapper.selectByPrimaryKey(order.getOptionPayTemplateId());
        if(payTemplate == null){
            return null;
        }
        orderDetailDto.setPayTemplate(payTemplate);

        //获取物流方式
        LmsLogisticsMode logisticsMode = logisticsModeMapper.selectByPrimaryKey(order.getUsedPayModeId());
        if(logisticsMode == null){
            return null;
        }
        orderDetailDto.setLogisticsMode(logisticsMode);

        //获取物流模板
        LmsLogisticsTemplate logisticsTemplate = logisticsTemplateMapper.selectByPrimaryKey(order.getOptionLogisticsTemplateId());
        if(logisticsTemplate == null){
            return null;
        }
        orderDetailDto.setLmsLogisticsTemplate(logisticsTemplate);

        //获取订单的全场通用的优惠劵信息
        SmsCoupon coupon = couponMapper.selectByPrimaryKey(order.getCouponId());
        if(coupon != null){
            orderDetailDto.setCoupon(coupon);
        }

        //获取订单的全场通用的营销活动信息
        SmsMarketingActivities marketingActivities = marketingActivitiesMapper.selectByPrimaryKey(order.getMarketingActivityId());
        if(marketingActivities != null){
            orderDetailDto.setMarketingActivities(marketingActivities);
        }

        //获取订单的商品及其优惠详情
        List<OmsPortalOrderItemDetailVo> portalOrderItemDetailDtoList = new ArrayList<OmsPortalOrderItemDetailVo>();
        OmsOrderItemExample orderItemExample = new OmsOrderItemExample();
        orderItemExample.createCriteria().andProductIdEqualTo(orderId);
        List<OmsOrderItem>  omsOrderItemList = orderItemMapper.selectByExample(orderItemExample);
        for (OmsOrderItem e : omsOrderItemList) {
            //定义元素
            OmsPortalOrderItemDetailVo portalOrderItemDetailDto = new OmsPortalOrderItemDetailVo();

            //商品详情
            BeanUtils.copyProperties(e, portalOrderItemDetailDto);

            //根据商品ID获取商品的优惠劵信息
            List<SmsCoupon> couponList = new ArrayList<SmsCoupon>();
            SmsCouponProductRelationExample couponProductRelationExample = new SmsCouponProductRelationExample();
            couponProductRelationExample.createCriteria().andProductIdEqualTo(e.getProductId());
            List<SmsCouponProductRelation>  couponProductRelationList =
                    couponProductRelationMapper.selectByExample(couponProductRelationExample);
            if(couponProductRelationList != null){
                for (SmsCouponProductRelation e1 : couponProductRelationList) {
                    SmsCoupon coupon1 = couponMapper.selectByPrimaryKey(e1.getCouponId());
                    couponList.add(coupon1);
                }
            }
            portalOrderItemDetailDto.setCouponList(couponList);

            //根据商品ID获取商品的营销活动信息
            List<OmsPortalMarketingActivityDo>  marketingActivitiesDtoList = new ArrayList<OmsPortalMarketingActivityDo>();
            SmsMarketingActivityProductRelationExample marketingActivityProductRelationExample =
                    new SmsMarketingActivityProductRelationExample();
            marketingActivityProductRelationExample.createCriteria().andProductIdEqualTo(e.getProductId());
            List<SmsMarketingActivityProductRelation> marketingActivityProductRelationList =
                    marketingActivityProductRelationMapper.selectByExample(marketingActivityProductRelationExample);
            for (SmsMarketingActivityProductRelation e2 : marketingActivityProductRelationList) {
                //定义
                OmsPortalMarketingActivityDo marketingActivityDto = new OmsPortalMarketingActivityDo();
                //获取活动信息
                SmsMarketingActivities marketingActivities1 =
                        marketingActivitiesMapper.selectByPrimaryKey(e2.getActivityId());
                BeanUtils.copyProperties(marketingActivities1, marketingActivityDto);

                //获取活动规则信息
                SmsMarketingActivityRuleExample ruleExample = new SmsMarketingActivityRuleExample();
                ruleExample.createCriteria().andActivityIdEqualTo(e2.getActivityId());
                List<SmsMarketingActivityRule> ruleList = marketingActivityRuleMapper.selectByExample(ruleExample);
                if(ruleList == null){
                    return null;
                }
                marketingActivityDto.setSmsMarketingActivityRule(ruleList.get(0));
                marketingActivitiesDtoList.add(marketingActivityDto);
            }
            portalOrderItemDetailDto.setMarketingActivityDtoList(marketingActivitiesDtoList);

            //拼接元素
            portalOrderItemDetailDtoList.add(portalOrderItemDetailDto);
        }
        orderDetailDto.setPortalOrderItemDetailDtoList(portalOrderItemDetailDtoList);

        //返回查询结果
        return orderDetailDto;
    }

    @Override
    public List<OmsOrder> page(OmsOrderQueryParamDto queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return portalOrderDao.getList(queryParam);
    }

    @Override
    public List<OmsPortalOrderListVo> pageBasicInfo(OmsOrderQueryParamDto queryParam, Integer pageSize, Integer pageNum) {
        //TODO 简单实现,不考虑性能
        //定义返回变量
        List<OmsPortalOrderListVo>  orderBasicInfoVoList = new ArrayList<OmsPortalOrderListVo>();

        PageHelper.startPage(pageNum, pageSize);
        List<OmsOrder> orderList = portalOrderDao.getList(queryParam);
        if(orderList == null || orderList.size() == 0){
            return null;
        }

        for (OmsOrder order : orderList) {
            OmsPortalOrderListVo orderBasicInfoVo = new OmsPortalOrderListVo();

            //获取订单第1个商品
            OmsOrderItemExample  itemExample = new OmsOrderItemExample();
            itemExample.createCriteria().andOrderIdEqualTo(order.getId());
            List<OmsOrderItem> orderItemList = orderItemMapper.selectByExample(itemExample);
            if(orderItemList == null || orderItemList.size() == 0){
                return null;
            }
            BeanUtils.copyProperties(order, orderBasicInfoVo);

            //获取订单第1个商品主图的路径
            PmsProduct product = pmsProductMapper.selectByPrimaryKey(orderItemList.get(0).getProductId());
            if(product == null){
                return null;
            }

            orderBasicInfoVo.setFirstProductId(product.getId());
            orderBasicInfoVo.setFirstProductFullPicPath(product.getPic());
            orderBasicInfoVoList.add(orderBasicInfoVo);
        }

        return orderBasicInfoVoList;
    }

    @Override
    public List<OmsPortalDeliverOrderVo> pageDeliverOrderDetail(OmsOrderQueryParamDto queryParam, Integer pageSize, Integer pageNum) {
        //分页设置
        PageHelper.startPage(pageNum, pageSize);

        //定义返回值
        List<OmsPortalDeliverOrderVo>  deliverOrderVoList = new ArrayList<OmsPortalDeliverOrderVo>();

        //查询符合条件的订单
        List<OmsOrder> orderList =  portalOrderDao.getList(queryParam);
        if(orderList == null || orderList.isEmpty()){
            log.warn("未找到相关的订单信息{}",queryParam);
            return null;
        }
        //组装查询结果
        for (OmsOrder order : orderList) {
            OmsPortalDeliverOrderVo deliverOrderVo = new OmsPortalDeliverOrderVo();

            //设置订单基本信息
            BeanUtils.copyProperties(order, deliverOrderVo);

            //获取订单的商品列表
            List<OmsPortalDeliverOrderItemVo> deliverOrderItemVoList = new ArrayList<OmsPortalDeliverOrderItemVo>();
            OmsOrderItemExample itemExample = new OmsOrderItemExample();
            itemExample.createCriteria().andOrderIdEqualTo(order.getId());
            List<OmsOrderItem> itemList = orderItemMapper.selectByExample(itemExample);
            if(itemList == null || itemList.isEmpty()){
                log.warn("订单无相关的商品信息{}", order.getId());
                continue;
            }
            for (OmsOrderItem orderItem : itemList) {
                OmsPortalDeliverOrderItemVo deliverOrderItemVo = new OmsPortalDeliverOrderItemVo();
                BeanUtils.copyProperties(orderItem, deliverOrderItemVo);
                deliverOrderItemVoList.add(deliverOrderItemVo);
            }
            deliverOrderVo.setDeliverOrderItemVoList(deliverOrderItemVoList);

            //获取订单的物流方式
            LmsLogisticsMode logisticsMode = logisticsModeMapper.selectByPrimaryKey(order.getUsedLogisticsModeId());
            if(logisticsMode == null){
                //TODO 暂时注释掉 by panqq
//                log.error("获取订单的物流方式信息失败{}", order.getId());
//                return null;
            }
            deliverOrderVo.setLogisticsMode(logisticsMode);

            //增加vo
            deliverOrderVoList.add(deliverOrderVo);
        }

        //返回查询结果
        return deliverOrderVoList;
    }

    @Override
    public OmsPortalDeliverOrderVo getDeliverOrderDetail(Long orderId) {
        OmsPortalDeliverOrderVo orderDeliverVo = new OmsPortalDeliverOrderVo();

        //获取订单基本信息
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        //收件人信息、订单状态、订单时间等
        BeanUtils.copyProperties(order, orderDeliverVo);

        //获取订单的商品列表 TODO 暂不考虑性能
        List<OmsPortalDeliverOrderItemVo> deliverOrderItemVoList = new ArrayList<OmsPortalDeliverOrderItemVo>();
        OmsOrderItemExample itemExample = new OmsOrderItemExample();
        itemExample.createCriteria().andOrderIdEqualTo(orderId);
        List<OmsOrderItem> itemList = orderItemMapper.selectByExample(itemExample);
        for (OmsOrderItem orderItem : itemList) {
            OmsPortalDeliverOrderItemVo deliverOrderItemVo = new OmsPortalDeliverOrderItemVo();
            BeanUtils.copyProperties(orderItem, deliverOrderItemVo);
            deliverOrderItemVoList.add(deliverOrderItemVo);
        }
        orderDeliverVo.setDeliverOrderItemVoList(deliverOrderItemVoList);

        //获取订单的物流方式
        LmsLogisticsMode logisticsMode = logisticsModeMapper.selectByPrimaryKey(order.getUsedLogisticsModeId());
        if(logisticsMode == null ){
            log.error("获取订单的物流方式失败{}", orderId);
            return null;
        }
        orderDeliverVo.setLogisticsMode(logisticsMode);

        return orderDeliverVo;
    }

    @Override
    public int commitOrder(OmsOrder omsOrder) {
        omsOrder.setStatus(1); //1 - 待业务员审核确认
        return orderMapper.updateByPrimaryKey(omsOrder);
    }

    @Override
    public int getCheckStatus(Long orderId) {
        return orderMapper.selectByPrimaryKey(orderId).getStatus();
    }

    /**
     * 计算订单的总金额
     *
     * @param portalOrderDetailDto
     */
    @Override
    public OmsPortalOrderAmountDto calculateAmount(OmsPortalOrderDetailVo portalOrderDetailDto) {
        //计算订单的总金额
        //弃用该接口
        return null;
    }

    /**
     * 查询订单的商品信息 by orderId
     *
     * @param orderId
     */
    @Override
    public List<Map<String, Object>> listOrderItem(Long orderId) {
        OmsOrderItemExample example = new OmsOrderItemExample();
        example.createCriteria().andOrderIdEqualTo(orderId);
        List<OmsOrderItem> omsOrderItems = orderItemMapper.selectByExample(example);
        List<Map<String, Object>> orderItemMaps = new ArrayList<Map<String, Object>>();
        OmsOrder omsOrder = orderMapper.selectByPrimaryKey(orderId);
        for (OmsOrderItem orderItem : omsOrderItems) {
            Map<String, Object> map = new HashMap<String,Object>();
            //CartProduct cartProduct = portalProductDao.getCartProduct(orderItem.getProductId());
            map.put("orderItem", orderItem);  //订单商品条目
            //map.put("cartProduct", cartProduct); //商品规格 + 库存
            PromotionProduct promotionProduct= portalProductDao.getPromotionProduct(orderItem.getProductId());
            //获取客户持有的商品的优惠劵信息 sms_coupon_history + sms_coupon
            List<SmsCoupon>  couponList =  promotionCommon.searchAppointCoupon(omsOrder.getMemberId(), orderItem.getProductId());
            promotionProduct.setCouponList(couponList);
            map.put("promotionProduct", promotionProduct);//单件商品优惠信息
            orderItemMaps.add(map);
        }
        return orderItemMaps;
    }

    @Override
    public List<OmsOrderItem> listOrderItemGeneral(Long orderId) {
        //获取订单关联的商品ID
        OmsOrderItemExample itemExample = new OmsOrderItemExample();
        itemExample.createCriteria().andOrderIdEqualTo(orderId);
        return orderItemMapper.selectByExample(itemExample);
    }

    /**
     * 为订单添加商品
     *
     * @param listOrderItem
     */
    @Override
    public int addOrderItem(List<OmsOrderItem> listOrderItem) {
        for (OmsOrderItem e : listOrderItem) {
            if(orderItemMapper.insert(e) < 0){
                return -1;
            }
        }
        return 0;
    }

    /**
     * 删除订单商品
     *
     * @param listOrderItem
     */
    @Override
    public int deleteOrderItem(List<OmsOrderItem> listOrderItem) {
        for (OmsOrderItem e : listOrderItem) {
            if(orderItemMapper.deleteByPrimaryKey(e.getId()) < 0){
                return -1;
            }
        }
        return 0;
    }

    /**
     * 更新订单商品
     *
     * @param listOrderItem
     */
    @Override
    public int updateOrderItem(List<OmsOrderItem> listOrderItem) {
        for (OmsOrderItem e : listOrderItem) {
            if(orderItemMapper.updateByPrimaryKey(e) < 0){
                return -1;
            }
        }
        return 0;
    }

    @Override
    public int SaveOrderDetailByMember(OmsPortalOrderDetailVo portalOrderDetailDto) {
        //定义订单实际支付金额
        BigDecimal payAmount = new BigDecimal("0.00");

        //获取订单信息
        OmsOrder order = new OmsOrder();
        BeanUtils.copyProperties(portalOrderDetailDto, order);
        //保存客户订单信息
        if(orderMapper.updateByPrimaryKeySelective(order) < 0){
            return -1;
        }

        //获取订单商品列表
        List<OmsPortalOrderItemDetailVo>  portalOrderItemDetailDtoList =
                portalOrderDetailDto.getPortalOrderItemDetailDtoList();
        //保存订单的商品明细,同时再次计算订单实际应付金额, 与前端传过来的金额做比对
        for (OmsPortalOrderItemDetailVo e : portalOrderItemDetailDtoList) {
            OmsOrderItem orderItem = new OmsOrderItem();
            BeanUtils.copyProperties(e, orderItem);
            if(orderItemMapper.selectByPrimaryKey(orderItem.getId()) != null){
                orderItemMapper.updateByPrimaryKeySelective(orderItem);
            }else{
                orderItemMapper.insert(orderItem);
            }

            //销售价格*购买数量 - 优惠券分解金额 - 营销活动分解金额
            payAmount.add(orderItem.getProductPrice().multiply(BigDecimal.valueOf(orderItem.getProductQuantity())));
            payAmount.subtract(orderItem.getCouponAmount());
            payAmount.subtract(orderItem.getActivityAmount());
        }

        payAmount.subtract(order.getFreightAmount());

        if(!payAmount.equals(order.getPayAmount())){
            return -1;
        }

        return 0;
    }

    @Override
    public int SaveOrderDetailByMember(OmsPortalOrderDetailDto orderDetailDto) {
        //定义订单实际支付金额
        BigDecimal payAmount = new BigDecimal("0.00");

        //获取订单信息、支付方式、物流方式、全场通用的营销活动方式、全场通用的优惠劵
        OmsOrder order = new OmsOrder();
        BeanUtils.copyProperties(orderDetailDto, order);
        //保存客户订单信息
        if(orderMapper.updateByPrimaryKeySelective(order) < 0){
            return -1;
        }

        //删除旧orderItem数据
        OmsOrderItemExample omsOrderItemExample = new OmsOrderItemExample();
        omsOrderItemExample.createCriteria().andOrderIdEqualTo(order.getId());
        if (orderItemMapper.deleteByExample(omsOrderItemExample) < 0){
            return -1;
        }

        //获取订单商品列表
        List<OmsPortalOrderItemDetailDto>  portalOrderItemDetailDtoList =
                orderDetailDto.getPortalOrderItemDetailDtoList();
        //保存订单的商品明细,同时再次计算订单实际应付金额, 与前端传过来的金额做比对
        for (OmsPortalOrderItemDetailDto e : portalOrderItemDetailDtoList) {
            OmsOrderItem orderItem = new OmsOrderItem();
            BeanUtils.copyProperties(e, orderItem);
            if (orderItem.getActivityAmount() == null) {
                orderItem.setActivityAmount(new BigDecimal(0.0));
            }
//            if(orderItemMapper.selectByPrimaryKey(orderItem.getId()) != null){
//                orderItemMapper.updateByPrimaryKeySelective(orderItem);
//            }else{
            //orderItemMapper.insert(orderItem)
//            }
           if(orderItemMapper.insert(orderItem) < 0){
               return  -1;
           }

            //销售价格*购买数量 - 优惠券分解金额 - 营销活动分解金额
            payAmount.add(orderItem.getProductPrice().multiply(BigDecimal.valueOf(orderItem.getProductQuantity())));
            payAmount.subtract(orderItem.getCouponAmount());
            payAmount.subtract(orderItem.getActivityAmount());
        }

        //设置订单总金额
        order.setTotalAmount(payAmount);

        //设置订单实际应付总金额
        if (order.getFreightAmount() == null) {
            order.setFreightAmount(new BigDecimal(0.0));
        }
        payAmount.subtract(order.getFreightAmount());
        order.setPayAmount(payAmount);

        //TODO 暂时不校验金额
//        if(!payAmount.equals(order.getPayAmount())){
//            return -1;
//        }

        //更新订单信息 并返回
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    /**
     * 保存订单商品的实物照片URI, 更改订单状态为 商品实物照片待审核
     *
     * @param orderItemPhysicalPicDtoList
     */
    @Override
    public int saveOrderItemPhysicalPic(List<OmsOrderPhysicalPicDto> orderItemPhysicalPicDtoList) {
        //保存订单的实物照片资源信息
        for (OmsOrderPhysicalPicDto e : orderItemPhysicalPicDtoList) {
            //备注:照片跟订单挂钩, 不跟商品挂钩
            OmsOrderItemPhysicalPic orderItemPhysicalPic = new OmsOrderItemPhysicalPic();
            BeanUtils.copyProperties(e, orderItemPhysicalPic);
            orderItemPhysicalPic.setLastCreateId(AppOprRoleConst.ROLE_DELIVER);
            orderItemPhysicalPic.setLastCreateTime(new Date());
            orderItemPhysicalPic.setLastUpdateId(AppOprRoleConst.ROLE_DELIVER);
            orderItemPhysicalPic.setLastUpdateTime(new Date());
            if(orderItemPhysicalPicMapper.insert(orderItemPhysicalPic) < 0){
                log.error("保存订单的实物照片资源信息失败{}", orderItemPhysicalPic);
                return -1;
            }
        }

        //更改订单状态为 商品待审核
        OmsOrder order = new OmsOrder();
        if(orderItemPhysicalPicDtoList.get(0) == null){
            log.error("更改订单状态失败,请检查...");
            return -1;
        }
        order.setId(orderItemPhysicalPicDtoList.get(0).getOrderId());
        order.setStatus(OmsOrderConst.STATUS_TOBE_PICTURES_REVIEWED_5);
        order.setLastUpdateId(AppOprRoleConst.ROLE_MEMBER);
        order.setLastUpdateTime(new Date());
        if(orderMapper.updateByPrimaryKeySelective(order) < 0){
            log.error("更改订单商品状态失败{}", order);
            return -1;
        }

        //登记订单操作日志
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(orderItemPhysicalPicDtoList.get(0).getOrderId());
        history.setCreateTime(new Date());
        history.setOperateMan(AppOprRoleConst.ROLE_MEMBER);
        history.setOrderStatus(OmsOrderConst.STATUS_TOBE_PICTURES_REVIEWED_5);
        history.setNote("商品实物照片待审核");
        if(orderOperateHistoryMapper.insert(history) != 1){
            log.error("登记订单操作日志失败");
            return -1;
        }

        return 1;
    }

    @Override
    public List<OmsOrderPhysicalPicVo> getOrderPhysicalPic(Long orderId) {
        //定义返回变量
        List<OmsOrderPhysicalPicVo> orderPhysicalPicVoList = new ArrayList<OmsOrderPhysicalPicVo>();
        OmsOrderItemPhysicalPicExample picExample = new OmsOrderItemPhysicalPicExample();
        picExample.createCriteria().andOrderIdEqualTo(orderId);
        //TODO 性能暂不考虑, 简单做
        List<OmsOrderItemPhysicalPic>  orderItemPhysicalPicList =
                orderItemPhysicalPicMapper.selectByExample(picExample);
        if(orderItemPhysicalPicList == null && orderItemPhysicalPicList.isEmpty()){
            log.debug("订单无对应的物理照片{}", orderId);
            return null;
        }
        for (OmsOrderItemPhysicalPic orderItemPhysicalPic : orderItemPhysicalPicList) {
            OmsOrderPhysicalPicVo orderPhysicalPicVo = new OmsOrderPhysicalPicVo();
            BeanUtils.copyProperties(orderItemPhysicalPic, orderPhysicalPicVo);
            orderPhysicalPicVoList.add(orderPhysicalPicVo);
        }

        return orderPhysicalPicVoList;
    }

    /**
     * 客户订单商品实物照片审核
     *
     * @param orderCheckPhysicalPicDto
     */
    @Override
    public int checkOrderPhysicalPic(OmsOrderCheckPhysicalPicDto orderCheckPhysicalPicDto) {
        //更新订单状态及订单照片审核状态
        OmsOrder order = new OmsOrder();
        order.setId(orderCheckPhysicalPicDto.getOrderId());
        if(orderCheckPhysicalPicDto.getPhysicalPicConfirmStatus() == OmsOrderConst.PHYSICAL_PIC_CONFIRM_STATUS_OK ){
            order.setStatus(OmsOrderConst.STATUS_TOBE_SEND_6); //7 - 待发货
        }
        order.setPhysicalPicConfirmStatus(orderCheckPhysicalPicDto.getPhysicalPicConfirmStatus());
        order.setLastUpdateId(AppOprRoleConst.ROLE_MEMBER);
        order.setLastUpdateTime(new Date());
        int cnt = orderMapper.updateByPrimaryKeySelective(order);
        if(cnt < 0){
            log.error("更新订单状态失败{}", orderCheckPhysicalPicDto.getOrderId());
            return -1;
        }

        if(cnt == 0){
            log.warn("订单不存在{}", orderCheckPhysicalPicDto.getOrderId());
            return 0;
        }

        //登记订单的操作日志
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(orderCheckPhysicalPicDto.getOrderId());
        history.setCreateTime(new Date());
        history.setOperateMan(AppOprRoleConst.ROLE_MEMBER);
        history.setOrderStatus(OmsOrderConst.STATUS_TOBE_SEND_6);
        if(orderOperateHistoryMapper.insert(history) != 1){
            log.error("登记订单操作日志失败");
            return -1;
        }

        return 1;
    }

    /**
     * 发货员更改订单状态:(待拍照5、待审核图片6、待发货7、配送中8)
     * @param orderId
     * @return
     */
    @Override
    public int updateDeliveredStatus(Long orderId, Integer status) {
        OmsOrder order = new OmsOrder();
        order.setId(orderId);
        order.setStatus(status);
        if(orderMapper.updateByPrimaryKeySelective(order) != 1){
            return -1;
        }
        return 0;
    }

    @Override
    public int receivedOrder(Long orderId) {
        OmsOrder order = new OmsOrder();
        order.setId(orderId);
        order.setStatus(OmsOrderConst.STATUS_RECEIVED_9); //设置订单已收货
        order.setLastUpdateTime(new Date());
        order.setLastUpdateId("portal");
        if(orderMapper.updateByPrimaryKeySelective(order) != 1){
            log.error("更改订单状态为已收货失败");
            return -1;
        }

        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(orderId);
        history.setCreateTime(new Date());
        history.setOperateMan(AppOprRoleConst.ROLE_MEMBER);
        history.setOrderStatus(OmsOrderConst.STATUS_RECEIVED_9);
        history.setNote("已收货");
        if(orderOperateHistoryMapper.insert(history) != 1){
            log.error("登记订单操作日志失败");
            return -1;
        }

        return 1;
    }

    /**
     * 查询订单的备选支付方式
     *
     * @param orderId
     */
    @Override
    public List<PaymsPayMode> listOrderPayMode(Long orderId) {
        //获取订单的支付模板
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        if(order == null || order.getOptionPayTemplateId() == 0){
            return null;
        }

        PaymsPayTemplateModeRelationExample payTemplateModeRelationExample = new PaymsPayTemplateModeRelationExample();
        payTemplateModeRelationExample.createCriteria().andTemplateIdEqualTo(order.getOptionPayTemplateId());
        List<PaymsPayTemplateModeRelation> paymsPayTemplateModeRelationList =
                payTemplateModeRelationMapper.selectByExample(payTemplateModeRelationExample);

        //查询支付模板下面的支付方式
        List<Long> ids = new ArrayList<>();
        for (PaymsPayTemplateModeRelation e : paymsPayTemplateModeRelationList) {
            ids.add(e.getId());
        }

        PaymsPayModeExample  payModeExample = new PaymsPayModeExample();
        payModeExample.createCriteria().andIdIn(ids);
        List<PaymsPayMode>   payModeList  = payModeMapper.selectByExample(payModeExample);

        return payModeList;
    }

    /**
     * 设置订单的支付方式
     *
     */
    @Override
    public int setOrderPayMode(Long orderId, Long payModeId) {
        OmsOrder omsOrder = new OmsOrder();
        omsOrder.setId(orderId);
        omsOrder.setUsedPayModeId(payModeId);
        return orderMapper.updateByPrimaryKeySelective(omsOrder);
    }

    /**
     * 设置订单的物流方式
     *
     */
    @Override
    public int setOrderLogisticsMode(Long orderId,  Long logisticsModeId) {
        //从数据库获取订单信息
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        if(order == null){
            return  -1;
        }

        //设置订单物流方式
        order.setUsedLogisticsModeId(logisticsModeId);

        //根据订单的物流模板、物流方式、收货地、发货地 获取物流费用信息
        LmsLogisticsChargeExample logisticsChargeExample = new LmsLogisticsChargeExample();
        LmsLogisticsChargeExample.Criteria criteria =  logisticsChargeExample.createCriteria();
        criteria.andTemplateIdEqualTo(order.getOptionLogisticsTemplateId());
        criteria.andModeIdEqualTo(logisticsModeId);
        //criteria.andSendNameEqualTo(order.getSendCountry());
        criteria.andReceiptNameEqualTo(order.getReceiverCountry());
        List<LmsLogisticsCharge> logisticsChargeList = logisticsChargeMapper.selectByExample(logisticsChargeExample);
        if(logisticsChargeList == null || logisticsChargeList.size() == 0 || logisticsChargeList.size() != 1 ){
            return -1;
        }

        //TODO  物流金额暂不计算,填默认值 999.99
        BigDecimal bigDecimal = new BigDecimal("999.99");
        order.setFreightAmount(bigDecimal);

        //订单实际应付价格重新计算 :  实际应付价格 = 物流费用 + 订单金额
        order.setPayAmount(order.getPayAmount().add(order.getFreightAmount()));
        order.setTotalAmount(order.getTotalAmount().add(order.getFreightAmount()));
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public int setOrderLogisticsModeV2(Long orderId, Long logisticsModeId, String chargeType) {
        //从数据库获取订单信息
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        if(order == null){
            return  -1;
        }

        //设置订单物流方式
        order.setUsedLogisticsModeId(logisticsModeId);

        //根据订单的物流模板、物流方式、收货地、发货地 获取物流费用信息
        LmsLogisticsChargeExample logisticsChargeExample = new LmsLogisticsChargeExample();
        LmsLogisticsChargeExample.Criteria criteria =  logisticsChargeExample.createCriteria();
        criteria.andTemplateIdEqualTo(order.getOptionLogisticsTemplateId());
        criteria.andModeIdEqualTo(logisticsModeId);
        criteria.andSendNameEqualTo(order.getSendCountry());
        criteria.andReceiptNameEqualTo(order.getReceiverCountry());
        criteria.andChargeTypeEqualTo(chargeType);
        List<LmsLogisticsCharge> logisticsChargeList = logisticsChargeMapper.selectByExample(logisticsChargeExample);
        if(logisticsChargeList == null || logisticsChargeList.size() == 0 || logisticsChargeList.size() != 1 ){
            return -1;
        }

        //根据费用类型, 统计物流费用
        if(chargeType == "00"){
            // TODO 累加订单商品重量,计算商品费用

        }else{
            // TODO 累加商品数量, 计算商品费用

        }

        //TODO   物流金额暂不计算,填默认值 999.99
        BigDecimal bigDecimal = new BigDecimal("999.99");
        order.setFreightAmount(bigDecimal);

        //订单实际应付价格重新计算 :  实际应付价格 = 物流费用 + 订单金额
        order.setPayAmount(new BigDecimal("00.00"));
        order.setPayAmount(order.getPayAmount().add(order.getFreightAmount()).add(order.getTotalAmount()));
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    /**
     * 登记订单物流跟踪情况
     *
     * @param orderId
     * @param orderLogisticsTraceLog
     */
    @Override
    public int addLogisticsLog(Long orderId, OmsOrderLogisticsTraceLog orderLogisticsTraceLog) {
         return orderLogisticsTraceLogMapper.insert(orderLogisticsTraceLog);
    }

    /**
     * 获取订单物流跟踪情况(ALL,分页查询)
     *
     * @param orderId
     * @param pageSize
     * @param pageNum
     */
    @Override
    public List<OmsOrderLogisticsTraceLog> getLogisticsLogAll(Long orderId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        OmsOrderLogisticsTraceLogExample example = new OmsOrderLogisticsTraceLogExample();
        example.createCriteria().andOrderIdEqualTo(orderId);
        return orderLogisticsTraceLogMapper.selectByExample(example);
    }

    /**
     * 获取订单物流跟踪最新情况
     *
     * @param orderId
     */
    @Override
    public OmsOrderLogisticsTraceLog getLogisticsLogLast(Long orderId) {

        OmsOrderLogisticsTraceLogExample example = new OmsOrderLogisticsTraceLogExample();
        example.createCriteria().andOrderIdEqualTo(orderId);
        //TODO 需要注意看下是否可以排序
        example.setOrderByClause(" lastCreateTime desc ");
        List<OmsOrderLogisticsTraceLog> logisticsTraceLogList =
                orderLogisticsTraceLogMapper.selectByExample(example);
        if(logisticsTraceLogList.size() > 0){
            return  logisticsTraceLogList.get(0);
        }

        return null;
    }

    /**
     * 查询订单的备选物流方式
     *
     * @param orderId
     */
    @Override
    public List<LmsLogisticsModeVo> listLmsLogisticsModeVo(Long orderId) {
        // TODO　protal 和 admin 存在共同的业务, 建议增加 业务中台模块
        //定义返回值
        List<LmsLogisticsModeVo> logisticsModeVoList = new ArrayList<LmsLogisticsModeVo>();

        //获取订单物流模板
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        if(order == null || order.getOptionLogisticsTemplateId() == 0){
            return null;
        }

        //获取物流模板底下的物流方式信息
        //TODO  暂不考虑性能, 简单实现
        LmsLogisticsChargeExample logisticsChargeExample = new LmsLogisticsChargeExample();
        logisticsChargeExample.createCriteria().andTemplateIdEqualTo(order.getOptionLogisticsTemplateId());
        List<LmsLogisticsCharge>  logisticsChargeList =  logisticsChargeMapper.selectByExample(logisticsChargeExample);

        //物流方式的定义信息
        List<Long> ids = new ArrayList<>();
        for (LmsLogisticsCharge e : logisticsChargeList) {
            LmsLogisticsModeVo logisticsModeVo = new LmsLogisticsModeVo();
            LmsLogisticsMode logisticsMode = logisticsModeMapper.selectByPrimaryKey(e.getId());
            if(logisticsMode == null){
                return null;
            }
            BeanUtils.copyProperties(logisticsMode, logisticsModeVo);
            logisticsModeVo.setLogisticsCharge(e);
            logisticsModeVoList.add(logisticsModeVo);
        }
        return logisticsModeVoList;
    }

    @Override
    public ConfirmOrderResult generateConfirmOrder() {
        ConfirmOrderResult result = new ConfirmOrderResult();
        //获取购物车信息
        UmsMember currentMember = memberService.getCurrentMember();
        List<CartPromotionItem> cartPromotionItemList = cartItemService.listPromotion(currentMember.getId());
        result.setCartPromotionItemList(cartPromotionItemList);
        //获取用户收货地址列表
        List<UmsMemberReceiveAddress> memberReceiveAddressList = memberReceiveAddressService.list(currentMember.getId());
        result.setMemberReceiveAddressList(memberReceiveAddressList);
        //获取用户可用优惠券列表
        List<SmsCouponHistoryDetail> couponHistoryDetailList = memberCouponService.listCart(cartPromotionItemList, 1);
        result.setCouponHistoryDetailList(couponHistoryDetailList);
        //获取用户积分
        result.setMemberIntegration(currentMember.getIntegration());
        //获取积分使用规则
        UmsIntegrationConsumeSetting integrationConsumeSetting = integrationConsumeSettingMapper.selectByPrimaryKey(1L);
        result.setIntegrationConsumeSetting(integrationConsumeSetting);
        //计算总金额、活动优惠、应付金额
        ConfirmOrderResult.CalcAmount calcAmount = calcCartAmount(cartPromotionItemList);
        result.setCalcAmount(calcAmount);
        return result;
    }

    /////////////TODO 下面的方法建议弃用add by ruiwu.xu@20190119///////////////////

    @Override
    public CommonResult generateOrder(OrderParam orderParam) {
        List<OmsOrderItem> orderItemList = new ArrayList<>();
        //获取购物车及优惠信息
        UmsMember currentMember = memberService.getCurrentMember();
        List<CartPromotionItem> cartPromotionItemList = cartItemService.listPromotion(currentMember.getId());
        for (CartPromotionItem cartPromotionItem : cartPromotionItemList) {
            //生成下单商品信息
            OmsOrderItem orderItem = new OmsOrderItem();
            orderItem.setProductId(cartPromotionItem.getProductId());
            orderItem.setProductName(cartPromotionItem.getProductName());
            orderItem.setProductPic(cartPromotionItem.getProductPic());
            orderItem.setProductAttr(cartPromotionItem.getProductAttr());
            orderItem.setProductBrand(cartPromotionItem.getProductBrand());
            orderItem.setProductSn(cartPromotionItem.getProductSn());
            orderItem.setProductPrice(cartPromotionItem.getPrice());
            orderItem.setProductQuantity(cartPromotionItem.getQuantity());
            orderItem.setProductSkuId(cartPromotionItem.getProductSkuId());
            orderItem.setProductSkuCode(cartPromotionItem.getProductSkuCode());
            orderItem.setProductCategoryId(cartPromotionItem.getProductCategoryId());
            orderItem.setPromotionAmount(cartPromotionItem.getReduceAmount());
            orderItem.setPromotionName(cartPromotionItem.getPromotionMessage());
            orderItem.setGiftIntegration(cartPromotionItem.getIntegration());
            orderItem.setGiftGrowth(cartPromotionItem.getGrowth());
            orderItemList.add(orderItem);
        }
        //判断购物车中商品是否都有库存
        if (!hasStock(cartPromotionItemList)) {
            return new CommonResult().failed("库存不足，无法下单");
        }
        //判断使用使用了优惠券
        if (orderParam.getCouponId() == null) {
            //不用优惠券
            for (OmsOrderItem orderItem : orderItemList) {
                orderItem.setCouponAmount(new BigDecimal(0));
            }
        } else {
            //使用优惠券
            SmsCouponHistoryDetail couponHistoryDetail = getUseCoupon(cartPromotionItemList, orderParam.getCouponId());
            if (couponHistoryDetail == null) {
                return new CommonResult().failed("该优惠券不可用");
            }
            //对下单商品的优惠券进行处理
            handleCouponAmount(orderItemList, couponHistoryDetail);
        }
        //判断是否使用积分
        if (orderParam.getUseIntegration() == null) {
            //不使用积分
            for (OmsOrderItem orderItem : orderItemList) {
                orderItem.setIntegrationAmount(new BigDecimal(0));
            }
        } else {
            //使用积分
            BigDecimal totalAmount = calcTotalAmount(orderItemList);
            BigDecimal integrationAmount = getUseIntegrationAmount(orderParam.getUseIntegration(), totalAmount, currentMember, orderParam.getCouponId() != null);
            if (integrationAmount.compareTo(new BigDecimal(0)) == 0) {
                return new CommonResult().failed("积分不可用");
            } else {
                //可用情况下分摊到可用商品中
                for (OmsOrderItem orderItem : orderItemList) {
                    BigDecimal perAmount = orderItem.getProductPrice().divide(totalAmount, 3,RoundingMode.HALF_EVEN).multiply(integrationAmount);
                    orderItem.setIntegrationAmount(perAmount);
                }
            }
        }
        //计算order_item的实付金额
        handleRealAmount(orderItemList);
        //进行库存锁定
        lockStock(cartPromotionItemList);
        //根据商品合计、运费、活动优惠、优惠券、积分计算应付金额
        OmsOrder order = new OmsOrder();
        order.setDiscountAmount(new BigDecimal(0));
        order.setTotalAmount(calcTotalAmount(orderItemList));
        order.setFreightAmount(new BigDecimal(0));
        order.setPromotionAmount(calcPromotionAmount(orderItemList));
        order.setPromotionInfo(getOrderPromotionInfo(orderItemList));
        if (orderParam.getCouponId() == null) {
            order.setCouponAmount(new BigDecimal(0));
        } else {
            order.setCouponId(orderParam.getCouponId());
            order.setCouponAmount(calcCouponAmount(orderItemList));
        }
        if (orderParam.getUseIntegration() == null) {
            order.setIntegration(0);
            order.setIntegrationAmount(new BigDecimal(0));
        } else {
            order.setIntegration(orderParam.getUseIntegration());
            order.setIntegrationAmount(calcIntegrationAmount(orderItemList));
        }
        order.setPayAmount(calcPayAmount(order));
        //转化为订单信息并插入数据库
        order.setMemberId(currentMember.getId());
        order.setCreateTime(new Date());
        order.setMemberUsername(currentMember.getUsername());
        //支付方式：0->未支付；1->支付宝；2->微信
        order.setPayType(orderParam.getPayType());
        //订单来源：0->PC订单；1->app订单
        order.setSourceType(1);
        //订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
        order.setStatus(0);
        //订单类型：0->正常订单；1->秒杀订单
        order.setOrderType(0);
        //收货人信息：姓名、电话、邮编、地址
        UmsMemberReceiveAddress address = memberReceiveAddressService.getItem(orderParam.getMemberReceiveAddressId());
        order.setReceiverName(address.getFirstName()+"."+address.getLastName());
        order.setReceiverPhone(address.getTelephone());
        order.setReceiverPostCode(address.getPostCode());
        order.setReceiverProvince(address.getProvince());
        order.setReceiverCity(address.getCity());
        order.setReceiverRegion(address.getRegion());
        order.setReceiverDetailAddress(address.getAddress1() + address.getAddress1());
        //0->未确认；1->已确认
        order.setConfirmStatus(0);
        order.setDeleteStatus(0);
        //计算赠送积分
        order.setIntegration(calcGifIntegration(orderItemList));
        //计算赠送成长值
        order.setGrowth(calcGiftGrowth(orderItemList));
        //生成订单号
        order.setOrderSn(generateOrderSn(order));
        // TODO: 2018/9/3 bill_*,delivery_*
        //插入order表和order_item表
        orderMapper.insert(order);
        for (OmsOrderItem orderItem : orderItemList) {
            orderItem.setOrderId(order.getId());
            orderItem.setOrderSn(order.getOrderSn());
        }
        orderItemDao.insertList(orderItemList);
        //如使用优惠券更新优惠券使用状态
        if(orderParam.getCouponId()!=null){
            updateCouponStatus(orderParam.getCouponId(),currentMember.getId(),1);
        }
        //如使用积分需要扣除积分
        if(orderParam.getUseIntegration()!=null){
            order.setUseIntegration(orderParam.getUseIntegration());
            memberService.updateIntegration(currentMember.getId(),currentMember.getIntegration()-orderParam.getUseIntegration());
        }
        //删除购物车中的下单商品
        deleteCartItemList(cartPromotionItemList,currentMember);
        Map<String,Object> result = new HashMap<>();
        result.put("order",order);
        result.put("orderItemList",orderItemList);
        return new CommonResult().success("下单成功", result);
    }

    @Override
    public CommonResult paySuccess(Long orderId) {
        //修改订单支付状态
        OmsOrder order = new OmsOrder();
        order.setId(orderId);
        order.setStatus(1);
        order.setPaymentTime(new Date());
        orderMapper.updateByPrimaryKeySelective(order);
        //恢复所有下单商品的锁定库存，扣减真实库存
        OmsOrderDetail orderDetail = portalOrderDao.getDetail(orderId);
        int count = portalOrderDao.updateSkuStock(orderDetail.getOrderItemList());
        return new CommonResult().success("支付成功",count);
    }

    @Override
    public CommonResult cancelTimeOutOrder() {
        OmsOrderSetting orderSetting = orderSettingMapper.selectByPrimaryKey(1L);
        //查询超时、未支付的订单及订单详情
        List<OmsOrderDetail> timeOutOrders = portalOrderDao.getTimeOutOrders(orderSetting.getNormalOrderOvertime());
        if(CollectionUtils.isEmpty(timeOutOrders)){
            return new CommonResult().failed("暂无超时订单");
        }
        //修改订单状态为交易取消
        List<Long> ids = new ArrayList<>();
        for (OmsOrderDetail timeOutOrder : timeOutOrders) {
            ids.add(timeOutOrder.getId());
        }
        portalOrderDao.updateOrderStatus(ids,4);
        for (OmsOrderDetail timeOutOrder : timeOutOrders) {
            //解除订单商品库存锁定
            portalOrderDao.releaseSkuStockLock(timeOutOrder.getOrderItemList());
            //修改优惠券使用状态
            updateCouponStatus(timeOutOrder.getCouponId(),timeOutOrder.getMemberId(),0);
            //返还使用积分
            if(timeOutOrder.getUseIntegration()!=null){
                UmsMember member = memberService.getById(timeOutOrder.getMemberId());
                memberService.updateIntegration(timeOutOrder.getMemberId(),member.getIntegration()+timeOutOrder.getUseIntegration());
            }
        }
        return new CommonResult().success(null);
    }

    @Override
    public void cancelOrder(Long orderId) {
        //查询为付款的取消订单
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andIdEqualTo(orderId).andStatusEqualTo(0).andDeleteStatusEqualTo(0);
        List<OmsOrder> cancelOrderList = orderMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(cancelOrderList)){
            return;
        }
        OmsOrder cancelOrder = cancelOrderList.get(0);
        if(cancelOrder!=null){
            //修改订单状态为取消
            cancelOrder.setStatus(4);
            orderMapper.updateByPrimaryKeySelective(cancelOrder);
            OmsOrderItemExample orderItemExample=new OmsOrderItemExample();
            orderItemExample.createCriteria().andOrderIdEqualTo(orderId);
            List<OmsOrderItem> orderItemList = orderItemMapper.selectByExample(orderItemExample);
            //解除订单商品库存锁定
            portalOrderDao.releaseSkuStockLock(orderItemList);
            //修改优惠券使用状态
            updateCouponStatus(cancelOrder.getCouponId(),cancelOrder.getMemberId(),0);
            //返还使用积分
            if(cancelOrder.getUseIntegration()!=null){
                UmsMember member = memberService.getById(cancelOrder.getMemberId());
                memberService.updateIntegration(cancelOrder.getMemberId(),member.getIntegration()+cancelOrder.getUseIntegration());
            }
        }
    }

    @Override
    public void sendDelayMessageCancelOrder(Long orderId) {
        //获取订单超时时间
        OmsOrderSetting orderSetting = orderSettingMapper.selectByPrimaryKey(1L);
        long delayTimes = orderSetting.getNormalOrderOvertime()*60*1000;
        //发送延迟消息
        cancelOrderSender.sendMessage(orderId,delayTimes);
    }

    /**
     * 生成18位订单编号:8位日期+2位平台号码+2位支付方式+6位以上自增id
     */
    private String generateOrderSn(OmsOrder order) {
        StringBuilder sb = new StringBuilder();
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String key = REDIS_KEY_PREFIX_ORDER_ID + date;
        Long increment = redisService.increment(key, 1);
        sb.append(date);
        sb.append(String.format("%02d",order.getSourceType()));
        sb.append(String.format("%02d",order.getPayType()));
        String incrementStr = increment.toString();
        if(incrementStr.length()<=6){
            sb.append(String.format("%06d",increment));
        }else{
            sb.append(incrementStr);
        }
        return sb.toString();
    }

    /**
     * 删除下单商品的购物车信息
     */
    private void deleteCartItemList(List<CartPromotionItem> cartPromotionItemList, UmsMember currentMember) {
        List<Long> ids = new ArrayList<>();
        for (CartPromotionItem cartPromotionItem : cartPromotionItemList) {
            ids.add(cartPromotionItem.getId());
        }
        cartItemService.delete(currentMember.getId(),ids);
    }

    /**
     * 计算该订单赠送的成长值
     */
    private Integer calcGiftGrowth(List<OmsOrderItem> orderItemList) {
        Integer sum=0;
        for (OmsOrderItem orderItem : orderItemList) {
            sum=sum+orderItem.getGiftGrowth()*orderItem.getProductQuantity();
        }
        return sum;
    }

    /**
     * 计算该订单赠送的积分
     */
    private Integer calcGifIntegration(List<OmsOrderItem> orderItemList) {
        int sum=0;
        for (OmsOrderItem orderItem : orderItemList) {
            sum+=orderItem.getGiftIntegration()*orderItem.getProductQuantity();
        }
        return sum;
    }

    /**
     * 将优惠券信息更改为指定状态
     * @param couponId 优惠券id
     * @param memberId 会员id
     * @param useStatus 0->未使用；1->已使用
     */
    private void updateCouponStatus(Long couponId, Long memberId,Integer useStatus) {
        if(couponId==null)return;
        //查询第一张优惠券
        SmsCouponHistoryExample example = new SmsCouponHistoryExample();
        example.createCriteria().andMemberIdEqualTo(memberId)
                .andCouponIdEqualTo(couponId).andUseStatusEqualTo(useStatus==0?1:0);
        List<SmsCouponHistory> couponHistoryList = couponHistoryMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(couponHistoryList)){
            SmsCouponHistory couponHistory = couponHistoryList.get(0);
            couponHistory.setUseTime(new Date());
            couponHistory.setUseStatus(useStatus);
            couponHistoryMapper.updateByPrimaryKeySelective(couponHistory);
        }
    }

    private void handleRealAmount(List<OmsOrderItem> orderItemList) {
        for (OmsOrderItem orderItem : orderItemList) {
            //原价-促销价格-优惠券抵扣-积分抵扣
            BigDecimal realAmount = orderItem.getProductPrice()
                    .subtract(orderItem.getPromotionAmount())
                    .subtract(orderItem.getCouponAmount())
                    .subtract(orderItem.getIntegrationAmount());
            orderItem.setRealAmount(realAmount);
        }
    }

    /**
     * 获取订单促销信息
     */
    private String getOrderPromotionInfo(List<OmsOrderItem> orderItemList) {
        StringBuilder sb = new StringBuilder();
        for (OmsOrderItem orderItem : orderItemList) {
            sb.append(orderItem.getPromotionName());
            sb.append(",");
        }
        String result = sb.toString();
        if (result.endsWith(",")) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    /**
     * 计算订单应付金额
     */
    private BigDecimal calcPayAmount(OmsOrder order) {
        //总金额+运费-促销优惠-优惠券优惠-积分抵扣
        BigDecimal payAmount = order.getTotalAmount()
                .add(order.getFreightAmount())
                .subtract(order.getPromotionAmount())
                .subtract(order.getCouponAmount())
                .subtract(order.getIntegrationAmount());
        return payAmount;
    }

    /**
     * 计算订单优惠券金额
     */
    private BigDecimal calcIntegrationAmount(List<OmsOrderItem> orderItemList) {
        BigDecimal integrationAmount = new BigDecimal(0);
        for (OmsOrderItem orderItem : orderItemList) {
            if (orderItem.getIntegrationAmount() != null) {
                integrationAmount = integrationAmount.add(orderItem.getIntegrationAmount().multiply(new BigDecimal(orderItem.getProductQuantity())));
            }
        }
        return integrationAmount;
    }

    /**
     * 计算订单优惠券金额
     */
    private BigDecimal calcCouponAmount(List<OmsOrderItem> orderItemList) {
        BigDecimal couponAmount = new BigDecimal(0);
        for (OmsOrderItem orderItem : orderItemList) {
            if (orderItem.getCouponAmount() != null) {
                couponAmount = couponAmount.add(orderItem.getCouponAmount().multiply(new BigDecimal(orderItem.getProductQuantity())));
            }
        }
        return couponAmount;
    }

    /**
     * 计算订单活动优惠
     */
    private BigDecimal calcPromotionAmount(List<OmsOrderItem> orderItemList) {
        BigDecimal promotionAmount = new BigDecimal(0);
        for (OmsOrderItem orderItem : orderItemList) {
            if (orderItem.getPromotionAmount() != null) {
                promotionAmount = promotionAmount.add(orderItem.getPromotionAmount().multiply(new BigDecimal(orderItem.getProductQuantity())));
            }
        }
        return promotionAmount;
    }

    /**
     * 获取可用积分抵扣金额
     *
     * @param useIntegration 使用的积分数量
     * @param totalAmount    订单总金额
     * @param currentMember  使用的用户
     * @param hasCoupon      是否已经使用优惠券
     */
    private BigDecimal getUseIntegrationAmount(Integer useIntegration, BigDecimal totalAmount, UmsMember currentMember, boolean hasCoupon) {
        BigDecimal zeroAmount = new BigDecimal(0);
        //判断用户是否有这么多积分
        if (useIntegration.compareTo(currentMember.getIntegration()) > 0) {
            return zeroAmount;
        }
        //根据积分使用规则判断使用可用
        //是否可用于优惠券共用
        UmsIntegrationConsumeSetting integrationConsumeSetting = integrationConsumeSettingMapper.selectByPrimaryKey(1L);
        if (hasCoupon && integrationConsumeSetting.getCouponStatus().equals(0)) {
            //不可与优惠券共用
            return zeroAmount;
        }
        //是否达到最低使用积分门槛
        if (useIntegration.compareTo(integrationConsumeSetting.getUseUnit()) < 0) {
            return zeroAmount;
        }
        //是否超过订单抵用最高百分比
        BigDecimal integrationAmount = new BigDecimal(useIntegration).divide(new BigDecimal(integrationConsumeSetting.getUseUnit()), 2,RoundingMode.HALF_EVEN);
        BigDecimal maxPercent = new BigDecimal(integrationConsumeSetting.getMaxPercentPerOrder()).divide(new BigDecimal(100), 2, RoundingMode.HALF_EVEN);
        if (integrationAmount.compareTo(totalAmount.multiply(maxPercent)) > 0) {
            return zeroAmount;
        }
        return integrationAmount;
    }

    /**
     * 对优惠券优惠进行处理
     *
     * @param orderItemList       order_item列表
     * @param couponHistoryDetail 可用优惠券详情
     */
    private void handleCouponAmount(List<OmsOrderItem> orderItemList, SmsCouponHistoryDetail couponHistoryDetail) {
        SmsCoupon coupon = couponHistoryDetail.getCoupon();
        if (coupon.getUseType().equals(0)) {
            //全场通用
            calcPerCouponAmount(orderItemList, coupon);
        } else if (coupon.getUseType().equals(1)) {
            //指定分类
            List<OmsOrderItem> couponOrderItemList = getCouponOrderItemByRelation(couponHistoryDetail, orderItemList, 0);
            calcPerCouponAmount(couponOrderItemList, coupon);
        } else if (coupon.getUseType().equals(2)) {
            //指定商品
            List<OmsOrderItem> couponOrderItemList = getCouponOrderItemByRelation(couponHistoryDetail, orderItemList, 1);
            calcPerCouponAmount(couponOrderItemList, coupon);
        }
    }

    /**
     * 对每个下单商品进行优惠券金额分摊的计算
     *
     * @param orderItemList 可用优惠券的下单商品商品
     */
    private void calcPerCouponAmount(List<OmsOrderItem> orderItemList, SmsCoupon coupon) {
        BigDecimal totalAmount = calcTotalAmount(orderItemList);
        for (OmsOrderItem orderItem : orderItemList) {
            //(商品价格/可用商品总价)*优惠券面额
            BigDecimal couponAmount = orderItem.getProductPrice().divide(totalAmount, 3, RoundingMode.HALF_EVEN).multiply(coupon.getAmount());
            orderItem.setCouponAmount(couponAmount);
        }
    }

    /**
     * 获取与优惠券有关系的下单商品
     *
     * @param couponHistoryDetail 优惠券详情
     * @param orderItemList       下单商品
     * @param type                使用关系类型：0->相关分类；1->指定商品
     */
    private List<OmsOrderItem> getCouponOrderItemByRelation(SmsCouponHistoryDetail couponHistoryDetail, List<OmsOrderItem> orderItemList, int type) {
        List<OmsOrderItem> result = new ArrayList<>();
        if (type == 0) {
            List<Long> categoryIdList = new ArrayList<>();
            for (SmsCouponProductCategoryRelation productCategoryRelation : couponHistoryDetail.getCategoryRelationList()) {
                categoryIdList.add(productCategoryRelation.getProductCategoryId());
            }
            for (OmsOrderItem orderItem : orderItemList) {
                if (categoryIdList.contains(orderItem.getProductCategoryId())) {
                    result.add(orderItem);
                } else {
                    orderItem.setCouponAmount(new BigDecimal(0));
                }
            }
        } else if (type == 1) {
            List<Long> productIdList = new ArrayList<>();
            for (SmsCouponProductRelation productRelation : couponHistoryDetail.getProductRelationList()) {
                productIdList.add(productRelation.getProductId());
            }
            for (OmsOrderItem orderItem : orderItemList) {
                if (productIdList.contains(orderItem.getProductId())) {
                    result.add(orderItem);
                } else {
                    orderItem.setCouponAmount(new BigDecimal(0));
                }
            }
        }
        return result;
    }

    /**
     * 获取该用户可以使用的优惠券
     *
     * @param cartPromotionItemList 购物车优惠列表
     * @param couponId              使用优惠券id
     */
    private SmsCouponHistoryDetail getUseCoupon(List<CartPromotionItem> cartPromotionItemList, Long couponId) {
        List<SmsCouponHistoryDetail> couponHistoryDetailList = memberCouponService.listCart(cartPromotionItemList, 1);
        for (SmsCouponHistoryDetail couponHistoryDetail : couponHistoryDetailList) {
            if (couponHistoryDetail.getCoupon().getId().equals(couponId)) {
                return couponHistoryDetail;
            }
        }
        return null;
    }

    /**
     * 计算总金额
     */
    private BigDecimal calcTotalAmount(List<OmsOrderItem> orderItemList) {
        BigDecimal totalAmount = new BigDecimal("0");
        for (OmsOrderItem item : orderItemList) {
            totalAmount = totalAmount.add(item.getProductPrice().multiply(new BigDecimal(item.getProductQuantity())));
        }
        return totalAmount;
    }

    /**
     * 锁定下单商品的所有库存
     */
    private void lockStock(List<CartPromotionItem> cartPromotionItemList) {
        for (CartPromotionItem cartPromotionItem : cartPromotionItemList) {
            PmsSkuStock skuStock = skuStockMapper.selectByPrimaryKey(cartPromotionItem.getProductSkuId());
            skuStock.setLockStock(skuStock.getLockStock() + cartPromotionItem.getQuantity());
            skuStockMapper.updateByPrimaryKeySelective(skuStock);
        }
    }

    /**
     * 判断下单商品是否都有库存
     */
    private boolean hasStock(List<CartPromotionItem> cartPromotionItemList) {
        for (CartPromotionItem cartPromotionItem : cartPromotionItemList) {
            if (cartPromotionItem.getRealStock() <= 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 计算购物车中商品的价格
     */
    private ConfirmOrderResult.CalcAmount calcCartAmount(List<CartPromotionItem> cartPromotionItemList) {
        ConfirmOrderResult.CalcAmount calcAmount = new ConfirmOrderResult.CalcAmount();
        calcAmount.setFreightAmount(new BigDecimal(0));
        BigDecimal totalAmount = new BigDecimal("0");
        BigDecimal promotionAmount = new BigDecimal("0");
        for (CartPromotionItem cartPromotionItem : cartPromotionItemList) {
            totalAmount = totalAmount.add(cartPromotionItem.getPrice().multiply(new BigDecimal(cartPromotionItem.getQuantity())));
            promotionAmount = promotionAmount.add(cartPromotionItem.getReduceAmount().multiply(new BigDecimal(cartPromotionItem.getQuantity())));
        }
        calcAmount.setTotalAmount(totalAmount);
        calcAmount.setPromotionAmount(promotionAmount);
        calcAmount.setPayAmount(totalAmount.subtract(promotionAmount));
        return calcAmount;
    }

}
