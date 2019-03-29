package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.model.PaymsPayMode;
import com.macro.mall.service.OmsPayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单管理Controller
 * Created by macro on 2018/10/11.
 */
@Api(tags = "支付模块-支付方式", description = "支付方式:PaymsPayModeController",position = 50)
@Controller
@RequestMapping("/pay/mode")
public class PaymsPayModeController {
    @Autowired
    private OmsPayService omsPayService;

    @ApiOperation("增加支付方式")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:pay:mode:add')")
    public CommonResult add(@RequestBody PaymsPayMode paymsPayMode) {
        int count = omsPayService.addPayMode(paymsPayMode);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("更新支付方式")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:pay:mode:update')")
    public CommonResult update(@RequestBody PaymsPayMode paymsPayMode) {
        int count = omsPayService.updatePayMode(paymsPayMode);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("删除支付方式(物理删)")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:pay:mode:delete')")
    public CommonResult update(@PathVariable("id") Long id) {
        int count = omsPayService.deletePayMode(id);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("查询交易支付方式定义(ALL)")
    @ApiResponses({@ApiResponse(code = 201, response = PaymsPayMode.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:pay:mode')")
    public CommonResult list() {
        List<PaymsPayMode> paymsPayModeList = omsPayService.listPayModeAll();
        return new CommonResult().success(paymsPayModeList);
    }
}
