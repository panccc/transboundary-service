package com.transample.demo.mapper;

import com.transample.demo.domain.TaoCartOrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 购物车单类商品 数据层
 * 
 * @author youcaihua
 * @date 2020-10-13
 */

public interface TaoCartOrderItemMapper 
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
	public int insertTaoCartOrderItem(TaoCartOrderItem taoCartOrderItem);
	
	/**
     * 修改购物车单类商品
     * 
     * @param taoCartOrderItem 购物车单类商品信息
     * @return 结果
     */
	public int updateTaoCartOrderItem(TaoCartOrderItem taoCartOrderItem);
	
	/**
     * 删除购物车单类商品
     * 
     * @param orderItemId 购物车单类商品ID
     * @return 结果
     */
	public int deleteTaoCartOrderItemById(Integer orderItemId);
	
	/**
     * 批量删除购物车单类商品
     * 
     * @param orderItemIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaoCartOrderItemByIds(String[] orderItemIds);
	
}