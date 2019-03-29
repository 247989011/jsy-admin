package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "订单的商品实物照片", value="OmsOrderItemPhysicalPic")
@Getter
@Setter
@ToString
public class OmsOrderItemPhysicalPic implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("订单ID")
    private Long orderId;
    @ApiModelProperty("订单商品明细ID")
    private Long orderItemId;
    @ApiModelProperty("图片存取方式：0-OSS | 1-FastDfs")
    private String picSaveWay;
    @ApiModelProperty("fastdfs存储路径-组")
    private String picFastdfsGroup;
    @ApiModelProperty("fastdfs存储路径-文件名")
    private String picFastdfsFullname;
    @ApiModelProperty("图片OssUrl")
    private String picOssUrl;
    @ApiModelProperty("00 - 未确认;01 - 确认通过;02 - 确认不通过")
    private String confirmStatus;
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date lastCreateTime;
    @ApiModelProperty(value = "创建者或创建模块", hidden = true)
    private String lastCreateId;
    @ApiModelProperty(value = "更新时间", hidden = true)
    private Date lastUpdateTime;
    @ApiModelProperty(value = "更新者或更新模块", hidden = true)
    private String lastUpdateId;
    private static final long serialVersionUID = 1L;
}
