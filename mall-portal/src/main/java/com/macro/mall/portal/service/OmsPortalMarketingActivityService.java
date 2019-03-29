package com.macro.mall.portal.service;

import com.macro.mall.portal.domain.OmsPortalMarketingActivityDo;
import com.macro.mall.portal.domain.OmsPortalMarketingActivityWithProductIdDo;

import java.util.List;


/**
 * 商品的营销活动Service
 * Created by macro on 2018/8/30.
 */
public interface OmsPortalMarketingActivityService {

    /**
     * 查询所有通用的正式进行的营销活动
     */
    List<OmsPortalMarketingActivityDo> listGeneralMarketingActivity();

    /**
     * 商品参加的指定的正在进行的营销活动
     */
    List<OmsPortalMarketingActivityWithProductIdDo> listAppointMarketingActivity(Long productId);
}
