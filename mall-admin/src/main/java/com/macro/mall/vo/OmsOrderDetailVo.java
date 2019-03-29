package com.macro.mall.vo;

import com.macro.mall.model.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel("订单基本信息vo")
@Data
public class OmsOrderDetailVo extends OmsOrder {
    @ApiModelProperty("订单的客户信息")
    private UmsMember member;

    @ApiModelProperty("订单的操作记录")
    private List<OmsOrderOperateHistory> orderOperateHistoryList;

    @ApiModelProperty(value = "订单的商品及其优惠详情")
    private List<OmsOrderItemDetailVo> orderItemDetailDtoList;

    @ApiModelProperty(value = "全场通用的优惠劵信息")
    private SmsCoupon coupon;

    @ApiModelProperty(value = "全场通用的营销活动信息")
    private SmsMarketingActivities marketingActivities;

    @ApiModelProperty(value = "订单的物流方式")
    private LmsLogisticsMode logisticsMode;
    @ApiModelProperty(value = "订单的物流模板")
    private LmsLogisticsTemplate LmsLogisticsTemplate;

    @ApiModelProperty(value = "订单的支付方式")
    private PaymsPayMode payMode;
    @ApiModelProperty(value = "订单的支付模板")
    private PaymsPayTemplate payTemplate;

}
