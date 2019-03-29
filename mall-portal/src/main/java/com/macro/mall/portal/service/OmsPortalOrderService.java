package com.macro.mall.portal.service;

import com.macro.mall.model.*;
import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.domain.ConfirmOrderResult;
import com.macro.mall.portal.domain.OrderParam;
import com.macro.mall.portal.dto.*;
import com.macro.mall.portal.vo.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 前台订单管理Service
 * Created by macro on 2018/8/30.
 */
public interface OmsPortalOrderService {
    /**
     * 根据用户购物车信息生成确认单信息
     */
    ConfirmOrderResult generateConfirmOrder();

    /**
     * 根据提交信息生成订单
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * 支付成功后的回调
     */
    @Transactional
    CommonResult paySuccess(Long orderId);

    /**
     * 自动取消超时订单
     */
    @Transactional
    CommonResult cancelTimeOutOrder();

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);

    /**
     * 发送延迟消息取消订单
     */
    void sendDelayMessageCancelOrder(Long orderId);

    /**
     * 查询订单
     */
    @Deprecated
    List<OmsOrder> page(OmsOrderQueryParamDto queryParam, Integer pageSize, Integer pageNum);

    /**
     * 查询订单的基本信息
     */
    List<OmsPortalOrderListVo> pageBasicInfo(OmsOrderQueryParamDto queryParam, Integer pageSize, Integer pageNum);


    /**
     * 根据订单Id,获取订单详情
     */
    OmsPortalOrderDetailVo getOrderDetail(Long orderId);

    /**
     * 【发货员】分页查询订单及订单详情
     */
    List<OmsPortalDeliverOrderVo> pageDeliverOrderDetail(OmsOrderQueryParamDto queryParam, Integer pageSize, Integer pageNum);
    /**
     * 【发货员】分页查询订单及订单详情
     */
    OmsPortalDeliverOrderVo getDeliverOrderDetail(Long orderId);


    /**
     * 确认订单信息(支付方式、物流方式，确认完订单状态为‘1-待业务员审核’)
     * @param omsOrder
     * @return
     */
    int commitOrder(OmsOrder omsOrder);

    /**
     *
     * @param orderId
     * @return
     */
    int getCheckStatus(Long orderId);

    /**
     * 计算订单的总金额
     */
    @Deprecated
     OmsPortalOrderAmountDto calculateAmount(OmsPortalOrderDetailVo portalOrderDetailDto);

    /**
     * 查询订单的商品信息 by orderId
     */
    List<Map<String, Object>> listOrderItem(Long orderId);

    /**
     * 查询订单的商品信息 by orderId 通用
     */
    List<OmsOrderItem>  listOrderItemGeneral(Long orderId);

    /**
     * 为订单添加商品
     */
    @Transactional
    int addOrderItem(List<OmsOrderItem> listOrderItem);

    /**
     * 删除订单商品
     */
    @Transactional
    int deleteOrderItem(List<OmsOrderItem> listOrderItem);

    /**
     * 更新订单商品
     */
    @Transactional
    int updateOrderItem(List<OmsOrderItem> listOrderItem);

    /**
     * 客户保存订单商品列表
     */
    @Transactional
    @Deprecated
    int SaveOrderDetailByMember(OmsPortalOrderDetailVo portalOrderDetailDto);

    /**
     * 客户保存订单商品列表
     */
    @Transactional
    int SaveOrderDetailByMember(OmsPortalOrderDetailDto orderDetailDto);

    /**
     * 增加订单商品的实物照片URI, 同时更新订单状态为 商品图片待审核
     */
    @Transactional
    int saveOrderItemPhysicalPic(List<OmsOrderPhysicalPicDto> orderItemPhysicalPicDtoList);

    /**
     * 获取订单商品的实物照片
     */
    List<OmsOrderPhysicalPicVo> getOrderPhysicalPic(Long orderId);

    /**
     * 客户订单商品实物照片审核
     */
    @Transactional
    int checkOrderPhysicalPic(OmsOrderCheckPhysicalPicDto orderCheckPhysicalPicDto);

    /**
     * 发货员更改订单状态:(待拍照5、待审核图片6、待发货7、配送中8)
     */
    int updateDeliveredStatus(Long orderId, Integer status);

    /**
     * 更改订单状态为已发货
     */
    @Transactional
    int receivedOrder(Long orderId);

    /**
     *查询订单的备选支付方式
     */
    List<PaymsPayMode> listOrderPayMode(Long orderId);

    /**
     *设置订单的支付方式
     */
    int setOrderPayMode(Long orderId, Long payModeId);

    /**
     *查询订单的备选物流方式
     */
    List<LmsLogisticsModeVo> listLmsLogisticsModeVo(Long orderId);

    /**
     *设置订单的物流方式
     */
    int setOrderLogisticsMode(Long orderId,  Long logisticsModeId);


    /**
     *设置订单的物流方式
     */
    int setOrderLogisticsModeV2(Long orderId,  Long logisticsModeId, String chargeType);

    /**
     * 登记订单物流跟踪情况
     */
    int addLogisticsLog(Long orderId,  OmsOrderLogisticsTraceLog orderLogisticsTraceLog);

    /**
     * 获取订单物流跟踪情况(ALL)
     */
    List<OmsOrderLogisticsTraceLog>  getLogisticsLogAll(Long orderId, Integer pageSize, Integer pageNum);

    /**
     * 获取订单物流跟踪最新情况
     */
    OmsOrderLogisticsTraceLog getLogisticsLogLast(Long orderId);

    //获取订单基本信息
    OmsOrder getOrder(Long orderId);

    //获取订单及订单列表信息
    OmsPortalOrderBasicInfoVo getOrderBasicInfo(Long orderId);
}
