package com.macro.mall.mapper;

import com.macro.mall.model.UmsTags;
import com.macro.mall.model.UmsTagsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsTagsMapper {
    int countByExample(UmsTagsExample example);

    int deleteByExample(UmsTagsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsTags record);

    int insertSelective(UmsTags record);

    List<UmsTags> selectByExample(UmsTagsExample example);

    UmsTags selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsTags record, @Param("example") UmsTagsExample example);

    int updateByExample(@Param("record") UmsTags record, @Param("example") UmsTagsExample example);

    int updateByPrimaryKeySelective(UmsTags record);

    int updateByPrimaryKey(UmsTags record);
}