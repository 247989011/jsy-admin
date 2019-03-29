package com.macro.mall.dto;

import com.macro.mall.model.UmsAdmin;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel("接收更新用户信息")
@Data
public class UmsAdminDTO extends UmsAdmin {

    @ApiModelProperty("角色ids")
    private List<Long> roles;

    @ApiModelProperty("新密码")
    private String newpassword1;

}
