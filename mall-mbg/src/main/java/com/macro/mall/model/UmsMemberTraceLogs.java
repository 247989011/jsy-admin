package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "会员跟踪日志表", value="UmsMemberTraceLogs")
@Getter
@Setter
@ToString
public class UmsMemberTraceLogs implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("会员id")
    private Long memberId;
    @ApiModelProperty("业务员ID")
    private Long adminId;
    @ApiModelProperty("日志标题")
    private String logTitle;
    @ApiModelProperty("日志状态:00 - 正常, 01 - 删除")
    private String logStatus;
    @ApiModelProperty("最后更新着或更新模块")
    private String logText;
    @ApiModelProperty("创建时间")
    private Date lastCreateTime;
    @ApiModelProperty("创建者或创建模块")
    private String lastCreateId;
    @ApiModelProperty("最后更新时间")
    private Date lastUpdateTime;
    @ApiModelProperty("最后更新着或更新模块")
    private String lastUpdateId;
    private static final long serialVersionUID = 1L;
}