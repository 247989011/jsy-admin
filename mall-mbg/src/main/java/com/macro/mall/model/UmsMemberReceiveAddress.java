package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ApiModel(description = "会员收货地址", value="UmsMemberReceiveAddress")
@Getter
@Setter
@ToString
public class UmsMemberReceiveAddress implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("会员id")
    private Long memberId;
    @ApiModelProperty("收货人名称firstName")
    private String firstName;
    @ApiModelProperty("收货人名称lastName")
    private String lastName;
    @ApiModelProperty("邮箱")
    private String eMail;
    @ApiModelProperty("电话")
    private String telephone;
    @ApiModelProperty("邮政编码")
    private String postCode;
    @ApiModelProperty("国家或地区")
    private String country;
    @ApiModelProperty("省份/直辖市")
    private String province;
    @ApiModelProperty("城市")
    private String city;
    @ApiModelProperty("区")
    private String region;
    @ApiModelProperty("详细地址1(街道)")
    private String address1;
    @ApiModelProperty("详细地址2(街道)")
    private String address2;
    @ApiModelProperty("是否为默认地址")
    private Integer defaultStatus;
    @ApiModelProperty("公司")
    private String company;
    @ApiModelProperty("传真")
    private String fax;
    @ApiModelProperty("创建时间")
    private String lastCreateTime;
    @ApiModelProperty("创建者或创建模块")
    private String lastCreateId;
    @ApiModelProperty("更新时间")
    private String lastUpdateTime;
    @ApiModelProperty("更新者或更新模块")
    private String lastUpdateId;

    private static final long serialVersionUID = 1L;
}