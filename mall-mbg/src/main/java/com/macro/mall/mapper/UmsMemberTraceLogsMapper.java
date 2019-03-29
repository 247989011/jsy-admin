package com.macro.mall.mapper;

import com.macro.mall.model.UmsMemberTraceLogs;
import com.macro.mall.model.UmsMemberTraceLogsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsMemberTraceLogsMapper {
    int countByExample(UmsMemberTraceLogsExample example);

    int deleteByExample(UmsMemberTraceLogsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberTraceLogs record);

    int insertSelective(UmsMemberTraceLogs record);

    List<UmsMemberTraceLogs> selectByExampleWithBLOBs(UmsMemberTraceLogsExample example);

    List<UmsMemberTraceLogs> selectByExample(UmsMemberTraceLogsExample example);

    UmsMemberTraceLogs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsMemberTraceLogs record, @Param("example") UmsMemberTraceLogsExample example);

    int updateByExampleWithBLOBs(@Param("record") UmsMemberTraceLogs record, @Param("example") UmsMemberTraceLogsExample example);

    int updateByExample(@Param("record") UmsMemberTraceLogs record, @Param("example") UmsMemberTraceLogsExample example);

    int updateByPrimaryKeySelective(UmsMemberTraceLogs record);

    int updateByPrimaryKeyWithBLOBs(UmsMemberTraceLogs record);

    int updateByPrimaryKey(UmsMemberTraceLogs record);
}