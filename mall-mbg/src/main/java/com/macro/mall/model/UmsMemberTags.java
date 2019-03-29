package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ApiModel(description = "会员和分类标签库关系表", value="UmsMemberTags")
@Getter
@Setter
@ToString
public class UmsMemberTags implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("会员id")
    private Long memberId;
    @ApiModelProperty("标签id")
    private Long tagsId;
    private static final long serialVersionUID = 1L;
}