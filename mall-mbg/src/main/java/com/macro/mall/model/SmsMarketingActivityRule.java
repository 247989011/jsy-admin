package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(description = "营销活动规则", value="SmsMarketingActivityRule")
@Getter
@Setter
@ToString
public class SmsMarketingActivityRule implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("活动id")
    private Long activityId;
    @ApiModelProperty("0 - 全场通用 1-指定分类  2-指定商品")
    private String useType;
    @ApiModelProperty("满价")
    private BigDecimal fullPrice;
    @ApiModelProperty("减价")
    private BigDecimal reducePrice;

    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date lastCreateTime;
    @ApiModelProperty(value = "创建者或创建模块", hidden = true)
    private String lastCreateId;
    @ApiModelProperty(value = "更新时间", hidden = true)
    private Date lastUpdateTime;
    @ApiModelProperty(value = "更新者或更新模块", hidden = true)
    private String lastUpdateId;
    private static final long serialVersionUID = 1L;
}