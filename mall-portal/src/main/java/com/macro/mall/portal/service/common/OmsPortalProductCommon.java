package com.macro.mall.portal.service.common;

import com.google.common.collect.Lists;
import com.macro.mall.mapper.PmsProductAttributeMapper;
import com.macro.mall.mapper.PmsSkuStockMapper;
import com.macro.mall.model.*;
import com.macro.mall.portal.domain.OmsPortalMarketingActivityDo;
import com.macro.mall.portal.vo.PmsPortalProductDetailVo;
import com.xiaoleilu.hutool.json.JSONArray;
import com.xiaoleilu.hutool.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class OmsPortalProductCommon {
    @Autowired
    private PmsSkuStockMapper skuStockMapper;
    @Autowired
    private PmsProductAttributeMapper productAttributeMapper;
    @Autowired
    private  OmsPortalPromotionCommon promotionCommon;
    
    //根据商品基本信息组装商品详情
    public List<PmsPortalProductDetailVo> productDetail(Set<PmsProduct> products, Long memberId) {
        //定义返回值变量
        List<PmsPortalProductDetailVo> portalProductDetailVoList = new ArrayList<PmsPortalProductDetailVo>();
        
        for (PmsProduct e : products) {
            PmsSkuStockExample skuStockExample1 = new PmsSkuStockExample();
            skuStockExample1.createCriteria().andProductIdEqualTo(e.getId());
            List<PmsSkuStock>  skuStocks = skuStockMapper.selectByExample(skuStockExample1);
            if (skuStocks.isEmpty()) {
                continue;
            }
            //获取商品的营销活动信息
            List<OmsPortalMarketingActivityDo>  portalMarketingActivityDtoList =
                    promotionCommon.searchAppointMarketingActivity(e.getId());
            //获取客户持有的商品的优惠劵信息
            List<SmsCoupon>  couponList =  promotionCommon.searchAppointCoupon(memberId, e.getId());
            //获取商品属性
            PmsProductAttributeExample attributeExample = new PmsProductAttributeExample();
            attributeExample.createCriteria()
                    .andProductAttributeCategoryIdEqualTo(e.getProductAttributeCategoryId())
                    .andTypeEqualTo(0);
            attributeExample.setOrderByClause(" sort asc ");
            List<PmsProductAttribute> productAttributes = productAttributeMapper.selectByExample(attributeExample);

            for (PmsSkuStock skuStock : skuStocks) {
                JSONArray productAttr = new JSONArray();
                int iii = 0;
                for (PmsProductAttribute productAttribute : productAttributes) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("key", productAttribute.getName());
                    if (iii == 0) {
                        jsonObject.put("value", skuStock.getSp1());
                    }else if (iii == 1) {
                        jsonObject.put("value", skuStock.getSp2());
                    }else if (iii == 2) {
                        jsonObject.put("value", skuStock.getSp3());
                    }
                    productAttr.add(jsonObject);
                    iii++;
                }

                PmsPortalProductDetailVo portalProductDetailDto = new PmsPortalProductDetailVo();
                portalProductDetailDto.setSkuStock(new PmsSkuStock());
                portalProductDetailDto.setCouponList(Lists.newArrayList());
                portalProductDetailDto.setMarketingActivityDtoList(Lists.newArrayList());
                portalProductDetailDto.setProductId(e.getId());
                portalProductDetailDto.setProductSn(e.getProductSn());
                portalProductDetailDto.setProductName(e.getName());
                portalProductDetailDto.setProductBrand(e.getBrandName());
                portalProductDetailDto.setProductCategoryId(e.getProductCategoryId());
                portalProductDetailDto.setProductPic(e.getPic());
                portalProductDetailDto.setProductSkuId(skuStock.getId());
                portalProductDetailDto.setProductSkuCode(skuStock.getSkuCode());
                portalProductDetailDto.setPicConfirmStatus("00");
                portalProductDetailDto.setProductPrice(skuStock.getPrice());
                portalProductDetailDto.setProductQuantity(1);
                portalProductDetailDto.setCouponAmount(new BigDecimal("0"));
                portalProductDetailDto.setActivityAmount(new BigDecimal("0"));
                portalProductDetailDto.setProductAttr(productAttr.toJSONString(2));
                portalProductDetailDto.setSp1(skuStock.getSp1());
                portalProductDetailDto.setSp2(skuStock.getSp2());
                portalProductDetailDto.setSp3(skuStock.getSp3());

                portalProductDetailDto.setMarketingActivityDtoList(portalMarketingActivityDtoList);
                portalProductDetailDto.setCouponList(couponList);
                portalProductDetailDto.setSkuStock(skuStock);
                //增加
                portalProductDetailVoList.add(portalProductDetailDto);
            }
        }
        return portalProductDetailVoList;
    }
}
