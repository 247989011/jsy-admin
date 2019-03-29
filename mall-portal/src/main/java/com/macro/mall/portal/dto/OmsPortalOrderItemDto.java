package com.macro.mall.portal.dto;

import com.macro.mall.model.LmsLogisticsMode;
import com.macro.mall.model.OmsOrder;
import com.macro.mall.model.OmsOrderItem;
import com.macro.mall.model.PmsSkuStock;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单模块-订单明细详情
 * Created by ruiwu.xu on 2019/01/19.
 */
@ApiModel(value= "订单模块-订单的商品Dto",description = "订单的商品Dto:OmsPortalOrderItemDto")
@Getter
@Setter
public class OmsPortalOrderItemDto extends OmsOrderItem{
    @ApiModelProperty(value = "商品的sku信息")
    private PmsSkuStock skuStock;
}
