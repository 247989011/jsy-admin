package com.macro.mall.service.impl;

import com.macro.mall.constant.AppOprRoleConst;
import com.macro.mall.constant.OmsOrderConst;
import com.macro.mall.domain.CommonResult;
import com.macro.mall.mapper.*;
import com.macro.mall.model.*;
import com.macro.mall.service.OmsOrderPayService;
import com.macro.mall.vo.OmsOrderPayResultInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 订单模块-订单支付Service实现类
 * Created by macro on 2018/10/11.
 */
@Service
@Slf4j
public class OmsOrderPayServiceImpl implements OmsOrderPayService {
    //订单相关
    @Autowired
    private OmsOrderMapper orderMapper;
    @Autowired
    private OmsOrderOperateHistoryMapper orderOperateHistoryMapper;

    //支付相关
    @Autowired
    private OmsOfflinePayMtcnPicMapper offlinePayMtcnPicMapper;
    @Autowired
    private OmsOrderPayLogMapper orderPayLogMapper;
    @Autowired
    private PaymsPayModeMapper payModeMapper;

    //物流相关
    @Autowired
    private  OmsOrderLogisticsDeliveryStaffMapper orderLogisticsDeliveryStaffMapper;


    @Override
    public CommonResult confirmPayment(Long orderId) {
        //1-登记订单已到款
        OmsOrder order = new OmsOrder();
        order.setId(orderId);
        order.setLastUpdateTime(new Date());
        order.setLastUpdateId(AppOprRoleConst.ROLE_ADMIN);
        order.setStatus(OmsOrderConst.STATUS_TOTAKE_PICTURES_4);
        if(orderMapper.updateByPrimaryKeySelective(order) < 0){
            log.error("更新订单的状态信息失败{}", order);
            return new CommonResult().failed(11000,"确认到账失败");
        }

        //2-登记订单的操作日志
        //登记订单操作日志
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(orderId);
        history.setCreateTime(new Date());
        history.setOperateMan(AppOprRoleConst.ROLE_MEMBER);
        history.setOrderStatus(OmsOrderConst.STATUS_TOTAKE_PICTURES_4);
        history.setNote("订单的款项已收到, 待发货员拍照");
        if(orderOperateHistoryMapper.insert(history) != 1){
            log.error("登记订单操作日志失败");
            return new CommonResult().failed(11001,"登记订单操作日志失败");
        }
        return new CommonResult().success(1);
    }

    @Override
    public int confirmPayment(OmsOrderLogisticsDeliveryStaff orderLogisticsDeliveryStaff) {
        //1-登记订单已到款
        OmsOrder order = new OmsOrder();
        order.setId(orderLogisticsDeliveryStaff.getOrderId());
        order.setLastUpdateTime(new Date());
        order.setLastUpdateId(AppOprRoleConst.ROLE_ADMIN);
        order.setStatus(OmsOrderConst.STATUS_TOTAKE_PICTURES_4);
        if(orderMapper.updateByPrimaryKeySelective(order) < 0){
            log.error("更新订单的状态信息失败{}", order);
            return -1;
        }

        //登记订单的物流发货员信息
        orderLogisticsDeliveryStaff.setLastCreateId(AppOprRoleConst.ROLE_ADMIN);
        orderLogisticsDeliveryStaff.setLastCreateTime(new Date());
        orderLogisticsDeliveryStaff.setLastUpdateId(AppOprRoleConst.ROLE_ADMIN);
        orderLogisticsDeliveryStaff.setLastUpdateTime(new Date());
        if(orderLogisticsDeliveryStaffMapper.insertSelective(orderLogisticsDeliveryStaff) <0){
            log.error("登记订单的物流发货员信息失败{}", orderLogisticsDeliveryStaff);
            return -1;
        }

        //3-登记订单的操作日志
        //登记订单操作日志
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(orderLogisticsDeliveryStaff.getOrderId());
        history.setCreateTime(new Date());
        history.setOperateMan(AppOprRoleConst.ROLE_MEMBER);
        history.setOrderStatus(OmsOrderConst.STATUS_TOTAKE_PICTURES_4);
        history.setNote("订单的款项已收到, 待发货员拍照");
        if(orderOperateHistoryMapper.insert(history) != 1){
            log.error("登记订单操作日志失败");
            return -1;
        }

        return 1;
    }

    @Override
    public OmsOrderPayResultInfoVo getPayResult(Long orderId) {
        //定义返回变量
        OmsOrderPayResultInfoVo orderPayResultInfoVo = new OmsOrderPayResultInfoVo();

        //根据订单ID号,获取订单的支付信息
        OmsOrderPayLogExample payLogExample = new OmsOrderPayLogExample();
        payLogExample.createCriteria().andOrderIdEqualTo(orderId);
        List<OmsOrderPayLog> orderPayLogList = orderPayLogMapper.selectByExample(payLogExample);
        if(orderPayLogList == null  || orderPayLogList.isEmpty()){
            log.warn("未找到该订单的相关支付信息{}", orderId);
            return null;
        }
        BeanUtils.copyProperties(orderPayLogList.get(0), orderPayResultInfoVo);

        //判断是否是线下支付,若是线下支付，则查询线下支付信息
        if("1".equals(orderPayLogList.get(0).getIsOfflinePay()) ){
            OmsOfflinePayMtcnPicExample offlinePayMtcnPicExample = new OmsOfflinePayMtcnPicExample();
            offlinePayMtcnPicExample.createCriteria().andIdEqualTo(orderPayLogList.get(0).getMtcnCodeId());
            List<OmsOfflinePayMtcnPic> offlinePayPicList = offlinePayMtcnPicMapper.selectByExample(offlinePayMtcnPicExample);
            if(offlinePayPicList == null || offlinePayPicList.isEmpty()){
                log.warn("位找到线下支付信息{}", orderId);
                return null;
            }
            orderPayResultInfoVo.setOfflinePayMtcnPic(offlinePayPicList.get(0));
        }

        //查询订单的支付方式
        PaymsPayModeExample payModeExample = new PaymsPayModeExample();
        payModeExample.createCriteria().andIdEqualTo(orderPayLogList.get(0).getPayModeId());
        List<PaymsPayMode>  payModeList = payModeMapper.selectByExample(payModeExample);
        if(payModeList == null || payModeList.isEmpty()){
            log.warn("支付方式为定义{}", orderPayLogList.get(0).getPayModeId());
            //return null;
        }else{
            orderPayResultInfoVo.setPayMode(payModeList.get(0));
        }
        return orderPayResultInfoVo;
    }
}
