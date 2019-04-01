package com.macro.mall.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.demo.mapper.TestDemoMapper;
import com.macro.mall.demo.model.TestDemo;
import com.macro.mall.demo.service.TestDemoService;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author auto code generator
 * @date 2019-04-01 12:12:43
 */
@Service("testDemoService")
public class TestDemoServiceImpl extends ServiceImpl<TestDemoMapper, TestDemo> implements TestDemoService {

  /**
   * 简单分页查询
   * @param testDemo
   * @return
   */
  @Override
  public IPage<TestDemo> getTestDemoPage(Page<TestDemo> page, TestDemo testDemo){
      return baseMapper.selectPage(page, Wrappers.query(testDemo));
  }

}
