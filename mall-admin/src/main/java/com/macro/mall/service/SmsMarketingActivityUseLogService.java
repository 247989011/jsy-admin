package com.macro.mall.service;

import com.macro.mall.model.SmsMarketingActivityUseLog;

import java.util.List;

/**
 * 营销活动使用日志Service
 * Created by ruiwu.xu on 2019/01/05.
 */
public interface SmsMarketingActivityUseLogService {
    /**
     * 添加营销活动使用日志
     */
    int add(SmsMarketingActivityUseLog smsMarketingActivityUseLog);

    /**
     * 营销活动使用日志分页查询
     */
    List<SmsMarketingActivityUseLog> page(String keyword, Integer pageSize, Integer pageNum);
}
