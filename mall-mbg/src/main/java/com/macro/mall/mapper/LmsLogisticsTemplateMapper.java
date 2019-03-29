package com.macro.mall.mapper;

import com.macro.mall.model.LmsLogisticsTemplate;
import com.macro.mall.model.LmsLogisticsTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LmsLogisticsTemplateMapper {
    int countByExample(LmsLogisticsTemplateExample example);

    int deleteByExample(LmsLogisticsTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LmsLogisticsTemplate record);

    int insertSelective(LmsLogisticsTemplate record);

    List<LmsLogisticsTemplate> selectByExample(LmsLogisticsTemplateExample example);

    LmsLogisticsTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LmsLogisticsTemplate record, @Param("example") LmsLogisticsTemplateExample example);

    int updateByExample(@Param("record") LmsLogisticsTemplate record, @Param("example") LmsLogisticsTemplateExample example);

    int updateByPrimaryKeySelective(LmsLogisticsTemplate record);

    int updateByPrimaryKey(LmsLogisticsTemplate record);
}