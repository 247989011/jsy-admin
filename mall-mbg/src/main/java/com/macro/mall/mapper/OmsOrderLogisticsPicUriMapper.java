package com.macro.mall.mapper;

import com.macro.mall.model.OmsOrderLogisticsPicUri;
import com.macro.mall.model.OmsOrderLogisticsPicUriExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsOrderLogisticsPicUriMapper {
    int countByExample(OmsOrderLogisticsPicUriExample example);

    int deleteByExample(OmsOrderLogisticsPicUriExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmsOrderLogisticsPicUri record);

    int insertSelective(OmsOrderLogisticsPicUri record);

    List<OmsOrderLogisticsPicUri> selectByExample(OmsOrderLogisticsPicUriExample example);

    OmsOrderLogisticsPicUri selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OmsOrderLogisticsPicUri record, @Param("example") OmsOrderLogisticsPicUriExample example);

    int updateByExample(@Param("record") OmsOrderLogisticsPicUri record, @Param("example") OmsOrderLogisticsPicUriExample example);

    int updateByPrimaryKeySelective(OmsOrderLogisticsPicUri record);

    int updateByPrimaryKey(OmsOrderLogisticsPicUri record);
}