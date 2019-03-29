package com.macro.mall.dto;

import com.macro.mall.model.PmsProductCategory;
import com.macro.mall.model.SmsMarketingActivityProductCategoryRelation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("营销活动关联的商品分类DTO")
@Data
public class SmsMarketingActivityProductCategoryRelationDTO  extends  SmsMarketingActivityProductCategoryRelation{
    @ApiModelProperty("商品分类信息")
    private PmsProductCategory productCategory;
}
