package com.macro.mall.portal.controller;

import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.service.OmsPortalOrderService;
import com.macro.mall.portal.vo.LmsLogisticsModeVo;
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
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 订单管理Controller
 * Created by ruiwu.xu on 2019/01/19.
 */

@Api(tags = "订单模块-订单物流方式", description = "订单物流方式:OmsPortalOrderLogisticsModeSetController")
@Slf4j
@Controller
@RequestMapping("/order/logistics/mode")
public class OmsPortalOrderLogisticsModeSetController {
    @Autowired
    private OmsPortalOrderService portalOrderService;

    @ApiOperation("查询订单的备选物流方式")
    @ApiResponses({@ApiResponse(code = 201, response = LmsLogisticsModeVo.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/list/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult list(@PathVariable("orderId")  Long orderId) {
        List<LmsLogisticsModeVo>   logisticsModeVoList = portalOrderService.listLmsLogisticsModeVo(orderId);
        return new CommonResult().success(logisticsModeVoList);
    }

    @ApiOperation("设置订单的具体物流方式,同时更新订单的物流费用,V2, 收费类型(00-按重量|01-按数量)")
    @ApiIgnore
    @RequestMapping(value = "/update/logisticmode/{orderId}/{logisticModeId}/{chargeType}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult setV2(@PathVariable("orderId") Long orderId,
                            @PathVariable("logisticModeId") Long logisticModeId,
                            @PathVariable("chargeType") String chargeType) {
        int count = portalOrderService.setOrderLogisticsModeV2(orderId, logisticModeId, chargeType);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("设置订单的具体物流方式,同时更新订单的物流费用")
    @RequestMapping(value = "/update/logisticmode/{orderId}/{logisticModeId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult set(@PathVariable("orderId") Long orderId, @PathVariable("logisticModeId") Long logisticModeId) {
        int count = portalOrderService.setOrderLogisticsMode(orderId, logisticModeId);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }
}
