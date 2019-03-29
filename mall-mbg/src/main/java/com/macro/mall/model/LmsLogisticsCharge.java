package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ApiModel(description = "物流费用", value="LmsLogisticsCharge")
@Getter
@Setter
@ToString
public class LmsLogisticsCharge implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("物流模板ID")
    private Long templateId;
    @ApiModelProperty("物流方式ID")
    private Long modeId;
    @ApiModelProperty("发货地ID")
    private Long sendId;
    @ApiModelProperty("收货地ID")
    private Long receiptId;
    @ApiModelProperty("发货地名字")
    private String sendName;
    @ApiModelProperty("收货地名字")
    private String receiptName;
    @ApiModelProperty("计费方式类型:00 - 按重量; 01 - 按数量")
    private String chargeType;
    @ApiModelProperty("小于等于N(件 or 千克)")
    private Integer lessThanN;
    @ApiModelProperty("小于等于N的费用")
    private Integer lessThanNCharge;
    @ApiModelProperty("每递增N(件 or 千克)")
    private Integer eachAddN;
    @ApiModelProperty("每递增N的费用")
    private Integer eachAddNCharge;
    @ApiModelProperty("创建时间")
    private String lastCreateTime;
    @ApiModelProperty("创建者或创建模块")
    private String lastCreateId;
    @ApiModelProperty("最后更新时间")
    private String lastUpdateTime;
    @ApiModelProperty("最后更新者或更新模块")
    private String lastUpdateId;
    private static final long serialVersionUID = 1L;

}