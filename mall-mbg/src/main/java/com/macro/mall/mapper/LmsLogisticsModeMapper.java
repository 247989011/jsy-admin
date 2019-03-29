package com.macro.mall.mapper;

import com.macro.mall.model.LmsLogisticsMode;
import com.macro.mall.model.LmsLogisticsModeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LmsLogisticsModeMapper {
    int countByExample(LmsLogisticsModeExample example);

    int deleteByExample(LmsLogisticsModeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LmsLogisticsMode record);

    int insertSelective(LmsLogisticsMode record);

    List<LmsLogisticsMode> selectByExample(LmsLogisticsModeExample example);

    LmsLogisticsMode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LmsLogisticsMode record, @Param("example") LmsLogisticsModeExample example);

    int updateByExample(@Param("record") LmsLogisticsMode record, @Param("example") LmsLogisticsModeExample example);

    int updateByPrimaryKeySelective(LmsLogisticsMode record);

    int updateByPrimaryKey(LmsLogisticsMode record);
}