package com.macro.mall.portal.dto;

import com.macro.mall.model.OmsOrderItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 订单模块-订单的商品及其优惠详情Dto
 * Created by ruiwu.xu on 2019/01/19.
 */
@ApiModel(value= "订单模块-订单的商品及其优惠详情Dto",description = "订单的商品及其优惠详情Dto:OmsPortalOrderItemDetailVo")
@Getter
@Setter
public class OmsPortalOrderItemDetailDto extends OmsOrderItem{
    @ApiModelProperty(value = "商品的skuID")
    //private PmsSkuStock skuStock;
    private Long skuStockId;
}
