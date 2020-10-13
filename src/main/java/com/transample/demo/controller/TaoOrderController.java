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
import com.transample.demo.domain.TaoOrder;
import com.transample.demo.service.ITaoOrderService;
import com.transample.demo.common.ResponseResult;

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
	
	@GetMapping()
	public String taoOrder()
	{
	    return prefix + "/taoOrder";
	}
	
	/**
	 * 查询订单列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public List<TaoOrder> list(TaoOrder taoOrder)
	{
        List<TaoOrder> list = taoOrderService.selectTaoOrderList(taoOrder);
		return list;
	}
	
	
	/**
	 * 新增订单
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存订单
	 */
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity addSave(TaoOrder taoOrder)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoOrderService.insertTaoOrder(taoOrder)));
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
