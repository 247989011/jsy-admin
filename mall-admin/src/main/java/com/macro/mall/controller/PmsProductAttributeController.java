package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.dto.PmsProductAttributeParam;
import com.macro.mall.dto.ProductAttrInfo;
import com.macro.mall.model.PmsProductAttribute;
import com.macro.mall.service.PmsProductAttributeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 商品属性管理Controller
 * Created by macro on 2018/4/26.
 */
@Controller
@Api(tags = "商品模块-商品属性管理", description = "商品属性管理:PmsProductAttributeController",position = 35)
@RequestMapping("/productAttribute")
public class PmsProductAttributeController {
    @Autowired
    private PmsProductAttributeService productAttributeService;

    @ApiOperation("根据分类查询属性列表或参数列表")
    @ApiResponses({@ApiResponse(code = 201, response = PmsProductAttribute.class,
            message="状态200的data格式说明：data返回值为列表")})
    @ApiImplicitParams({@ApiImplicitParam(name = "type", value = "0表示属性，1表示参数", required = true, paramType = "query", dataType = "integer")})
    @RequestMapping(value = "/page/{cid}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:productAttribute')")
    public CommonResult page(@PathVariable Long cid,
                          @RequestParam(value = "type") Integer type,
                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProductAttribute> productAttributeList = productAttributeService.getList(cid, type, pageSize, pageNum);
        return new CommonResult().pageSuccess(productAttributeList);
    }

    @ApiOperation("添加商品属性信息")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:productAttribute:add')")
    public CommonResult add(@RequestBody PmsProductAttributeParam productAttributeParam, BindingResult bindingResult) {
        int count = productAttributeService.create(productAttributeParam);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("修改商品属性信息")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:productAttribute:update')")
    public CommonResult update(@PathVariable Long id,@RequestBody PmsProductAttributeParam productAttributeParam,BindingResult bindingResult){
        int count = productAttributeService.update(id,productAttributeParam);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("查询单个商品属性")
    @ApiResponses({@ApiResponse(code = 201, response = PmsProductAttribute.class,
            message="状态200的data格式说明：data返回值为对象")})
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:productAttribute')")
    public CommonResult get(@PathVariable Long id){
        PmsProductAttribute productAttribute = productAttributeService.getItem(id);
        return new CommonResult().success(productAttribute);
    }

    @ApiOperation("批量删除商品属性")
    @RequestMapping(value = "/batch/delete",method = RequestMethod.DELETE)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:productAttribute:delete')")
    public CommonResult batchDelete(@RequestParam("ids") List<Long> ids){
        int count = productAttributeService.delete(ids);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("根据商品分类的id获取商品属性及属性分类")
    @ApiResponses({@ApiResponse(code = 201, response = ProductAttrInfo.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/list/attrInfo/{productCategoryId}",method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:productAttribute')")
    public CommonResult listAttrInfo(@PathVariable Long productCategoryId){
        List<ProductAttrInfo> productAttrInfoList = productAttributeService.getProductAttrInfo(productCategoryId);
        return new CommonResult().success(productAttrInfoList);
    }

    @ApiOperation("根据商品分类的id获取商品属性及属性分类")
    @RequestMapping(value = "/list/attr/{productAttributeCategoryId}",method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:productAttribute')")
    public CommonResult listAttr(@PathVariable Long productAttributeCategoryId){
        List<PmsProductAttribute> productAttrInfoList = productAttributeService.getProductAttr(productAttributeCategoryId);
        return new CommonResult().success(productAttrInfoList);
    }

}
