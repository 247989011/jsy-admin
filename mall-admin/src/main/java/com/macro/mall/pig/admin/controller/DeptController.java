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

package com.macro.mall.pig.admin.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.macro.mall.domain.CommonResult;
import com.macro.mall.pig.admin.model.dto.DeptTree;
import com.macro.mall.pig.admin.model.entity.SysDept;
import com.macro.mall.pig.admin.service.SysDeptService;
import com.macro.mall.pig.common.constant.CommonConstant;
import com.macro.mall.pig.common.web.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 部门管理 前端控制器
 * </p>
 *
 * @author lengleng
 * @since 2018-01-20
 */
//@RestController
//@RequestMapping("/dept")
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
    @ApiOperation("通过ID查询")
    @ApiResponses({@ApiResponse(code = 201, response = SysDept.class,
            message="状态200的data格式说明：data返回值为对象")})
    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult get(@PathVariable Integer id) {
        return  new CommonResult().success(sysDeptService.selectById(id));
    }


    /**
     * 返回树形菜单集合
     *
     * @return 树形菜单
     */
    @ApiOperation("返回树形菜单集合")
    @ApiResponses({@ApiResponse(code = 201, response = DeptTree.class,
            message="状态200的data格式说明：data返回值为对象")})
    @GetMapping(value = "/tree")
    @ResponseBody
    public CommonResult getTree() {
        SysDept condition = new SysDept();
        condition.setDelFlag(CommonConstant.STATUS_NORMAL);
        List<DeptTree> deptTreeList = sysDeptService.selectListTree(new EntityWrapper<>(condition));
        return  new CommonResult().success(deptTreeList);
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
        return new CommonResult().success(sysDeptService.insertDept(sysDept));
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
        return new CommonResult().success(sysDeptService.deleteDeptById(id));
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
