package com.transample.demo.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.transample.demo.common.ResultCode;
import com.transample.demo.constants.OrderConstant;
import com.transample.demo.domain.TaoCartOrderItem;
import com.transample.demo.domain.TaoOrderItem;
import com.transample.demo.dto.OrderDTO;
import com.transample.demo.service.ITaoOrderItemService;
import io.swagger.annotations.Api;
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
@RestController
@Api(tags = "订单相关API")
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
	private static final String queryStatusAPIValue = "待确认underConfirm,已确认confirm,待发货underSend,运输中send" +
			",待成交receive,已成交takeOver";
	@ApiOperation("商家按条件获取订单列表")
	@GetMapping("/list/seller/{status}/{sellerId}")
	public List<TaoOrder> getListOfSeller(@PathVariable @ApiParam(value = queryStatusAPIValue,required = true) String status,@PathVariable @ApiParam("商家id") Integer sellerId)
	{
		TaoOrder order = new TaoOrder();
		order.setSellerId(sellerId);
		switch (status)
		{
			case "underConfirm":
				order.setStatus(OrderConstant.PAY);
				break;
			case "confirm":
				order.setStatus(OrderConstant.AUDIT);
				break;
			case "underSend":
				order.setStatus(OrderConstant.AUDIT);
				break;
			case "send":
				order.setStatus(OrderConstant.TRANSPORT);
				break;
			case "receive":
				order.setStatus(OrderConstant.ARRIVE);
				break;
			case "takeOver":
				order.setStatus(OrderConstant.FINISH);
				break;
		}
      		List<TaoOrder> list = taoOrderService.selectTaoOrderList(order);

		return list;
	}

	private static final String queryStatusUserAPIValue = "已购买pay,待发货underSend,运输中send" +
			",已购买takeOver";
	@ApiOperation("用户按条件获取订单列表")
	@GetMapping("/list/user/{status}/{userId}")
	public List<TaoOrder> getListOfUser(@PathVariable @ApiParam(value = queryStatusUserAPIValue,required = true) String status,@PathVariable @ApiParam("用户id") Integer userId)
	{
		TaoOrder order = new TaoOrder();
		order.setVillagerId(userId);
		switch (status)
		{
			case "pay":
				order.setStatus(OrderConstant.PAY);
				break;
			case "underSend":
				order.setStatus(OrderConstant.AUDIT);
				break;
			case "send":
				order.setStatus(OrderConstant.TRANSPORT);
				break;
			case "takeOver":
				order.setStatus(OrderConstant.FINISH);
				break;
		}
		List<TaoOrder> list = taoOrderService.selectTaoOrderList(order);

		return list;
	}

	private static final String queryStatusStationAPIValue = "村站等待收取underSend,已代收receive";
	@ApiOperation("村站按条件获取订单列表")
	@GetMapping("/list/station/{status}/{stationId}")
	public List<TaoOrder> getListOfStation(@PathVariable @ApiParam(value = queryStatusStationAPIValue,required = true) String status,@PathVariable @ApiParam("村站id") Integer stationId)
	{
		TaoOrder order = new TaoOrder();
		order.setStationId(stationId);
		switch (status)
		{
			case "underSend":
				order.setStatus(OrderConstant.TRANSPORT);
				break;
			case "receive":
				order.setStatus(OrderConstant.ARRIVE);
				break;
		}
		List<TaoOrder> list = taoOrderService.selectTaoOrderList(order);

		return list;
	}


	@ApiOperation("获取下单前返显给前端的信息，参数和返回结果待确认")
	@GetMapping("/getInfoBeforeAdd")
	public String getInfoBeforeAdd()
	{
		return prefix+"/getInfoBeforeAdd";
	}

	/**
	 * 新增保存订单
	 */
	@ApiOperation("下单 参数 订单的一些基本信息和各个商品的信息list")
	@PostMapping("/addOrder")
	public ResponseEntity addOrder(@RequestBody OrderDTO orderDTO)
	{
		HashMap<Integer,List<TaoOrderItem>> hashMap = orderDTO.getOrderItemHashMap();
		for(Integer sellerId : hashMap.keySet())
		{
			TaoOrder order = orderDTO.getOrder();
			order.setOrderId(null);
			order.setSellerId(sellerId);
			/**
			 * 设置下单的默认状态为未付款
			 */
			order.setStatus(OrderConstant.UNPAID);
			List<TaoOrderItem> list = hashMap.get(sellerId);

			order= taoOrderService.calOrderInfo(order,list);

			taoOrderService.updateTaoOrder(order);
		}

		return ResponseEntity.ok(ResponseResult.ok("下单成功"));
	}




	@ApiOperation("获取订单详情返显给前端的信息")
	@GetMapping("/getOrderInfo/{orderId}")
	public TaoOrder getOrderInfo(@PathVariable @ApiParam(value = "订单id",required = true) Integer orderId)
	{
	    TaoOrder order = taoOrderService.selectTaoOrderById(orderId);

		return order;
	}
	


	/**
	 * 修改订单
	 */
	@ApiOperation("编辑时返显给前端的信息")
	@GetMapping("/getInfoBeforeEdit/{orderId}")
	public TaoOrder getInfoBeforeEdit(@PathVariable("orderId") @ApiParam(value = "订单id",required = true) Integer orderId)
	{
		TaoOrder taoOrder = taoOrderService.selectTaoOrderById(orderId);
	    return taoOrder;
	}
	
	/**
	 * 修改保存订单
	 */
	private static final String editAPIValue = "支付成功pay,商家确认confirm,商家缺货stockOut,用户取消订单cancel" +
			",发货send,商品送达arrive,商品签收receive,订单完成takeOver";
	@ApiOperation("修改订单的状态")
	@PostMapping("/edit/{op}/{orderId}")
	public ResponseEntity edit(@PathVariable @ApiParam(value = editAPIValue ,required = true) String op,@PathVariable @ApiParam(value = "订单id",required = true) Integer orderId)
	{		
		TaoOrder order = taoOrderService.selectTaoOrderById(orderId);
		/**
		 * 获取当前时间
		 */
		Date date = new Date();
		if(op.equals("pay"))
		{
			order.setStatus(OrderConstant.PAY);
		}else if(op.equals("confirm"))
		{
			order.setStatus(OrderConstant.AUDIT);
		}else if(op.equals("stockOut"))
		{
			order.setStatus(OrderConstant.LACK);
		}else if(op.equals("cancel"))
		{
			order.setStatus(OrderConstant.CANCEL);
		}else if(op.equals("send"))
		{
			order.setStatus(OrderConstant.TRANSPORT);
			/**
			 * 设置发货时间
			 */
			order.setSendTime(date);

		}else if(op.equals("arrive"))
		{
			order.setStatus(OrderConstant.ARRIVE);
			/**
			 * 设置商品送达时间
			 */
			order.setArriveTime(date);
		}else if(op.equals("receive"))
		{
			order.setStatus(OrderConstant.RECEIVE);
			/**
			 * 设置商品签收时间
			 */
			order.setShouTime(date);
		}else if(op.equals("takeOver"))
		{
			order.setStatus(OrderConstant.FINISH);
			/**
			 * 设置订单完成时间
			 */
			order.setFinishTime(date);
		}else
		{
			return ResponseEntity.ok(ResponseResult.fail(ResultCode.FILED_VALUE_INVALID));

		}

		if(taoOrderService.updateTaoOrder(order)==0)
		{
			return ResponseEntity.ok(ResponseResult.fail(ResultCode.DATA_UPDATE_ERROR));
		}
		return ResponseEntity.ok(ResponseResult.ok("操作成功"));

	}
	
//	/**
//	 * 删除订单
//	 */
//
//	@PostMapping( "/remove")
//	@ResponseBody
//	public ResponseEntity remove(String ids)
//	{
//		return ResponseEntity.ok(ResponseResult.ok(taoOrderService.deleteTaoOrderByIds(ids)));
//	}
	
}
