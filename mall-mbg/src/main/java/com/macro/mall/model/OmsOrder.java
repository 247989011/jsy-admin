package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(description = "订单", value="OmsOrder")
@Getter
@Setter
@ToString
public class OmsOrder implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("订单编号")
    private String orderSn;

    @ApiModelProperty("会员id")
    private Long memberId;
    @ApiModelProperty("用户帐号")
    private String memberUsername;

    @ApiModelProperty("备选的物流模板")
    private Long optionLogisticsTemplateId;
    @ApiModelProperty("订单使用的物流方式")
    private Long usedLogisticsModeId;

    @ApiModelProperty("备选的支付模板")
    private Long optionPayTemplateId;
    @ApiModelProperty("支付方式：0 - 线上支付 1 - 线下支付")
    private Integer payType;
    @ApiModelProperty("订单使用的支付方式")
    private Long usedPayModeId;
    @ApiModelProperty("线下汇款监控号码")
    private String offlinePayMtcnCode;

    @ApiModelProperty("优惠劵id")
    private Long couponId;
    @ApiModelProperty("营销活动ID-全场通用的营销活动")
    private Long marketingActivityId;

    @ApiModelProperty("预选状态0、待提交订单1、待审核订单2、待支付3、待确认到款4、" +
            "待拍照5、待审核图片6、待发货7、配送中8、已收货9、取消订单10")
    private Integer status;
    @ApiModelProperty("00 - 未确认|01 - 确认通过|02 - 确认不通过")
    private String physicalPicConfirmStatus;

    @ApiModelProperty("订单总金额")
    private BigDecimal totalAmount;
    @ApiModelProperty("运费金额")
    private BigDecimal freightAmount;
    @ApiModelProperty("应付金额(实际支付金额)")
    private BigDecimal payAmount;
    @ApiModelProperty(value = "促销优化金额(满减、满折)")
    private BigDecimal promotionAmount;
    @ApiModelProperty(value = "优惠券抵扣金额 ")
    private BigDecimal couponAmount;
    @ApiModelProperty(value = "管理员后台调整订单使用的折扣金额")
    private BigDecimal discountAmount;

    @ApiModelProperty("物流公司(配送方式)")
    private String deliveryCompany;
    @ApiModelProperty("物流单号")
    private String deliverySn;
    @ApiModelProperty("收货人姓名")
    private String receiverName;
    @ApiModelProperty("收货人电话")
    private String receiverPhone;
    @ApiModelProperty("收货人邮编")
    private String receiverPostCode;
    @ApiModelProperty("收货国家")
    private String receiverCountry;
    @ApiModelProperty("发货国家")
    private String sendCountry;
    @ApiModelProperty("省份/直辖市")
    private String receiverProvince;
    @ApiModelProperty("城市")
    private String receiverCity;
    @ApiModelProperty("区")
    private String receiverRegion;
    @ApiModelProperty("详细地址")
    private String receiverDetailAddress;
    @ApiModelProperty("收件人ID")
    private Long receiverId;
    @ApiModelProperty("收件人邮箱")
    private String receiverEmail;

    @ApiModelProperty("自动确认时间(天)")
    private Integer autoConfirmDay;
    @ApiModelProperty("支付时间")
    private Date paymentTime;
    @ApiModelProperty("发货时间")
    private Date deliveryTime;
    @ApiModelProperty("确认收货时间")
    private Date receiveTime;

    @ApiModelProperty("订单备注")
    private String note;

    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("修改时间")
    private Date modifyTime;

    @ApiModelProperty("创建时间")
    private Date lastCreateTime;
    @ApiModelProperty("创建者或创建模块")
    private String lastCreateId;
    @ApiModelProperty("最后更新时间")
    private Date lastUpdateTime;
    @ApiModelProperty("最后更新者或更新模块")
    private String lastUpdateId;

    @ApiModelProperty(value = "配送状态:0-待客户照片确认;1-待发货确认(订单审核); 2-已发货(配送中);3-未发货;4-配送完成", hidden = true)
    private Integer confirmStatus;
    @ApiModelProperty(value = "删除状态：0->未删除；1->已删除", hidden = true)
    private Integer deleteStatus;

    @ApiModelProperty(value = "积分抵扣金额 - 暂不用", hidden = true)
    private BigDecimal integrationAmount;
    @ApiModelProperty(value = "下单时使用的积分 - 暂不用", hidden = true)
    private Integer useIntegration;
    @ApiModelProperty(value = "可以获得的积分 - 暂不用", hidden = true)
    private Integer integration;
    @ApiModelProperty(value = "可以活动的成长值 - 暂不用", hidden = true)
    private Integer growth;
    @ApiModelProperty(value = "活动信息 - 暂不用", hidden = true)
    private String promotionInfo;

    @ApiModelProperty(value = "订单来源 - 暂不用：0->PC订单；1->app订单", hidden = true)
    private Integer sourceType;
    @ApiModelProperty(value = "订单类型 - 暂不用：0->正常订单；1->秒杀订单", hidden = true)
    private Integer orderType;

    @ApiModelProperty(value = "发票类型 - 暂不用：0->不开发票；1->电子发票；2->纸质发票", hidden = true)
    private Integer billType;
    @ApiModelProperty(value = "发票抬头 - 暂不用", hidden = true)
    private String billHeader;
    @ApiModelProperty(value = "发票内容 - 暂不用", hidden = true)
    private String billContent;
    @ApiModelProperty(value = "收票人电话 - 暂不用", hidden = true)
    private String billReceiverPhone;
    @ApiModelProperty(value = "收票人邮箱 - 暂不用", hidden = true)
    private String billReceiverEmail;

    @ApiModelProperty(value = "评价时间 - 暂不用", hidden = true)
    private Date commentTime;

    private static final long serialVersionUID = 1L;
}