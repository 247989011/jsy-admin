package com.macro.mall.service;

import com.macro.mall.dto.UmsMemberTagsDTO;
import com.macro.mall.model.UmsMemberTags;
import com.macro.mall.model.UmsTags;

import java.util.List;

/**
 * 会员标签库管理Service
 * Created by ruiwu.xu on 2018/01/02.
 */
public interface UmsTagsService {
    /**
     * 添加标签库的分类标签
     * @param umsTags 会员分类标签信息
     */
    int add(UmsTags umsTags);

    /**
     * 修改标签库的分类标签
     * @param id 分类标签ID
     * @param umsTags 分类标签信息
     */
    int update(Long id, UmsTags umsTags);

    /**
     * 删除标签库的分类标签
     * @param id 分类标签ID
     */
    int delete(Long id);

    /**
     * 获取标签库的分类标签列表（所有）
     */
    List<UmsTags> list();

    /**
     * 根据ID获取标签信息
     */
    UmsTags selectById(long id);


    /**
     * 获取标签库的分类标签列表(分页查询)
     */
    List<UmsTags> page(String tagName, Integer pageNum, Integer pageSize);


    //TODO 上面标签库,下面与会员相关

    /**
     * 增加会员的分类标签列表(批量)
     * @param listMemberTags  会员分类标签列表
     * */
    int addMemberTagsList(Long memberId, List<UmsMemberTags> listMemberTags);

    /**
     * 删除会员的分类标签列表(批量)
     * @param memberId  会员ID
     * @param tagIds   标签ID列表e
     * */
    int deleteMemberTagsList(Long memberId, List<Long> tagIds);

    /**
     * 获取会员的分类标签信息
     */
    UmsMemberTagsDTO listMemberTags(Long memberId);


}
