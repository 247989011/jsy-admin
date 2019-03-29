package com.macro.mall.portal.controller;

import com.macro.mall.model.SmsCoupon;
import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.vo.SmsCouponVo;
import com.macro.mall.portal.service.OmsPortalCouponService;
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

@Api(tags = "订单模块-优惠劵+活动",description = "优惠劵:OmsPortalOrderCouponController")
@ApiIgnore
@Controller
@RequestMapping("/order/coupon")
@Deprecated
public class OmsPortalOrderCouponController {
    @Autowired
    private OmsPortalCouponService couponService;

    @ApiOperation("获取客户全场通用的正在进行的优惠劵")
    @ApiResponses({@ApiResponse(code = 201, response = SmsCoupon.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/general/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listGeneralCoupon() {
        List<SmsCoupon>   couponList = couponService.listGeneralCoupon();
        return new CommonResult().success(couponList);
    }

    @ApiOperation("订单商品的非全场通用的有效期内的优惠劵+活动")
    @ApiResponses({@ApiResponse(code = 201, response = SmsCouponVo.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/appoint/list/{productId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listAppointCoupon(@PathVariable("productId") Long productId) {
        List<SmsCouponVo>  couponList = couponService.listAppointCoupon(productId);
        return new CommonResult().success(couponList);
    }
}
