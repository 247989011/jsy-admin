package com.macro.mall.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UmsAdmin implements Serializable {
    private Long id;

    private String username;

    private String password;

    /**
     * 头像
     *
     * @mbggenerated
     */
    private String icon;

    /**
     * 邮箱
     *
     * @mbggenerated
     */
    private String email;

    /**
     * 昵称
     *
     * @mbggenerated
     */
    private String nickName;

    /**
     * 备注信息
     *
     * @mbggenerated
     */
    private String note;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 最后登录时间
     *
     * @mbggenerated
     */
    private Date loginTime;

    /**
     * 帐号启用状态：0->禁用；1->启用
     *
     * @mbggenerated
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

}
