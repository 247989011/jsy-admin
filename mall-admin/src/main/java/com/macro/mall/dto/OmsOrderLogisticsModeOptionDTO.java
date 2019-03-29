package com.macro.mall.dto;

import com.macro.mall.model.LmsLogisticsMode;
import com.macro.mall.model.OmsLogisticsModeOption;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@ApiModel("订单的备选物流方式")
@Data
@Deprecated
public class OmsOrderLogisticsModeOptionDTO {
    @ApiModelProperty("订单Id")
    private Long OrderId;

    @ApiModelProperty("备选物流方式信息")
    private List<OmsLogisticsModeOption> logisticsModeOption;

    @ApiModelProperty("备选物流方式的定义信息")
    private List<LmsLogisticsMode> logisticsMode;
}
