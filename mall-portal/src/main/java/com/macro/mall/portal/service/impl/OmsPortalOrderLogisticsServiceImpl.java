package com.macro.mall.portal.service.impl;

import com.macro.mall.portal.constant.AppOprRoleConst;
import com.macro.mall.portal.constant.OmsOrderConst;
import com.macro.mall.portal.dto.OmsOrderLogisticsPicDto;
import com.macro.mall.portal.service.OmsPortalOrderLogisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 前台订单管理Service
 * Created by macro on 2018/8/30.
 */
@Service
@Slf4j
public class OmsPortalOrderLogisticsServiceImpl implements OmsPortalOrderLogisticsService {
    //订单相关
    @Autowired
    private OmsOrderMapper orderMapper;

    //物流相关
    @Autowired
    private OmsOrderLogisticsPicUriMapper orderLogisticsPicUriMapper;
    @Autowired
    private OmsOrderLogisticsTraceLogMapper orderLogisticsTraceLogMapper;

    @Override
    public int saveLogisticsPic(OmsOrderLogisticsPicDto orderLogisticsPicDto) {
        if(orderLogisticsPicDto == null){
            log.warn("无物流发货凭证需要保存");
            return 0;
        }

        //登记订单物流跟踪情况
        OmsOrderLogisticsTraceLog omsOrderLogisticsTraceLog = new OmsOrderLogisticsTraceLog();
        omsOrderLogisticsTraceLog.setOrderId(orderLogisticsPicDto.getOrderId());
        omsOrderLogisticsTraceLog.setTraceNo(orderLogisticsPicDto.getTraceNo());
        omsOrderLogisticsTraceLog.setTraceContent("订单已发货");
        omsOrderLogisticsTraceLog.setLastCreateId(AppOprRoleConst.ROLE_DELIVER);
        omsOrderLogisticsTraceLog.setLastCreateTime(new Date());
        omsOrderLogisticsTraceLog.setLastUpdateId(AppOprRoleConst.ROLE_DELIVER);
        omsOrderLogisticsTraceLog.setLastUpdateTime(new Date());
        if(orderLogisticsTraceLogMapper.insert(omsOrderLogisticsTraceLog) < 0){
            log.error("登记订单物流跟踪情况失败{}",omsOrderLogisticsTraceLog);
            return -1;
        }

        // 保存物流凭证URI信息
        for (OmsOrderLogisticsPicUri orderLogisticsPicUri : orderLogisticsPicDto.getOrderLogisticsPicUriList()) {
            orderLogisticsPicUri.setLastCreateId(AppOprRoleConst.ROLE_DELIVER);
            orderLogisticsPicUri.setLastCreateTime(new Date());
            orderLogisticsPicUri.setLastUpdateId(AppOprRoleConst.ROLE_DELIVER);
            orderLogisticsPicUri.setLastUpdateTime(new Date());
            if(orderLogisticsPicUriMapper.insert(orderLogisticsPicUri) < 0){
                log.error("登记订单物流信息失败{}", orderLogisticsPicUri);
                return -1;
            }
        }

        //更改订单状态为配送中
        OmsOrder order = new OmsOrder();
        order.setId(orderLogisticsPicDto.getOrderId());
        order.setStatus(OmsOrderConst.STATUS_TOBE_SENDING_7);
        order.setLastUpdateTime(new Date());
        order.setLastUpdateId(AppOprRoleConst.ROLE_DELIVER);
        if(orderMapper.updateByPrimaryKeySelective(order) < 0){
            log.error("更新订单状态失败{}", order);
            return -1;
        }
        //TODO 订单的状态记录
        return 1;
    }
}
