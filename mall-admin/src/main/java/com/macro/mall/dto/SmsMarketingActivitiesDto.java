package com.macro.mall.dto;

import com.macro.mall.model.SmsMarketingActivities;
import com.macro.mall.model.SmsMarketingActivityRule;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 营销活动Dto
 * Created by macro on 2018/10/11.
 */
@ApiModel("营销活动Dto")
@Data
public class SmsMarketingActivitiesDto extends SmsMarketingActivities {
    @ApiModelProperty("营销活动规则")
    private SmsMarketingActivityRule marketingActivityRule;
    @ApiModelProperty("营销活动关联的商品")
    private List<Long> productIds;
    @ApiModelProperty("营销活动关联的商品分类")
    private List<Long> productCategoryIds;
}
