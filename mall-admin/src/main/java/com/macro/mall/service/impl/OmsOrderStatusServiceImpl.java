package com.macro.mall.service.impl;

import com.macro.mall.mapper.OmsOrderMapper;
import com.macro.mall.model.OmsOrder;
import com.macro.mall.service.OmsOrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单状态Service实现类
 * Created by macro on 2018/10/11.
 */
@Service
public class OmsOrderStatusServiceImpl implements OmsOrderStatusService {
    @Autowired
    private OmsOrderMapper orderMapper;
    /**
     * 校验订单状态迁移的合法性校验
     *
     * @param orderStatus
     */
    @Override
    public boolean checkOrderStatusForward(Long orderId, Integer orderStatus) {
        //订单状态向前迁移路径：
        //预选状态0->待提交订单1->待审核订单2->待支付3->待确认到款4
        //->待拍照5->待审核图片6->待发货7->配送中8->已收货9

        //获取订单的当前状态
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        int orderStatusCur = order.getStatus();

        //简单实现
        if( (orderStatusCur+1) == orderStatus){
            return true;
        }

        return false;
    }

    /**
     * 校验订单状态向后回滚的合法性校验
     *
     * @param orderId
     * @param orderStatus
     */
    @Override
    public boolean checkOrderStatusRollback(Long orderId, Integer orderStatus) {
        //订单状态向后回滚路径：
        //预选状态0->待提交订单1->待审核订单2->待支付3->待确认到款4
        //->待拍照5->待审核图片6->待发货7->配送中8->已收货9

        //获取订单的当前状态
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        int orderStatusCur = order.getStatus();

        //简单实现
        if( (orderStatusCur-1) == orderStatus){
            return true;
        }

        return false;
    }
}
