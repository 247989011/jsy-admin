package com.macro.mall.service;

import com.macro.mall.dto.LmsLogisticsQueryParamDto;
import com.macro.mall.model.LmsLogisticsCharge;
import com.macro.mall.vo.LmsLogisticsChargeVo;

import java.util.List;

/**
 * 物流费用Service
 * Created by ruiwu.xu on 2019/01/05.
 */
public interface LmsLogisticsChargeService {
    /**
     * 添加物流费用
     */
    int add(LmsLogisticsCharge logisticsCharge);

    /**
     * 修改物流费用
     */
    int update(Long id, LmsLogisticsCharge logisticsCharge);

    /**
     * 删除物流费用
     */
    int delete(Long id);

    /**
     * 获取物流费用
     */
    LmsLogisticsCharge getItem(Long id);

    /**
     * 获取物流费用
     */
    List<LmsLogisticsChargeVo> page(LmsLogisticsQueryParamDto  logisticsQueryParamDto, Integer pageSize, Integer pageNum);

}
