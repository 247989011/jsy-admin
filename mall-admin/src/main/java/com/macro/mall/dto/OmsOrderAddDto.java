package com.macro.mall.dto;

import com.macro.mall.model.OmsOrder;
import com.macro.mall.model.PmsSkuStock;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单创建信息
 * Created by macro on 2018/10/11.
 */
@ApiModel("订单创建dto")
@Data
public class OmsOrderAddDto extends OmsOrder {
    private List<PmsProductDto> productList;
}
