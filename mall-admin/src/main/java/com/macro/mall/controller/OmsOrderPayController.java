package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.model.OmsOrderLogisticsDeliveryStaff;
import com.macro.mall.service.OmsOrderPayService;
import com.macro.mall.vo.OmsOrderPayResultInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 订单模块-订单支付Controller
 * Created by macro on 2018/10/11.
 */
@Api(tags = "订单模块-订单支付", description = "订单支付:OmsOrderPayController",position = 50)
@Controller
@RequestMapping("/order/pay")
public class OmsOrderPayController {
    @Autowired
    private OmsOrderPayService orderPayService;

    @ApiOperation("【业务员】确认订单已到款, 同时保存该订单的物流发货员信息")
    @RequestMapping(value = "/payment/confirm", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:pay:payment:confirm')")
    public CommonResult confirmPayment(@RequestBody OmsOrderLogisticsDeliveryStaff orderLogisticsDeliveryStaff) {
        int count = orderPayService.confirmPayment(orderLogisticsDeliveryStaff);
        if(count > 0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }
    @ApiOperation("【业务员】确认订单已到款")
    @ApiIgnore
    @RequestMapping(value = "/payment/confirm/{orderId}/{status}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:pay:payment:confirm')")
    public CommonResult confirmPayment(@PathVariable("orderId") Long orderId,@PathVariable("status") Integer status) {
        return orderPayService.confirmPayment(orderId);
    }

    @ApiOperation("【业务员】查询订单支付结果信息")
    @ApiResponses({@ApiResponse(code = 201, response = OmsOrderPayResultInfoVo.class,
            message="状态200的data格式说明：data返回值为单个对象")})
    @RequestMapping(value = "/result/get/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:result:get')")
    public CommonResult getPayResult(@PathVariable("orderId") Long orderId) {
        OmsOrderPayResultInfoVo orderPayResultInfoVo = orderPayService.getPayResult(orderId);
        return new CommonResult().success(orderPayResultInfoVo);
    }
}
