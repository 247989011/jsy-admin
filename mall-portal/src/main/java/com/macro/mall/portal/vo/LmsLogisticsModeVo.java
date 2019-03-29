package com.macro.mall.portal.vo;

import com.macro.mall.model.LmsLogisticsCharge;
import com.macro.mall.model.LmsLogisticsMode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 订单模块-可选的物流方式
 * Created by ruiwu.xu on 2019/01/19.
 */
@ApiModel(value= "订单模块-可选的物流方式",description = "可选的物流方式:LmsLogisticsModeVo")
@Getter
@Setter
public class LmsLogisticsModeVo extends  LmsLogisticsMode{
    @ApiModelProperty(value = "物流方式对应的费用信息")
    private LmsLogisticsCharge logisticsCharge;
}