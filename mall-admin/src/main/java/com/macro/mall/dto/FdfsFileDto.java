package com.macro.mall.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("fastDfs文件传输Dto")
@Getter
@Setter
public class FdfsFileDto {
    @ApiModelProperty("Fdfs文件组")
    private String FdfsGroup;
    @ApiModelProperty("Fdfs文件名")
    private String FdfsFullName;
    @ApiModelProperty("原始文件名")
    private String originName;
    @ApiModelProperty("文件内容")
    private byte[] fileContext;
}
