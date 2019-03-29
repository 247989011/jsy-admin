package com.macro.mall.portal.controller;

import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.dto.OmsOrderLogisticsPicDto;
import com.macro.mall.portal.service.OmsPortalOrderLogisticsService;
import com.macro.mall.portal.service.OmsPortalOrderService;
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
 * Created by macro on 2019/01/19.
 */

@Controller
@Api(tags = "订单模块-订单物流跟踪", description = "订单物流跟踪:OmsPortalOrderLogisticsController",position = 50)
@RequestMapping("/order/logistics")
public class OmsPortalOrderLogisticsController {
    @Autowired
    private OmsPortalOrderService orderPortalService;
    @Autowired
    private OmsPortalOrderLogisticsService orderLogisticsService;

    @ApiOperation("【发货员】保存订单物流发货凭证URI, 同时更改订单状态为配送中")
    @RequestMapping(value = "/pic/save", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult saveLogisticsPic(@RequestBody OmsOrderLogisticsPicDto orderLogisticsPicDto) {
        int count = orderLogisticsService.saveLogisticsPic(orderLogisticsPicDto);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("登记订单物流跟踪情况")
    @RequestMapping(value = "/add/{orderId}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@PathVariable Long orderId, @RequestBody OmsOrderLogisticsTraceLog orderLogisticsTraceLog) {
        int count = orderPortalService.addLogisticsLog(orderId, orderLogisticsTraceLog);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("查询订单物流跟踪最新情况")
    @ApiResponses({@ApiResponse(code = 201, response = OmsOrderLogisticsTraceLog.class,
            message="状态200的data格式说明：data返回值为单个对象")})
    @RequestMapping(value = "/get/last/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getLast(@PathVariable Long orderId) {
        OmsOrderLogisticsTraceLog orderLogisticsTraceLog = orderPortalService.getLogisticsLogLast(orderId);
        return new CommonResult().success(orderLogisticsTraceLog);
    }

    @ApiOperation("查询订单物流跟踪情况(分页查询)")
    @ApiResponses({@ApiResponse(code = 201, response = OmsOrderLogisticsTraceLog.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/page/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult page(@PathVariable Long orderId,
                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OmsOrderLogisticsTraceLog>  orderLogisticsTraceLogList = orderPortalService.getLogisticsLogAll(orderId, pageSize, pageNum);
        return new CommonResult().pageSuccess(orderLogisticsTraceLogList);
    }
}
