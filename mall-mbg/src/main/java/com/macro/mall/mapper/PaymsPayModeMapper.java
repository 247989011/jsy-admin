package com.macro.mall.mapper;

import com.macro.mall.model.PaymsPayMode;
import com.macro.mall.model.PaymsPayModeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaymsPayModeMapper {
    int countByExample(PaymsPayModeExample example);

    int deleteByExample(PaymsPayModeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PaymsPayMode record);

    int insertSelective(PaymsPayMode record);

    List<PaymsPayMode> selectByExample(PaymsPayModeExample example);

    PaymsPayMode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PaymsPayMode record, @Param("example") PaymsPayModeExample example);

    int updateByExample(@Param("record") PaymsPayMode record, @Param("example") PaymsPayModeExample example);

    int updateByPrimaryKeySelective(PaymsPayMode record);

    int updateByPrimaryKey(PaymsPayMode record);
}