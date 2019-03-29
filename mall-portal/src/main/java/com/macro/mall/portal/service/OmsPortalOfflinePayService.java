package com.macro.mall.portal.service;

import com.macro.mall.model.OmsOfflinePayMtcnPic;
import com.macro.mall.portal.dto.OmsOfflinePayMtcnPicDto;
import org.springframework.transaction.annotation.Transactional;

/**
 * 线下支付管理Service
 * Created by ruiwu.xu on 2019/02/24.
 */
public interface OmsPortalOfflinePayService {
    /**
     * 设置订单的支付类型 0 -线上支付 1-线下支付
     * @param orderId
     * @param payType
     * @return
     */
    int setPayType(Long orderId, Integer payType);

    /**
     * 1、保存线下支付凭证 及 保存订单的支付信息
     * 2、更改订单状态为 待确认到款
     * 3、登记订单的操作日志
     * @param offlinePayMtcnPicDto
     * @return
     */
    @Transactional
    int  saveMtcn(OmsOfflinePayMtcnPicDto offlinePayMtcnPicDto);

    /**
     * 获取线下支付凭证
     * @param orderId
     * @return
     */
    OmsOfflinePayMtcnPic  getMtcn(Long orderId);
}
