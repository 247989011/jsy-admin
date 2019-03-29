package com.macro.mall.service;

import com.macro.mall.dto.UmsMemberTraceLogsDto;
import com.macro.mall.model.UmsMemberTraceLogs;

import java.util.List;

/**
 * 会员跟踪日志Service
 * Created by macro on 2018/4/26.
 */
public interface UmsMemberLogsService {
    /**
     * 增加会员跟踪日志(多条)
     * */
    int add(Long memberId, List<UmsMemberTraceLogs> listMemberTraceLogs);

    /**
     * 增加会员跟踪日志(单条)
     * */
    int add(Long memberId, UmsMemberTraceLogs memberTraceLogs);

    /**
     * 删除会员跟踪日志
     * */
    int delete(List<Long> traceLogsIdList);


    /**
     * 更新会员跟踪日志
     * */
    int update(Long memberId, List<UmsMemberTraceLogs> listMemberTraceLogs);

    /**
     * 根据id 获取客户日志信息
     * @param id
     * @return
     */
    UmsMemberTraceLogsDto get(Long id);

    /**
     * 获取所有会员跟踪日志(by memberId)
     */
    List<UmsMemberTraceLogsDto> page(Long memberId, Integer pageSize,Integer pageNum);

    /**
     * 获取所有会员跟踪日志(by keyword)
     */
    List<UmsMemberTraceLogsDto> page(String keyword, Integer pageSize, Integer pageNum);

}
