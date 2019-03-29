package com.macro.mall.portal.controller;

import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.domain.OmsPortalMarketingActivityDo;
import com.macro.mall.portal.domain.OmsPortalMarketingActivityWithProductIdDo;
import com.macro.mall.portal.service.OmsPortalMarketingActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
 * Created by macro on 2018/8/30.
 */
@Api(tags = "订单模块-商品营销活动",description = "商品营销活动:OmsPortalOrderMarketingActivityController")
@ApiIgnore
@Controller
@RequestMapping("/order/marketingActivity")
@Deprecated
public class OmsPortalOrderMarketingActivityController {
    @Autowired
    private OmsPortalMarketingActivityService portalMarketingActivityService;

    @ApiOperation("订单商品参加的所有的正式进行的非全场通用的营销活动")
    @ApiResponses({@ApiResponse(code = 201, response = OmsPortalMarketingActivityWithProductIdDo.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/appoint/list/{productId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listAppointMarketingActivity(@PathVariable("productId") Long productId) {
        List<OmsPortalMarketingActivityWithProductIdDo>  portalMarketingActivityWithProductIdDtoList =
                portalMarketingActivityService.listAppointMarketingActivity(productId);
        return new CommonResult().success(portalMarketingActivityWithProductIdDtoList);
    }

    @ApiOperation("获取所有全场通用的正在进行的营销活动")
    @ApiIgnore
    @ApiResponses({@ApiResponse(code = 201, response = OmsPortalMarketingActivityDo.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/general/list", method = RequestMethod.GET)
    @ResponseBody
    @Deprecated
    public CommonResult listGeneralMarketingActivity() {
        List<OmsPortalMarketingActivityDo>  omsPortalMarketingActivityDtoList = portalMarketingActivityService.listGeneralMarketingActivity();
        return new CommonResult().success(omsPortalMarketingActivityDtoList);
    }

}
