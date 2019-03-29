package com.macro.mall.mapper;

import com.macro.mall.model.LmsLogisticsAreaDefine;
import com.macro.mall.model.LmsLogisticsAreaDefineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LmsLogisticsAreaDefineMapper {
    int countByExample(LmsLogisticsAreaDefineExample example);

    int deleteByExample(LmsLogisticsAreaDefineExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LmsLogisticsAreaDefine record);

    int insertSelective(LmsLogisticsAreaDefine record);

    List<LmsLogisticsAreaDefine> selectByExample(LmsLogisticsAreaDefineExample example);

    LmsLogisticsAreaDefine selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LmsLogisticsAreaDefine record, @Param("example") LmsLogisticsAreaDefineExample example);

    int updateByExample(@Param("record") LmsLogisticsAreaDefine record, @Param("example") LmsLogisticsAreaDefineExample example);

    int updateByPrimaryKeySelective(LmsLogisticsAreaDefine record);

    int updateByPrimaryKey(LmsLogisticsAreaDefine record);
}