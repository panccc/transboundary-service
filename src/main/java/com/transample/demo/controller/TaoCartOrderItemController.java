package com.transample.demo.controller;

import java.util.HashMap;
import java.util.List;

import com.transample.demo.common.ResultCode;
import com.transample.demo.dto.RemoveIdsDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.transample.demo.domain.TaoCartOrderItem;
import com.transample.demo.service.ITaoCartOrderItemService;
import com.transample.demo.common.ResponseResult;

/**
 * 购物车单类商品 信息操作处理
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
//@CrossOrigin
@RestController
@Slf4j
@RequestMapping("/taoCartOrderItem")
@Api(tags = "购物车单类商品相关API")
public class TaoCartOrderItemController
{
    private String prefix = "taoCartOrderItem";
	
	@Autowired
	private ITaoCartOrderItemService taoCartOrderItemService;
	
//	@GetMapping()
//	public String taoCartOrderItem()
//	{
//	    return prefix + "/taoCartOrderItem";
//	}
	
	/**
	 * 查询购物车单类商品列表
	 */
	@ApiOperation("查询购物车单类商品列表")
	@GetMapping("/list/{cartId}")
	public HashMap<Integer,List<TaoCartOrderItem>> getCartList(@PathVariable Integer cartId)
	{


        return taoCartOrderItemService.getCartItemListGroupBySeller(cartId);
	}
	
	
//	/**
//	 * 新增购物车单类商品
//	 */
//	@GetMapping("/add")
//	public String add()
//	{
//	    return prefix + "/add";
//	}
	
	/**
	 * 新增保存购物车单类商品
	 */
	@ApiOperation("新增保存购物车单类商品")
	@PostMapping("/add/{cartId}")
	public ResponseEntity addItem(@ApiParam(value = "购物车id",required = true)@PathVariable("cartId") Integer cartId,@RequestBody TaoCartOrderItem taoCartOrderItem)
	{		
		taoCartOrderItem.setCartId(cartId);

		return ResponseEntity.ok(ResponseResult.ok(taoCartOrderItemService.insertTaoCartOrderItem(taoCartOrderItem)));
	}

	/**
	 * 修改购物车单类商品
	 */
	@ApiOperation("修改购物车单类商品,返回该商品的基本信息")
	@GetMapping("/getInfoBeforeEdit/{orderItemId}")
	public ResponseEntity getInfoBeforeEdit(@PathVariable("orderItemId") @ApiParam(value = "订单单个商品号",required = true) Integer orderItemId)
	{
		TaoCartOrderItem taoCartOrderItem = taoCartOrderItemService.selectTaoCartOrderItemById(orderItemId);
		if(taoCartOrderItem==null)return ResponseEntity.ok(ResponseResult.fail(ResultCode.FILED_VALUE_INVALID));


		return ResponseEntity.ok(ResponseResult.ok(taoCartOrderItem));
//	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存购物车单类商品
	 */
	@ApiOperation("修改购物车单类商品")
	@PostMapping("/edit")
	public ResponseEntity editCart(@RequestBody TaoCartOrderItem taoCartOrderItem)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoCartOrderItemService.updateTaoCartOrderItem(taoCartOrderItem)));
	}
	
	/**
	 * 删除购物车单类商品
	 */
	@ApiOperation("删除购物车单类商品")
	@PostMapping( "/remove")
	public ResponseEntity removeItems(@RequestBody @ApiParam("被删除商品的id字符串，用逗号分隔")RemoveIdsDTO removeIdsDTO)
	{
		if(removeIdsDTO.getIds()==null||removeIdsDTO.getIds().equals(""))return ResponseEntity.ok(ResponseResult.fail(ResultCode.FILED_VALUE_INVALID));

		return ResponseEntity.ok(ResponseResult.ok(taoCartOrderItemService.deleteTaoCartOrderItemByIds(removeIdsDTO.getIds())));
	}
	
}
