package com.macro.mall.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.demo.model.TestDemo;

/**
 * 
 *
 * @author auto code generator
 * @date 2019-04-01 12:12:43
 */
public interface TestDemoService extends IService<TestDemo> {

  /**
   * 简单分页查询
   * @param testDemo 
   * @return
   */
  IPage<TestDemo> getTestDemoPage(Page<TestDemo> page, TestDemo testDemo);


}
