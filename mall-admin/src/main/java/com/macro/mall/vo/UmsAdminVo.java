package com.macro.mall.vo;

import com.macro.mall.model.UmsAdmin;
import com.macro.mall.model.UmsRole;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel("后台用户vo")
@Data
public class UmsAdminVo extends UmsAdmin {


    @ApiModelProperty("角色列表")
    private List<UmsRole> roleList;


}
