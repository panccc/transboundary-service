package com.transample.demo.mapper;

import com.transample.demo.domain.TaoOrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 订单单类商品 数据层
 * 
 * @author youcaihua
 * @date 2020-10-13
 */

public interface TaoOrderItemMapper 
{
	/**
     * 查询订单单类商品信息
     * 
     * @param orderItemId 订单单类商品ID
     * @return 订单单类商品信息
     */
	public TaoOrderItem selectTaoOrderItemById(Integer orderItemId);
	
	/**
     * 查询订单单类商品列表
     * 
     * @param taoOrderItem 订单单类商品信息
     * @return 订单单类商品集合
     */
	public List<TaoOrderItem> selectTaoOrderItemList(TaoOrderItem taoOrderItem);
	
	/**
     * 新增订单单类商品
     * 
     * @param taoOrderItem 订单单类商品信息
     * @return 结果
     */
	public int insertTaoOrderItem(TaoOrderItem taoOrderItem);
	
	/**
     * 修改订单单类商品
     * 
     * @param taoOrderItem 订单单类商品信息
     * @return 结果
     */
	public int updateTaoOrderItem(TaoOrderItem taoOrderItem);
	
	/**
     * 删除订单单类商品
     * 
     * @param orderItemId 订单单类商品ID
     * @return 结果
     */
	public int deleteTaoOrderItemById(Integer orderItemId);
	
	/**
     * 批量删除订单单类商品
     * 
     * @param orderItemIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaoOrderItemByIds(String[] orderItemIds);
	
}