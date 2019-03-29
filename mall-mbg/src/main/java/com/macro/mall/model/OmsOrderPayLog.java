package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "订单支付结果信息", value="OmsOrderPayLog")
@Getter
@Setter
@ToString
public class OmsOrderPayLog implements Serializable {
    @ApiModelProperty("主键ID")
    private Long id;
    @ApiModelProperty("订单ID")
    private Long orderId;
    @ApiModelProperty("支付方式ID")
    private Long payModeId;
    @ApiModelProperty("支付状态:00-未支付|01-支付成功|02-支付失败")
    private String payResultStatus;
    @ApiModelProperty("支付结果描述")
    private String payResultDescription;
    @ApiModelProperty("支付时间")
    private Date payTime;
    @ApiModelProperty("支付结果凭证")
    private String payResultProof;
    @ApiModelProperty("是否线下支付:0-不是|1-是")
    private String isOfflinePay;
    @ApiModelProperty("线下支付凭证ID")
    private Long mtcnCodeId;
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date lastCreateTime;
    @ApiModelProperty(value = "创建者或创建模块", hidden = true)
    private String lastCreateId;
    @ApiModelProperty(value = "订单ID", hidden = true)
    private Date lastUpdateTime;
    @ApiModelProperty(value = "更新者或更新模块", hidden = true)
    private String lastUpdateId;

    private static final long serialVersionUID = 1L;
}