package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.dto.SmsCouponParam;
import com.macro.mall.model.SmsCoupon;
import com.macro.mall.service.SmsCouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 优惠券管理Controller
 * Created by macro on 2018/8/28.
 */
@Api(tags = "营销模块-优惠券管理", description = "优惠券管理:SmsCouponController",position = 70)
@Controller
@RequestMapping("/coupon")
public class SmsCouponController {
    @Autowired
    private SmsCouponService couponService;
    @ApiOperation("添加优惠券")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('sms:coupon:add')")
    public CommonResult add(@RequestBody SmsCouponParam couponParam) {
        int count = couponService.create(couponParam);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("删除优惠券")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    //@PreAuthorize("hasAuthority('sms:coupon:delete')")
    public CommonResult delete(@PathVariable Long id) {
        int count = couponService.delete(id);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("修改优惠券")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('sms:coupon:update')")
    public CommonResult update(@PathVariable Long id,@RequestBody SmsCouponParam couponParam) {
        int count = couponService.update(id,couponParam);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("根据优惠券名称和类型分页获取优惠券列表")
    @ApiResponses({@ApiResponse(code = 201, response = SmsCoupon.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('sms:coupon')")
    public CommonResult page(
            @RequestParam(value = "name",required = false, defaultValue = "") String name,
            @RequestParam(value = "type",required = false) Integer type,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<SmsCoupon> couponList = couponService.list(name,type,pageSize,pageNum);
        return new CommonResult().pageSuccess(couponList);
    }

    @ApiOperation("获取单个优惠券的详细信息")
    @ApiResponses({@ApiResponse(code = 201, response = SmsCouponParam.class,
            message="状态200的data格式说明：data返回值为对象")})
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('sms:coupon')")
    public CommonResult get(@PathVariable Long id) {
        SmsCouponParam couponParam = couponService.getItem(id);
        return new CommonResult().success(couponParam);
    }
}
