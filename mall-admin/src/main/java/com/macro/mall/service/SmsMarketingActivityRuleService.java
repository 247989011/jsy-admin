package com.macro.mall.service;

import com.macro.mall.model.SmsMarketingActivityRule;

/**
 * 营销活动规则Service
 * Created by ruiwu.xu on 2019/01/05.
 */
public interface SmsMarketingActivityRuleService {
    /**
     * 添加营销活动的活动规则
     */
    int create(SmsMarketingActivityRule marketingActivityRule);

    /**
     * 修改指定营销活动的活动规则
     */
    int update(Long id, SmsMarketingActivityRule marketingActivityRule);

    /**
     * 删除营销活动规则
     */
    int delete(Long id);


    /**
     * 获取营销活动的活动规则的详细信息
     */
    SmsMarketingActivityRule getItem(Long id);
}
