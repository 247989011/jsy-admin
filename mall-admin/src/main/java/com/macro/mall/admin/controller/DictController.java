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


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.admin.model.SysDict;
import com.macro.mall.admin.service.SysDictService;
import com.macro.mall.common.controller.BaseController;
import com.macro.mall.common.domain.CommonResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 * @author lengleng
 * @since 2017-11-19
 */
@Api(tags = "后台账户权限-数据字典管理", description = "数据字典管理:DictController",position = 100)
@RestController
@RequestMapping("/dict")
public class DictController extends BaseController {
    @Autowired
    private SysDictService sysDictService;

    /**
     * 通过ID查询字典信息
     *
     * @param id ID
     * @return 字典信息
     */
    @GetMapping("/{id}")
    @ResponseBody
    public SysDict dict(@PathVariable Integer id) {
        return sysDictService.getById(id);
    }

    /**
     * 分页查询字典信息
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @RequestMapping("/dictPage")
    @ResponseBody
    public CommonResult dictPage(Page page, SysDict sysDict) {
        return new CommonResult().success(sysDictService.page(page, Wrappers.query(sysDict)));
    }

    /**
     * 通过字典类型查找字典
     *
     * @param type 类型
     * @return 同类型字典
     */
    @GetMapping("/type/{type}")
    @Cacheable(value = "dict_details", key = "#type")
    @ResponseBody
    public CommonResult findDictByType(@PathVariable String type) {
        return new CommonResult().success(sysDictService.list(Wrappers
                .<SysDict>query().lambda()
                .eq(SysDict::getType, type)));
    }

    /**
     * 添加字典
     *
     * @param sysDict 字典信息
     * @return success、false
     */
    @PostMapping
    @CacheEvict(value = "dict_details", key = "#sysDict.type")
    @ResponseBody
    public CommonResult dict(@RequestBody SysDict sysDict) {
        return new CommonResult().success(sysDictService.save(sysDict));
    }

    /**
     * 删除字典，并且清除字典缓存
     *
     * @param id   ID
     * @param type 类型
     * @return R
     */
    @DeleteMapping("/{id}/{type}")
    @CacheEvict(value = "dict_details", key = "#type")
    @ResponseBody
    public CommonResult deleteDict(@PathVariable Integer id, @PathVariable String type) {
        return new CommonResult().success(sysDictService.removeById(id));
    }

    /**
     * 修改字典
     *
     * @param sysDict 字典信息
     * @return success/false
     */
    @PutMapping
    @CacheEvict(value = "dict_details", key = "#sysDict.type")
    @ResponseBody
    public CommonResult editDict(@RequestBody SysDict sysDict) {
        return new CommonResult().success(sysDictService.updateById(sysDict));
    }
}
