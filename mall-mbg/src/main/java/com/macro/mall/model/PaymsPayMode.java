package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "支付模块-支付方式", value="PaymsPayMode")
@Getter
@Setter
@ToString
public class PaymsPayMode implements Serializable {
    @ApiModelProperty("主键ID")
    private Long id;
    @ApiModelProperty("支付方式中文名称")
    private String payModeNameCn;
    @ApiModelProperty("支付方式英文名称")
    private String payModeNameEn;
    @ApiModelProperty(value = "创建时间",hidden = true)
    private Date lastCreateTime;
    @ApiModelProperty(value = "创建者",hidden = true)
    private String lastCreateId;
    @ApiModelProperty(value = "更新时间", hidden =true)
    private Date lastUpdateTime;
    @ApiModelProperty(value = "更新者", hidden = true)
    private String lastUpdateId;
    private static final long serialVersionUID = 1L;
}