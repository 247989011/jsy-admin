package com.macro.mall.common.mapper;

import com.macro.mall.common.model.FdfsFilenameMapper;
import com.macro.mall.common.model.FdfsFilenameMapperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FdfsFilenameMapperMapper {
    int countByExample(FdfsFilenameMapperExample example);

    int deleteByExample(FdfsFilenameMapperExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FdfsFilenameMapper record);

    int insertSelective(FdfsFilenameMapper record);

    List<FdfsFilenameMapper> selectByExample(FdfsFilenameMapperExample example);

    FdfsFilenameMapper selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FdfsFilenameMapper record, @Param("example") FdfsFilenameMapperExample example);

    int updateByExample(@Param("record") FdfsFilenameMapper record, @Param("example") FdfsFilenameMapperExample example);

    int updateByPrimaryKeySelective(FdfsFilenameMapper record);

    int updateByPrimaryKey(FdfsFilenameMapper record);
}
