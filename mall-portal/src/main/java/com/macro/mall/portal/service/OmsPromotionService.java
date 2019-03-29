package com.macro.mall.portal.service;

import com.macro.mall.model.OmsCartItem;
import com.macro.mall.portal.domain.CartPromotionItem;
import com.macro.mall.portal.domain.PromotionProduct;
import com.macro.mall.portal.vo.SmsGeneralPromotionVo;
import com.macro.mall.portal.vo.SmsPromotionVo;

import java.util.List;

/**
 * Created by macro on 2018/8/27.
 * 促销管理Service
 */
public interface OmsPromotionService {
    /**
     * 获取客户的单个商品的优惠信息(有效的)
     * @param memberId  客户ID
     * @param productId  商品ID
     */
    SmsPromotionVo getPromotionOfProduct(Long memberId, Long productId);

    /**
     * 获取客户的单个商品的优惠信息(有效的)
     * @param memberId  客户ID
     */
    SmsGeneralPromotionVo getGeneralPromotion(Long memberId);

    /**
     * 计算购物车中的促销活动信息
     * @param cartItemList 购物车
     */
    @Deprecated
    List<CartPromotionItem> calcCartPromotion(List<OmsCartItem> cartItemList);

    /**
     * 获取单个商品的优惠信息
     * @param productId
     * @return
     */
    @Deprecated
    List<PromotionProduct> getPromotion(Long productId);
}
