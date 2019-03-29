package com.macro.mall.portal.service;

import com.macro.mall.portal.dto.OmsOrderLogisticsPicDto;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单模块-订单物流Service
 * Created by macro on 2018/8/30.
 */
public interface OmsPortalOrderLogisticsService {
    /**
     *
     * @param orderLogisticsPicDto
     * @return
     */
    @Transactional
    int saveLogisticsPic(OmsOrderLogisticsPicDto orderLogisticsPicDto);
}
