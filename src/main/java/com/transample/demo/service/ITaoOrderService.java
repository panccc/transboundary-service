package com.transample.demo.service;

import com.transample.demo.domain.TaoCartOrderItem;
import com.transample.demo.domain.TaoOrder;
import com.transample.demo.domain.TaoOrderItem;

import java.util.List;

/**
 * 订单 服务层
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
public interface ITaoOrderService 
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
     * 删除订单信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaoOrderByIds(String ids);

	/**
	 * 计算一些订单的基本信息
	 * @param order
	 * @param itemList
	 * @return
	 */
	public TaoOrder calOrderInfo(TaoOrder order, List<TaoOrderItem> itemList);


	/**
	 * 根据条件获取订单数量
	 * @param order
	 * @return
	 */
	public int getOrderNum(TaoOrder order);
	
}
