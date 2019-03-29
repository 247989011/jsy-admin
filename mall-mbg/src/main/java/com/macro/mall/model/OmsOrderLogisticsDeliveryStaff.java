package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "订单的物流发货员信息", value="OmsOrderLogisticsDeliveryStaff")
@Getter
@Setter
@ToString
public class OmsOrderLogisticsDeliveryStaff implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("订单ID")
    private Long orderId;
    @ApiModelProperty("发货员ID")
    private Long deliveryStaffId;
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date lastCreateTime;
    @ApiModelProperty(value = "创建者", hidden = true)
    private String lastCreateId;
    @ApiModelProperty(value = "更新时间", hidden = true)
    private Date lastUpdateTime;
    @ApiModelProperty(value = "更新者", hidden = true)
    private String lastUpdateId;
    private static final long serialVersionUID = 1L;
}