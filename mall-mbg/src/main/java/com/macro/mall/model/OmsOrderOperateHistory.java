package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "订单物流跟踪日志", value="OmsOrderLogisticsTraceLog")
@Getter
@Setter
@ToString
public class OmsOrderOperateHistory implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("订单id")
    private Long orderId;
    @ApiModelProperty("操作人：用户；系统；后台管理员")
    private String operateMan;
    @ApiModelProperty("操作时间")
    private Date createTime;
    @ApiModelProperty("订单状态：预选状态0、待提交订单1、待审核订单2、待支付3、待确认到款4、待拍照5、待审核图片6、待发货7、配送中8、已收货9、取消订单10")
    private Integer orderStatus;
    @ApiModelProperty("备注")
    private String note;
    private static final long serialVersionUID = 1L;
}