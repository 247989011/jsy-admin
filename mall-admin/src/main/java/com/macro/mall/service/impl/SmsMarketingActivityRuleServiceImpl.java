package com.macro.mall.service.impl;

import com.macro.mall.mapper.SmsMarketingActivityRuleMapper;
import com.macro.mall.model.SmsMarketingActivityRule;
import com.macro.mall.service.SmsMarketingActivityRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 营销活动规则Service实现类
 * Created by ruiwu.xu on 2019/01/05.
 */
@Service
public class SmsMarketingActivityRuleServiceImpl implements SmsMarketingActivityRuleService {
    @Autowired
    private SmsMarketingActivityRuleMapper smsMarketingActivityRuleMapper;

    /**
     * 添加营销活动的活动规则
     *
     * @param marketingActivityRule
     */
    @Override
    public int create(SmsMarketingActivityRule marketingActivityRule) {
        return smsMarketingActivityRuleMapper.insert(marketingActivityRule);
    }

    /**
     * 修改指定营销活动的活动规则
     *
     * @param id
     * @param marketingActivityRule
     */
    @Override
    public int update(Long id, SmsMarketingActivityRule marketingActivityRule) {
        return smsMarketingActivityRuleMapper.updateByPrimaryKey(marketingActivityRule);
    }

    /**
     * 删除营销活动规则
     *
     * @param id
     */
    @Override
    public int delete(Long id) {
        return smsMarketingActivityRuleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 获取营销活动的活动规则的详细信息
     *
     * @param id
     */
    @Override
    public SmsMarketingActivityRule getItem(Long id) {
        return smsMarketingActivityRuleMapper.selectByPrimaryKey(id);
    }
}
