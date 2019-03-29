package com.macro.mall.portal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单模块-订单及其关联详情Dto
 * Created by ruiwu.xu on 2019/01/19.
 */
@ApiModel(value= "订单模块-订单及其关联详情Dto",description = "订单及其关联详情Dto:OmsPortalOrderDetailDto")
@Getter
@Setter
public class OmsPortalOrderDetailDto extends  OmsOrder{
    @ApiModelProperty(value = "订单的商品及其优惠详情")
    private List<OmsPortalOrderItemDetailDto> portalOrderItemDetailDtoList;
}
