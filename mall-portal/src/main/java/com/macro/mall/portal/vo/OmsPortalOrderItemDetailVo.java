package com.macro.mall.portal.vo;

import com.macro.mall.portal.domain.OmsPortalMarketingActivityDo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单模块-订单的商品及其优惠详情
 * Created by ruiwu.xu on 2019/01/19.
 */
@ApiModel(value= "订单模块-订单的商品及其优惠详情",description = "订单的商品及其优惠详情:OmsPortalOrderItemDetailVo")
@Getter
@Setter
public class OmsPortalOrderItemDetailVo extends OmsOrderItem{
    @ApiModelProperty(value = "商品的sku")
    private PmsSkuStock skuStock;
    @ApiModelProperty(value = "商品的优惠劵")
    private List<SmsCoupon> couponList;
    @ApiModelProperty(value = "商品的营销活动")
    private List<OmsPortalMarketingActivityDo> marketingActivityDtoList;
}
