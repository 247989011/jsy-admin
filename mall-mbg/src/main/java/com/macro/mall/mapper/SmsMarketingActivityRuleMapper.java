package com.macro.mall.mapper;

import com.macro.mall.model.SmsMarketingActivityRule;
import com.macro.mall.model.SmsMarketingActivityRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsMarketingActivityRuleMapper {
    int countByExample(SmsMarketingActivityRuleExample example);

    int deleteByExample(SmsMarketingActivityRuleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsMarketingActivityRule record);

    int insertSelective(SmsMarketingActivityRule record);

    List<SmsMarketingActivityRule> selectByExample(SmsMarketingActivityRuleExample example);

    SmsMarketingActivityRule selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsMarketingActivityRule record, @Param("example") SmsMarketingActivityRuleExample example);

    int updateByExample(@Param("record") SmsMarketingActivityRule record, @Param("example") SmsMarketingActivityRuleExample example);

    int updateByPrimaryKeySelective(SmsMarketingActivityRule record);

    int updateByPrimaryKey(SmsMarketingActivityRule record);
}