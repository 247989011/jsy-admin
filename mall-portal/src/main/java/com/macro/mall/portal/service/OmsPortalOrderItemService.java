package com.macro.mall.portal.service;

import com.macro.mall.portal.domain.PromotionProduct;
import com.macro.mall.portal.vo.PmsPortalProductDetailVo;

/**
 * 订单的商品明细Service
 * Created by macro on 2018/4/27.
 */
public interface OmsPortalOrderItemService {
    /**
     * 根据根据商品id获取商品详情，包含sku，属性，参与优惠活动，对应客户持有优惠券 信息
     */
    PromotionProduct getProductDetail(Long productId, Long memberId);
}
