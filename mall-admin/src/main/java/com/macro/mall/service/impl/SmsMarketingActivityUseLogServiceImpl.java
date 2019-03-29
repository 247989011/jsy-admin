package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.mapper.SmsMarketingActivityUseLogMapper;
import com.macro.mall.model.SmsMarketingActivityUseLog;
import com.macro.mall.model.SmsMarketingActivityUseLogExample;
import com.macro.mall.service.SmsMarketingActivityUseLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 营销活动Service实现类
 * Created by macro on 2018/11/16.
 */
@Service
public class SmsMarketingActivityUseLogServiceImpl implements SmsMarketingActivityUseLogService {

    @Autowired
    private SmsMarketingActivityUseLogMapper smsMarketingActivityUseLogMapper;

    /**
     * 添加营销活动的使用日志
     *
     * @param smsMarketingActivityUseLog
     */
    @Override
    public int add(SmsMarketingActivityUseLog smsMarketingActivityUseLog) {
        return smsMarketingActivityUseLogMapper.insert(smsMarketingActivityUseLog);
    }

    /**
     * 分页查询活动
     *
     * @param keyword
     * @param pageSize
     * @param pageNum
     */
    @Override
    public List<SmsMarketingActivityUseLog> page(String keyword, Integer pageSize, Integer pageNum) {
        //设置分页查询
        PageHelper.startPage(pageNum, pageSize);
        //处理查询关键字
        StringBuffer keywordHandle = new StringBuffer();
        keywordHandle.append("%").append(keyword).append("%");
        //设置查询条件
        SmsMarketingActivityUseLogExample example = new SmsMarketingActivityUseLogExample();
        SmsMarketingActivityUseLogExample.Criteria criteria1  = example.createCriteria();
        SmsMarketingActivityUseLogExample.Criteria criteria2  = example.createCriteria();
        criteria1.andActivityNameLike(keywordHandle.toString());
        example.or(criteria2.andMemberNameLike(keywordHandle.toString()));
        return smsMarketingActivityUseLogMapper.selectByExample(example);
    }
}
