package com.macro.mall.vo;

import com.macro.mall.model.OmsOfflinePayMtcnPic;
import com.macro.mall.model.OmsOrderPayLog;
import com.macro.mall.model.PaymsPayMode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("订单支付结果信息Vo")
@Data
public class OmsOrderPayResultInfoVo extends OmsOrderPayLog {
    @ApiModelProperty(value = "订单线下支付凭证信息")
    private OmsOfflinePayMtcnPic offlinePayMtcnPic;

    @ApiModelProperty(value = "订单的支付方式")
    private PaymsPayMode payMode;
}
