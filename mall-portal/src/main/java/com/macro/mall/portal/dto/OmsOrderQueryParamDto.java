package com.macro.mall.portal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 订单查询参数
 * Created by ruiwu.xu on 2019/01/19.
 */
@ApiModel(value= "订单查询参数Dto",description = "订单查询参数Dto:OmsOrderQueryParamDto")
@Getter
@Setter
public class OmsOrderQueryParamDto {
    @ApiModelProperty(value = "订单编号")
    private String orderSn;
    @ApiModelProperty(value = "客户Id")
    private Long memberId;
    @ApiModelProperty(value = "收货人姓名/号码")
    private String receiverKeyword;
    @ApiModelProperty(value = "订单状态：预选状态0、待提交订单1、待审核订单2、待支付3、待确认到款4、待拍照5、待审核图片6、待发货7、配送中8、已收货9")
    private Integer status;
    @ApiModelProperty(value = "订单类型：0->正常订单；1->秒杀订单", hidden = true)
    private Integer orderType;
    @ApiModelProperty(value = "订单来源：0->PC订单；1->app订单",  hidden = true)
    private Integer sourceType;
    @ApiModelProperty(value = "订单提交时间",  hidden = true)
    private String createTime;
}
