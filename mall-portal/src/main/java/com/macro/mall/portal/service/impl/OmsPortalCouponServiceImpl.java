package com.macro.mall.portal.service.impl;

import com.macro.mall.common.model.*;
import com.macro.mall.portal.vo.SmsCouponVo;
import com.macro.mall.portal.service.OmsPortalCouponService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruiwu.xu on 2019/01/08.
 */
@Service
public class OmsPortalCouponServiceImpl implements OmsPortalCouponService {
    @Autowired
    private SmsCouponMapper couponMapper;
    @Autowired
    private SmsCouponProductRelationMapper couponProductRelationMapper;
    @Autowired
    private SmsCouponProductCategoryRelationMapper couponProductCategoryRelationMapper;
    @Autowired
    private PmsProductMapper pmsProductMapper;

    @Override
    public List<SmsCoupon> listGeneralCoupon() {
        SmsCouponExample couponExample = new SmsCouponExample();
        couponExample.createCriteria().andUseTypeEqualTo(0); //0->全场通用
        //TODO 逻辑不对 ,是客户持有的全场通用优惠券，而不是所有的优惠券 sms_coupon_history

        return couponMapper.selectByExample(couponExample);
    }

    @Override
    public List<SmsCouponVo> listAppointCoupon(Long productId) {
        //定义返回值
        List<SmsCouponVo> couponDtoList = new ArrayList<SmsCouponVo>();

        //从商品ID获取商品参加的营销活动
        SmsCouponProductRelationExample couponProductRelationExample = new SmsCouponProductRelationExample();
        couponProductRelationExample.createCriteria().andProductIdEqualTo(productId);
        List<SmsCouponProductRelation> couponProductRelationList = couponProductRelationMapper.
                selectByExample(couponProductRelationExample);
        //TODO 逻辑不对
        for (SmsCouponProductRelation e : couponProductRelationList) {
            SmsCouponVo couponDto = new SmsCouponVo();
            couponDto.setProductId(productId);
            SmsCoupon coupon = couponMapper.selectByPrimaryKey(e.getCouponId());
            if(coupon != null ){
                BeanUtils.copyProperties(coupon, couponDto);
            }
            couponDtoList.add(couponDto);
        }

        //从商品分类获取商品参加的营销活动
        SmsCouponProductCategoryRelationExample couponProductCategoryRelationExample =
                new SmsCouponProductCategoryRelationExample();
        couponProductCategoryRelationExample.createCriteria().andProductCategoryIdEqualTo(
                pmsProductMapper.selectByPrimaryKey(productId).getProductCategoryId());
        List<SmsCouponProductCategoryRelation>  couponProductCategoryRelationList =
                couponProductCategoryRelationMapper.selectByExample(couponProductCategoryRelationExample);
        for (SmsCouponProductCategoryRelation e : couponProductCategoryRelationList) {
            SmsCouponVo couponDto = new SmsCouponVo();
            couponDto.setProductId(productId);
            SmsCoupon coupon = couponMapper.selectByPrimaryKey(e.getCouponId());
            if(coupon != null ){
                BeanUtils.copyProperties(coupon, couponDto);
            }
            couponDtoList.add(couponDto);
        }

        //TODO 单个商品 对应的活动


        return couponDtoList;
    }
}
