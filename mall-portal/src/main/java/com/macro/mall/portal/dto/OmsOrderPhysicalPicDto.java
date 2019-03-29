package com.macro.mall.portal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 订单模块-订单商品的实物照片Dto
 * Created by ruiwu.xu on 2019/01/19.
 */
@ApiModel(value= "订单模块-订单商品的实物照片Dto",description = "订单商品的实物照片:OmsOrderItemPhysicalPicDto")
@Getter
@Setter
public class OmsOrderPhysicalPicDto implements Serializable {
    @ApiModelProperty("订单ID")
    private Long orderId;
    @ApiModelProperty("图片存取方式：0-OSS | 1-FastDfs")
    private String picSaveWay;
    @ApiModelProperty("fastdfs存储路径-组")
    private String picFastdfsGroup;
    @ApiModelProperty("fastdfs存储路径-文件名")
    private String picFastdfsFullname;
    @ApiModelProperty("图片OssUrl")
    private String picOssUrl;
    private static final long serialVersionUID = 1L;
}
