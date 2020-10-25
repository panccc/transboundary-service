package com.transample.demo.constants;

public class OrderConstant {

    public enum Municipality
    {
        北京市,
        上海市,
        天津市,
        重庆市
    }
    public enum AutonomousRegion
    {
        内蒙古自治区,
        宁夏回族自治区,
        西藏自治区,
        新疆维吾尔自治区,
        广西壮族自治区
    }
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
