package com.macro.mall.mapper;

import com.macro.mall.model.SmsMarketingActivityProductRelation;
import com.macro.mall.model.SmsMarketingActivityProductRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsMarketingActivityProductRelationMapper {
    int countByExample(SmsMarketingActivityProductRelationExample example);

    int deleteByExample(SmsMarketingActivityProductRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsMarketingActivityProductRelation record);

    int insertSelective(SmsMarketingActivityProductRelation record);

    List<SmsMarketingActivityProductRelation> selectByExample(SmsMarketingActivityProductRelationExample example);

    SmsMarketingActivityProductRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsMarketingActivityProductRelation record, @Param("example") SmsMarketingActivityProductRelationExample example);

    int updateByExample(@Param("record") SmsMarketingActivityProductRelation record, @Param("example") SmsMarketingActivityProductRelationExample example);

    int updateByPrimaryKeySelective(SmsMarketingActivityProductRelation record);

    int updateByPrimaryKey(SmsMarketingActivityProductRelation record);
}