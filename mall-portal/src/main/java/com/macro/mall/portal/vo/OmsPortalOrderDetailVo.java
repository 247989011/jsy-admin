package com.macro.mall.portal.vo;

import com.macro.mall.model.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单模块-订单明细详情
 * Created by ruiwu.xu on 2019/01/19.
 */
@ApiModel(value= "订单模块-订单及其关联详情(大而全)",description = "订单及其关联详情(大而全):OmsPortalOrderDetailVo")
@Getter
@Setter
public class OmsPortalOrderDetailVo extends  OmsOrder{
    @ApiModelProperty(value = "订单的商品及其优惠详情")
    private List<OmsPortalOrderItemDetailVo> portalOrderItemDetailDtoList;

    @ApiModelProperty(value = "全场通用的优惠劵信息")
    private  SmsCoupon coupon;

    @ApiModelProperty(value = "全场通用的营销活动信息")
    private  SmsMarketingActivities marketingActivities;

    @ApiModelProperty(value = "订单的物流方式")
    private LmsLogisticsMode logisticsMode;
    @ApiModelProperty(value = "订单的物流模板")
    private LmsLogisticsTemplate LmsLogisticsTemplate;

    @ApiModelProperty(value = "订单的支付方式")
    private PaymsPayMode payMode;
    @ApiModelProperty(value = "订单的支付模板")
    private PaymsPayTemplate payTemplate;

}