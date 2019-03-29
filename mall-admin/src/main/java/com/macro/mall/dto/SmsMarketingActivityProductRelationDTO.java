package com.macro.mall.dto;

import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.SmsMarketingActivityProductRelation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("营销活动关联的商品DTO")
@Data
public class SmsMarketingActivityProductRelationDTO  extends  SmsMarketingActivityProductRelation{
    @ApiModelProperty("商品详情")
    private PmsProduct  pmsProduct;
}
