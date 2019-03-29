package com.macro.mall.portal.controller;

import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.domain.MemberDetails;
import com.macro.mall.portal.domain.PromotionProduct;
import com.macro.mall.portal.service.OmsPromotionService;
import com.macro.mall.portal.vo.SmsGeneralPromotionVo;
import com.macro.mall.portal.vo.SmsPromotionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.security.Principal;


/**
 * 订单模块Controller
 * Created by ruiwu.xu on 2019/02/22.
 */
@Api(tags = "订单模块-优惠信息", description = "优惠信息:OmsPortalOrderPromotionController")
@Controller
@RequestMapping("/order/promotion")
public class OmsPortalOrderPromotionController {
    @Autowired
    private OmsPromotionService omsPromotionService;

    @ApiOperation("获取客户的单个商品的优惠信息(有效的)")
    @ApiResponses({@ApiResponse(code = 201, response = SmsPromotionVo.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/promotion/list/{productId}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getPromotionOfProduct(@PathVariable  Long productId, @RequestParam("memberId") Long memberId){
        return new CommonResult().success(omsPromotionService.getPromotionOfProduct(memberId,productId));
    }

    @ApiOperation("获取客户的全场通用的商品的优惠信息(有效的)")
    @ApiResponses({@ApiResponse(code = 201, response = SmsGeneralPromotionVo.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/promotion/general/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getGeneralPromotion(Principal principal){

        Long memberId = ((MemberDetails) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUmsMember().getId();
//        return new CommonResult().success(omsPromotionService.getGeneralPromotion(
//                ((MemberDetails) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUmsMember().getId()));

                return new CommonResult().success(omsPromotionService.getGeneralPromotion(memberId));
    }

    @ApiOperation("获取单个商品的优惠信息(有效的)")
    @ApiResponses({@ApiResponse(code = 201, response = PromotionProduct.class,
            message="状态200的data格式说明：data返回值为列表")})
    @ApiIgnore
    //@RequestMapping(value = "/promotion/list/{productId}", method = RequestMethod.POST)
    @ResponseBody
    @Deprecated
    public CommonResult getPromotion(@PathVariable  Long productId){
        return new CommonResult().success(omsPromotionService.getPromotion(productId));
    }
}
