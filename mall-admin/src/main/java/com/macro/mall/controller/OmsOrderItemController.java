package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.model.OmsOrderItem;
import com.macro.mall.service.OmsOrderService;
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
@Controller
@Api(tags = "订单模块-订单的商品管理", description = "订单的商品管理:OmsOrderItemController",position = 50)
@RequestMapping("/order/item")
public class OmsOrderItemController {
    @Autowired
    private OmsOrderService orderService;

    @ApiOperation("查询订单的商品列表")
    @ApiResponses({@ApiResponse(code = 201, response = OmsOrderItem.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/list/{orderId}", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:item')")
    public CommonResult list(@PathVariable("orderId") long orderId) {
        List<OmsOrderItem> orderItemList = orderService.listOrderItem(orderId);
        if(orderItemList != null){
            return new CommonResult().success(orderItemList);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("批量增加订单的商品项")
    @RequestMapping(value = "/batch/add", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:item:batch:add')")
    public CommonResult add(@RequestBody List<OmsOrderItem> orderItemList) {
        int count = orderService.addOrderItem(orderItemList);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("批量更新订单的商品项")
    @RequestMapping(value = "/batch/update", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:item:batch:update')")
    public CommonResult batchUpdate(@RequestBody List<OmsOrderItem> orderItemList) {
        int count = orderService.updateOrderItem(orderItemList);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("批量删除订单的商品")
    @RequestMapping(value = "/batch/delete", method = RequestMethod.DELETE)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:item:batch:delete')")
    public CommonResult batchDelete(@RequestBody List<OmsOrderItem> orderItemList) {
        int count = orderService.deleteOrderItem(orderItemList);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }
}
