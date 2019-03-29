package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.dto.OmsOrderPayModeOptionDTO;
import com.macro.mall.model.OmsPayModeOption;
import com.macro.mall.service.OmsPayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 订单管理Controller
 * Created by macro on 2018/10/11.
 */
@Api(tags = "订单模块-订单的备选支付方式(弃用)", description = "订单的备选支付方式:OmsOrderPayOptionController",position = 50)
@ApiIgnore
@Controller
@RequestMapping("/order/pay/option")
@Deprecated
public class OmsOrderPayOptionController {
//    @Autowired
//    private OmsPayService omsPayService;
//
//    @ApiOperation("增加订单的备选支付方式")
//    @RequestMapping(value = "/add/{orderId}", method = RequestMethod.POST)
//    @ResponseBody
//    //@PreAuthorize("hasAuthority('oms:order:pay:option:add')")
//    public CommonResult add(@PathVariable("orderId") Long orderId, @RequestBody OmsPayModeOption payModeOption) {
//        int count = omsPayService.addOrderPayOption(orderId, payModeOption);
//        if(count>0){
//            return new CommonResult().success(count);
//        }
//        return new CommonResult().failed();
//    }
//
//    @ApiOperation("删除订单的备选支付方式")
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
//    @ResponseBody
//    //@PreAuthorize("hasAuthority('oms:order:pay:option:delete')")
//    public CommonResult delete(@PathVariable("id") Long id) {
//        int count = omsPayService.deleteOrderPayOption(id);
//        if(count>0){
//            return new CommonResult().success(count);
//        }
//        return new CommonResult().failed();
//    }
//
//    @ApiOperation("查询订单的所有备选支付方式")
//    @ApiResponses({@ApiResponse(code = 201, response = OmsOrderPayModeOptionDTO.class,
//            message="状态200的data格式说明：data返回值为列表")})
//    @RequestMapping(value = "/list/{orderId}", method = RequestMethod.GET)
//    @ResponseBody
//    //@PreAuthorize("hasAuthority('oms:order:pay:option')")
//    public CommonResult list(@PathVariable("orderId")  Long orderId) {
//        OmsOrderPayModeOptionDTO orderPayModeOptionDTO = omsPayService.listOrderPayOption(orderId);
//        return new CommonResult().success(orderPayModeOptionDTO);
//    }
}
