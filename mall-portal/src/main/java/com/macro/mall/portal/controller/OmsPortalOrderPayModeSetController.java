package com.macro.mall.portal.controller;

import com.macro.mall.model.PaymsPayMode;
import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.service.OmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 订单管理Controller
 * Created by macro on 2018/8/30.
 */

@Api(tags = "订单模块-订单支付方式",
        description = "订单支付方式:OmsPortalOrderPayModeSetController")
@Slf4j
@Controller
@RequestMapping("/order/pay/mode")
public class OmsPortalOrderPayModeSetController {
    @Autowired
    private OmsPortalOrderService portalOrderService;

    @ApiOperation("查询订单的备选支付方式")
    @ApiResponses({@ApiResponse(code = 201, response = PaymsPayMode.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/list/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult list(@PathVariable("orderId")  Long orderId) {
        List<PaymsPayMode> payModeList= portalOrderService.listOrderPayMode(orderId);
        return new CommonResult().success(payModeList);
    }

    @ApiOperation("设置订单的具体支付方式")
    @RequestMapping(value = "/update/logisticmode/{orderId}/{payModeId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult set(@PathVariable("orderId") Long orderId, @PathVariable("payModeId") Long payModeId) {
        int count = portalOrderService.setOrderPayMode(orderId, payModeId);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }
}
