package com.macro.mall.mapper;

import com.macro.mall.model.OmsOrderLogisticsTraceLog;
import com.macro.mall.model.OmsOrderLogisticsTraceLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsOrderLogisticsTraceLogMapper {
    int countByExample(OmsOrderLogisticsTraceLogExample example);

    int deleteByExample(OmsOrderLogisticsTraceLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmsOrderLogisticsTraceLog record);

    int insertSelective(OmsOrderLogisticsTraceLog record);

    List<OmsOrderLogisticsTraceLog> selectByExampleWithBLOBs(OmsOrderLogisticsTraceLogExample example);

    List<OmsOrderLogisticsTraceLog> selectByExample(OmsOrderLogisticsTraceLogExample example);

    OmsOrderLogisticsTraceLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OmsOrderLogisticsTraceLog record, @Param("example") OmsOrderLogisticsTraceLogExample example);

    int updateByExampleWithBLOBs(@Param("record") OmsOrderLogisticsTraceLog record, @Param("example") OmsOrderLogisticsTraceLogExample example);

    int updateByExample(@Param("record") OmsOrderLogisticsTraceLog record, @Param("example") OmsOrderLogisticsTraceLogExample example);

    int updateByPrimaryKeySelective(OmsOrderLogisticsTraceLog record);

    int updateByPrimaryKeyWithBLOBs(OmsOrderLogisticsTraceLog record);

    int updateByPrimaryKey(OmsOrderLogisticsTraceLog record);
}