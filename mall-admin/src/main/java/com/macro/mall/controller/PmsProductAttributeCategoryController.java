package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.dto.PmsProductAttributeCategoryItem;
import com.macro.mall.model.PmsProductAttributeCategory;
import com.macro.mall.service.PmsProductAttributeCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品属性分类Controller
 * Created by macro on 2018/4/26.
 */
@Api(tags = "商品模块-商品属性分类管理", description = "商品属性分类管理:PmsProductAttributeCategoryController",position = 36)
@Controller
@RequestMapping("/productAttribute/category")
public class PmsProductAttributeCategoryController {
    @Autowired
    private PmsProductAttributeCategoryService productAttributeCategoryService;

    @ApiOperation("添加商品属性分类")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:productAttribute:category:add')")
    public CommonResult add(@RequestParam String name) {
        int count = productAttributeCategoryService.create(name);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("修改商品属性分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:productAttribute:category:update')")
    public CommonResult update(@PathVariable Long id, @RequestParam String name) {
        int count = productAttributeCategoryService.update(id, name);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("删除单个商品属性分类")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:productAttribute:category:delete')")
    public CommonResult delete(@PathVariable Long id) {
        int count = productAttributeCategoryService.delete(id);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("获取单个商品属性分类信息")
    @ApiResponses({@ApiResponse(code = 201, response = PmsProductAttributeCategory.class,
            message="状态200的data格式说明：data返回值为对象")})
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:productAttribute:category')")
    public CommonResult get(@PathVariable("id") Long id) {
        PmsProductAttributeCategory productAttributeCategory = productAttributeCategoryService.getItem(id);
        return new CommonResult().success(productAttributeCategory);
    }

    @ApiOperation("分页获取所有商品属性分类")
    @ApiResponses({@ApiResponse(code = 201, response = PmsProductAttributeCategory.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:productAttribute:category')")
    public CommonResult page(@RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "1") Integer pageNum) {
        List<PmsProductAttributeCategory> productAttributeCategoryList = productAttributeCategoryService.getList(pageSize, pageNum);
        return new CommonResult().pageSuccess(productAttributeCategoryList);
    }

    @ApiOperation("获取所有商品属性分类及其下属性")
    @ApiResponses({@ApiResponse(code = 201, response = PmsProductAttributeCategoryItem.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/list/withAttr", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:productAttribute:category')")
    public CommonResult getListWithAttr() {
        List<PmsProductAttributeCategoryItem> productAttributeCategoryResultList = productAttributeCategoryService.getListWithAttr();
        return new CommonResult().success(productAttributeCategoryResultList);
    }
}
