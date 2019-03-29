package com.macro.mall.mapper;

import com.macro.mall.model.OmsPayModeOption;
import com.macro.mall.model.OmsPayModeOptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsPayModeOptionMapper {
    int countByExample(OmsPayModeOptionExample example);

    int deleteByExample(OmsPayModeOptionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmsPayModeOption record);

    int insertSelective(OmsPayModeOption record);

    List<OmsPayModeOption> selectByExample(OmsPayModeOptionExample example);

    OmsPayModeOption selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OmsPayModeOption record, @Param("example") OmsPayModeOptionExample example);

    int updateByExample(@Param("record") OmsPayModeOption record, @Param("example") OmsPayModeOptionExample example);

    int updateByPrimaryKeySelective(OmsPayModeOption record);

    int updateByPrimaryKey(OmsPayModeOption record);
}