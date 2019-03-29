package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ApiModel(description = "后台用户角色和权限关系表", value="UmsRolePermissionRelation")
@Getter
@Setter
@ToString
public class UmsRolePermissionRelation implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("角色id")
    private Long roleId;
    @ApiModelProperty("权限id")
    private Long permissionId;
    private static final long serialVersionUID = 1L;
}