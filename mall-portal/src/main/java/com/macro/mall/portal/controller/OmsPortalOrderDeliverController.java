package com.macro.mall.portal.controller;

import com.macro.mall.model.OmsOrderItem;
import com.macro.mall.portal.constant.OmsOrderConst;
import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.dto.OmsOrderCheckPhysicalPicDto;
import com.macro.mall.portal.dto.OmsOrderPhysicalPicDto;
import com.macro.mall.portal.dto.OmsOrderQueryParamDto;
import com.macro.mall.portal.service.OmsPortalOrderService;
import com.macro.mall.portal.vo.OmsOrderPhysicalPicVo;
import com.macro.mall.portal.vo.OmsPortalDeliverOrderVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 订单管理Controller
 * Created by ruiwu.xu on 2018/12/11.
 */
@Controller
@Api(tags = "订单模块-订单发货", description = "订单发货:OmsPortalOrderDeliverController",position = 50)
@RequestMapping("/order/deliver")
public class OmsPortalOrderDeliverController {
    @Autowired
    private OmsPortalOrderService  portalOrderService;

    @ApiOperation("【发货员】分页查询订单基本信息、订单商品列表、订单物流方式:(订单状态=待拍照5、待审核图片6、待发货7、配送中8、已收货9)")
    @ApiResponses({@ApiResponse(code = 201, response = OmsPortalDeliverOrderVo.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/order/page", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult pageDeliverOrderDetail(OmsOrderQueryParamDto orderQueryParamDto,
                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        //检查发货员订单状态权限
        if(orderQueryParamDto.getStatus() !=null && !checkDeliveryStatusAuth(orderQueryParamDto.getStatus())){
            return new CommonResult().failed("发货员无权限订单查询状态="+orderQueryParamDto.getStatus()+",请检查");
        }

        List<OmsPortalDeliverOrderVo> orderDtoList = portalOrderService.pageDeliverOrderDetail(orderQueryParamDto, pageSize, pageNum);
        if(orderDtoList != null && !orderDtoList.isEmpty()){
            return new CommonResult().pageSuccess(orderDtoList);
        }

        return new CommonResult().failed();
    }

    @ApiOperation("【发货员】根据orderId查询订单基本信息、订单商品列表、订单物流方式:(订单状态=待拍照5、待审核图片6、待发货7、配送中8、已收货9)")
    @ApiResponses({@ApiResponse(code = 201, response = OmsPortalDeliverOrderVo.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/order/get/detail/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getDeliverOrderDetail(@PathVariable("orderId") Long orderId) {

        OmsPortalDeliverOrderVo  deliverOrderVo = portalOrderService.getDeliverOrderDetail(orderId);
        if(deliverOrderVo != null){
            return new CommonResult().success(deliverOrderVo);
        }

        return new CommonResult().failed();
    }

    @ApiOperation("【发货员】根据orderId 获取订单的商品列表")
    @ApiIgnore
    @ApiResponses({@ApiResponse(code = 201, response = OmsOrderItem.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/order/item/list/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult orderItemList(@PathVariable("orderId") Long orderId){
        List<OmsOrderItem> orderItemList = portalOrderService.listOrderItemGeneral(orderId);
        if(orderItemList != null){
            return new CommonResult().success(orderItemList);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("【发货员】保存订单商品实物照片(OSS照片URI), 同时更改订单状态为待审核图片")
    @RequestMapping(value = "/order/pic/oss/save", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult saveOssOrderItemPic(@RequestBody List<OmsOrderPhysicalPicDto> orderItemPhysicalPicDtoList) {
        int count = portalOrderService.saveOrderItemPhysicalPic(orderItemPhysicalPicDtoList);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("【发货员】上传订单商品实物照片(fastdfs照片URI), 同时更改订单状态为待审核图片")
    @RequestMapping(value = "/order/pic/fastdfs/save", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult uploadFastdfsOrderItemPic(@RequestBody List<OmsOrderPhysicalPicDto> orderItemPhysicalPicDtoList) {
        int count = portalOrderService.saveOrderItemPhysicalPic(orderItemPhysicalPicDtoList);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("【发货员|客户】获取订单商品实物照片(fastdfs照片路径)")
    @ApiResponses({@ApiResponse(code = 201, response = OmsOrderPhysicalPicVo.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/pic/fastdfs/get/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getFastdfsOrderPhysicalPic(@PathVariable("orderId") Long orderId){
        List<OmsOrderPhysicalPicVo> orderPhysicalPicVoList = portalOrderService.getOrderPhysicalPic(orderId);
        if(orderPhysicalPicVoList != null && !orderPhysicalPicVoList.isEmpty()){
            return new CommonResult().success(orderPhysicalPicVoList);
        }
        return new CommonResult().failed();
    }


    @ApiOperation("【发货员|客户】获取订单商品实物照片(OSS照片路径)")
    @ApiResponses({@ApiResponse(code = 201, response = OmsOrderPhysicalPicVo.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/pic/oss/get/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getOssOrderItemPic(@PathVariable("orderId") Long orderId) {
        List<OmsOrderPhysicalPicVo> orderPhysicalPicVoList = portalOrderService.getOrderPhysicalPic(orderId);
        if(orderPhysicalPicVoList != null &&  !orderPhysicalPicVoList.isEmpty()){
            return new CommonResult().success(orderPhysicalPicVoList);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("【客户】订单商品实物照片审核,同时根据审核结果更新订单状态")
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult checkOrderPhysicalPic(@RequestBody OmsOrderCheckPhysicalPicDto orderCheckPhysicalPicDto) {
        int count = portalOrderService.checkOrderPhysicalPic(orderCheckPhysicalPicDto);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }


    @ApiOperation("【客户】确认订单商品已收到")
    @RequestMapping(value = "/received/{orderId}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult receivedOrder(@PathVariable("orderId") Long orderId) {
        int count = portalOrderService.receivedOrder(orderId);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("【发货员】更改订单状态:(待拍照5、待审核图片6、待发货7、配送中8)")
    @ApiIgnore
    @RequestMapping(value = "/delivered/status/update/{orderId}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateDeliveredStatus(@PathVariable("orderId") Long orderId, @RequestParam("status") Integer status) {
        //检查发货员订单状态操作是否合法
        if(checkDeliveryStatusAuth(status) == false && status != 9){
            return new CommonResult().failed("发货员无权限将订单查询状态改为:"+status+",请检查");
        }

        int count = portalOrderService.updateDeliveredStatus(orderId, status);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    private boolean checkDeliveryStatusAuth(Integer status){
        //发货员只能查看状态为 待拍照5、待审核图片6、待发货7、配送中8、已收货9 的订单
        if( status == OmsOrderConst.STATUS_TOBE_COMMIT_0 ||
            status == OmsOrderConst.STATUS_TOBE_CHECK_1 ||
            status == OmsOrderConst.STATUS_TOBE_PAY_2 ||
            status == OmsOrderConst.STATUS_TOBE_PAY_CHECK_3 ){
            return false;
        }
        return true;
    }
}
