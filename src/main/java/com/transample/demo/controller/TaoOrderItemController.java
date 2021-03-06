package com.transample.demo.controller;

import java.util.HashMap;
import java.util.List;

import com.transample.demo.annotation.ApiQualityLog;
import com.transample.demo.common.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.transample.demo.domain.TaoOrderItem;
import com.transample.demo.service.ITaoOrderItemService;
import com.transample.demo.common.ResponseResult;

/**
 * 订单单类商品 信息操作处理
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
//@Controller
@Api(tags = "订单的商品信息相关API")
@RequestMapping("/taoOrderItem")
public class TaoOrderItemController
{
    private String prefix = "taoOrderItem";
	
	@Autowired
	private ITaoOrderItemService taoOrderItemService;
	
//	@GetMapping()
//	public String taoOrderItem()
//	{
//	    return prefix + "/taoOrderItem";
//	}
	
	/**
	 * 查询订单单类商品列表
	 */
	@ApiOperation("查询订单单类商品列表")
	@PostMapping("/list")
	@ResponseBody
	public ResponseEntity getItemList(@RequestBody TaoOrderItem taoOrderItem)
	{
        List<TaoOrderItem> list = taoOrderItemService.selectTaoOrderItemList(taoOrderItem);
		return ResponseEntity.ok(ResponseResult.ok(list));
	}
	
	
//	/**
//	 * 新增订单单类商品
//	 */
//	@GetMapping("/add")
//	public String add()
//	{
//	    return prefix + "/add";
//	}
	
	/**
	 * 新增保存订单单类商品
	 */
	@ApiQualityLog(methodDesc = "商品加入购物车",indexParams = "addCartCount",calculateType = "statistics")
	@ApiOperation("新增保存订单单类商品")
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity addItem(@RequestBody @ApiParam(value = "商品的基本信息",required = true)TaoOrderItem taoOrderItem)
	{		
//		taoOrderItem.setOrderId(orderId);
		/*
		 * 感知逻辑（业务无关）
		 */
		HashMap<String,String> indexes=new HashMap<>();
		indexes.put("productId",taoOrderItem.getGoodsId().toString());
		System.out.println("加入购物车：");
		return ResponseEntity.ok(ResponseResult.ok(taoOrderItemService.insertTaoOrderItem(taoOrderItem),indexes));
	}

	/**
	 * 修改订单单类商品
	 */
	@ApiOperation("获得修改订单单类商品的信息")
	@GetMapping("/getInfoBeforeEdit")
	@ResponseBody
	public ResponseEntity getInfoBeforeEdit(@RequestParam("orderItemId") @ApiParam(value = "生成的订单id",required = true)Integer orderItemId)
	{
		TaoOrderItem taoOrderItem = taoOrderItemService.selectTaoOrderItemById(orderItemId);
		if(taoOrderItem==null)return ResponseEntity.ok(ResponseResult.fail(ResultCode.FILED_VALUE_INVALID));

		return ResponseEntity.ok(ResponseResult.ok(taoOrderItem));
	}
	
	/**
	 * 修改保存订单单类商品
	 */
	@ApiOperation("获得修改订单单类商品的信息")
	@PostMapping("/edit")
	@ResponseBody
	public ResponseEntity editItem(@RequestBody TaoOrderItem taoOrderItem)
	{
		/**
		 * 如果数量为0，则直接调用删除方法
		 */
		if(taoOrderItem.getAmount()==0)return removeItem(String.valueOf(taoOrderItem.getOrderItemId()));

		/**
		 * default
		 */
		return ResponseEntity.ok(ResponseResult.ok(taoOrderItemService.updateTaoOrderItem(taoOrderItem)));
	}
	
	/**
	 * 删除订单单类商品
	 */
	@ApiOperation("删除订单类商品")
	@PostMapping( "/remove")
	@ResponseBody
	public ResponseEntity removeItem(@ApiParam("orderItemId,用逗号隔开") String ids)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoOrderItemService.deleteTaoOrderItemByIds(ids)));
	}
}
