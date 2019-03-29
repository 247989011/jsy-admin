package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ApiModel(description = "物流地区", value="LmsLogisticsAreaDefine")
@Getter
@Setter
@ToString
public class LmsLogisticsAreaDefine implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("地区中文名")
    private String areaNameCn;
    @ApiModelProperty("地区英文名")
    private String areaNameEn;
    @ApiModelProperty("地区类型:00 - 发货地;01 - 收货地;02 - 既是 发货地  也是 收货地")
    private String areaType;
    @ApiModelProperty("创建时间")
    private String lastCreateTime;
    @ApiModelProperty("创建者或创建模块")
    private String lastCreateId;
    @ApiModelProperty("更新时间")
    private String lastUpdateTime;
    @ApiModelProperty("更新者或更新模块")
    private String lastUpdateId;
    private static final long serialVersionUID = 1L;
}