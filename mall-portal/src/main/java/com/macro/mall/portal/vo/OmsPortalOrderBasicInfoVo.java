package com.macro.mall.portal.vo;

import com.macro.mall.model.OmsOrder;
import com.macro.mall.model.OmsOrderItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单模块-订单及订单商品项信息
 * Created by ruiwu.xu on 2019/01/19.
 */
@ApiModel(value= "订单模块-订单及订单商品项信息",description = "订单及订单商品项信息:OmsPortalOrderBasicInfoVo")
@Getter
@Setter
public class OmsPortalOrderBasicInfoVo extends OmsOrder {
    @ApiModelProperty(value = "订单的商品项")
    private List<OmsOrderItem> orderItemList;
}
