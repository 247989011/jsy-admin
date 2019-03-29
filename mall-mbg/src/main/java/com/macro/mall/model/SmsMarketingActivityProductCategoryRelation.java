package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "营销活动关联的产品分类", value="SmsMarketingActivityProductCategoryRelation")
@Getter
@Setter
@ToString
public class SmsMarketingActivityProductCategoryRelation implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("活动id")
    private Long activityId;
    @ApiModelProperty("产品分类id")
    private Long productCategoryId;
    @ApiModelProperty("产品分类名称")
    private String productCategoryName;
    @ApiModelProperty("父分类名称")
    private String parentCategoryName;
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