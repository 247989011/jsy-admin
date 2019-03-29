package com.macro.mall.constant;

//常量定义
public final class OmsOrderConst {
    //私有构造方法
    private OmsOrderConst() {}

    //订单状态：预选状态0、待提交订单1、待审核订单2、待支付3、待确认到款4、待拍照5、待审核图片6、待发货7、配送中8、已收货9、取消订单10
    public static final int STATUS_TOBE_COMMIT_0 = 0;//待提交订单
    public static final int STATUS_TOBE_CHECK_1 = 1;//待审核订单
    public static final int STATUS_TOBE_PAY_2 = 2;//待支付
    public static final int STATUS_TOBE_PAY_CHECK_3 = 3;//待确认到款
    public static final int STATUS_TOTAKE_PICTURES_4 = 4;//待拍照
    public static final int STATUS_TOBE_PICTURES_REVIEWED_5 = 5;//待审核图片
    public static final int STATUS_TOBE_SEND_6 = 6;//待发货
    public static final int STATUS_TOBE_SENDING_7 = 7;//配送中
    public static final int STATUS_TOBE_SIGN_8 = 8;//等待签收
    public static final int STATUS_RECEIVED_9 = 9;//已收货
    public static final int STATUS_CANCELED_10 = 10;//已取消订单

    //删除状态：0->未删除；1->已删除
    public static final int DELETE_STATUS_INUSE_0 = 0;
    public static final int DELETE_STATUS_DELETE_1 = 1;

}
