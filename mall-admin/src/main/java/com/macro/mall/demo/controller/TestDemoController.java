/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */

package com.macro.mall.demo.controller;

import com.macro.mall.common.controller.BaseController;
import com.macro.mall.common.domain.CommonResult;
import com.macro.mall.demo.service.TestDemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 部门管理 前端控制器
 * </p>
 *
 * @author lengleng
 * @since 2018-01-20
 */
@Api(tags = "testDemo", description = "testDemo描述",position = 100)
@RestController
@RequestMapping("/test/demo")
public class TestDemoController extends BaseController {
    @Autowired
    private TestDemoService testDemoService;

    /**
     * 通过ID查询
     *
     * @param id ID
     * @return SysDept
     */
    @ApiOperation(value = "通过ID查询",notes = "通过ID查询详情")
    @GetMapping("/{id}/{name}")
    @ResponseBody
    public CommonResult get(@PathVariable Integer id,@PathVariable String name) {

        return  new CommonResult().success(
                testDemoService.getById(id));
    }


}
