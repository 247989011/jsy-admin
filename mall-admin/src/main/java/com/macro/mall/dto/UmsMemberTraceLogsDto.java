package com.macro.mall.dto;

import com.macro.mall.model.UmsMemberTraceLogs;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("会员的跟踪日志Dto")
@Data
public class UmsMemberTraceLogsDto extends  UmsMemberTraceLogs{
    @ApiModelProperty("客户姓名")
    //private UmsMember member;
    private String memberName;
    @ApiModelProperty("业务员姓名")
    //private UmsAdmin umsdmin;
    private String adminName;
}

