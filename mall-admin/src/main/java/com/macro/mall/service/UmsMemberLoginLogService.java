package com.macro.mall.service;

import com.macro.mall.dto.UmsMemberLoginLogDto;

import java.util.List;

/**
 * 会员登录日志Service
 * Created by macro on 2018/4/26.
 */
public interface UmsMemberLoginLogService {
    /**
     * 分页查询会员登录日志
     */
    List<UmsMemberLoginLogDto> page(String keyword, Integer pageSize, Integer pageNum);

}
