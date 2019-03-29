package com.macro.mall.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * Created by ruiwu.xu on 2019/01/26.
 */
@ApiModel("业务执行结果对象:BusinessGeneralResult")
@Getter
@Setter
public class BusinessGeneralResult {
    //操作成功
    public static final int SUCCESS = 0;
    //重复数据
    public static final int DUPLICATED_DATA = 1;
    //格式错误
    public static final int FORMAT_ERROR = 2;
    //错误码
    public static final int  FAILED = -1;


    @ApiModelProperty("应答码")
    private int code;
    @ApiModelProperty("应答码描述")
    private String message;
    @ApiModelProperty("执行结果数据集")
    private Object data;

    public BusinessGeneralResult setResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
        return this;
    }
}
