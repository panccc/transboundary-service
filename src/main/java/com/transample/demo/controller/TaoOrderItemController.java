package com.transample.demo.controller;

import java.util.List;

import io.swagger.annotations.ApiOperation;
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
@Controller
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
	public List<TaoOrderItem> list(@RequestBody TaoOrderItem taoOrderItem)
	{
        List<TaoOrderItem> list = taoOrderItemService.selectTaoOrderItemList(taoOrderItem);
		return list;
	}
	
	
	/**
	 * 新增订单单类商品
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存订单单类商品
	 */
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity addSave(TaoOrderItem taoOrderItem)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoOrderItemService.insertTaoOrderItem(taoOrderItem)));
	}

	/**
	 * 修改订单单类商品
	 */
	@GetMapping("/edit/{orderItemId}")
	public String edit(@PathVariable("orderItemId") Integer orderItemId, ModelMap mmap)
	{
		TaoOrderItem taoOrderItem = taoOrderItemService.selectTaoOrderItemById(orderItemId);
		mmap.put("taoOrderItem", taoOrderItem);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存订单单类商品
	 */
	@PostMapping("/edit")
	@ResponseBody
	public ResponseEntity editSave(TaoOrderItem taoOrderItem)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoOrderItemService.updateTaoOrderItem(taoOrderItem)));
	}
	
	/**
	 * 删除订单单类商品
	 */

	@PostMapping( "/remove")
	@ResponseBody
	public ResponseEntity remove(String ids)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoOrderItemService.deleteTaoOrderItemByIds(ids)));
	}
	
}
