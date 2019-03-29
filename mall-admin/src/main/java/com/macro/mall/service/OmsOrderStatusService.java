package com.macro.mall.service;

/**
 * 订单状态Service
 * Created by macro on 2018/10/11.
 */
public interface OmsOrderStatusService {
    /**
     * 校验订单状态向前迁移的合法性校验
     */
    boolean checkOrderStatusForward(Long orderId, Integer orderStatus);

    /**
     * 校验订单状态向后回滚的合法性校验
     */
    boolean checkOrderStatusRollback(Long orderId, Integer orderStatus);

}
