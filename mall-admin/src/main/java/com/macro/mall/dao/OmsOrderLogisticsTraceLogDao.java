package com.macro.mall.dao;

import com.macro.mall.model.OmsOrderLogisticsTraceLog;
import org.apache.ibatis.annotations.Param;

/**
 * 订单自定义查询Dao
 * Created by ruiwu.xu on 2019/01/23.
 */
public interface OmsOrderLogisticsTraceLogDao {
    /**
     * 获取最近的订单跟踪日志
     */
    OmsOrderLogisticsTraceLog getLastOrderTraceLog(@Param("orderId") Long orderId);
}
