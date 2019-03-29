package com.macro.mall.portal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 订单模块-订单的商品及其优惠详情
 * Created by ruiwu.xu on 2019/01/19.
 */
@ApiModel(value= "订单模块-订单的商品及其优惠详情",description = "订单的商品及其优惠详情:OmsPortalOrderItemDetailVo")
@Getter
@Setter
//public class OmsPortalDeliverOrderItemVo  implements Serializable {
public class OmsPortalDeliverOrderItemVo  {
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
    @ApiModelProperty("商品图片路径")
    private String productPic;
    @ApiModelProperty("商品sku编号")
    private Long productSkuId;
    @ApiModelProperty("商品sku条码")
    private String productSkuCode;

    @ApiModelProperty(value = "00 - 未确认;01 - 确认通过;02 - 确认不通过", hidden = true)
    private String picConfirmStatus;

    @ApiModelProperty("购买数量")
    private Integer productQuantity;
    @ApiModelProperty("商品销售属性:[{\"key\":\"颜色\",\"value\":\"颜色\"},{\"key\":\"容量\",\"value\":\"4G\"}]")
    private String productAttr;

    //private static final long serialVersionUID = 1L;
}
