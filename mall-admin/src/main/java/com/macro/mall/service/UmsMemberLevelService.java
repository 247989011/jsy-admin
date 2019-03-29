package com.macro.mall.service;

import com.macro.mall.model.UmsMemberLevel;

import java.util.List;

/**
 * 会员等级管理Service
 * Created by macro on 2018/4/26.
 */
public interface UmsMemberLevelService {
    /**
     * 获取所有会员登录
     * @param defaultStatus 是否为默认会员
     */
    List<UmsMemberLevel> list(Integer defaultStatus);

    List<UmsMemberLevel> page(String name, Integer pageSize, Integer pageNum);

    List<UmsMemberLevel> listAll();

    UmsMemberLevel selectMemberLevelById(Long id);

    Boolean update(Long id, UmsMemberLevel memberLevel);

    int delete(Long id);

    int create(UmsMemberLevel memberLevel);

}
