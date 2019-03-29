package com.macro.mall.service;

import com.macro.mall.dto.SmsMarketingActivitiesDto;
import com.macro.mall.model.SmsMarketingActivities;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 营销活动Service
 * Created by ruiwu.xu on 2019/01/05.
 */
public interface SmsMarketingActivityService {
    /**
     * 添加营销活动
     */
    int add(SmsMarketingActivities marketingActivities);

    /**
     * 添加营销活动
     */
    @Transactional
    int addV2(SmsMarketingActivitiesDto marketingActivitiesDto);

    /**
     * 修改指定营销活动
     */
    int update(Long id, SmsMarketingActivities marketingActivities);

    /**
     * 删除单个活动
     */
    int delete(Long id);

    /**
     * 修改营销活动状态(00 - 活动开始/01 - 活动结束)
     */
    int updateStatus(Long id, String activityState);

    /**
     * 获取营销活动详询信息
     */
    SmsMarketingActivities getItem(Long id);

    /**
     * 营销活动分页查询
     */
    List<SmsMarketingActivities> list(String keyword, Integer pageSize, Integer pageNum);
}
