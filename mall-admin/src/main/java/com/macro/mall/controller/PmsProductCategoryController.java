package com.macro.mall.controller;

import com.macro.mall.domain.BusinessGeneralResult;
import com.macro.mall.domain.CommonResult;
import com.macro.mall.dto.PmsProductCategoryParam;
import com.macro.mall.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.model.PmsProductCategory;
import com.macro.mall.service.PmsProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品分类模块Controller
 * Created by macro on 2018/4/26.
 */
@Api(tags = "商品模块-商品分类管理", description = "商品分类管理:PmsProductCategoryController",position = 37)
@Controller
@RequestMapping("/productCategory")
public class PmsProductCategoryController {
    @Autowired
    private PmsProductCategoryService productCategoryService;

    @ApiOperation("添加商品分类")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:productCategory:add')")
    public CommonResult add(@Validated @RequestBody PmsProductCategoryParam productCategoryParam,
                         BindingResult result) {
        BusinessGeneralResult  businessGeneralResult = productCategoryService.add(productCategoryParam);
        if (businessGeneralResult.getCode()  ==  0) {
            return new CommonResult().success(businessGeneralResult.getMessage());
        } else {
            return new CommonResult().failed(businessGeneralResult.getCode(), businessGeneralResult.getMessage());
        }
    }

    @ApiOperation("修改商品分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:productCategory:update')")
    public CommonResult update(@PathVariable Long id,
                         @Validated
                         @RequestBody PmsProductCategoryParam productCategoryParam,
                         BindingResult result) {
        int count = productCategoryService.update(id, productCategoryParam);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("删除商品分类")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:productCategory:delete')")
    public CommonResult delete(@PathVariable Long id) {
        int count = productCategoryService.delete(id);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("分页查询商品分类")
    @ApiResponses({@ApiResponse(code = 201, response = PmsProductCategory.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/page/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:productCategory')")
    public CommonResult page(@PathVariable("parentId") Long parentId,
                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProductCategory> productCategoryList = productCategoryService.getList(parentId, pageSize, pageNum);
        return new CommonResult().pageSuccess(productCategoryList);
    }

    @ApiOperation("根据id获取商品分类")
    @ApiResponses({@ApiResponse(code = 201, response = PmsProductCategory.class,
            message="状态200的data格式说明：data返回值为对象")})
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:productCategory')")
    public CommonResult get(@PathVariable("id") Long id) {
        PmsProductCategory productCategory = productCategoryService.getItem(id);
        return new CommonResult().success(productCategory);
    }

    @ApiOperation("修改导航栏显示状态")
    @RequestMapping(value = "/update/navStatus", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:productCategory:update')")
    public CommonResult updateNavStatus(@RequestParam("ids") List<Long> ids, @RequestParam("navStatus") Integer navStatus) {
        int count = productCategoryService.updateNavStatus(ids, navStatus);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("修改显示状态")
    @RequestMapping(value = "/update/showStatus", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:productCategory:update')")
    public CommonResult updateShowStatus(@RequestParam("ids") List<Long> ids, @RequestParam("showStatus") Integer showStatus) {
        int count = productCategoryService.updateShowStatus(ids, showStatus);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("查询所有一级分类及子分类")
    @RequestMapping(value = "/list/withChildren", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:productCategory')")
    public CommonResult listWithChildren() {
        List<PmsProductCategoryWithChildrenItem> list = productCategoryService.listWithChildren();
        return new CommonResult().success(list);
    }
}
