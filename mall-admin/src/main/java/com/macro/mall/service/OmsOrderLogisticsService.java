package com.macro.mall.service;

import com.macro.mall.model.UmsMember;

import java.util.List;

/**
 * 订单管理Service
 * Created by macro on 2018/10/11.
 */
public interface OmsOrderLogisticsService {

    /**
     * 查询系统物流发货员信息
     * @return
     */
    List<UmsMember> listDeliveryStaff();
}
