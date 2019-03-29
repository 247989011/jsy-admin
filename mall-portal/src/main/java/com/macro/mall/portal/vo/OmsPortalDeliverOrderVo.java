package com.macro.mall.portal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * 订单模块-【发货员】订单及订单物流信息
 * Created by ruiwu.xu on 2019/01/19.
 */
@ApiModel(value= "订单模块-订单基本信息、商品列表、收件人信息、订单物流信息",
        description = "订单基本信息、商品列表、收件人信息、订单物流信息:OmsPortalDeliverOrderVo")
@Getter
@Setter
//public class OmsPortalDeliverOrderVo implements Serializable {
public class OmsPortalDeliverOrderVo {
    //订单基本信息
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("订单编号")
    private String orderSn;
    @ApiModelProperty("订单状态：待拍照5、待审核图片6、待发货7、配送中8、已收货9")
    private Integer status;
    @ApiModelProperty("配送状态:0-待客户照片确认;1-待发货确认(订单审核); 2-已发货(配送中);3-未发货;4-配送完成")
    private Integer confirmStatus;
    @ApiModelProperty("订单备注")
    private String note;
    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty(value = "商品列表")
    private List<OmsPortalDeliverOrderItemVo> deliverOrderItemVoList;

    //收件人信息
    @ApiModelProperty("会员id")
    private Long memberId;
    @ApiModelProperty("用户帐号")
    private String memberUsername;
    @ApiModelProperty("发货国家")
    private String sendCountry;
    @ApiModelProperty("物流公司(配送方式)")
    private String deliveryCompany;
    @ApiModelProperty("物流单号")
    private String deliverySn;
    @ApiModelProperty("收件人ID")
    private Long receiverId;
    @ApiModelProperty("收货人姓名")
    private String receiverName;
    @ApiModelProperty("收件人邮箱")
    private String receiverEmail;
    @ApiModelProperty("收货人电话")
    private String receiverPhone;
    @ApiModelProperty("收货人邮编")
    private String receiverPostCode;
    @ApiModelProperty("收货国家")
    private String receiverCountry;
    @ApiModelProperty("省份/直辖市")
    private String receiverProvince;
    @ApiModelProperty("城市")
    private String receiverCity;
    @ApiModelProperty("区")
    private String receiverRegion;
    @ApiModelProperty("详细地址")
    private String receiverDetailAddress;
    @ApiModelProperty("发货时间")
    private Date deliveryTime;
    @ApiModelProperty("确认收货时间")
    private Date receiveTime;

    @ApiModelProperty(value = "订单的物流方式")
    private LmsLogisticsMode logisticsMode;

    //private static final long serialVersionUID = 1L;
}
