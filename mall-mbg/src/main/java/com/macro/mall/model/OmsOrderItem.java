package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(description = "订单所含商品", value="OmsOrderItem")
@Getter
@Setter
@ToString
public class OmsOrderItem implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("订单id")
    private Long orderId;
    @ApiModelProperty("订单编号")
    private String orderSn;
    @ApiModelProperty("商品Id")
    private Long productId;
    @ApiModelProperty("商品编码")
    private String productSn;
    @ApiModelProperty("商品名称")
    private String productName;
    @ApiModelProperty("商品商标")
    private String productBrand;
    @ApiModelProperty("商品分类id")
    private Long productCategoryId;
    @ApiModelProperty("商品图片")
    private String productPic;
    @ApiModelProperty("商品sku编号")
    private Long productSkuId;
    @ApiModelProperty("商品sku条码")
    private String productSkuCode;
    @ApiModelProperty("00 - 未确认;01 - 确认通过;02 - 确认不通过")
    private String picConfirmStatus;

    @ApiModelProperty("销售价格")
    private BigDecimal productPrice;
    @ApiModelProperty("购买数量")
    private Integer productQuantity;
    @ApiModelProperty("优惠劵ID")
    private Long couponId;
    @ApiModelProperty("优惠券分解金额")
    private BigDecimal couponAmount;
    @ApiModelProperty("营销活动ID")
    private Long activityId;
    @ApiModelProperty("营销活动分解金额")
    private BigDecimal activityAmount;

    @ApiModelProperty("商品销售属性:[{\"key\":\"颜色\",\"value\":\"颜色\"},{\"key\":\"容量\",\"value\":\"4G\"}]")
    private String productAttr;

    @ApiModelProperty(value = "商品的销售属性-暂不用", hidden = true)
    private String sp1;
    @ApiModelProperty(value = "商品的销售属性-暂不用", hidden = true)
    private String sp2;
    @ApiModelProperty(value = "商品的销售属性-暂不用",hidden = true)
    private String sp3;
    @ApiModelProperty(value = "积分优惠分解金额-暂不用", hidden = true)
    private BigDecimal integrationAmount;
    @ApiModelProperty(value = "该商品经过优惠后的分解金额-暂不用", hidden = true)
    private BigDecimal realAmount;
    @ApiModelProperty(value = "商品促销名称-暂不用",hidden = true)
    private String promotionName;
    @ApiModelProperty(value = "商品促销分解金额-暂不用", hidden = true)
    private BigDecimal promotionAmount;
    @ApiModelProperty(value = "赠送的积分-暂不用", hidden = true)
    private Integer giftIntegration;
    @ApiModelProperty(value = "赠送的成长值-暂不用", hidden = true)
    private Integer giftGrowth;

    private static final long serialVersionUID = 1L;
}
