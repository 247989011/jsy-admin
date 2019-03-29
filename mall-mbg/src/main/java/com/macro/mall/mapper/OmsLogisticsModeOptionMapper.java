package com.macro.mall.mapper;

import com.macro.mall.model.OmsLogisticsModeOption;
import com.macro.mall.model.OmsLogisticsModeOptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsLogisticsModeOptionMapper {
    int countByExample(OmsLogisticsModeOptionExample example);

    int deleteByExample(OmsLogisticsModeOptionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmsLogisticsModeOption record);

    int insertSelective(OmsLogisticsModeOption record);

    List<OmsLogisticsModeOption> selectByExample(OmsLogisticsModeOptionExample example);

    OmsLogisticsModeOption selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OmsLogisticsModeOption record, @Param("example") OmsLogisticsModeOptionExample example);

    int updateByExample(@Param("record") OmsLogisticsModeOption record, @Param("example") OmsLogisticsModeOptionExample example);

    int updateByPrimaryKeySelective(OmsLogisticsModeOption record);

    int updateByPrimaryKey(OmsLogisticsModeOption record);
}