package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.model.OmsOrderLogisticsTraceLog;
import com.macro.mall.model.UmsMember;
import com.macro.mall.service.OmsOrderLogisticsService;
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
 * 订单模块Controller
 * Created by ruiwu.xu on 2019/01/19.
 */
@Api(tags = "订单模块-订单物流", description = "订单物流:OmsOrderLogisticsController",position = 50)
@Controller
@RequestMapping("/order/logistics")
public class OmsOrderLogisticsController {
    @Autowired
    private OmsOrderService orderService;
    @Autowired
    private OmsOrderLogisticsService orderLogisticsService;

    @ApiOperation("获取物流发货员信息")
    @ApiResponses({@ApiResponse(code = 201, response = UmsMember.class,
            message="状态200的data格式说明")})
    @RequestMapping(value = "/delivery/staff", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:logistics:delivery:staff')")
    public CommonResult listDeliveryStaff() {
        List<UmsMember> memberList = orderLogisticsService.listDeliveryStaff();
        return new CommonResult().success(memberList);
    }


    @ApiOperation("登记订单物流跟踪情况")
    @RequestMapping(value = "/trace/add/{orderId}", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:logistics:add')")
    public CommonResult add(@PathVariable("orderId") Long orderId,
                            @RequestBody OmsOrderLogisticsTraceLog orderLogisticsTraceLog) {
        int count = orderService.addLogisticsLog(orderId, orderLogisticsTraceLog);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("查询订单物流跟踪最新情况")
    @ApiResponses({@ApiResponse(code = 201, response = OmsOrderLogisticsTraceLog.class,
            message="状态200的data格式说明：data返回值为单个对象")})
    @RequestMapping(value = "/trace/get/last/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:logistics')")
    public CommonResult getLast(@PathVariable("orderId") Long orderId) {
        OmsOrderLogisticsTraceLog orderLogisticsTraceLog = orderService.getLogisticsLogLast(orderId);
        return new CommonResult().success(orderLogisticsTraceLog);
    }

    @ApiOperation("分页查询订单物流跟踪情况")
    @ApiResponses({@ApiResponse(code = 201, response = OmsOrderLogisticsTraceLog.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/trace/page/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:logistics')")
    public CommonResult page(@PathVariable(value = "orderId") Long orderId,
                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OmsOrderLogisticsTraceLog>  orderLogisticsTraceLogList = orderService.getLogisticsLogAll(orderId, pageSize, pageNum);
        return new CommonResult().pageSuccess(orderLogisticsTraceLogList);
    }
}
