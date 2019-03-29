package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.dto.OmsOrderLogisticsModeOptionDTO;
import com.macro.mall.model.OmsLogisticsModeOption;
import com.macro.mall.service.OmsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 订单管理Controller
 * Created by macro on 2018/10/11.
 */
@Api(tags = "订单模块-订单的备选物流方式(弃用)", description = "订单的备选物流方式:OmsOrderLogisticsOptionController",position = 50)
@ApiIgnore
@Controller
@RequestMapping("/order/logistics/option")
@Deprecated
public class OmsOrderLogisticsOptionController {
    @Autowired
    private OmsOrderService orderService;

    @ApiOperation("增加订单的备选物流方式")
    @RequestMapping(value = "/add/{orderId}", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:logistics:option:add')")
    public CommonResult add(@PathVariable("orderId") Long orderId,
                               @RequestBody OmsLogisticsModeOption logisticsModeOption) {
        int count = orderService.addOrderLogisticsModeOption(orderId, logisticsModeOption);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("删除订单的备选物流方式")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:logistics:option:delete')")
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = orderService.deleteOrderLogisticsModeOption(id);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("查询订单的所有备选物流方式")
    @ApiResponses({@ApiResponse(code = 201, response = OmsOrderLogisticsModeOptionDTO.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/list/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:logistics:option')")
    public CommonResult list(@PathVariable("orderId") Long orderId) {
        OmsOrderLogisticsModeOptionDTO orderLogisticsModeOptionDTO = orderService.listOrderLogisticsModeOption(orderId);
        return new CommonResult().success(orderLogisticsModeOptionDTO);
    }
}
