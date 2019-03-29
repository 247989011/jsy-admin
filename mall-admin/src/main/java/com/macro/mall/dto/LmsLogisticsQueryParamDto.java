package com.macro.mall.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("物流信息查询Dto")
@Getter
@Setter
public class LmsLogisticsQueryParamDto {
    @ApiModelProperty("模板名称")
    private String templateName;
    @ApiModelProperty("物流方式名称")
    private String logisticsModeName;
    @ApiModelProperty("发货地名字")
    private String sendName;
    @ApiModelProperty("收货地名字")
    private String receiptName;
}
