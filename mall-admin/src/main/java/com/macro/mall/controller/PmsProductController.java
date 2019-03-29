package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.dto.PmsProductParam;
import com.macro.mall.dto.PmsProductQueryParam;
import com.macro.mall.dto.PmsProductResult;
import com.macro.mall.model.PmsProduct;
import com.macro.mall.service.PmsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品管理Controller
 * Created by macro on 2018/4/26.
 */
@Api(tags = "商品模块-商品管理", description = "商品管理:PmsProductController",position = 34)
@Controller
@RequestMapping("/product")
public class PmsProductController {
    @Autowired
    private PmsProductService productService;

    @ApiOperation("创建商品")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:product:add')")
    public CommonResult add(@RequestBody PmsProductParam productParam, BindingResult bindingResult) {
        int count = productService.create(productParam);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("根据商品id获取商品编辑信息")
    @RequestMapping(value = "/get/updateInfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:product')")
    public CommonResult getUpdateInfo(@PathVariable Long id) {
        PmsProductResult productResult = productService.getUpdateInfo(id);
        return new CommonResult().success(productResult);
    }

    @ApiOperation("更新商品")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:product:update')")
    public Object update(@PathVariable Long id, @RequestBody PmsProductParam productParam, BindingResult bindingResult) {
        int count = productService.update(id, productParam);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("查询商品")
    @ApiResponses({@ApiResponse(code = 201, response = PmsProduct.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:product')")
    public CommonResult page(PmsProductQueryParam productQueryParam,
                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProduct> productList = productService.list(productQueryParam, pageSize, pageNum);
        return new CommonResult().pageSuccess(productList);
    }

    @ApiOperation("查询单个商品详情")
    @ApiResponses({@ApiResponse(code = 201, response = PmsProduct.class,
            message="状态200的data格式说明：data返回值为单个对象")})
    @RequestMapping(value = "/get/detail/{id}", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:product')")
    public CommonResult getDetail(@PathVariable Long id) {
        PmsProduct product = productService.detail(id);
        return new CommonResult().success(product);
    }

    @ApiOperation("根据商品名称或货号模糊查询")
    @ApiResponses({@ApiResponse(code = 201, response = PmsProduct.class,
            message="状态200的data格式说明：data返回值为单个对象")})
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:product')")
    public CommonResult list(@RequestParam(name = "name", required = false,defaultValue = "") String  name) {
        List<PmsProduct> productList = productService.list(name);
        return new CommonResult().success(productList);
    }

    @ApiOperation("批量修改商品审核状态")
    @RequestMapping(value = "/update/verifyStatus",method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:product:update')")
    public CommonResult updateVerifyStatus(@RequestParam("ids") List<Long> ids,
                                     @RequestParam("verifyStatus") Integer verifyStatus,
                                     @RequestParam("detail") String detail) {
        int count = productService.updateVerifyStatus(ids, verifyStatus, detail);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("批量上下架")
    @RequestMapping(value = "/update/publishStatus",method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:product:update')")
    public CommonResult updatePublishStatus(@RequestParam("ids") List<Long> ids,
                                     @RequestParam("publishStatus") Integer publishStatus) {
        int count = productService.updatePublishStatus(ids, publishStatus);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("批量推荐商品")
    @RequestMapping(value = "/update/recommendStatus",method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:product:update')")
    public CommonResult updateRecommendStatus(@RequestParam("ids") List<Long> ids,
                                      @RequestParam("recommendStatus") Integer recommendStatus) {
        int count = productService.updateRecommendStatus(ids, recommendStatus);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("批量设为新品")
    @RequestMapping(value = "/update/newStatus",method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:product:update')")
    public CommonResult updateNewStatus(@RequestParam("ids") List<Long> ids,
                                        @RequestParam("newStatus") Integer newStatus) {
        int count = productService.updateNewStatus(ids, newStatus);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("批量修改删除状态")
    @RequestMapping(value = "/delete/status",method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:product:delete')")
    public CommonResult updateDeleteStatus(@RequestParam("ids") List<Long> ids,
                                  @RequestParam("status") Integer status) {
        int count = productService.updateDeleteStatus(ids, status);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }
}
