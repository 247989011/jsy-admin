package com.macro.mall.mapper;

import com.macro.mall.model.SmsMarketingActivityUseLog;
import com.macro.mall.model.SmsMarketingActivityUseLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsMarketingActivityUseLogMapper {
    int countByExample(SmsMarketingActivityUseLogExample example);

    int deleteByExample(SmsMarketingActivityUseLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsMarketingActivityUseLog record);

    int insertSelective(SmsMarketingActivityUseLog record);

    List<SmsMarketingActivityUseLog> selectByExample(SmsMarketingActivityUseLogExample example);

    SmsMarketingActivityUseLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsMarketingActivityUseLog record, @Param("example") SmsMarketingActivityUseLogExample example);

    int updateByExample(@Param("record") SmsMarketingActivityUseLog record, @Param("example") SmsMarketingActivityUseLogExample example);

    int updateByPrimaryKeySelective(SmsMarketingActivityUseLog record);

    int updateByPrimaryKey(SmsMarketingActivityUseLog record);
}