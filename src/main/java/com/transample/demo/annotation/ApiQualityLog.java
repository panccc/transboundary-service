package com.transample.demo.annotation;/*
 * @Author: panc
 * @Date:2020/10/13 11:14*/

import java.lang.annotation.*;

/**
 * 打印
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ApiQualityLog {
    /**
     * 需要打印入参
     * @return
     */
    boolean needPrintArgs() default true;
    /**
     * 需要打印入参
     * @return
     */
    String indexParams() default "";
    /**
     * 需要打印返回值
     * @return
     */
    boolean needReturnT() default true;
    /**
     * 方法的描述
     * @return
     */
    String methodDesc() default "";

    /**
     * 参数的描述（数组）
     * @return
     */
    String[] paramsDesc() default {};
    /**
     * 返回值的描述
     * @return
     */
    String returnDesc() default "返回值";
    /**
     * 标记为统计型（“statistics”）或者单一型("")
     * @return
     */
    String calculateType() default "";
}
