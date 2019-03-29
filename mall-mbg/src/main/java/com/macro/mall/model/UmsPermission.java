package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "后台用户权限表", value="UmsPermission")
@Getter
@Setter
@ToString
public class UmsPermission implements Serializable {
    @ApiModelProperty("主键ID")
    private Long id;
    @ApiModelProperty("父级权限id")
    private Long pid;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("权限值")
    private String value;
    @ApiModelProperty("图标")
    private String icon;
    @ApiModelProperty("权限类型：0->目录；1->菜单；2->按钮(接口绑定权限)")
    private Integer type;
    @ApiModelProperty("前端资源路径")
    private String uri;
    @ApiModelProperty("启用状态；0->禁用；1->启用")
    private Integer status;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("排序")
    private Integer sort;
    private static final long serialVersionUID = 1L;

}