package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ApiModel(description = "物流方式", value="LmsLogisticsMode")
@Getter
@Setter
@ToString
public class LmsLogisticsMode implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("物流方式名称")
    private String logisticsModeName;
    @ApiModelProperty("物流类型:00 - 四大快递;01 - 一般快递;02 - 平邮挂号;03 - 海外发货")
    private String logisticsType;
    @ApiModelProperty("运输时效-最少天数")
    private Integer minDays;
    @ApiModelProperty("运输时效-最大天数")
    private Integer maxDays;
    @ApiModelProperty("物流方式状态:00 - 在用; 01 - 弃用")
    private String logisticsModeStatus;
    @ApiModelProperty(value = "创建时间", hidden = true)
    private String lastCreateTime;
    @ApiModelProperty(value = "创建者或创建模块",hidden = true)
    private String lastCreateId;
    @ApiModelProperty(value = "最后更新时间",hidden = true)
    private String lastUpdateTime;
    @ApiModelProperty(value = "最后更新者或更新模块",hidden = true)
    private String lastUpdateId;
    private static final long serialVersionUID = 1L;
}