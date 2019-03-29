package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "线下支付凭证", value="OmsOfflinePayMtcnPic")
@Getter
@Setter
@ToString
public class OmsOfflinePayMtcnPic implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("线下付款监控码")
    private String mtcnCode;
    @ApiModelProperty("0-OSS存储 | 1-fastdfs存储")
    private String picSaveWay;
    @ApiModelProperty("OSS存储路径")
    private String picOssUrl;
    @ApiModelProperty("fastdfs存储组")
    private String picFastdfsGroup;
    @ApiModelProperty("fastdfs存储路径")
    private String picFastdfsFullname;
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