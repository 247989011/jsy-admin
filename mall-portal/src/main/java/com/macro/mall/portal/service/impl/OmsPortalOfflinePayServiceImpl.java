package com.macro.mall.portal.service.impl;

import com.macro.mall.common.model.*;
import com.macro.mall.portal.constant.AppOprRoleConst;
import com.macro.mall.portal.constant.OmsOrderConst;
import com.macro.mall.portal.dto.OmsOfflinePayMtcnPicDto;
import com.macro.mall.portal.service.OmsPortalOfflinePayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 商品sku库存管理Service实现类
 * Created by macro on 2018/4/27.
 */
@Service
@Slf4j
public class OmsPortalOfflinePayServiceImpl implements OmsPortalOfflinePayService {
    //订单相关
    @Autowired
    private OmsOrderMapper omsOrderMapper;
    @Autowired
    private OmsOrderOperateHistoryMapper orderOperateHistoryMapper;

    //支付相关
    @Autowired
    private OmsOfflinePayMtcnPicMapper offlinePayMtcnPicMapper;
    @Autowired
    private OmsOrderPayLogMapper orderPayLogMapper;

    @Override
    public int setPayType(Long orderId, Integer payType) {
        OmsOrder order = new OmsOrder();
        order.setId(orderId);
        order.setPayType(payType);
        return omsOrderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public int saveMtcn(OmsOfflinePayMtcnPicDto offlinePayMtcnPicDto) {
        //1-更新订单订单状态 为待确认到款、保存订单的线下支付凭证
        OmsOrder order = new OmsOrder();
        order.setId(offlinePayMtcnPicDto.getOrderId());
        order.setOfflinePayMtcnCode(offlinePayMtcnPicDto.getMtcnCode());
        order.setStatus(OmsOrderConst.STATUS_TOBE_PAY_CHECK_3);
        order.setLastUpdateId(AppOprRoleConst.ROLE_MEMBER);
        order.setLastUpdateTime(new Date());
        if(omsOrderMapper.updateByPrimaryKeySelective(order) < 0){
            log.error("更新订单相关信息失败{}",order);
            return -1;
        }


        //保存线下支付凭证, 并返回
        offlinePayMtcnPicDto.setLastCreateId(AppOprRoleConst.ROLE_MEMBER);
        offlinePayMtcnPicDto.setLastCreateTime(new Date());
        offlinePayMtcnPicDto.setLastUpdateId(AppOprRoleConst.ROLE_MEMBER);
        offlinePayMtcnPicDto.setLastUpdateTime(new Date());
        if(offlinePayMtcnPicMapper.insertSelective(offlinePayMtcnPicDto)<0){
            log.error("更新订单相关信息失败{}",offlinePayMtcnPicDto);
            return -1;
        }

        OmsOfflinePayMtcnPicExample example = new OmsOfflinePayMtcnPicExample();
        example.createCriteria().andMtcnCodeEqualTo(offlinePayMtcnPicDto.getMtcnCode());

        //保存订单的支付信息
        OmsOrderPayLog  orderPayLog = new OmsOrderPayLog();
        orderPayLog.setIsOfflinePay("1");
        orderPayLog.setOrderId(offlinePayMtcnPicDto.getOrderId());
        orderPayLog.setPayModeId(0L); //
        orderPayLog.setPayResultStatus("01");
        orderPayLog.setMtcnCodeId(offlinePayMtcnPicMapper.selectByExample(example).get(0).getId());
        orderPayLog.setPayResultDescription("客户提交线下支付凭证,默认支付成功");
        orderPayLog.setLastCreateId(AppOprRoleConst.ROLE_MEMBER);
        orderPayLog.setLastCreateTime(new Date());
        orderPayLog.setLastUpdateId(AppOprRoleConst.ROLE_MEMBER);
        orderPayLog.setLastUpdateTime(new Date());
        if(orderPayLogMapper.insert(orderPayLog) < 0){
            log.error("更改订单支付结果信息失败{}",orderPayLog);
            return -1;
        }

        //2-登记订单的操作日志
        //登记订单操作日志
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(offlinePayMtcnPicDto.getOrderId());
        history.setCreateTime(new Date());
        history.setOperateMan(AppOprRoleConst.ROLE_MEMBER);
        history.setOrderStatus(OmsOrderConst.STATUS_TOBE_PAY_CHECK_3);
        history.setNote("客户已付款,待业务员确认到款");
        if(orderOperateHistoryMapper.insert(history) != 1){
            log.error("登记订单操作日志失败");
            return -1;
        }

//        //保存线下支付凭证, 并返回
//        offlinePayMtcnPicDto.setLastCreateId(AppOprRoleConst.ROLE_MEMBER);
//        offlinePayMtcnPicDto.setLastCreateTime(new Date());
//        offlinePayMtcnPicDto.setLastUpdateId(AppOprRoleConst.ROLE_MEMBER);
//        offlinePayMtcnPicDto.setLastUpdateTime(new Date());
//        return offlinePayMtcnPicMapper.insertSelective(offlinePayMtcnPicDto);
        return 1;
    }

    @Override
    public OmsOfflinePayMtcnPic getMtcn(Long orderId) {
        OmsOfflinePayMtcnPicExample mtcnPicExample = new OmsOfflinePayMtcnPicExample();
        mtcnPicExample.createCriteria().andMtcnCodeEqualTo(omsOrderMapper.selectByPrimaryKey(orderId).getOfflinePayMtcnCode());
        return offlinePayMtcnPicMapper.selectByExample(mtcnPicExample).get(0);
    }
}
