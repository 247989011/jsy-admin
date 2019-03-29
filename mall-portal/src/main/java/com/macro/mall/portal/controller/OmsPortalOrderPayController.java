package com.macro.mall.portal.controller;

import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.service.OmsPortalOfflinePayService;
import com.macro.mall.portal.service.OmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 订单管理Controller
 * Created by ruiwu.xu on 2019/02/22.
 */
@Controller
@Api(tags = "订单模块-订单支付",description = "订单支付:OmsPortalOrderPayController")
@Slf4j
@RequestMapping("/order/pay")
public class OmsPortalOrderPayController {
    @Autowired
    private OmsPortalOrderService portalOrderService;
    @Autowired
    private OmsPortalOfflinePayService offlinePayService;

    @ApiOperation("订单支付类型：0-线上支付，1-线下支付")
    @RequestMapping(value = "/type/{orderId}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult setPayType(@PathVariable("orderId") Long orderId, @RequestParam Integer payType){
        if(offlinePayService.setPayType(orderId, payType) < 0){
            return new CommonResult().failed();
        }
        return  new CommonResult().success(null);
    }

    @ApiOperation("线上支付-订单支付成功的回调--暂不实现")
    @RequestMapping(value = "/success",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult paySuccess(@RequestParam Long orderId){
        return portalOrderService.paySuccess(orderId);
    }

    @ApiOperation("线上支付-订单支付接口--暂不实现")
    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult pay(@RequestParam Long orderId){
        //TODO  待实现 待确认
        return null;
    }

}
