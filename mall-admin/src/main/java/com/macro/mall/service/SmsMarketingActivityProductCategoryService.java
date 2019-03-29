package com.macro.mall.service;

import com.macro.mall.dto.SmsMarketingActivityProductCategoryRelationDTO;
import com.macro.mall.model.SmsMarketingActivityProductCategoryRelation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 营销活动关联的商品分类Service
 * Created by ruiwu.xu on 2019/01/05.
 */
public interface SmsMarketingActivityProductCategoryService {

    /**
     * 添加营销活动的关联商品分类(批量)
     */
    @Transactional
    int batchAdd(List<SmsMarketingActivityProductCategoryRelation> marketingActivityProductCategoryRelationList);

    /**
     * 删除某营销活动关联的商品分类(批量)
     */
    @Transactional
    int batchDelete(List<Long> ids);

    /**
     * 查询营销活动关联的商品分类
     */
    List<SmsMarketingActivityProductCategoryRelationDTO> page(Long activityId, Integer  pageNum, Integer pageSize);
}
