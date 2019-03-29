package com.macro.mall.mapper;

import com.macro.mall.model.LmsLogisticsCharge;
import com.macro.mall.model.LmsLogisticsChargeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LmsLogisticsChargeMapper {
    int countByExample(LmsLogisticsChargeExample example);

    int deleteByExample(LmsLogisticsChargeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LmsLogisticsCharge record);

    int insertSelective(LmsLogisticsCharge record);

    List<LmsLogisticsCharge> selectByExample(LmsLogisticsChargeExample example);

    LmsLogisticsCharge selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LmsLogisticsCharge record, @Param("example") LmsLogisticsChargeExample example);

    int updateByExample(@Param("record") LmsLogisticsCharge record, @Param("example") LmsLogisticsChargeExample example);

    int updateByPrimaryKeySelective(LmsLogisticsCharge record);

    int updateByPrimaryKey(LmsLogisticsCharge record);
}