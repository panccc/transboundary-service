package com.transample.demo.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.transample.demo.domain.TaoCartOrderItem;
import com.transample.demo.domain.TaoOrderItem;
import com.transample.demo.domain.TaoSeller;
import com.transample.demo.mapper.TaoOrderItemMapper;
import com.transample.demo.mapper.TaoSellerMapper;
import com.transample.demo.utils.OrderUtils;
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

	@Resource
	private TaoOrderItemMapper taoOrderItemMapper;

	@Resource
	private TaoSellerMapper taoSellerMapper;

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


	/**
	 * 计算一些订单的基本信息
	 *
	 * @param order
	 * @param itemList
	 * @return
	 */
	@Override
	public TaoOrder calOrderInfo(TaoOrder order, List<TaoOrderItem> itemList) {


		/**
		 * 向数据库中插入一条记录，并返回订单id
		 */
		int orderId = insertTaoOrder(order);

		int totalAmount = 0 ;
		double totalPrice = 0.0;


		for(int i=0;i<itemList.size();i++)
		{
			TaoOrderItem taoOrderItem = itemList.get(i);
			/**
			 * 统计商品总价格和总数量
			 */
			totalAmount+=taoOrderItem.getAmount();
			totalPrice+=taoOrderItem.getAmount()*taoOrderItem.getPrice();

			/**
			 * 将orderId填入orderItem
			 */
			taoOrderItem.setOrderId(orderId);
			/**
			 * 插入orderItem表
			 */
			taoOrderItemMapper.insertTaoOrderItem(taoOrderItem);
		}

		order.setTotalNumber(totalAmount);
		BigDecimal totalPriceBigDecimal = BigDecimal.valueOf(totalPrice);
		order.setTotalPrice(totalPriceBigDecimal);

		/**
		 * 设置订单物流价格
		 */
		TaoSeller seller = taoSellerMapper.selectTaoSellerById(order.getSellerId());
		String sellerAddress = seller.getSellerLocation();
		double logisticsOnePrice = OrderUtils.generateFare(sellerAddress, order.getAddress(), order.getTotalNumber(),false);
		order.setLogisticsOnePrice(BigDecimal.valueOf(logisticsOnePrice));
		if(order.getStationId()!=null)
		{
			/**
			设置二级物流价格
			 */
			double logisticsTwoPrice = OrderUtils.generateFare(sellerAddress, order.getAddress(), order.getTotalNumber(),true);
			order.setLogisticsTwoPrice(BigDecimal.valueOf(logisticsTwoPrice));
		}

		/**
		 * 创建时间
		 */
		Date date = new Date();
		order.setCreateTime(date);

		return order;
	}
}
