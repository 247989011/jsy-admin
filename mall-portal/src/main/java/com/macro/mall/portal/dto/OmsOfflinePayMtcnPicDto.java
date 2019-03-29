package com.macro.mall.portal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 线下支付凭证查询Dto
 * Created by ruiwu.xu on 2019/01/19.
 */
@ApiModel(value= "线下支付凭证查询Dto",description = "线下支付凭证查询Dto:OmsOfflinePayMtcnPicDto")
@Getter
@Setter
public class OmsOfflinePayMtcnPicDto extends OmsOfflinePayMtcnPic {
    @ApiModelProperty("订单Id")
    private  Long orderId;
}
