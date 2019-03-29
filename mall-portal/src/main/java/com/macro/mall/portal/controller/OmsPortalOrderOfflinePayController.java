package com.macro.mall.portal.controller;

import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.dto.OmsOfflinePayMtcnPicDto;
import com.macro.mall.portal.service.OmsPortalOfflinePayService;
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
@RequestMapping("/order/pay/offline")
public class OmsPortalOrderOfflinePayController {

    @Autowired
    private OmsPortalOfflinePayService offlinePayService;

    @ApiOperation("线下支付-保存线下支付凭证")
    @RequestMapping(value = "/mtcn/add",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult saveMtcn(@RequestBody OmsOfflinePayMtcnPicDto offlinePayMtcnPicDto){
        if(offlinePayService.saveMtcn(offlinePayMtcnPicDto) < 0){
            return new CommonResult().failed();
        }
        return  new CommonResult().success(null);
    }

    @ApiOperation("线下支付-获取线下支付凭证(凭证存储路径)")
    @RequestMapping(value = "/mtcn/get/{orderId}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getMtcn(@PathVariable("orderId") Long orderId){
        return  new CommonResult().success(offlinePayService.getMtcn(orderId));
    }
}
