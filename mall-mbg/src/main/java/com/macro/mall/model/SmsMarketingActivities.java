package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "营销活动", value="SmsMarketingActivities")
@Getter
@Setter
@ToString
public class SmsMarketingActivities implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("活动名称")
    private String activityName;
    @ApiModelProperty("前端标题")
    private String frontTitle;
    @ApiModelProperty("00 - 满减折扣、01 - 满减免邮")
    private String activityType;
    @ApiModelProperty("活动描述")
    private String activityDescription;
    @ApiModelProperty("00 - 活动开始、01 - 活动结束")
    private String activityState;
    @ApiModelProperty("活动开始时间")
    private Date activityBeginTime;
    @ApiModelProperty("活动结束时间")
    private Date activityEndTime;
    @ApiModelProperty("营销次数")
    private String useCount;

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