package com.macro.mall.dto;

import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.PmsSkuStock;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("订单创建商品dto")
@Data
public class PmsProductDto extends PmsProduct {

    @ApiModelProperty(value = "商品数量")
    private Integer productQuantity;
    @ApiModelProperty(value = "sku信息")
    private PmsSkuStock skuInfo;


}
