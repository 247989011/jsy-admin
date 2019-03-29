package com.macro.mall.mapper;

import com.macro.mall.model.UmsMemberTags;
import com.macro.mall.model.UmsMemberTagsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsMemberTagsMapper {
    int countByExample(UmsMemberTagsExample example);

    int deleteByExample(UmsMemberTagsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberTags record);

    int insertSelective(UmsMemberTags record);

    List<UmsMemberTags> selectByExample(UmsMemberTagsExample example);

    UmsMemberTags selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsMemberTags record, @Param("example") UmsMemberTagsExample example);

    int updateByExample(@Param("record") UmsMemberTags record, @Param("example") UmsMemberTagsExample example);

    int updateByPrimaryKeySelective(UmsMemberTags record);

    int updateByPrimaryKey(UmsMemberTags record);
}