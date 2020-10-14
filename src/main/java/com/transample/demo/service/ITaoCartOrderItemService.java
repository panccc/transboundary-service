package com.transample.demo.service;

import com.transample.demo.domain.TaoCartOrderItem;
import java.util.List;

/**
 * 购物车单类商品 服务层
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
public interface ITaoCartOrderItemService 
{
	/**
     * 查询购物车单类商品信息
     * 
     * @param orderItemId 购物车单类商品ID
     * @return 购物车单类商品信息
     */
	public TaoCartOrderItem selectTaoCartOrderItemById(Integer orderItemId);
	
	/**
     * 查询购物车单类商品列表
     * 
     * @param taoCartOrderItem 购物车单类商品信息
     * @return 购物车单类商品集合
     */
	public List<TaoCartOrderItem> selectTaoCartOrderItemList(TaoCartOrderItem taoCartOrderItem);
	
	/**
     * 新增购物车单类商品
     * 
     * @param taoCartOrderItem 购物车单类商品信息
     * @return 结果
     */
	public int insertTaoCartOrderItem(TaoCartOrderItem taoCartOrderItem,Integer villagerId);
	
	/**
     * 修改购物车单类商品
     * 
     * @param taoCartOrderItem 购物车单类商品信息
     * @return 结果
     */
	public int updateTaoCartOrderItem(TaoCartOrderItem taoCartOrderItem);
		
	/**
     * 删除购物车单类商品信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaoCartOrderItemByIds(String ids);
	
}
