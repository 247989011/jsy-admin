package com.macro.mall.portal.domain;

import com.macro.mall.model.SmsMarketingActivities;
import com.macro.mall.model.SmsMarketingActivityRule;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 商品营销活动信息
 * Created by ruiwu.xu on 2019/01/19.
 */
@ApiModel(value= "订单模块-营销活动信息",description = "商品营销活动信息:OmsPortalProductMarketingActivityDto")
@Getter
@Setter
public class OmsPortalMarketingActivityDo extends SmsMarketingActivities {
    @ApiModelProperty(value = "营销活动规则")
    private SmsMarketingActivityRule smsMarketingActivityRule;
}
