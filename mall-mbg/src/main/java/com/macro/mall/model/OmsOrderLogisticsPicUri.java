package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "订单物流凭证资源URI", value="OmsOrderLogisticsPicUri")
@Getter
@Setter
@ToString
public class OmsOrderLogisticsPicUri implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("订单ID")
    private Long orderId;
    @ApiModelProperty("物流单号")
    private String traceNo;
    @ApiModelProperty("物流凭证资源URI")
    private String logisticsPicUri;
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