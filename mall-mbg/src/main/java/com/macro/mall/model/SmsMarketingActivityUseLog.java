package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "营销活动日志", value="SmsMarketingActivityUseLog")
@Getter
@Setter
@ToString
public class SmsMarketingActivityUseLog implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("营销活动id")
    private Long activityId;
    @ApiModelProperty("营销活动名称")
    private String activityName;
    @ApiModelProperty("会员id")
    private Long memberId;
    @ApiModelProperty("会员名称")
    private String memberName;
    @ApiModelProperty("订单id")
    private Long orderId;
    @ApiModelProperty("订单号码")
    private String orderSn;
    @ApiModelProperty("使用时间")
    private Date useTime;
    @ApiModelProperty("创建时间")
    private Date lastCreateTime;
    @ApiModelProperty("创建者或创建模块Id")
    private String lastCreateId;
    @ApiModelProperty("更新时间")
    private Date lastUpdateTime;
    @ApiModelProperty("更新者或更新模块Id")
    private String lastUpdateId;

    private static final long serialVersionUID = 1L;
}