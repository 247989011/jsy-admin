package com.macro.mall.portal.controller;

import com.macro.mall.model.OmsOrder;
import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.domain.ConfirmOrderResult;
import com.macro.mall.portal.domain.OrderParam;
import com.macro.mall.portal.dto.OmsOrderQueryParamDto;
import com.macro.mall.portal.dto.OmsPortalOrderAmountDto;
import com.macro.mall.portal.dto.OmsPortalOrderDetailDto;
import com.macro.mall.portal.service.OmsPortalOrderService;
import com.macro.mall.portal.vo.OmsPortalOrderBasicInfoVo;
import com.macro.mall.portal.vo.OmsPortalOrderDetailVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 订单管理Controller
 * Created by macro on 2018/8/30.
 */
@Controller
@Api(tags = "订单模块-订单基本信息",description = "订单基本信息:OmsPortalOrderController")
@Slf4j
@RequestMapping("/order")
public class OmsPortalOrderController {
    @Autowired
    private OmsPortalOrderService portalOrderService;

    @ApiOperation("查询客户的订单列表")
    @ApiResponses({@ApiResponse(code = 201, response = OmsOrder.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult page(OmsOrderQueryParamDto queryParam,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OmsOrder> orderList = portalOrderService.page(queryParam, pageSize, pageNum);
        return new CommonResult().pageSuccess(orderList);
    }


    @ApiOperation("根据订单Id获取订单及其关联的详情,大而全")
    @ApiResponses({@ApiResponse(code = 201, response = OmsPortalOrderDetailVo.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/detail/get/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getOrderDetail(@PathVariable("orderId") Long orderId) {
        OmsPortalOrderDetailVo orderDetailDto = portalOrderService.getOrderDetail(orderId);
        return new CommonResult().success(orderDetailDto);
    }

    @ApiOperation("根据订单Id获取订单及订单商品项列表")
    @ApiResponses({@ApiResponse(code = 201, response = OmsPortalOrderBasicInfoVo.class,
            message="状态200的data格式说明")})
    @RequestMapping(value = "/basicInfo/get/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getOrderBasicInfo(@PathVariable("orderId") Long orderId) {
        OmsPortalOrderBasicInfoVo order = portalOrderService.getOrderBasicInfo(orderId);
        return new CommonResult().success(order);
    }

    @ApiOperation("根据订单Id获取订单")
    @ApiIgnore
    @ApiResponses({@ApiResponse(code = 201, response = OmsOrder.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/get/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getOrder(@PathVariable("orderId") Long orderId) {
        OmsOrder order = portalOrderService.getOrder(orderId);
        return new CommonResult().success(order);
    }

    @ApiOperation("客户保存订单商品列表")
    @ApiIgnore
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult SaveOrderDetailByMember(@RequestBody OmsPortalOrderDetailVo portalOrderDetailDto) {
        int count = portalOrderService.SaveOrderDetailByMember(portalOrderDetailDto);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation(value = "客户确认订单商品列表及优惠使用信息",notes = "客户确认订单商品列表及优惠使用信息")
    @RequestMapping(value = "/confirm/item8pro", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateOrderItemAndPromotion(@RequestBody OmsPortalOrderDetailDto portalOrderDetailDto) {
        int count = portalOrderService.SaveOrderDetailByMember(portalOrderDetailDto);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("客户订单提交(收件信息, 支付方式、物流方式，同时后端把订单状态改为‘1-待业务员审核’)")
    @RequestMapping(value = "/commit", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult commitOder(@RequestBody OmsOrder omsOrder) {
         int count = portalOrderService.commitOrder(omsOrder);
         if(count < 0){
             return new CommonResult().failed();
         }
        return new CommonResult().success(count);
    }

    @ApiOperation("获取订单审核结果(2-待支付，即业务员审核通过)")
    @RequestMapping(value = "/get/check/status/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getCheckStatus(@PathVariable Long orderId) {
        return new CommonResult().success(portalOrderService.getCheckStatus(orderId));
    }


    /////TODO 下面是弃用接口//////
    @ApiOperation("计算订单总金额")
    @ApiIgnore
    @ApiResponses({@ApiResponse(code = 201, response = OmsPortalOrderAmountDto.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/calculate/amount", method = RequestMethod.GET)
    @ResponseBody
    @Deprecated
    public CommonResult calculateAmount(OmsPortalOrderDetailVo portalOrderDetailDto) {
        OmsPortalOrderAmountDto  portalOrderAmountDto = portalOrderService.calculateAmount(portalOrderDetailDto);
        return new CommonResult().success(portalOrderAmountDto);
    }

    @ApiOperation("根据购物车信息生成确认单信息")
    @ApiIgnore
    @RequestMapping(value = "/generateConfirmOrder",method = RequestMethod.POST)
    @ResponseBody
    @Deprecated
    public Object generateConfirmOrder(){
        ConfirmOrderResult confirmOrderResult = portalOrderService.generateConfirmOrder();
        return new CommonResult().success(confirmOrderResult);
    }

    @ApiOperation("根据购物车信息生成订单")
    @ApiIgnore
    @RequestMapping(value = "/generateOrder",method = RequestMethod.POST)
    @ResponseBody
    @Deprecated
    public Object generateOrder(@RequestBody OrderParam orderParam){
        return portalOrderService.generateOrder(orderParam);
    }

    @ApiOperation("自动取消超时订单")
    @ApiIgnore
    @RequestMapping(value = "/cancelTimeOutOrder",method = RequestMethod.POST)
    @ResponseBody
    @Deprecated
    public Object cancelTimeOutOrder(){
        return portalOrderService.cancelTimeOutOrder();
    }

    @ApiOperation("取消单个超时订单")
    @ApiIgnore
    @RequestMapping(value = "/cancelOrder",method = RequestMethod.POST)
    @ResponseBody
    @Deprecated
    public Object cancelOrder(Long orderId){
        portalOrderService.sendDelayMessageCancelOrder(orderId);
        return new CommonResult().success(null);
    }
}
