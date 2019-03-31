package com.macro.mall.common.domain;

import com.macro.mall.common.util.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.BindingResult;

/**
 * 通用返回对象
 * Created by macro on 2018/4/26.
 */
@ApiModel("通用返回对象:CommonResult")
public class CommonResult {
    //操作成功
    public static final int SUCCESS = 200;
    //用户名不存在或密码错误
    public static final int  ERR_USER_INFO = 400;
    //未认证，用户认证失败，请重新登录
    public static final int UNAUTHORIZED = 401;
    //未授权
    public static final int  FORBIDDEN = 403;
    //参数校验失败
    public static final int VALIDATE_FAILED = 404;
    //验证码错误, 请重新输入
    public static final int  ERR_AUTH_CODE = 478;
    //演示环境没有权限操作
    public static final int  DEMO_ENV = 479;
    //操作失败
    public static final int FAILED = 500;


    @ApiModelProperty("编码")
    private int code;
    @ApiModelProperty("消息")
    private String message;
    @ApiModelProperty("数据")
    private Object data;

    /**
     * 演示环境没有权限操作
     */
    public CommonResult errAuthCode() {
        this.code = DEMO_ENV;
        this.message = "演示环境没有权限操作";
        this.data = null;
        return this;
    }

    /**
     * 用户名不存在或密码错误
     */
    public CommonResult errUserInfo() {
        this.code = ERR_USER_INFO;
        this.message = "用户名不存在或密码错误";
        this.data = null;
        return this;
    }

    /**
     * 验证码错误, 请重新输入
     */
    public CommonResult demoEnv() {
        this.code = ERR_AUTH_CODE;
        this.message = "验证码错误, 请重新输入";
        this.data = null;
        return this;
    }

    /**
     * 普通成功返回
     *
     * @param data 获取的数据
     */
    public CommonResult success(Object data) {
        this.code = SUCCESS;
        this.message = "操作成功";
        this.data = data;
        return this;
    }


    /**
     * 普通失败提示信息
     */
    public CommonResult failed() {
        this.code = FAILED;
        this.message = "操作失败";
        return this;
    }
    public CommonResult failed(Integer code,String msg) {
        this.code = code;
        this.message = msg;
        return this;
    }
    /**
     * 参数验证失败使用
     *
     * @param message 错误信息
     */
    public CommonResult validateFailed(String message) {
        this.code = VALIDATE_FAILED;
        this.message = message;
        return this;
    }

    /**
     * 未登录时使用
     *
     * @param message 错误信息
     */
    public CommonResult unauthorized(String message) {
        this.code = UNAUTHORIZED;
        this.message = "暂未登录或token已经过期";
        this.data = message;
        return this;
    }

    /**
     * 未授权时使用
     *
     * @param message 错误信息
     */
    public CommonResult forbidden(String message) {
        this.code = FORBIDDEN;
        this.message = "没有相关权限";
        this.data = message;
        return this;
    }

    /**
     * 参数验证失败使用
     * @param result 错误信息
     */
    public CommonResult validateFailed(BindingResult result) {
        validateFailed(result.getFieldError().getDefaultMessage());
        return this;
    }

    @Override
    public String toString() {
        return JsonUtil.objectToJson(this);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
