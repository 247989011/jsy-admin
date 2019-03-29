package com.macro.mall.dao;

import com.macro.mall.model.UmsMemberTags;
import com.macro.mall.model.UmsTags;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 会员与标签管理自定义Dao
 */
public interface UmsMemberTagsRelationDao {
    /**
     * 批量插入会员标签关系
     */
    int insertList(@Param("list") List<UmsMemberTags> memberTagsRelationList);

    /**
     * 获取会员所有标签
     */
    List<UmsTags> getTagsList(@Param("memberId") Long memberId);


}
