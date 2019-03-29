package com.macro.mall.service;

import com.macro.mall.model.LmsLogisticsMode;

import java.util.List;

/**
 * 物流方式Service
 * Created by ruiwu.xu on 2019/01/05.
 */
public interface LmsLogisticsModeService {

    //更新物流方式状态: 00 - 在用 01 - 弃用
    String LOGISTICS_MODE_STATUS_INUSE_00 = "00";
    String LOGISTICS_MODE_STATUS_DISUSE_01 = "01";

    /**
     * 获取物流方式(分页)
     */
    List<LmsLogisticsMode> page(String logisticsModeName, Integer pageSize, Integer pageNum);

    /**
     * 增加物流方式
     */
    int add(LmsLogisticsMode lmsLogisticsMode);

    /**
     * 更新物流方式
     */
    int update(LmsLogisticsMode lmsLogisticsMode);

    /**
     * 更新物流方式状态: 00 - 在用 01 - 弃用
     */
    int updateStatus(Long id,  String logisticsModeStatus);

    /**
     * 逻辑删除物流方式
     * @param id
     */
    int logicDelete(Long id);

    LmsLogisticsMode selectModeById(Long id);

    int delete(Long id);
}
