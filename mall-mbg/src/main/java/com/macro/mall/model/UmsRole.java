package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "后台用户角色表", value="UmsRole")
@Getter
@Setter
@ToString
public class UmsRole implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("后台用户数量")
    private Integer adminCount;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("启用状态：0->禁用；1->启用")
    private Integer status;
    @ApiModelProperty("排序")
    private Integer sort;
    private static final long serialVersionUID = 1L;
}