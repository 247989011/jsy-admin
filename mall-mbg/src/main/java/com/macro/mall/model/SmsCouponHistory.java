package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "优惠劵历史表", value="SmsCoupon")
@Getter
@Setter
@ToString
public class SmsCouponHistory implements Serializable {
    @ApiModelProperty("主键ID")
    private Long id;
    @ApiModelProperty("优惠劵Id")
    private Long couponId;
    @ApiModelProperty("优惠劵码")
    private String couponCode;
    @ApiModelProperty("会员id")
    private Long memberId;
    @ApiModelProperty("领取人昵称")
    private String memberNickname;

    @ApiModelProperty("使用状态：0->未使用；1->已使用；2->已过期")
    private Integer useStatus;

    @ApiModelProperty("获取类型：0->后台赠送；1->主动获取")
    private  Integer getType;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("使用时间")
    private Date useTime;
    @ApiModelProperty("使用该优惠劵的订单编号")
    private Long orderId;
    @ApiModelProperty("使用该优惠劵的订单号码")
    private String orderSn;

    private static final long serialVersionUID = 1L;
}