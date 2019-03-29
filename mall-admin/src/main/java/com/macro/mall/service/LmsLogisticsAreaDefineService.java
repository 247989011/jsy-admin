package com.macro.mall.service;

import com.macro.mall.model.LmsLogisticsAreaDefine;

import java.util.List;

/**
 * 物流地区Service
 * Created by ruiwu.xu on 2019/01/05.
 */
public interface LmsLogisticsAreaDefineService {
    /**
     * 查询物流地区
     */
    List<LmsLogisticsAreaDefine> list(String keyName, Integer pageSize, Integer pageNum);

    /**
     * 增加物流地区
     */
    int add(LmsLogisticsAreaDefine lmsLogisticsAreaDefine);

    /**
     * 更新物流地区
     */
    int update(LmsLogisticsAreaDefine lmsLogisticsAreaDefine);

    /**
     * 删除物流地区
     */
    int delete(Long id);

    LmsLogisticsAreaDefine getItem(Long id);
}
