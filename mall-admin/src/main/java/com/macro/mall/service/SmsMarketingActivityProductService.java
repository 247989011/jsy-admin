package com.macro.mall.service;

import com.macro.mall.dto.SmsMarketingActivityProductRelationDTO;
import com.macro.mall.model.SmsMarketingActivityProductRelation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 营销活动关联商品Service
 * Created by ruiwu.xu on 2019/01/05.
 */
public interface SmsMarketingActivityProductService {

    /**
     * 添加营销活动关联的商品(批量)
     */
    @Transactional
    int batchAdd(List<SmsMarketingActivityProductRelation> marketingActivityProductRelationList);

    /**
     * 删除某营销活动关联的商品(批量)
     */
    @Transactional
    int batchDelete(List<Long> ids);

    /**
     * 查询营销活动的关联商品(分页)
     */
    List<SmsMarketingActivityProductRelationDTO> page(Long activityId, Integer  pageNum, Integer pageSize);
}
