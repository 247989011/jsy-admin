package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(description = "SKU库存", value="PmsSkuStock")
@Getter
@Setter
@ToString
public class PmsSkuStock implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("商品ID")
    private Long productId;
    @ApiModelProperty("sku编码")
    private String skuCode;
    @ApiModelProperty("商品价格")
    private BigDecimal price;
    @ApiModelProperty("库存")
    private Integer stock;
    @ApiModelProperty("预警库存")
    private Integer lowStock;
    @ApiModelProperty("销售属性1")
    private String sp1;
    @ApiModelProperty("销售属性2")
    private String sp2;
    @ApiModelProperty("销售属性3")
    private String sp3;
    @ApiModelProperty("展示图片")
    private String pic;
    @ApiModelProperty("销量")
    private Integer sale;
    @ApiModelProperty("单品促销价格")
    private BigDecimal promotionPrice;
    @ApiModelProperty("锁定库存")
    private Integer lockStock;
    private static final long serialVersionUID = 1L;
}