package com.transample.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transample.demo.mapper.TaoCartOrderItemMapper;
import com.transample.demo.domain.TaoCartOrderItem;
import com.transample.demo.service.ITaoCartOrderItemService;

/**
 * 购物车单类商品 服务层实现
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Service
public class TaoCartOrderItemServiceImpl implements ITaoCartOrderItemService 
{
	@Autowired
	private TaoCartOrderItemMapper taoCartOrderItemMapper;

	/**
     * 查询购物车单类商品信息
     * 
     * @param orderItemId 购物车单类商品ID
     * @return 购物车单类商品信息
     */
    @Override
	public TaoCartOrderItem selectTaoCartOrderItemById(Integer orderItemId)
	{
	    return taoCartOrderItemMapper.selectTaoCartOrderItemById(orderItemId);
	}
	
	/**
     * 查询购物车单类商品列表
     * 
     * @param taoCartOrderItem 购物车单类商品信息
     * @return 购物车单类商品集合
     */
	@Override
	public List<TaoCartOrderItem> selectTaoCartOrderItemList(TaoCartOrderItem taoCartOrderItem)
	{
	    return taoCartOrderItemMapper.selectTaoCartOrderItemList(taoCartOrderItem);
	}
	
    /**
     * 新增购物车单类商品
     * 
     * @param taoCartOrderItem 购物车单类商品信息
     * @return 结果
     */
	@Override
	public int insertTaoCartOrderItem(TaoCartOrderItem taoCartOrderItem)
	{
	    return taoCartOrderItemMapper.insertTaoCartOrderItem(taoCartOrderItem);
	}
	
	/**
     * 修改购物车单类商品
     * 
     * @param taoCartOrderItem 购物车单类商品信息
     * @return 结果
     */
	@Override
	public int updateTaoCartOrderItem(TaoCartOrderItem taoCartOrderItem)
	{
	    return taoCartOrderItemMapper.updateTaoCartOrderItem(taoCartOrderItem);
	}

	/**
     * 删除购物车单类商品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTaoCartOrderItemByIds(String ids)
	{
		return taoCartOrderItemMapper.deleteTaoCartOrderItemByIds(ids.split(","));
	}
	
}
