package com.macro.mall.mapper;

import com.macro.mall.model.SmsMarketingActivities;
import com.macro.mall.model.SmsMarketingActivitiesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsMarketingActivitiesMapper {
    int countByExample(SmsMarketingActivitiesExample example);

    int deleteByExample(SmsMarketingActivitiesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsMarketingActivities record);

    int insertSelective(SmsMarketingActivities record);

    List<SmsMarketingActivities> selectByExample(SmsMarketingActivitiesExample example);

    SmsMarketingActivities selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsMarketingActivities record, @Param("example") SmsMarketingActivitiesExample example);

    int updateByExample(@Param("record") SmsMarketingActivities record, @Param("example") SmsMarketingActivitiesExample example);

    int updateByPrimaryKeySelective(SmsMarketingActivities record);

    int updateByPrimaryKey(SmsMarketingActivities record);
}