package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ApiModel(description = "物流模板", value="LmsLogisticsTemplate")
@Getter
@Setter
@ToString
public class LmsLogisticsTemplate implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("模板名称")
    private String templateName;
    @ApiModelProperty("模板状态 00 - 在用  01 - 弃用")
    private String templateStatus;
    @ApiModelProperty("创建时间")
    private String lastCreateTime;
    @ApiModelProperty("创建者或创建模块")
    private String lastCreateId;
    @ApiModelProperty("最后更新时间")
    private String lastUpdateTime;
    @ApiModelProperty("最后更新者或更新模块")
    private String lastUpdateId;
    private static final long serialVersionUID = 1L;

}