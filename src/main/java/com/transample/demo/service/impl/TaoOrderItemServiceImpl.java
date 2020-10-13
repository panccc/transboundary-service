package com.transample.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transample.demo.mapper.TaoOrderItemMapper;
import com.transample.demo.domain.TaoOrderItem;
import com.transample.demo.service.ITaoOrderItemService;

/**
 * 订单单类商品 服务层实现
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Service
public class TaoOrderItemServiceImpl implements ITaoOrderItemService 
{
	@Autowired
	private TaoOrderItemMapper taoOrderItemMapper;

	/**
     * 查询订单单类商品信息
     * 
     * @param orderItemId 订单单类商品ID
     * @return 订单单类商品信息
     */
    @Override
	public TaoOrderItem selectTaoOrderItemById(Integer orderItemId)
	{
	    return taoOrderItemMapper.selectTaoOrderItemById(orderItemId);
	}
	
	/**
     * 查询订单单类商品列表
     * 
     * @param taoOrderItem 订单单类商品信息
     * @return 订单单类商品集合
     */
	@Override
	public List<TaoOrderItem> selectTaoOrderItemList(TaoOrderItem taoOrderItem)
	{
	    return taoOrderItemMapper.selectTaoOrderItemList(taoOrderItem);
	}
	
    /**
     * 新增订单单类商品
     * 
     * @param taoOrderItem 订单单类商品信息
     * @return 结果
     */
	@Override
	public int insertTaoOrderItem(TaoOrderItem taoOrderItem)
	{
	    return taoOrderItemMapper.insertTaoOrderItem(taoOrderItem);
	}
	
	/**
     * 修改订单单类商品
     * 
     * @param taoOrderItem 订单单类商品信息
     * @return 结果
     */
	@Override
	public int updateTaoOrderItem(TaoOrderItem taoOrderItem)
	{
	    return taoOrderItemMapper.updateTaoOrderItem(taoOrderItem);
	}

	/**
     * 删除订单单类商品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTaoOrderItemByIds(String ids)
	{
		return taoOrderItemMapper.deleteTaoOrderItemByIds(ids.split(","));
	}
	
}
