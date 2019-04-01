package com.macro.mall.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.common.domain.CommonResult;
import com.macro.mall.demo.model.TestDemo;
import com.macro.mall.demo.service.TestDemoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;


/**
 * 
 *
 * @author auto code generator
 * @date 2019-04-01 12:12:43
 */
@RestController
@AllArgsConstructor
@RequestMapping("/testdemo")
public class TestDemoController {

  private final  TestDemoService testDemoService;

  /**
   * 简单分页查询
   * @param page 分页对象
   * @param testDemo 
   * @return
   */
  @GetMapping("/page")
  public CommonResult getTestDemoPage(Page<TestDemo> page, TestDemo testDemo) {
    return  new CommonResult().success(testDemoService.getTestDemoPage(page,testDemo));
  }


  /**
   * 通过id查询单条记录
   * @param id
   * @return R
   */
  @GetMapping("/{id}")
  public CommonResult getById(@PathVariable("id") Integer id){
    return new CommonResult().success(testDemoService.getById(id));
  }

  /**
   * 新增记录
   * @param testDemo
   * @return R
   */
  @PostMapping
  @PreAuthorize("hasAnyAuthority('demo_testdemo_add')")
  public CommonResult save(@RequestBody TestDemo testDemo){
    return new CommonResult().success(testDemoService.save(testDemo));
  }

  /**
   * 修改记录
   * @param testDemo
   * @return R
   */
  @PutMapping
  @PreAuthorize("hasAnyAuthority('demo_testdemo_edit')")
  public CommonResult update(@RequestBody TestDemo testDemo){
    return new CommonResult().success(testDemoService.updateById(testDemo));
  }

  /**
   * 通过id删除一条记录
   * @param id
   * @return R
   */
  @DeleteMapping("/{id}")
  @PreAuthorize("hasAnyAuthority('demo_testdemo_del')")
  public CommonResult removeById(@PathVariable Integer id){
    return new CommonResult().success(testDemoService.removeById(id));
  }

}
