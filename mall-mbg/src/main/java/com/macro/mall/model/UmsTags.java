package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ApiModel(description = "会员分类标签库", value="UmsTags")
@Getter
@Setter
@ToString
public class UmsTags implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("标签名")
    private String tagName;
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
