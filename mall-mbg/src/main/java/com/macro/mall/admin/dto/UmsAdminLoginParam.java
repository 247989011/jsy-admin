package com.macro.mall.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户登录参数
 * Created by macro on 2018/4/26.
 */
@ApiModel(description = "用户登录参数", value="UmsAdminLoginParam")
@Getter
@Setter
@ToString
public class UmsAdminLoginParam {
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    private String password;
}
