package com.macro.mall.portal.service;

import com.macro.mall.portal.vo.SmsCouponVo;

import java.util.List;


/**
 * 客户优惠劵Service
 * Created by macro on 2018/8/30.
 */
public interface OmsPortalCouponService {

    /**
     * 查询客户全场通用的正在进行的优惠劵
     */
    List<SmsCoupon> listGeneralCoupon();

    /**
     * 查询客户非全场通用的正在进行的优惠劵
     */
    List<SmsCouponVo> listAppointCoupon(Long productId);

}
