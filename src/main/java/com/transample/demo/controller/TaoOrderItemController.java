package com.transample.demo.controller;

import java.util.List;

import com.transample.demo.common.ResultCode;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	public List<TaoOrderItem> getItemList(@RequestBody TaoOrderItem taoOrderItem)
	{
        List<TaoOrderItem> list = taoOrderItemService.selectTaoOrderItemList(taoOrderItem);
		return list;
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
	@ApiOperation("新增保存订单单类商品")
	@PostMapping("/add/{orderId}")
	@ResponseBody
	public ResponseEntity addItem(@PathVariable @ApiParam(value = "生成的订单id",required = true) Integer orderId, @RequestBody @ApiParam(value = "商品的基本信息",required = true)TaoOrderItem taoOrderItem)
	{		
		taoOrderItem.setOrderId(orderId);
		return ResponseEntity.ok(ResponseResult.ok(taoOrderItemService.insertTaoOrderItem(taoOrderItem)));
	}

	/**
	 * 修改订单单类商品
	 */
	@ApiOperation("获得修改订单单类商品的信息")
	@GetMapping("/getInfoBeforeEdit/{orderItemId}")
	@ResponseBody
	public ResponseEntity getInfoBeforeEdit(@PathVariable("orderItemId") @ApiParam(value = "生成的订单id",required = true)Integer orderItemId)
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
