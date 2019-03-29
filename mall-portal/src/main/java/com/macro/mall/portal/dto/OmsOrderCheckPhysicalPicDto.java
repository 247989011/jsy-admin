package com.macro.mall.portal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 订单模块-商品实物照片审核Dto
 * Created by ruiwu.xu on 2019/01/19.
 */
@ApiModel(value= "订单模块-商品实物照片审核Dto",description = "商品实物照片审核Dto:OmsOrderCheckPhysicalPicDto")
@Getter
@Setter
public class OmsOrderCheckPhysicalPicDto implements Serializable {
    @ApiModelProperty("订单ID")
    private Long orderId;
    @ApiModelProperty("01 - 确认通过|02 - 确认不通过")
    private String physicalPicConfirmStatus;
}
