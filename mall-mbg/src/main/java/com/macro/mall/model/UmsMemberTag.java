package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(description = "会员标签表", value="UmsMemberTag")
@Getter
@Setter
@ToString
public class UmsMemberTag implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("标签名称")
    private String name;
    @ApiModelProperty("完成订单数量")
    private Integer finishOrderCount;
    @ApiModelProperty("完成订单金额")
    private BigDecimal finishOrderAmount;
    private static final long serialVersionUID = 1L;
}