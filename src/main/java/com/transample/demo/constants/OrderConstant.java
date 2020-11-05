package com.transample.demo.constants;

public class OrderConstant {
    /**
     * 关于订单的一些常数
     */

    /**
     * 订单状态
     */

    /**
     * 未付款
     */
    public static final  Integer UNPAID= 10;//未付款

    /**
     * 已付款
     */
    public static final  Integer PAY= 11;
    /**
     * 已审核
     */
    public static final  Integer AUDIT= 12;
    /**
     * 缺货
     */
    public static final  Integer LACK= 20;
    /**
     * 发货中
     */
    public static final  Integer TRANSPORT= 30;
    /**
     * 已送达
     */
    public static final  Integer ARRIVE= 31;
    /**
     * 已签收
     */
    public static final  Integer RECEIVE= 32;
    /**
     * 确认收货
     */
    public static final  Integer FINISH= 50;
    /**
     * 取消订单
     */
    public static final  Integer CANCEL= 60;

}
