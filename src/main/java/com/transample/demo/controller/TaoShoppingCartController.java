package com.transample.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.transample.demo.domain.TaoShoppingCart;
import com.transample.demo.service.ITaoShoppingCartService;
import com.transample.demo.common.ResponseResult;

/**
 * 购物车 信息操作处理
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
//@CrossOrigin
//@Controller
//@RequestMapping("/taoShoppingCart")
public class TaoShoppingCartController
{
    private String prefix = "taoShoppingCart";
	
	@Autowired
	private ITaoShoppingCartService taoShoppingCartService;
	
	@GetMapping()
	public String taoShoppingCart()
	{
	    return prefix + "/taoShoppingCart";
	}
	
	/**
	 * 查询购物车列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public ResponseEntity list(TaoShoppingCart taoShoppingCart)
	{
        List<TaoShoppingCart> list = taoShoppingCartService.selectTaoShoppingCartList(taoShoppingCart);
		return ResponseEntity.ok(ResponseResult.ok(list));
	}
	
	
	/**
	 * 新增购物车
	 */
//	@GetMapping("/add")
//	public String add()
//	{
//	    return prefix + "/add";
//	}
	
	/**
	 * 新增保存购物车
	 */
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity addSave(TaoShoppingCart taoShoppingCart)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoShoppingCartService.insertTaoShoppingCart(taoShoppingCart)));
	}
//
//	/**
//	 * 修改购物车
//	 */
//	@GetMapping("/edit/{cartId}")
//	public String edit(@PathVariable("cartId") Integer cartId, ModelMap mmap)
//	{
//		TaoShoppingCart taoShoppingCart = taoShoppingCartService.selectTaoShoppingCartById(cartId);
//		mmap.put("taoShoppingCart", taoShoppingCart);
//	    return prefix + "/edit";
//	}
	
	/**
	 * 修改保存购物车
	 */
	@PostMapping("/edit")
	@ResponseBody
	public ResponseEntity editSave(TaoShoppingCart taoShoppingCart)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoShoppingCartService.updateTaoShoppingCart(taoShoppingCart)));
	}
	
	/**
	 * 删除购物车
	 */

	@PostMapping( "/remove")
	@ResponseBody
	public ResponseEntity remove(String ids)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoShoppingCartService.deleteTaoShoppingCartByIds(ids)));
	}
	
}
