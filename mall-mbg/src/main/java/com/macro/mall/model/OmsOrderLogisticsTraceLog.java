package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "订单物流跟踪日志", value="OmsOrderLogisticsTraceLog")
@Getter
@Setter
@ToString
public class OmsOrderLogisticsTraceLog implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("订单编号")
    private Long orderId;
    @ApiModelProperty("跟踪序号(物流单号)")
    private String traceNo;
    @ApiModelProperty("跟踪到的订单物流情况")
    private String traceContent;
    @ApiModelProperty(value = "创建时间",hidden = true)
    private Date lastCreateTime;
    @ApiModelProperty(value = "创建者或创建模块",hidden = true)
    private String lastCreateId;
    @ApiModelProperty(value = "更新时间", hidden = true)
    private Date lastUpdateTime;
    @ApiModelProperty(value = "更新者或更新模块",hidden = true)
    private String lastUpdateId;

    private static final long serialVersionUID = 1L;
}
