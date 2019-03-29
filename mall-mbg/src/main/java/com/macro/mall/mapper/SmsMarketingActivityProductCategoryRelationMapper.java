package com.macro.mall.mapper;

import com.macro.mall.model.SmsMarketingActivityProductCategoryRelation;
import com.macro.mall.model.SmsMarketingActivityProductCategoryRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsMarketingActivityProductCategoryRelationMapper {
    int countByExample(SmsMarketingActivityProductCategoryRelationExample example);

    int deleteByExample(SmsMarketingActivityProductCategoryRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsMarketingActivityProductCategoryRelation record);

    int insertSelective(SmsMarketingActivityProductCategoryRelation record);

    List<SmsMarketingActivityProductCategoryRelation> selectByExample(SmsMarketingActivityProductCategoryRelationExample example);

    SmsMarketingActivityProductCategoryRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsMarketingActivityProductCategoryRelation record, @Param("example") SmsMarketingActivityProductCategoryRelationExample example);

    int updateByExample(@Param("record") SmsMarketingActivityProductCategoryRelation record, @Param("example") SmsMarketingActivityProductCategoryRelationExample example);

    int updateByPrimaryKeySelective(SmsMarketingActivityProductCategoryRelation record);

    int updateByPrimaryKey(SmsMarketingActivityProductCategoryRelation record);
}