package com.transample.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transample.demo.mapper.TaoOrderMapper;
import com.transample.demo.domain.TaoOrder;
import com.transample.demo.service.ITaoOrderService;

import javax.annotation.Resource;

/**
 * 订单 服务层实现
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Service
public class TaoOrderServiceImpl implements ITaoOrderService 
{
	@Resource
	private TaoOrderMapper taoOrderMapper;

	/**
     * 查询订单信息
     * 
     * @param orderId 订单ID
     * @return 订单信息
     */
    @Override
	public TaoOrder selectTaoOrderById(Integer orderId)
	{
	    return taoOrderMapper.selectTaoOrderById(orderId);
	}
	
	/**
     * 查询订单列表
     * 
     * @param taoOrder 订单信息
     * @return 订单集合
     */
	@Override
	public List<TaoOrder> selectTaoOrderList(TaoOrder taoOrder)
	{
	    return taoOrderMapper.selectTaoOrderList(taoOrder);
	}
	
    /**
     * 新增订单
     * 
     * @param taoOrder 订单信息
     * @return 结果返回订单号即主键
     */
	@Override
	public int insertTaoOrder(TaoOrder taoOrder)
	{
		taoOrderMapper.insertTaoOrder(taoOrder);
		return taoOrder.getOrderId();
	}
	
	/**
     * 修改订单
     * 
     * @param taoOrder 订单信息
     * @return 结果
     */
	@Override
	public int updateTaoOrder(TaoOrder taoOrder)
	{
	    return taoOrderMapper.updateTaoOrder(taoOrder);
	}

	/**
     * 删除订单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTaoOrderByIds(String ids)
	{
		return taoOrderMapper.deleteTaoOrderByIds(ids.split(","));
	}
	
}
