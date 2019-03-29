package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.dto.*;
import com.macro.mall.model.OmsOrder;
import com.macro.mall.service.OmsOrderService;
import com.macro.mall.service.OmsOrderStatusService;
import com.macro.mall.service.RedisService;
import com.macro.mall.vo.OmsOrderDetailVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 订单管理Controller
 * Created by macro on 2018/10/11.
 */
@Api(tags = "订单模块-订单管理", description = "订单管理:OmsOrderController",position = 50)
@Controller
@RequestMapping("/order")
public class OmsOrderController {
    @Autowired
    private OmsOrderService orderService;
    @Autowired
    private OmsOrderStatusService omsOrderStatusService;
    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.orderId}")
    private String REDIS_KEY_PREFIX_ORDER_ID;


    @ApiOperation("创建订单")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:add')")
    public CommonResult add(@RequestBody OmsOrderAddDto orderDto) {
        int count = orderService.add(orderDto);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }


    @ApiOperation(value = "【业务员】审核订单", notes = "订单状态更新为：1-订单审核不通过(待提交订单状态);" +
            " 3-订单审核通过(待确认到款)")
    @RequestMapping(value = "/review/{orderId}/{status}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:review')")
    public CommonResult reviewOrder(@PathVariable("orderId") Long orderId, @PathVariable("status") Integer status) {

        return orderService.reviewOrder(orderId, status);
    }


    @ApiOperation("生成14位订单编号:8位日期+6位以上自增id")
    @ApiResponses({@ApiResponse(code = 201, response = String.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/orderSn", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:orderSn')")
    public CommonResult generateOrderSn() {
        StringBuilder sb = new StringBuilder();
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String key = REDIS_KEY_PREFIX_ORDER_ID + date;
        Long increment = redisService.increment(key, 1);
        sb.append(date);
       // sb.append(String.format("%02d",order.getSourceType()));
        //sb.append(String.format("%02d",order.getPayType()));
        String incrementStr = increment.toString();
        if(incrementStr.length()<=6){
            sb.append(String.format("%06d",increment));
        }else{
            sb.append(incrementStr);
        }
        return new CommonResult().success(sb.toString());
    }

    @ApiOperation("查询订单")
    @ApiResponses({@ApiResponse(code = 201, response = OmsOrder.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order')")
    public CommonResult page(OmsOrderQueryParam queryParam) {
        List<OmsOrder> orderList = orderService.page(queryParam, queryParam.getPageSize(), queryParam.getPageNum());
        return new CommonResult().pageSuccess(orderList);
    }

    @ApiOperation("查询订单V2")
    @ApiResponses({@ApiResponse(code = 201, response = OmsOrderDetailVo.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/v2/page/", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order')")
    public CommonResult pageV2(OmsOrderQueryParam queryParam) {
        List<OmsOrderDetailVo> orderList = orderService.pageV2(queryParam, queryParam.getPageSize(), queryParam.getPageNum());
        return new CommonResult().pageSuccess(orderList);
    }

    @ApiOperation("更改订单信息(通用)")
    @Ignore
    @RequestMapping(value = "/update/general", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:update')")
    public CommonResult updateGeneral(@RequestParam OmsOrder order) {

        int count = orderService.updateOrderGeneralInfo(order);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("更改订单状态(by orderId)")
    @Ignore
    @RequestMapping(value = "/update/status/{orderId}", method = RequestMethod.POST,
            name="订单状态：预选状态(0)、待提交订单(1)、待审核订单(2)、" +
                    "待支付(3)、待确认到款(4)、待拍照(5)、待审核图片(6)、" +
                    "待发货(7)、配送中(8)、已收货(9)")
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:update')")
    public CommonResult updateOrderStatus(@PathVariable("orderId") Long orderId , @RequestParam Integer status) {

        boolean b = omsOrderStatusService.checkOrderStatusForward(orderId, status);
        if(!b){
            return new CommonResult().failed(CommonResult.FAILED, "订单目前无法向前迁移到状态="+status);
        }

        int count = orderService.updateOrderStatus(orderId, status);
        if (count > 0) {
            return new CommonResult().success(count);
        }

        return new CommonResult().failed();
    }

    @ApiOperation("订单状态回滚(by orderId)")
    @Ignore
    @RequestMapping(value = "/update/status/rollback/{orderId}", method = RequestMethod.POST,
            name="订单状态：预选状态(0)、待提交订单(1)、待审核订单(2)、" +
                    "待支付(3)、待确认到款(4)、待拍照(5)、待审核图片(6)、" +
                    "待发货(7)、配送中(8)、已收货(9)")
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:update')")
    public CommonResult updateOrderStatusRollback(@PathVariable("orderId") Long orderId , @RequestParam Integer status) {

        boolean b = omsOrderStatusService.checkOrderStatusRollback(orderId, status);
        if(!b){
            return new CommonResult().failed(CommonResult.FAILED, "订单目前无法回滚到状态="+status);
        }

        int count = orderService.updateOrderStatus(orderId, status);
        if (count > 0) {
            return new CommonResult().success(count);
        }

        return new CommonResult().failed();
    }

    @ApiOperation("更改订单的配送状态(by orderId)")
    @Ignore
    @RequestMapping(value = "/update/confirmStatus/{orderId}", method = RequestMethod.POST, name="订单状态：" +
            "配送状态:0-待客户照片确认;1-待发货确认（订单审核）; 2-已发货（配送中）; 3-未发货; 4-配送完成")
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:update')")
    public CommonResult updateOrderConfirmStatus(@PathVariable("orderId") Long orderId , @RequestParam Integer confirmStatus) {

        int count = orderService.updateOrderConfirmStatus(orderId, confirmStatus);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("逻辑上订单删除")
    @RequestMapping(value = "/logic/delete/{orderId}", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:logic:delete')")
    public CommonResult logicDelete(@PathVariable("orderId") Long orderId) {

        int count = orderService.logicDelete(orderId);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("物理上订单删除")
    @RequestMapping(value = "/delete/{orderId}", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:logic:delete')")
    public CommonResult delete(@PathVariable("orderId") Long orderId) {

        int count = orderService.delete(orderId);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("获取订单详情:订单信息、商品信息、操作记录")
    @ApiResponses({@ApiResponse(code = 201, response = OmsOrderDetail.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/get/detail/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getDetail(@PathVariable("orderId") Long orderId) {
        OmsOrderDetail orderDetailResult = orderService.detail(orderId);
        return new CommonResult().success(orderDetailResult);
    }

    @ApiOperation("修改订单费用信息")
    @RequestMapping(value = "/update/moneyInfo", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:update')")
    public CommonResult updateReceiverInfo(@RequestBody OmsMoneyInfoParam moneyInfoParam) {
        int count = orderService.updateMoneyInfo(moneyInfoParam);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("备注订单")
    @RequestMapping(value = "/update/note", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:update')")
    public CommonResult updateNote(@RequestParam("id") Long id,
                             @RequestParam("note") String note,
                             @RequestParam("updateOrderStatus") Integer status) {
        int count = orderService.updateNote(id,note,status);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }


    @ApiOperation("修改收货人信息")
    @RequestMapping(value = "/update/receiverInfo", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:update')")
    public CommonResult updateReceiverInfo(@RequestBody OmsReceiverInfoParam receiverInfoParam) {
        int count = orderService.updateReceiverInfo(receiverInfoParam);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("批量发货")
    @RequestMapping(value = "/update/delivery", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('oms:order:update')")
    public CommonResult delivery(@RequestBody List<OmsOrderDeliveryParam> deliveryParamList) {
        int count = orderService.delivery(deliveryParamList);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("批量关闭订单")
    @RequestMapping(value = "/update/close", method = RequestMethod.POST)
    @ResponseBody
    @Deprecated
    public CommonResult close(@RequestParam("ids") List<Long> ids, @RequestParam String note) {
        int count = orderService.close(ids,note);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("批量删除订单")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @Deprecated
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = orderService.delete(ids);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

}
