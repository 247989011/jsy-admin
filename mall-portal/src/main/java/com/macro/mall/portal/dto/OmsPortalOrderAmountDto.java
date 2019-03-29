package com.macro.mall.portal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 商品营销活动信息
 * Created by ruiwu.xu on 2019/01/19.
 */
@ApiModel(value= "订单模块-订单总金额",description = "订单总金额:OmsPortalOrderAmountDto")
@Getter
@Setter
public class OmsPortalOrderAmountDto {
    @ApiModelProperty(value = "订单ID")
    private String orderId;
    @ApiModelProperty(value = "订单总金额")
    private  Long   amount;
}
