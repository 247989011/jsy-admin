package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "会员表", value="UmsMember")
@Getter
@Setter
@ToString
public class UmsMember implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("所属业务员")
    private Long umsAdminId;
    @ApiModelProperty("会员级别id")
    private Long memberLevelId;
    @ApiModelProperty("会员分类标签id")
    private Long memberTagId;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("昵称")
    private String nickname;
    @ApiModelProperty("手机号码")
    private String phone;

    @ApiModelProperty("0-普通会员|1-发货员")
    private String isDeliveryStaff;

    @ApiModelProperty("帐号启用状态:0->禁用；1->启用")
    private Integer status;
    @ApiModelProperty("注册时间")
    private Date createTime;
    @ApiModelProperty("头像")
    private String icon;
    @ApiModelProperty("性别：0->未知；1->男；2->女")
    private Integer gender;
    @ApiModelProperty("生日")
    private Date birthday;
    @ApiModelProperty("所在城市")
    private String city;
    @ApiModelProperty("职业")
    private String job;
    @ApiModelProperty("个性签名")
    private String personalizedSignature;
    @ApiModelProperty("用户来源 0 - 本系统;1 - 第3方渠道")
    private Integer sourceType;
    @ApiModelProperty("积分")
    private Integer integration;
    @ApiModelProperty("成长值")
    private Integer growth;
    @ApiModelProperty("剩余抽奖次数")
    private Integer luckeyCount;
    @ApiModelProperty("历史积分数量")
    private Integer historyIntegration;


    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("whatsapp帐号")
    private String whatsapp;
    @ApiModelProperty("facebook帐号")
    private String facebook;
    @ApiModelProperty("twitter帐号")
    private String twitter;
    @ApiModelProperty("skype帐号")
    private String skype;
    @ApiModelProperty("tumblr帐号")
    private String tumblr;
    @ApiModelProperty("instagram帐号")
    private String instagram;
    @ApiModelProperty("qq帐号")
    private String qq;
    @ApiModelProperty("微信帐号")
    private String weixin;


    @ApiModelProperty("创建时间")
    private Date lastCreateTime;
    @ApiModelProperty("创建者")
    private String lastCreateId;
    @ApiModelProperty("更新时间")
    private Date lastUpdateTime;
    @ApiModelProperty("更新者")
    private String lastUpdateId;

    private static final long serialVersionUID = 1L;


}
