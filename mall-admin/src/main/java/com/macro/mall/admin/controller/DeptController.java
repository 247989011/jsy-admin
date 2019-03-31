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

package com.macro.mall.admin.controller;

import com.macro.mall.admin.dto.DeptTree;
import com.macro.mall.admin.model.SysDept;
import com.macro.mall.admin.service.SysDeptService;
import com.macro.mall.common.controller.BaseController;
import com.macro.mall.common.domain.CommonResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * <p>
 * 部门管理 前端控制器
 * </p>
 *
 * @author lengleng
 * @since 2018-01-20
 */
@Api(tags = "后台账户权限-部门管理", description = "部门管理:DeptController",position = 100)
@Controller
@RequestMapping("/dept")
public class DeptController extends BaseController {
    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 通过ID查询
     *
     * @param id ID
     * @return SysDept
     */
    @ApiOperation(value = "通过ID查询",notes = "通过ID查询详情")
    @ApiImplicitParams({
            @ApiImplicitParam(value ="123",name = "id",defaultValue = "1",required = true,paramType = "query",dataType = "string"),
            @ApiImplicitParam(value ="123",name = "id",defaultValue = "1",required = true,paramType = "query",dataType = "string")
    })
    @ApiResponses({@ApiResponse(code = 201, response = SysDept.class,
            message="状态200的data格式说明：data返回值为对象")})
    @GetMapping("/{id}")
    //@RequestMapping(value = "",method ={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public CommonResult get(@PathVariable Integer id) {
        return  new CommonResult().success(sysDeptService.getById(id));
    }


    /**
     * 返回树形菜单集合
     *
     * @return 树形菜单
     */
    @ApiOperationSort(1)
    @ApiOperation("返回树形菜单集合")
    @ApiResponses({@ApiResponse(code = 201, response = DeptTree.class,
            message="状态200的data格式说明：data返回值为对象")})
    @GetMapping(value = "/tree")
    @ResponseBody
    @Deprecated
    public CommonResult getTree() {
        return  new CommonResult().success(sysDeptService.listDeptTrees());
    }

    /**
     * 添加
     *
     * @param sysDept 实体
     * @return success/false
     */
    @ApiOperation("添加")
    @ApiResponses({@ApiResponse(code = 201, response = Boolean.class,
            message="状态200的data格式说明：data返回值为对象")})
    @PostMapping
    @ResponseBody
    public CommonResult add(@RequestBody SysDept  sysDept) {
        return new CommonResult().success(sysDeptService.saveDept(sysDept));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @ApiOperation("删除")
    @ApiResponses({@ApiResponse(code = 201, response = Boolean.class,
            message="状态200的data格式说明：data返回值为对象")})
    @DeleteMapping("/{id}")
    @ResponseBody
    public CommonResult delete(@PathVariable Integer id) {
        return new CommonResult().success(sysDeptService.removeDeptById(id));
    }

    /**
     * 编辑
     *
     * @param sysDept 实体
     * @return success/false
     */
    @ApiOperation("编辑")
    @ApiResponses({@ApiResponse(code = 201, response = Boolean.class,
            message="状态200的data格式说明：data返回值为对象")})
    @PutMapping
    @ResponseBody
    public CommonResult edit(@RequestBody SysDept sysDept) {
        sysDept.setUpdateTime(new Date());
        return  new  CommonResult().success(sysDeptService.updateDeptById(sysDept));
    }
}
