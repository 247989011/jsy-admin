package com.macro.mall.portal.vo;

import com.macro.mall.model.SmsCoupon;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单模块-优惠劵Dto
 * Created by ruiwu.xu on 2019/01/19.
 */
@ApiModel(value= "订单模块-优惠劵Dto",description = "优惠劵Dto:SmsCouponDto")
@Getter
@Setter
@Deprecated
public class SmsCouponVo {
    @ApiModelProperty(value = "商品ID")
    private Long productId;
    //客户持有的对应的商品优惠券 list
    List<SmsCoupon>   couponList;

    //商品参与的优惠活动 list
}
