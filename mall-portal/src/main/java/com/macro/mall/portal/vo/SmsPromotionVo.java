package com.macro.mall.portal.vo;

import com.macro.mall.portal.domain.OmsPortalMarketingActivityDo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单模块-优惠劵Dto
 * Created by ruiwu.xu on 2019/01/19.
 */
@ApiModel(value= "订单模块-优惠信息Vo(单个商品)",description = "优惠信息Vo(单个商品):SmsPromotionVo")
@Getter
@Setter
public class SmsPromotionVo {
    @ApiModelProperty(value = "商品ID")
    private Long productId;
    @ApiModelProperty(value = "客户持有的对应商品的优惠券")
    List<SmsCoupon>   couponList;
    @ApiModelProperty(value = "客户可以参加的对应商品的营销活动")
    List<OmsPortalMarketingActivityDo>  marketingActivityDtoList;
}
