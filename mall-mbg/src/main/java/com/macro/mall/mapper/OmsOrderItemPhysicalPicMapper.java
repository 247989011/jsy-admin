package com.macro.mall.mapper;

import com.macro.mall.model.OmsOrderItemPhysicalPic;
import com.macro.mall.model.OmsOrderItemPhysicalPicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsOrderItemPhysicalPicMapper {
    int countByExample(OmsOrderItemPhysicalPicExample example);

    int deleteByExample(OmsOrderItemPhysicalPicExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmsOrderItemPhysicalPic record);

    int insertSelective(OmsOrderItemPhysicalPic record);

    List<OmsOrderItemPhysicalPic> selectByExample(OmsOrderItemPhysicalPicExample example);

    OmsOrderItemPhysicalPic selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OmsOrderItemPhysicalPic record, @Param("example") OmsOrderItemPhysicalPicExample example);

    int updateByExample(@Param("record") OmsOrderItemPhysicalPic record, @Param("example") OmsOrderItemPhysicalPicExample example);

    int updateByPrimaryKeySelective(OmsOrderItemPhysicalPic record);

    int updateByPrimaryKey(OmsOrderItemPhysicalPic record);
}