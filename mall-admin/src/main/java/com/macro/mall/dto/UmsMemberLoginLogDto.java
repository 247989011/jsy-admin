package com.macro.mall.dto;

import com.macro.mall.model.UmsMember;
import com.macro.mall.model.UmsMemberLoginLog;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("会员的登录日志Dto")
@Data
public class UmsMemberLoginLogDto  extends UmsMemberLoginLog {
    @ApiModelProperty("客户信息")
    private UmsMember member;
}

