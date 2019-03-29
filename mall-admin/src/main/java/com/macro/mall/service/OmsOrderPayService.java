package com.macro.mall.service;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.model.OmsOrderLogisticsDeliveryStaff;
import com.macro.mall.vo.OmsOrderPayResultInfoVo;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单模块-订单支付Service
 * Created by macro on 2018/10/11.
 */
public interface OmsOrderPayService {
    /**
     * 确认订单已到款
     * @param orderId
     * @return
     */
    @Transactional
    CommonResult confirmPayment(Long orderId);

    /**
     * 确认订单已到款,同时保存订单的物流发货员信息
     * @param orderLogisticsDeliveryStaff
     * @return
     */
    @Transactional
    int confirmPayment(OmsOrderLogisticsDeliveryStaff orderLogisticsDeliveryStaff);

    /**
     * 查询订单的支付结果信息
     * @param orderId
     * @return
     */
    OmsOrderPayResultInfoVo getPayResult(Long orderId);

}
