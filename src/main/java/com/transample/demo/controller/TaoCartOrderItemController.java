package com.transample.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.transample.demo.domain.TaoCartOrderItem;
import com.transample.demo.service.ITaoCartOrderItemService;
import com.transample.demo.common.ResponseResult;

/**
 * 购物车单类商品 信息操作处理
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Controller
@RequestMapping("/taoCartOrderItem")
public class TaoCartOrderItemController
{
    private String prefix = "taoCartOrderItem";
	
	@Autowired
	private ITaoCartOrderItemService taoCartOrderItemService;
	
	@GetMapping()
	public String taoCartOrderItem()
	{
	    return prefix + "/taoCartOrderItem";
	}
	
	/**
	 * 查询购物车单类商品列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public List<TaoCartOrderItem> list(TaoCartOrderItem taoCartOrderItem)
	{
        List<TaoCartOrderItem> list = taoCartOrderItemService.selectTaoCartOrderItemList(taoCartOrderItem);
		return list;
	}
	
	
	/**
	 * 新增购物车单类商品
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存购物车单类商品
	 */
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity addSave(TaoCartOrderItem taoCartOrderItem)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoCartOrderItemService.insertTaoCartOrderItem(taoCartOrderItem)));
	}

	/**
	 * 修改购物车单类商品
	 */
	@GetMapping("/edit/{orderItemId}")
	public String edit(@PathVariable("orderItemId") Integer orderItemId, ModelMap mmap)
	{
		TaoCartOrderItem taoCartOrderItem = taoCartOrderItemService.selectTaoCartOrderItemById(orderItemId);
		mmap.put("taoCartOrderItem", taoCartOrderItem);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存购物车单类商品
	 */
	@PostMapping("/edit")
	@ResponseBody
	public ResponseEntity editSave(TaoCartOrderItem taoCartOrderItem)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoCartOrderItemService.updateTaoCartOrderItem(taoCartOrderItem)));
	}
	
	/**
	 * 删除购物车单类商品
	 */

	@PostMapping( "/remove")
	@ResponseBody
	public ResponseEntity remove(String ids)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoCartOrderItemService.deleteTaoCartOrderItemByIds(ids)));
	}
	
}
