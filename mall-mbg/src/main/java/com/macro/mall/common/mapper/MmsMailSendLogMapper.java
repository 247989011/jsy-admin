package com.macro.mall.common.mapper;

import com.macro.mall.common.model.MmsMailSendLog;
import com.macro.mall.common.model.MmsMailSendLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MmsMailSendLogMapper {
    int countByExample(MmsMailSendLogExample example);

    int deleteByExample(MmsMailSendLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MmsMailSendLog record);

    int insertSelective(MmsMailSendLog record);

    List<MmsMailSendLog> selectByExampleWithBLOBs(MmsMailSendLogExample example);

    List<MmsMailSendLog> selectByExample(MmsMailSendLogExample example);

    MmsMailSendLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MmsMailSendLog record, @Param("example") MmsMailSendLogExample example);

    int updateByExampleWithBLOBs(@Param("record") MmsMailSendLog record, @Param("example") MmsMailSendLogExample example);

    int updateByExample(@Param("record") MmsMailSendLog record, @Param("example") MmsMailSendLogExample example);

    int updateByPrimaryKeySelective(MmsMailSendLog record);

    int updateByPrimaryKeyWithBLOBs(MmsMailSendLog record);

    int updateByPrimaryKey(MmsMailSendLog record);
}
