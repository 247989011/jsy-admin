package com.macro.mall.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.mapper.*;
import com.macro.mall.common.model.*;
import com.macro.mall.portal.dao.PmsSkuStockDao;
import com.macro.mall.portal.dto.OmsPortalSkuDto;
import com.macro.mall.portal.service.OmsPortalSkuStockService;
import com.macro.mall.portal.service.common.OmsPortalProductCommon;
import com.macro.mall.portal.vo.PmsPortalProductDetailVo;
import com.xiaoleilu.hutool.bean.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 商品sku库存管理Service实现类
 * Created by macro on 2018/4/27.
 */
@Service
public class OmsPortalSkuStockServiceImpl implements OmsPortalSkuStockService {
    @Autowired
    private PmsSkuStockMapper skuStockMapper;
    @Autowired
    private PmsSkuStockDao skuStockDao;
    @Autowired
    private PmsProductMapper productMapper;
    @Autowired
    private OmsOrderItemMapper omsOrderItemMapper;
    @Autowired
    private SmsMarketingActivityProductRelationMapper marketingActivityProductRelationMapper;
    @Autowired
    private SmsMarketingActivityProductCategoryRelationMapper marketingActivityProductCategoryRelationMapper;
    @Autowired
    private  SmsMarketingActivitiesMapper marketingActivitiesMapper;
    @Autowired
    private  SmsMarketingActivityRuleMapper marketingActivityRuleMapper;
    @Autowired
    private  SmsCouponProductRelationMapper couponProductRelationMapper;
    @Autowired
    private  SmsCouponProductCategoryRelationMapper couponProductCategoryRelationMapper;
    @Autowired
    private  SmsCouponMapper couponMapper;
    @Autowired
    private PmsProductAttributeMapper pmsProductAttributeMapper;
    @Autowired
    private OmsPortalProductCommon portalProductCommon;

    @Override
    public List<PmsSkuStock> getList(Long pid, String keyword) {
        PmsSkuStockExample example = new PmsSkuStockExample();
        PmsSkuStockExample.Criteria criteria = example.createCriteria().andProductIdEqualTo(pid);
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andSkuCodeLike("%" + keyword + "%");
        }
        return skuStockMapper.selectByExample(example);
    }

    //获取商品的营销活动信息
//    private  List<OmsPortalMarketingActivityDo>  getProductMarketingActivityDetail(Long productId){
//        //获取商品的营销活动信息
//        List<OmsPortalMarketingActivityDo> marketingActivityDtoList = new ArrayList<OmsPortalMarketingActivityDo>();
//        //从商品ID获取参加的所有营销活动
//        SmsMarketingActivityProductRelationExample productRelationExample =
//                new SmsMarketingActivityProductRelationExample();
//        productRelationExample.createCriteria().andProductIdEqualTo(productId);
//        List<SmsMarketingActivityProductRelation> productRelationList =
//                marketingActivityProductRelationMapper.selectByExample(productRelationExample);
//        for (SmsMarketingActivityProductRelation e1 : productRelationList) {
//            //定义
//            OmsPortalMarketingActivityDo portalMarketingActivityDto =
//                    new OmsPortalMarketingActivityDo();
//
//            //设置营销活动
//            SmsMarketingActivities marketingActivities = marketingActivitiesMapper.selectByPrimaryKey(e1.getActivityId());
//            if(marketingActivities != null){
//                BeanUtils.copyProperties(marketingActivities, portalMarketingActivityDto);
//            }
//
//            //设置营销活动对应的营销活动规则
//            SmsMarketingActivityRuleExample activityRuleExample = new SmsMarketingActivityRuleExample();
//            activityRuleExample.createCriteria().andActivityIdEqualTo(e1.getActivityId());
//            SmsMarketingActivityRule activityRule = marketingActivityRuleMapper.selectByExample(activityRuleExample).get(0);
//            portalMarketingActivityDto.setSmsMarketingActivityRule(activityRule);
//
//            //增加
//            marketingActivityDtoList.add(portalMarketingActivityDto);
//        }
//        //从商品分类获取参加的所有营销活动
//        SmsMarketingActivityProductCategoryRelationExample activityProductCategoryRelationExample =
//                new SmsMarketingActivityProductCategoryRelationExample();
//        activityProductCategoryRelationExample.createCriteria().andProductCategoryIdEqualTo(
//                productMapper.selectByPrimaryKey(productId).getProductCategoryId());
//        List<SmsMarketingActivityProductCategoryRelation>  marketingActivityProductCategoryRelationList =
//                marketingActivityProductCategoryRelationMapper.selectByExample(activityProductCategoryRelationExample);
//        for (SmsMarketingActivityProductCategoryRelation e2 : marketingActivityProductCategoryRelationList) {
//            //定义
//            OmsPortalMarketingActivityDo portalMarketingActivityDto = new OmsPortalMarketingActivityDo();
//
//            //设置营销活动
//            SmsMarketingActivities marketingActivities = marketingActivitiesMapper.selectByPrimaryKey(e2.getActivityId());
//            if(marketingActivities != null){
//                BeanUtils.copyProperties(marketingActivities, portalMarketingActivityDto);
//            }
//
//            //设置营销活动对应的营销活动规则
//            SmsMarketingActivityRuleExample activityRuleExample = new SmsMarketingActivityRuleExample();
//            activityRuleExample.createCriteria().andActivityIdEqualTo(e2.getActivityId());
//            SmsMarketingActivityRule activityRule = marketingActivityRuleMapper.selectByExample(activityRuleExample).get(0);
//            portalMarketingActivityDto.setSmsMarketingActivityRule(activityRule);
//
//            //增加
//            marketingActivityDtoList.add(portalMarketingActivityDto);
//        }
//
//        return marketingActivityDtoList;
//    }

//    //获取商品的营销活动信息
//    private  List<SmsCoupon>  getProductCouponDetail(Long productId){
//        //获取商品的优惠劵信息
//        List<SmsCoupon> couponList = new ArrayList<SmsCoupon>();
//        //从商品ID获取商品参加的优惠劵
//        //TODO 只获取客户持有的相关商品的优惠券！！！
//        SmsCouponProductRelationExample couponProductRelationExample = new SmsCouponProductRelationExample();
//        couponProductRelationExample.createCriteria()
//                .andProductIdEqualTo(productId);
//        List<SmsCouponProductRelation> couponProductRelationList = couponProductRelationMapper.
//                selectByExample(couponProductRelationExample);
//        for (SmsCouponProductRelation e3 : couponProductRelationList) {
//            SmsCoupon coupon = couponMapper.selectByPrimaryKey(e3.getCouponId());
//            couponList.add(coupon);
//        }
//        //从商品分类获取商品参加的优惠劵
//        SmsCouponProductCategoryRelationExample couponProductCategoryRelationExample =
//                new SmsCouponProductCategoryRelationExample();
//        couponProductCategoryRelationExample.createCriteria().andProductCategoryIdEqualTo(
//                productMapper.selectByPrimaryKey(productId).getProductCategoryId());
//        List<SmsCouponProductCategoryRelation>  couponProductCategoryRelationList =
//                couponProductCategoryRelationMapper.selectByExample(couponProductCategoryRelationExample);
//        for (SmsCouponProductCategoryRelation e4 : couponProductCategoryRelationList) {
//            SmsCoupon coupon = couponMapper.selectByPrimaryKey(e4.getCouponId());
//            couponList.add(coupon);
//        }
//
//        return couponList;
//    }

    //根据商品名称、商品Sku编号、商品货号进行模糊搜索
    @Override
    public List<PmsPortalProductDetailVo> pageProductDetail(Long memberId, String keyword, Integer pageSize, Integer pageNum) {
        //定义返回值变量
        //List<PmsPortalProductDetailVo> productDetailVoList = new ArrayList<PmsPortalProductDetailVo>();
        //设置分页查询
        PageHelper.startPage(pageNum, pageSize);
        //处理查询关键字
        StringBuffer sb = new StringBuffer();
        sb.append("%").append(keyword).append("%");

        //从sku库获取商品及其优惠详情
        PmsSkuStockExample skuStockExample = new PmsSkuStockExample();
        skuStockExample.createCriteria().andSkuCodeLike(sb.toString());
        List<PmsSkuStock>  skuStockList = skuStockMapper.selectByExample(skuStockExample);
        Set<PmsProduct> products = new HashSet<>();
        for (PmsSkuStock e : skuStockList) {
            //拷贝商品信息
            PmsProduct  product = productMapper.selectByPrimaryKey(e.getProductId());
            products.add(product);
        }
        //商品库获取商品及其优惠详情
        PmsProductExample productExample = new PmsProductExample();
        productExample.createCriteria().andNameLike(sb.toString());
        List<PmsProduct> productList = productMapper.selectByExample(productExample);
        products.addAll(productList);

        List<PmsPortalProductDetailVo>  productDetailVoList = portalProductCommon.productDetail(products, memberId);

// TODO  提取公共部分
//        for (PmsProduct e : products) {
//            PmsSkuStockExample skuStockExample1 = new PmsSkuStockExample();
//            skuStockExample1.createCriteria().andProductIdEqualTo(e.getId());
//            List<PmsSkuStock>  skuStocks = skuStockMapper.selectByExample(skuStockExample1);
//            if (skuStocks.isEmpty()) {
//                continue;
//            }
//            //获取商品的营销活动信息
//            List<OmsPortalMarketingActivityDo>  portalMarketingActivityDtoList = getProductMarketingActivityDetail(e.getId());
//            //获取客户持有的商品的优惠劵信息
//            List<SmsCoupon>  couponList =  getProductCouponDetail(e.getId());
//            //获取商品属性
//            PmsProductAttributeExample attributeExample = new PmsProductAttributeExample();
//            attributeExample.createCriteria()
//                    .andProductAttributeCategoryIdEqualTo(e.getProductAttributeCategoryId())
//                    .andTypeEqualTo(0);
//            attributeExample.setOrderByClause(" sort asc ");
//            List<PmsProductAttribute> productAttributes = pmsProductAttributeMapper.selectByExample(attributeExample);
//
//            for (PmsSkuStock skuStock : skuStocks) {
//                JSONArray productAttr = new JSONArray();
//                int iii = 0;
//                for (PmsProductAttribute productAttribute : productAttributes) {
//                    JSONObject jsonObject = new JSONObject();
//                    jsonObject.put("key", productAttribute.getName());
//                    if (iii == 0) {
//                        jsonObject.put("value", skuStock.getSp1());
//                    }else if (iii == 1) {
//                        jsonObject.put("value", skuStock.getSp2());
//                    }else if (iii == 2) {
//                        jsonObject.put("value", skuStock.getSp3());
//                    }
//                    productAttr.add(jsonObject);
//                    iii++;
//                }
//
//                PmsPortalProductDetailVo portalProductDetailDto = new PmsPortalProductDetailVo();
//                portalProductDetailDto.setSkuStock(new PmsSkuStock());
//                portalProductDetailDto.setCouponList(Lists.newArrayList());
//                portalProductDetailDto.setMarketingActivityDtoList(Lists.newArrayList());
//                portalProductDetailDto.setProductId(e.getId());
//                portalProductDetailDto.setProductSn(e.getProductSn());
//                portalProductDetailDto.setProductName(e.getName());
//                portalProductDetailDto.setProductBrand(e.getBrandName());
//                portalProductDetailDto.setProductCategoryId(e.getProductCategoryId());
//                portalProductDetailDto.setProductPic(e.getPic());
//                portalProductDetailDto.setProductSkuId(skuStock.getId());
//                portalProductDetailDto.setProductSkuCode(skuStock.getSkuCode());
//                portalProductDetailDto.setPicConfirmStatus("00");
//                portalProductDetailDto.setProductPrice(skuStock.getPrice());
//                portalProductDetailDto.setProductQuantity(1);
//                portalProductDetailDto.setCouponAmount(new BigDecimal("0"));
//                portalProductDetailDto.setActivityAmount(new BigDecimal("0"));
//                portalProductDetailDto.setProductAttr(productAttr.toJSONString(2));
//                portalProductDetailDto.setSp1(skuStock.getSp1());
//                portalProductDetailDto.setSp2(skuStock.getSp2());
//                portalProductDetailDto.setSp3(skuStock.getSp3());
//
//                portalProductDetailDto.setMarketingActivityDtoList(portalMarketingActivityDtoList);
//                portalProductDetailDto.setCouponList(couponList);
//                portalProductDetailDto.setSkuStock(skuStock);
//                //增加
//                productDetailVoList.add(portalProductDetailDto);
//            }
//        }
        return productDetailVoList;
    }

    @Override
    public List<OmsPortalSkuDto> getSkuAndProductList(Long pid, String keyword) {
        //定义查询结果
        List<OmsPortalSkuDto> omsPortalSkuDtoList = new ArrayList<OmsPortalSkuDto>();

        //查询sku
        PmsSkuStockExample example = new PmsSkuStockExample();
        PmsSkuStockExample.Criteria criteria = example.createCriteria().andProductIdEqualTo(pid);
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andSkuCodeLike("%" + keyword + "%");
        }
        List<PmsSkuStock>  pmsSkuStockList = skuStockMapper.selectByExample(example);

        //查询sku对应的商品信息
        for (PmsSkuStock e : pmsSkuStockList) {
            OmsPortalSkuDto omsPortalSkuDto = new OmsPortalSkuDto();
            BeanUtil.copyProperties(e, omsPortalSkuDto);
            PmsProduct pmsProduct= productMapper.selectByPrimaryKey(e.getProductId());
            if(pmsProduct != null) {
                BeanUtil.copyProperties(pmsProduct, omsPortalSkuDto);
            }else {
                return null;
            }
            omsPortalSkuDtoList.add(omsPortalSkuDto);
        }

        //返回查询结果
        return omsPortalSkuDtoList;
    }

    @Override
    public int update(Long pid, List<PmsSkuStock> skuStockList) {
        return skuStockDao.replaceList(skuStockList);
    }

    /**
     * 通过SKU为订单增加商品信息
     *
     * @param order
     * @param skuStockList
     */
    @Override
    public int addOrderProductBySku(OmsOrder order, List<PmsSkuStock> skuStockList) {
        //根据SKU获取商品详情
        //商品加入到订单商品项
        for (PmsSkuStock e : skuStockList) {
            PmsProduct product  = productMapper.selectByPrimaryKey(e.getProductId());
            if(product != null){
                OmsOrderItem orderItem = new OmsOrderItem();
                orderItem.setOrderId(order.getId());
                orderItem.setOrderSn(order.getOrderSn());
                orderItem.setProductId(product.getId());
                orderItem.setProductSn(product.getProductSn());
                orderItem.setProductBrand(product.getBrandName());
                orderItem.setProductName(product.getName());
                orderItem.setProductPic(product.getPic());
                //00 - 未确认
                orderItem.setPicConfirmStatus("00");
                orderItem.setProductSkuId(e.getId());
                orderItem.setProductSkuCode(e.getSkuCode());
                orderItem.setProductCategoryId(product.getProductCategoryId());
                orderItem.setProductPrice(product.getPrice());
                //默认填 0
                orderItem.setProductQuantity(0);
                omsOrderItemMapper.insert(orderItem);

                /*如下字段不做设置
                private String sp1;
                private String sp2;
                private String sp3;
                private String productAttr;
                private String promotionName;
                private BigDecimal promotionAmount;
                private BigDecimal couponAmount;
                private BigDecimal integrationAmount;
                private BigDecimal realAmount;
                private Integer giftIntegration;
                private Integer giftGrowth;
                */

            }
        }
        return 0;
    }
}
