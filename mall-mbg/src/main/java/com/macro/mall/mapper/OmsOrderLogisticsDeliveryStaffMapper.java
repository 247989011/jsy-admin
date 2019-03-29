package com.macro.mall.mapper;

import com.macro.mall.model.OmsOrderLogisticsDeliveryStaff;
import com.macro.mall.model.OmsOrderLogisticsDeliveryStaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsOrderLogisticsDeliveryStaffMapper {
    int countByExample(OmsOrderLogisticsDeliveryStaffExample example);

    int deleteByExample(OmsOrderLogisticsDeliveryStaffExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmsOrderLogisticsDeliveryStaff record);

    int insertSelective(OmsOrderLogisticsDeliveryStaff record);

    List<OmsOrderLogisticsDeliveryStaff> selectByExample(OmsOrderLogisticsDeliveryStaffExample example);

    OmsOrderLogisticsDeliveryStaff selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OmsOrderLogisticsDeliveryStaff record, @Param("example") OmsOrderLogisticsDeliveryStaffExample example);

    int updateByExample(@Param("record") OmsOrderLogisticsDeliveryStaff record, @Param("example") OmsOrderLogisticsDeliveryStaffExample example);

    int updateByPrimaryKeySelective(OmsOrderLogisticsDeliveryStaff record);

    int updateByPrimaryKey(OmsOrderLogisticsDeliveryStaff record);
}