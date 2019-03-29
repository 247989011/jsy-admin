package com.macro.mall.dto;

import com.macro.mall.model.PaymsPayTemplateModeRelation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 订单创建信息
 * Created by macro on 2018/10/11.
 */
@ApiModel("支付模板的支付方式Dto")
@Getter
@Setter
public class PaymsPayTemplateModeRelationDto extends PaymsPayTemplateModeRelation {
    @ApiModelProperty("支付模板Id")
    private Long templateId;
}
