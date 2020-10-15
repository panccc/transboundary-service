package com.transample.demo.controller;

import java.util.Date;
import java.util.List;

import com.transample.demo.domain.TaoCartOrderItem;
import com.transample.demo.domain.TaoOrderItem;
import com.transample.demo.dto.OrderDTO;
import com.transample.demo.service.ITaoOrderItemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.transample.demo.domain.TaoOrder;
import com.transample.demo.service.ITaoOrderService;
import com.transample.demo.common.ResponseResult;

import javax.annotation.Resource;

/**
 * 订单 信息操作处理
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Controller
@RequestMapping("/taoOrder")
public class TaoOrderController
{
    private String prefix = "taoOrder";
	
	@Autowired
	private ITaoOrderService taoOrderService;

	@Resource
	private ITaoOrderItemService taoOrderItemService;
	
//	@GetMapping()
//	public String taoOrder()
//	{
//	    return prefix + "/taoOrder";
//	}
	
	/**
	 * 查询订单列表
	 */
	//TODO 按条件查询
	@ApiOperation("获取订单列表，支持模糊查询")
	@PostMapping("/list")
	@ResponseBody
	public List<TaoOrder> list(@RequestBody TaoOrder taoOrder)
	{
        List<TaoOrder> list = taoOrderService.selectTaoOrderList(taoOrder);
		return list;
	}



	@ApiOperation("获取下单前返显给前端的信息，参数和返回结果待确认")
	@GetMapping("/getInfoBeforeAdd")
	@ResponseBody
	public String getInfoBeforeAdd()
	{
		return prefix+"/getInfoBeforeAdd";
	}

	/**
	 * 新增保存订单
	 */
	@ApiOperation("下单 参数 订单的一些基本信息和各个商品的信息list")
	@PostMapping("/addOrder")
	@ResponseBody
	public ResponseEntity addOrder(@RequestBody OrderDTO orderDTO)
	{
		TaoOrder order = orderDTO.getOrder();
		/**
		 * 向数据库中插入一条记录，并返回订单id
		 */
		int orderId = taoOrderService.insertTaoOrder(order);

		int totalAmount = 0 ;
		double totalPrice = 0.0;

		List<TaoOrderItem> itemList = orderDTO.getOrderItemList();
		for(int i=0;i<itemList.size();i++)
		{
			TaoOrderItem taoOrderItem = itemList.get(i);
			/**
			 * 统计商品总价格和总数量
			 */
			totalAmount+=taoOrderItem.getAmount();
			totalPrice+=taoOrderItem.getPrice();

			/**
			 * 将orderId填入orderItem
			 */
			taoOrderItem.setOrderId(orderId);
			/**
			 * 插入orderItem表
			 */
			taoOrderItemService.insertTaoOrderItem(taoOrderItem);
		}

		order.setTotalNumber(totalAmount);
		order.setTotalPrice(totalPrice);
		Date date = new Date();
		order.setCreateTime(date);

		/**
		 * 更新数量，价格和创建时间到order表中
		 */
		taoOrderService.updateTaoOrder(order);
		return ResponseEntity.ok(ResponseResult.ok("下单成功"));

	}




	@ApiOperation("获取订单详情返显给前端")
	@GetMapping("/getOrderInfo/{orderId}")
	@ResponseBody
	public TaoOrder getOrderInfo(@PathVariable @ApiParam(value = "订单id",required = true) Integer orderId)
	{
	    TaoOrder order = taoOrderService.selectTaoOrderById(orderId);
		return order;
	}
	


	/**
	 * 修改订单
	 */
	@GetMapping("/edit/{orderId}")
	public String edit(@PathVariable("orderId") Integer orderId, ModelMap mmap)
	{
		TaoOrder taoOrder = taoOrderService.selectTaoOrderById(orderId);
		mmap.put("taoOrder", taoOrder);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存订单
	 */
	@PostMapping("/edit")
	@ResponseBody
	public ResponseEntity editSave(TaoOrder taoOrder)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoOrderService.updateTaoOrder(taoOrder)));
	}
	
	/**
	 * 删除订单
	 */

	@PostMapping( "/remove")
	@ResponseBody
	public ResponseEntity remove(String ids)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoOrderService.deleteTaoOrderByIds(ids)));
	}
	
}
