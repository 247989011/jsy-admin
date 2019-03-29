package com.macro.mall.portal.vo;

import com.macro.mall.model.SmsCoupon;
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
@ApiModel(value= "订单模块-优惠信息Dto(全场通用)",description = "优惠信息:SmsPromotionVo(全场通用)")
@Getter
@Setter
public class SmsGeneralPromotionVo {
    @ApiModelProperty(value = "客户持有的全场通用的优惠券")
    List<SmsCoupon>   couponList;
    @ApiModelProperty(value = "客户可以参加的全场通用的营销活动")
    List<OmsPortalMarketingActivityDo>  marketingActivityDtoList;
}
