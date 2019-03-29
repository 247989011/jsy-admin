package com.macro.mall.portal.dto;

import com.macro.mall.model.SmsMarketingActivities;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 商品营销活动信息
 * Created by ruiwu.xu on 2019/01/19.
 */
@ApiModel(value= "订单模块-商品营销活动信息",description = "商品营销活动信息:OmsPortalProductMarketingActivityDto")
@Getter
@Setter
public class OmsPortalProductMarketingActivityDto {
    //TODO  不合理需要修改
    @ApiModelProperty(value = "商品ID")
    private Long productId;
    @ApiModelProperty(value = "商品ID参加的营销活动")
    private List<SmsMarketingActivities> marketingActivitiesList;
}
