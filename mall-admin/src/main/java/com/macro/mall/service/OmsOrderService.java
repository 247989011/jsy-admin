package com.macro.mall.service;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.dto.*;
import com.macro.mall.model.*;
import com.macro.mall.vo.OmsOrderDetailVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 订单管理Service
 * Created by macro on 2018/10/11.
 */
public interface OmsOrderService {

    Integer ORDER_DELETE_STATUS_INUSE_0 = 0; //未删除
    Integer ORDER_DELETE_STATUS_DISUSE_1 = 1; //已删除

    /**
     * 订单查询
     */
    List<OmsOrder> page(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * 订单查询V2
     */
    List<OmsOrderDetailVo> pageV2(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量发货
     */
    @Transactional
    int delivery(List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 批量关闭订单
     */
    @Transactional
    int close(List<Long> ids, String note);

    //更改订单的订单状态
    int updateOrderStatus(Long id, Integer status);

    /**
    /* 更改订单的订单信息(通用)
     **/
    int updateOrderGeneralInfo(OmsOrder omsOrder);

    /**
     * 更改订单配送(确认)状态
     */
    int updateOrderConfirmStatus(Long id, Integer confirmStatus);

    /**
     * 【业务员】审核订单
     * @param orderId
     * @return
     */
    CommonResult reviewOrder(Long orderId, Integer status);

    /**
     * 更改订单的订单删除状态
     */
    int updateOrderDeleteStatus(Long id, Integer deleteStatus);

    /**
     * 逻辑删除订单
     */
    int logicDelete(Long id);

    /**
     * 物理删除订单
     */
    int delete(Long id);

    /**
     * 批量删除订单
     */
    int delete(List<Long> ids);

    /**
     * 获取指定订单详情
     */
    OmsOrderDetail detail(Long id);

    /**
     * 修改订单收货人信息
     */
    @Transactional
    int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam);

    /**
     * 修改订单费用信息
     */
    @Transactional
    int updateMoneyInfo(OmsMoneyInfoParam moneyInfoParam);

    /**
     * 修改订单备注
     */
    @Transactional
    int updateNote(Long id, String note, Integer status);

    /**
     * 创建订单
     */
    @Transactional
    int add(OmsOrderAddDto orderAddDto);

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
     * 查询订单商品信息 by orderId
     */
    List<OmsOrderItem>  listOrderItem(Long orderId);

    /**
     * 登记订单物流跟踪情况
     */
    int addLogisticsLog(Long orderId,  OmsOrderLogisticsTraceLog orderLogisticsTraceLog);

    /**
     * 获取订单物流跟踪情况(ALL,分页查询)
     */
    List<OmsOrderLogisticsTraceLog>  getLogisticsLogAll(Long orderId, Integer pageSize, Integer pageNum);

    /**
     * 获取订单物流跟踪最新情况
     */
    OmsOrderLogisticsTraceLog getLogisticsLogLast(Long orderId);


    /**
     * 增加订单的备选支付方式
     */
    int addOrderPayOption(Long orderId, OmsPayModeOption payModeOption);

    /**
     *删除订单的备选支付方式
     */
    int deleteOrderPayOption(Long payOptionId);

    /**
     *查询订单的备选支付方式
     */
    OmsOrderPayModeOptionDTO listOrderPayOption(Long orderId);

    /**
     * 增加订单的备选物流方式
     */
    int addOrderLogisticsModeOption(Long orderId, OmsLogisticsModeOption logisticsModeOption);

    /**
     * 删除订单的备选物流方式
     */
    int deleteOrderLogisticsModeOption(Long logisticsOptionId);

    /**
     *查询订单的备选物流方式
     */
    OmsOrderLogisticsModeOptionDTO listOrderLogisticsModeOption(Long orderId);
}
