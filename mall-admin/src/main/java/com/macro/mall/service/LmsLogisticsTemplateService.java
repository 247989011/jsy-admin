package com.macro.mall.service;

import com.macro.mall.model.LmsLogisticsTemplate;

import java.util.List;

/**
 * 物流模板Service
 * Created by ruiwu.xu on 2019/01/05.
 */
public interface LmsLogisticsTemplateService {
    //流模板状态：00-启用、01-弃用
    String LOGISTICS_TEMPLATE_STATUS_INUSE_00 = "00";
    String LOGISTICS_TEMPLATE_STATUS_DISUSE_01 = "01";

    /**
     * 添加物流模板
     */
    int create(LmsLogisticsTemplate logisticsTemplate);

    /**
     * 修改物流模板信息
     */
    int update(Long id, LmsLogisticsTemplate logisticsTemplate);

    /**
     * 修改物流模板状态(00-正常、01-弃用)
     */
    int updateStatus(Long id, String status);

    /**
     * 逻辑删除物流模板
     */
    int logicDelete(Long id);

    /**
     * 物理删除物流模板
     */
    int delete(Long id);

    /**
     * 获取物流模板详情
     */
    LmsLogisticsTemplate getItem(Long id);

    /**
     * 查询物流模板(分页)
     */
    List<LmsLogisticsTemplate> page(String templateName, Integer pageSize, Integer pageNum);

}
