package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "订单的备选支付方式", value="OmsPayModeOption")
@Getter
@Setter
@ToString
@Deprecated
public class OmsPayModeOption implements Serializable {
    @ApiModelProperty("主键ID")
    private Long id;
    @ApiModelProperty("订单ID")
    private Long orderId;
    @ApiModelProperty("支付方式ID")
    private Long payModeId;
    @ApiModelProperty("创建时间")
    private Date lastCreateTime;
    @ApiModelProperty("创建者或创建模块")
    private String lastCreateId;
    @ApiModelProperty("更新时间")
    private Date lastUpdateTime;
    @ApiModelProperty("更新者或更新模块")
    private String lastUpdateId;

    private static final long serialVersionUID = 1L;
}