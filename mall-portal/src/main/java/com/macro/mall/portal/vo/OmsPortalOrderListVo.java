package com.macro.mall.portal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 订单模块-订单及订单列表信息
 * Created by ruiwu.xu on 2019/01/19.
 */
@ApiModel(value= "订单模块-订单及订单列表信息",description = "订单及订单列表信息:OmsPortalOrderListVo")
@Getter
@Setter
public class OmsPortalOrderListVo extends  OmsOrder{
    @ApiModelProperty("订单第1个商品的商品ID")
    private  Long firstProductId;
    @ApiModelProperty("订单第1个商品的主图片路径")
    private  String firstProductFullPicPath;

    @ApiModelProperty(value = "订单第1个商品的图片存取方式：0-OSS | 1-FastDfs", hidden = true)
    private String firstProductPicSaveWay;
    @ApiModelProperty(value = "订单第1个商品的fastdfs存储路径-组", hidden = true)
    private String firstProductPicFastdfsGroup;
    @ApiModelProperty(value = "订单第1个商品的fastdfs存储路径-文件名", hidden = true)
    private String firstProductPicFastdfsFullname;
    @ApiModelProperty(value = "订单第1个商品的图片OssUrl", hidden = true)
    private String firstProductPicOssUrl;
}
