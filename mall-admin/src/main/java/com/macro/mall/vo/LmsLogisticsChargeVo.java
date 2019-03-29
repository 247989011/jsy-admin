package com.macro.mall.vo;

import com.macro.mall.model.LmsLogisticsCharge;
import com.macro.mall.model.LmsLogisticsMode;
import com.macro.mall.model.LmsLogisticsTemplate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 物流模块-物流费用Dto
 * Created by ruiwu.xu on 2019/01/19.
 */
@ApiModel(value= "物流模块-物流费用Dto",description = "物流费用Dto:LmsLogisticsChargeDto")
@Getter
@Setter
public class LmsLogisticsChargeVo extends LmsLogisticsCharge {
    @ApiModelProperty("物流模板")
    private LmsLogisticsTemplate logisticsTemplate;
    @ApiModelProperty("物流模板")
    private LmsLogisticsMode logisticsMode;
}
