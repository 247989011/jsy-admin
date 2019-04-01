package com.macro.mall.demo.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 *
 * @author auto code generator
 * @date 2019-04-01 12:12:43
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("test_demo")
public class TestDemo extends Model<TestDemo> {
private static final long serialVersionUID = 1L;

    /**
   *
   */
    @TableId
    private Integer id;
    /**
   *
   */
    private String name;
    /**
   *
   */
    private String phone;

}
