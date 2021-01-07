package com.transample.demo.service;

import com.transample.demo.domain.Foundation;

import java.util.Date;

public interface FundService {
    /**
     * 计算基金的收益 在一定时间范围内
     * @param startTime 开始时间
     * @param endTime 终止时间
     * @param ratio 比率
     * @param status 订单的状态
     * @return 利润
     */
    double getProfit(Date startTime, Date endTime, double ratio,Integer status);

    /**
     * 查询基金会的详情
     * @param id 基金会的id
     * @return
     */
    Foundation getFoundation(Integer id);

    /**
     * 基金会登陆
     * @param id
     * @param password
     * @return
     */
    Foundation login(Integer id, String password);
}
