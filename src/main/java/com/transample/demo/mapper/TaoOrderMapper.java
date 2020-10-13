package com.transample.demo.mapper;

import com.transample.demo.domain.TaoOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 订单 数据层
 * 
 * @author youcaihua
 * @date 2020-10-13
 */

public interface TaoOrderMapper 
{
	/**
     * 查询订单信息
     * 
     * @param orderId 订单ID
     * @return 订单信息
     */
	public TaoOrder selectTaoOrderById(Integer orderId);
	
	/**
     * 查询订单列表
     * 
     * @param taoOrder 订单信息
     * @return 订单集合
     */
	public List<TaoOrder> selectTaoOrderList(TaoOrder taoOrder);
	
	/**
     * 新增订单
     * 
     * @param taoOrder 订单信息
     * @return 结果
     */
	public int insertTaoOrder(TaoOrder taoOrder);
	
	/**
     * 修改订单
     * 
     * @param taoOrder 订单信息
     * @return 结果
     */
	public int updateTaoOrder(TaoOrder taoOrder);
	
	/**
     * 删除订单
     * 
     * @param orderId 订单ID
     * @return 结果
     */
	public int deleteTaoOrderById(Integer orderId);
	
	/**
     * 批量删除订单
     * 
     * @param orderIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaoOrderByIds(String[] orderIds);
	
}