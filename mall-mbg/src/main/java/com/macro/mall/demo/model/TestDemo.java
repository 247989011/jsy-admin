package com.macro.mall.demo.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@TableName("test_demo")
@ApiModel("testDemo")
public class TestDemo extends Model<TestDemo> {

    @TableField("id")
    @ApiModelProperty("id")
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("phone")
    private String phone;


    protected Serializable pkVal() {
        return this.id;
    }
}
