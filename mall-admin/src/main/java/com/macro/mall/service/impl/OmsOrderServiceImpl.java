package com.macro.mall.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.macro.mall.constant.AppOprRoleConst;
import com.macro.mall.constant.OmsOrderConst;
import com.macro.mall.constant.OmsPayConst;
import com.macro.mall.dao.OmsOrderDao;
import com.macro.mall.dao.OmsOrderLogisticsTraceLogDao;
import com.macro.mall.dao.OmsOrderOperateHistoryDao;
import com.macro.mall.domain.CommonResult;
import com.macro.mall.domain.OmsMarketingActivityDo;
import com.macro.mall.dto.*;
import com.macro.mall.mapper.*;
import com.macro.mall.model.*;
import com.macro.mall.service.OmsOrderService;
import com.macro.mall.vo.OmsOrderDetailVo;
import com.macro.mall.vo.OmsOrderItemDetailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单管理Service实现类
 * Created by macro on 2018/10/11.
 */
@Service
@Slf4j
public class OmsOrderServiceImpl implements OmsOrderService {
    //订单相关
    @Autowired
    private OmsOrderMapper orderMapper;
    @Autowired
    private OmsOrderDao orderDao;
    @Autowired
    private OmsOrderOperateHistoryDao orderOperateHistoryDao;
    @Autowired
    private OmsOrderOperateHistoryMapper orderOperateHistoryMapper;
    @Autowired
    private OmsOrderItemMapper orderItemMapper;
    @Autowired
    private  OmsOrderOperateHistoryMapper omsOrderOperateHistoryMapper;

    //物流相关
    @Autowired
    private OmsOrderLogisticsTraceLogMapper orderLogisticsTraceLogMapper;
    @Autowired
    private OmsLogisticsModeOptionMapper  logisticsModeOptionMapper;
    @Autowired
    private LmsLogisticsModeMapper logisticsModeMapper;
    @Autowired
    private OmsOrderLogisticsTraceLogDao  orderLogisticsTraceLogDao;
    @Autowired
    private  LmsLogisticsTemplateMapper logisticsTemplateMapper;

    //支付相关
    @Autowired
    private OmsPayModeOptionMapper payModeOptionMapper;
    @Autowired
    private  PaymsPayModeMapper payModeMapper;
    @Autowired
    private  PaymsPayTemplateMapper payTemplateMapper;

    //商品相关
    @Autowired
    private  PmsProductMapper productMapper;
    @Autowired
    private PmsProductAttributeMapper productAttributeMapper;

    //优惠相关
    @Autowired
    private  SmsCouponMapper couponMapper;
    @Autowired
    private SmsCouponProductCategoryRelationMapper couponProductCategoryRelationMapper;
    @Autowired
    private  SmsCouponProductRelationMapper couponProductRelationMapper;
    @Autowired
    private  SmsMarketingActivitiesMapper marketingActivitiesMapper;
    @Autowired
    private  SmsMarketingActivityRuleMapper marketingActivityRuleMapper;
    @Autowired
    private  SmsMarketingActivityProductRelationMapper  marketingActivityProductRelationMapper;
    @Autowired
    private  SmsMarketingActivityProductCategoryRelationMapper marketingActivityProductCategoryRelationMapper;

    //客户相关
    @Autowired
    private  UmsMemberMapper  memberMapper;


    @Override
    public List<OmsOrder> page(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return orderDao.getList(queryParam);
    }

    @Override
    public List<OmsOrderDetailVo> pageV2(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum) {
        //定义返回值变量
        List<OmsOrderDetailVo>  orderDetailVoList = new ArrayList<OmsOrderDetailVo>();

        //设置分页查询
        PageHelper.startPage(pageNum, pageSize);

        //根据查询条件获取订单详情
        List<OmsOrder> orderList = orderDao.getList(queryParam);
        for (OmsOrder order : orderList) {
            //设置订单的基本信息
            OmsOrderDetailVo orderDetailVo = new OmsOrderDetailVo();
            BeanUtils.copyProperties(order, orderDetailVo);

            //获取订单的客户信息
            UmsMember member = memberMapper.selectByPrimaryKey(order.getMemberId());
            if(member != null){
                orderDetailVo.setMember(member);
            }

            //获取订单操作日志
            OmsOrderOperateHistoryExample orderOperateHistoryExample = new OmsOrderOperateHistoryExample();
            orderOperateHistoryExample.createCriteria().andOrderIdEqualTo(order.getId());
            List<OmsOrderOperateHistory>  omsOrderOperateHistoryList =
                    omsOrderOperateHistoryMapper.selectByExample(orderOperateHistoryExample);
            if(omsOrderOperateHistoryList != null){
                orderDetailVo.setOrderOperateHistoryList(omsOrderOperateHistoryList);
            }

            //获取支付方式
            PaymsPayMode payMode = payModeMapper.selectByPrimaryKey(order.getUsedPayModeId());
            if(payMode != null){
                orderDetailVo.setPayMode(payMode);
            }

            //获取支付模板
            PaymsPayTemplate payTemplate = payTemplateMapper.selectByPrimaryKey(order.getOptionPayTemplateId());
            if(payTemplate != null){
                orderDetailVo.setPayTemplate(payTemplate);
            }

            //获取物流方式
            LmsLogisticsMode logisticsMode = logisticsModeMapper.selectByPrimaryKey(order.getUsedPayModeId());
            if(logisticsMode != null){
                orderDetailVo.setLogisticsMode(logisticsMode);
            }

            //获取物流模板
            LmsLogisticsTemplate logisticsTemplate = logisticsTemplateMapper.selectByPrimaryKey(order.getOptionLogisticsTemplateId());
            if(logisticsTemplate != null){
                orderDetailVo.setLmsLogisticsTemplate(logisticsTemplate);
            }

            //获取订单的全场通用的优惠劵信息
            SmsCoupon coupon = couponMapper.selectByPrimaryKey(order.getCouponId());
            if(coupon != null){
                orderDetailVo.setCoupon(coupon);
            }

            //获取订单的全场通用的营销活动信息
            SmsMarketingActivities marketingActivities = marketingActivitiesMapper.selectByPrimaryKey(order.getMarketingActivityId());
            if(marketingActivities != null){
                orderDetailVo.setMarketingActivities(marketingActivities);
            }

            //获取订单的商品及其优惠详情
            List<OmsOrderItemDetailVo> orderItemDetailVoList = new ArrayList<OmsOrderItemDetailVo>();
            OmsOrderItemExample orderItemExample = new OmsOrderItemExample();
            orderItemExample.createCriteria().andOrderIdEqualTo(order.getId());
            List<OmsOrderItem>  omsOrderItemList = orderItemMapper.selectByExample(orderItemExample);
            for (OmsOrderItem orderItem : omsOrderItemList) {
                //定义元素
                OmsOrderItemDetailVo orderItemDetailVo = new OmsOrderItemDetailVo();

                //商品详情
                BeanUtils.copyProperties(orderItem, orderItemDetailVo);

                //根据商品ID获取商品的优惠劵信息
                List<SmsCoupon> couponList = new ArrayList<SmsCoupon>();
                SmsCouponProductRelationExample couponProductRelationExample = new SmsCouponProductRelationExample();
                couponProductRelationExample.createCriteria().andProductIdEqualTo(orderItem.getProductId());
                List<SmsCouponProductRelation>  couponProductRelationList =
                        couponProductRelationMapper.selectByExample(couponProductRelationExample);
                if(couponProductRelationList != null){
                    for (SmsCouponProductRelation e1 : couponProductRelationList) {
                        SmsCoupon coupon1 = couponMapper.selectByPrimaryKey(e1.getCouponId());
                        couponList.add(coupon1);
                    }
                }
                orderItemDetailVo.setCouponList(couponList);

                //根据商品ID获取商品的营销活动信息
                List<OmsMarketingActivityDo>  marketingActivitiesDtoList = new ArrayList<OmsMarketingActivityDo>();
                SmsMarketingActivityProductRelationExample marketingActivityProductRelationExample =
                        new SmsMarketingActivityProductRelationExample();
                marketingActivityProductRelationExample.createCriteria().andProductIdEqualTo(orderItem.getProductId());
                List<SmsMarketingActivityProductRelation> marketingActivityProductRelationList =
                        marketingActivityProductRelationMapper.selectByExample(marketingActivityProductRelationExample);
                for (SmsMarketingActivityProductRelation e2 : marketingActivityProductRelationList) {
                    //定义
                    OmsMarketingActivityDo marketingActivityDto = new OmsMarketingActivityDo();
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
                orderItemDetailVo.setMarketingActivityDtoList(marketingActivitiesDtoList);

                //拼接元素
                orderItemDetailVoList.add(orderItemDetailVo);
            }

            orderDetailVo.setOrderItemDetailDtoList(orderItemDetailVoList);

        }

        //返回查询结果
        return orderDetailVoList;
    }

    @Override
    public int delivery(List<OmsOrderDeliveryParam> deliveryParamList) {
        //批量发货
        int count = orderDao.delivery(deliveryParamList);
        //添加操作记录
        List<OmsOrderOperateHistory> operateHistoryList = deliveryParamList.stream()
                .map(omsOrderDeliveryParam -> {
                    OmsOrderOperateHistory history = new OmsOrderOperateHistory();
                    history.setOrderId(omsOrderDeliveryParam.getOrderId());
                    history.setCreateTime(new Date());
                    history.setOperateMan("后台管理员");
                    history.setOrderStatus(2);
                    history.setNote("完成发货");
                    return history;
                }).collect(Collectors.toList());
        orderOperateHistoryDao.insertList(operateHistoryList);
        return count;
    }

    @Override
    public int close(List<Long> ids, String note) {
        OmsOrder record = new OmsOrder();
        record.setStatus(4);
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andDeleteStatusEqualTo(0).andIdIn(ids);
        int count = orderMapper.updateByExampleSelective(record, example);
        List<OmsOrderOperateHistory> historyList = ids.stream().map(orderId -> {
            OmsOrderOperateHistory history = new OmsOrderOperateHistory();
            history.setOrderId(orderId);
            history.setCreateTime(new Date());
            history.setOperateMan("后台管理员");
            history.setOrderStatus(4);
            history.setNote("订单关闭:"+note);
            return history;
        }).collect(Collectors.toList());
        orderOperateHistoryDao.insertList(historyList);
        return count;
    }

    @Override
    public int updateOrderStatus(Long id, Integer status) {
        OmsOrder omsOrder = new OmsOrder();
        omsOrder.setId(id);
        omsOrder.setStatus(status);
        return orderMapper.updateByPrimaryKey(omsOrder);
    }

    /**
     * /* 更改订单信息
     *
     * @param omsOrder
     */
    @Override
    public int updateOrderGeneralInfo(OmsOrder omsOrder) {
        return orderMapper.updateByPrimaryKey(omsOrder);
    }

    @Override
    public int updateOrderConfirmStatus(Long id, Integer confirmStatus) {
        OmsOrder omsOrder = new OmsOrder();
        omsOrder.setId(id);
        omsOrder.setConfirmStatus(confirmStatus);
        return orderMapper.updateByPrimaryKey(omsOrder);
    }

    @Override
    public CommonResult reviewOrder(Long orderId, Integer status) {
        //1-更改订单审核状态  审核通过后  订单状态改为 待支付
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        if (order.getStatus() != 1) {
            log.error("订单状态不是待审核状态，不可审核");
            return new CommonResult().failed(10000,"订单状态不是待审核状态，不可审核");
        }
        order.setId(orderId);
        order.setStatus(status);
        order.setLastUpdateId(AppOprRoleConst.ROLE_ADMIN);
        order.setLastUpdateTime(new Date());
        if(orderMapper.updateByPrimaryKeySelective(order) < 0){
            log.error("更改订单状态失败{}", order);
            return new CommonResult().failed(10001,"订单状态更新失败");
        }
        //2-登记订单的操作日志
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(orderId);
        history.setCreateTime(new Date());
        history.setOperateMan(AppOprRoleConst.ROLE_MEMBER);
        history.setOrderStatus(OmsOrderConst.STATUS_TOBE_PAY_2);
        history.setNote("订单审核通过, 待客户付款");
        if(orderOperateHistoryMapper.insert(history) != 1){
            log.error("登记订单操作日志失败");
            return new CommonResult().failed(10001,"订单状态更新日志记录失败");
        }
        return new CommonResult().success(1);
    }

    /**
     * 更改订单删除状态
     *
     * @param id
     * @param deleteStatus
     */
    @Override
    public int updateOrderDeleteStatus(Long id, Integer deleteStatus) {
        OmsOrder omsOrder = new OmsOrder();
        omsOrder.setId(id);
        omsOrder.setDeleteStatus(deleteStatus);
        return orderMapper.updateByPrimaryKey(omsOrder);
    }

    /**
     * 逻辑删除订单
     *
     * @param id
     */
    @Override
    public int logicDelete(Long id) {
        OmsOrder omsOrder = new OmsOrder();
        omsOrder.setId(id);
        omsOrder.setDeleteStatus(ORDER_DELETE_STATUS_DISUSE_1);
        return orderMapper.updateByPrimaryKey(omsOrder);
    }

    /**
     * 物理删除订单
     *
     * @param id
     */
    @Override
    public int delete(Long id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    /**
     * 增加订单的备选物流方式
     *
     * @param orderId
     * @param logisticsModeOption
     */
    @Override
    public int addOrderLogisticsModeOption(Long orderId, OmsLogisticsModeOption logisticsModeOption) {
        return logisticsModeOptionMapper.insert(logisticsModeOption);
    }

    /**
     * 删除订单的备选物流方式
     *
     * @param logisticsOptionId
     */
    @Override
    public int deleteOrderLogisticsModeOption(Long logisticsOptionId) {
        return logisticsModeOptionMapper.deleteByPrimaryKey(logisticsOptionId);
    }

    /**
     * 查询订单的备选物流方式
     *
     * @param orderId
     */
    @Override
    public OmsOrderLogisticsModeOptionDTO listOrderLogisticsModeOption(Long orderId) {
        //获取订单的备选物流方式
        OmsLogisticsModeOptionExample logisticsModeOptionExample = new OmsLogisticsModeOptionExample();
        logisticsModeOptionExample.createCriteria().andOrderIdEqualTo(orderId);
        List<OmsLogisticsModeOption> logisticsModeOptionList = logisticsModeOptionMapper.selectByExample(logisticsModeOptionExample);

        //备选物流方式的定义信息
        List<Long> ids = new ArrayList<>();
        for (OmsLogisticsModeOption e : logisticsModeOptionList) {
            ids.add(e.getId());
        }
        LmsLogisticsModeExample  logisticsModeExample = new LmsLogisticsModeExample();
        logisticsModeExample.createCriteria().andIdIn(ids);
        List<LmsLogisticsMode>   lmsLogisticsModeList = logisticsModeMapper.selectByExample(logisticsModeExample);

        //组合查询结果
        OmsOrderLogisticsModeOptionDTO omsOrderLogisticsModeOptionDTO = new OmsOrderLogisticsModeOptionDTO();
        omsOrderLogisticsModeOptionDTO.setOrderId(orderId);
        omsOrderLogisticsModeOptionDTO.setLogisticsModeOption(logisticsModeOptionList);
        omsOrderLogisticsModeOptionDTO.setLogisticsMode(lmsLogisticsModeList);

        return omsOrderLogisticsModeOptionDTO;
    }

    @Override
    public int delete(List<Long> ids) {
        OmsOrder record = new OmsOrder();
        record.setDeleteStatus(1);
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andDeleteStatusEqualTo(0).andIdIn(ids);
        return orderMapper.updateByExampleSelective(record, example);
    }

    @Override
    public OmsOrderDetail detail(Long id) {
        return orderDao.getDetail(id);
    }

    @Override
    public int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam) {
        OmsOrder order = new OmsOrder();
        order.setId(receiverInfoParam.getOrderId());
        order.setReceiverName(receiverInfoParam.getReceiverName());
        order.setReceiverPhone(receiverInfoParam.getReceiverPhone());
        order.setReceiverPostCode(receiverInfoParam.getReceiverPostCode());
        order.setReceiverDetailAddress(receiverInfoParam.getReceiverDetailAddress());
        order.setReceiverProvince(receiverInfoParam.getReceiverProvince());
        order.setReceiverCity(receiverInfoParam.getReceiverCity());
        order.setReceiverRegion(receiverInfoParam.getReceiverRegion());
        order.setModifyTime(new Date());
        int count = orderMapper.updateByPrimaryKeySelective(order);
        //插入操作记录
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(receiverInfoParam.getOrderId());
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(receiverInfoParam.getStatus());
        history.setNote("修改收货人信息");
        orderOperateHistoryMapper.insert(history);
        return count;
    }

    @Override
    public int updateMoneyInfo(OmsMoneyInfoParam moneyInfoParam) {
        OmsOrder order = new OmsOrder();
        order.setId(moneyInfoParam.getOrderId());
        order.setFreightAmount(moneyInfoParam.getFreightAmount());
        order.setDiscountAmount(moneyInfoParam.getDiscountAmount());
        order.setModifyTime(new Date());
        int count = orderMapper.updateByPrimaryKeySelective(order);
        //插入操作记录
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(moneyInfoParam.getOrderId());
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(moneyInfoParam.getStatus());
        history.setNote("修改费用信息");
        orderOperateHistoryMapper.insert(history);
        return count;
    }

    @Override
    public int updateNote(Long id, String note, Integer status) {
        OmsOrder order = new OmsOrder();
        order.setId(id);
        order.setNote(note);
        order.setModifyTime(new Date());
        int count = orderMapper.updateByPrimaryKeySelective(order);
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(id);
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(status);
        history.setNote("修改备注信息："+note);
        orderOperateHistoryMapper.insert(history);
        return count;
    }

    /**
     * 创建订单
     *
     * @param orderAddDto
     */
    @Override
    public int add(OmsOrderAddDto orderAddDto) {
        OmsOrder omsOrder = new OmsOrder();
        BeanUtils.copyProperties(orderAddDto, omsOrder);
        //默认在用
        omsOrder.setDeleteStatus(OmsOrderConst.DELETE_STATUS_INUSE_0);
        omsOrder.setStatus(OmsOrderConst.STATUS_TOBE_COMMIT_0);
        //默认为线下支付方式
        omsOrder.setPayType(OmsPayConst.PAY_OFFLINE_0);
        omsOrder.setSourceType(0);
        omsOrder.setOrderType(0);
        omsOrder.setCreateTime(new Date());
        omsOrder.setLastCreateId("admin");
        omsOrder.setLastCreateTime(new Date());
        omsOrder.setLastUpdateId("admin");
        omsOrder.setLastUpdateTime(new Date());
        if (orderMapper.insertSelective(omsOrder) < 0){
            log.error("登记单基本信息失败{}", omsOrder);
            return -1;
        }

        List<PmsProductDto> pmsProductDtoList  =  orderAddDto.getProductList();
        for (PmsProductDto e : pmsProductDtoList) {
            PmsSkuStock skuStock = e.getSkuInfo();
            PmsProductAttributeExample pmsProductAttributeExample = new PmsProductAttributeExample();
            pmsProductAttributeExample.setOrderByClause("sort desc");
            pmsProductAttributeExample.createCriteria().andProductAttributeCategoryIdEqualTo(e.getProductCategoryId())
                    .andTypeEqualTo(0);
            List<PmsProductAttribute> productAttributes = productAttributeMapper.selectByExample(pmsProductAttributeExample);
            JSONArray productAttr = new JSONArray();

            if (productAttributes.size() >= 1) {
                JSONObject attr = new JSONObject();
                attr.put(productAttributes.get(0).getName(), skuStock.getSp1());
                productAttr.add(attr);
            }
            if (productAttributes.size() >= 2) {
                JSONObject attr = new JSONObject();
                attr.put(productAttributes.get(1).getName(), skuStock.getSp2());
                productAttr.add(attr);
            }
            if (productAttributes.size() >= 3) {
                JSONObject attr = new JSONObject();
                attr.put(productAttributes.get(2).getName(), skuStock.getSp3());
                productAttr.add(attr);
            }

            OmsOrderItem omsOrderItem = new OmsOrderItem();
            omsOrderItem.setOrderId(omsOrder.getId());
            omsOrderItem.setOrderSn(omsOrder.getOrderSn());
            omsOrderItem.setProductId(e.getId());
            omsOrderItem.setProductSn(e.getProductSn());
            omsOrderItem.setProductName(e.getName());
            omsOrderItem.setProductBrand(e.getBrandName());
            omsOrderItem.setProductCategoryId(e.getProductCategoryId());
            omsOrderItem.setProductPic(e.getPic());
            omsOrderItem.setProductSkuId(e.getId());
            omsOrderItem.setProductSkuCode(skuStock.getSkuCode());
            omsOrderItem.setPicConfirmStatus("00"); //00 - 未确认
            omsOrderItem.setProductPrice(skuStock.getPrice());
            omsOrderItem.setProductQuantity(e.getProductQuantity());
            omsOrderItem.setProductAttr(JSONArray.toJSONString(productAttr));
            omsOrderItem.setGiftIntegration(0);
            omsOrderItem.setGiftGrowth(0);
            //TODO 其余字段填值待确认,暂时不填
            if(orderItemMapper.insertSelective(omsOrderItem) < 0){
                log.error("登记订单明细失败{}", omsOrderItem);
                return -1;
            }
        }

        return 1;
    }

    /**
     * 为订单添加商品
     *
     * @param listOrderItem
     */
    @Override
    @Transactional
    public int addOrderItem(List<OmsOrderItem> listOrderItem) {
        int result = -1;
        for (int i = 0; i < listOrderItem.size(); i++){
            result = orderItemMapper.insert(listOrderItem.get(i));
            if (result <= 0){
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
        int result = -1;
        for (int i = 0; i < listOrderItem.size(); i++){
            result = orderItemMapper.deleteByPrimaryKey(listOrderItem.get(i).getId());
            if (result <= 0){
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
        int result = -1;
        for (int i = 0; i < listOrderItem.size(); i++){
            result = orderItemMapper.updateByPrimaryKey(listOrderItem.get(i));
            if (result <= 0){
                return -1;
            }
        }
        return 0;
    }

    /**
     * 查询订单商品信息 by orderId
     *
     * @param orderId
     */
    @Override
    public List<OmsOrderItem> listOrderItem(Long orderId) {
        OmsOrderItemExample example = new OmsOrderItemExample();
        example.createCriteria().andOrderIdEqualTo(orderId);
        return orderItemMapper.selectByExample(example);
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
        return orderLogisticsTraceLogDao.getLastOrderTraceLog(orderId);
    }


    /**
     * 增加订单的备选支付方式
     *
     * @param orderId
     * @param payModeOption
     */
    @Override
    public int addOrderPayOption(Long orderId, OmsPayModeOption payModeOption) {
        return payModeOptionMapper.insert(payModeOption);
    }

    /**
     * 删除订单的备选支付方式
     *
     * @param payOptionId
     */
    @Override
    public int deleteOrderPayOption(Long payOptionId) {
        return payModeOptionMapper.deleteByPrimaryKey(payOptionId);
    }


    @Override
    public OmsOrderPayModeOptionDTO listOrderPayOption(Long orderId) {
        return null;
    }
}
