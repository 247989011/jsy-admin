package com.macro.mall.portal.controller;

import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.domain.MemberDetails;
import com.macro.mall.portal.domain.PromotionProduct;
import com.macro.mall.portal.service.OmsPortalOrderItemService;
import com.macro.mall.portal.service.OmsPortalOrderService;
import com.macro.mall.portal.vo.PmsPortalProductDetailVo;
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
import java.util.List;
import java.util.Map;

/**
 * 订单管理Controller
 * Created by ruiwu.xu on 2018/10/11.
 */
@Controller
@Api(tags = "订单模块-订单商品详情", description = "订单商品详情:OmsPortalOrderItemController",position = 50)
@RequestMapping("/order/item")
public class OmsPortalOrderItemController {
    @Autowired
    private OmsPortalOrderService  portalOrderService;
    @Autowired
    private OmsPortalOrderItemService orderItemService;

    @ApiOperation("获取订单的商品详情")
    @ApiResponses({@ApiResponse(code = 201, response = Map.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/list/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult list(@PathVariable long orderId) {
        List<Map<String, Object>> orderItemList = portalOrderService.listOrderItem(orderId);
        if(orderItemList != null){
            return new CommonResult().success(orderItemList);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("根据商品id获取商品详情，包含sku，属性，参与优惠活动，对应客户持有优惠券 信息")
    @ApiResponses({@ApiResponse(code = 201, response = PmsPortalProductDetailVo.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/detail/{productId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult pageDetail(@PathVariable("productId") Long productId, Principal principal) {
        Long memberId =  ((MemberDetails) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUmsMember().getId();
        PromotionProduct portalProductDetailVo = orderItemService.getProductDetail(productId, memberId);
        return new CommonResult().success(portalProductDetailVo);
    }


    @ApiOperation("删除订单商品")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult deleteOrderItem(@RequestBody List<OmsOrderItem> listOrderItem) {
        int count = portalOrderService.deleteOrderItem(listOrderItem);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("更新订单商品列表")
    @ApiIgnore
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @Deprecated
    public CommonResult updateOrderItem(@RequestBody List<OmsOrderItem> listOrderItem) {
        int count = portalOrderService.updateOrderItem(listOrderItem);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }
}
