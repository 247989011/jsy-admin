package com.macro.mall.portal.dto;

import com.macro.mall.model.OmsOrderLogisticsPicUri;
import com.macro.mall.model.OmsOrderLogisticsTraceLog;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单物流凭证Dto
 * Created by ruiwu.xu on 2019/01/19.
 */
@ApiModel(value= "订单物流凭证Dto",description = "订单物流凭证Dto:OmsOrderLogisticsPicDto")
@Getter
@Setter
public class OmsOrderLogisticsPicDto extends OmsOrderLogisticsTraceLog {
    @ApiModelProperty("物流单号对应的发货凭证信息")
    List<OmsOrderLogisticsPicUri> orderLogisticsPicUriList;
}
