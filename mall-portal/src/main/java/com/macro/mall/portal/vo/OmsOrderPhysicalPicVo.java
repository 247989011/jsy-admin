package com.macro.mall.portal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 订单模块-订单商品的实物照片Vo
 * Created by ruiwu.xu on 2019/01/19.
 */
@ApiModel(value= "订单模块-订单商品的实物照片Vo",description = "订单商品的实物照片:OmsOrderItemPhysicalPicVo")
@Getter
@Setter
//public class OmsOrderPhysicalPicVo implements Serializable {
public class OmsOrderPhysicalPicVo{
    @ApiModelProperty("主键id")
    private Long id;
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
    //private static final long serialVersionUID = 1L;
}
