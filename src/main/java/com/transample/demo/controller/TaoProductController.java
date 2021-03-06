package com.transample.demo.controller;

import java.util.HashMap;
import java.util.List;

import com.transample.demo.annotation.ApiQualityLog;
import com.transample.demo.dto.RemoveIdsDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.transample.demo.domain.TaoProduct;
import com.transample.demo.service.ITaoProductService;
import com.transample.demo.common.ResponseResult;

/**
 * 商品 信息操作处理
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
//@CrossOrigin
@RestController
@RequestMapping("/taoProduct")
@Api(tags = "商品相关API")
public class TaoProductController
{

	@Autowired
	private ITaoProductService taoProductService;

	@ApiQualityLog(methodDesc = "查看商品详情",indexParams = "productPageViews",calculateType = "statistics")
	@GetMapping("/getProduct")
	@ApiOperation("通过id获取商品")
	public ResponseEntity<ResponseResult> getProduct(@ApiParam(value = "商品id", required = true) @RequestParam("productId") Integer productId)
	{
		/*
		 * 感知逻辑（业务无关）
		 */
		HashMap<String,String> indexes=new HashMap<>();
		indexes.put("productId",productId.toString());
		return ResponseEntity.ok(ResponseResult.ok(taoProductService.getProductById(productId),indexes));
	}

	@PostMapping("/list")
	@ApiOperation("获取相似商品列表")
	public ResponseEntity<ResponseResult> getProductList(@RequestBody TaoProduct product)
	{
		return ResponseEntity.ok(ResponseResult.ok(taoProductService.getTaoProductList(product)));
	}

	@GetMapping("/getInfoBeforeAdd")
    @ApiOperation("获取系统自动生成的新建商品信息")
	public ResponseEntity<ResponseResult> getInfoBeforeAdd(@RequestParam Integer sellerId)
	{
		return ResponseEntity.ok(ResponseResult.ok(taoProductService.getInfoBeforeAdd(sellerId)));
	}

	@PostMapping("/add")
	@ApiOperation("新增商品")
	public ResponseEntity<ResponseResult> add(@RequestBody TaoProduct taoProduct)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoProductService.addTaoProduct(taoProduct)));
	}

	@GetMapping("/getInfoBeforeEdit")
    @ApiOperation("通过id获取商品信息")
	public ResponseEntity getInfoBeforeEdit(@RequestParam("productId") Integer productId)
	{
		return ResponseEntity.ok(ResponseResult.ok(taoProductService.getInfoBeforeEdit(productId)));
	}
	
	@PostMapping("/edit")
	@ApiOperation("修改商品信息")
	public ResponseEntity<ResponseResult> edit(@RequestBody TaoProduct taoProduct)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoProductService.editTaoProduct(taoProduct)));
	}
	
	@PostMapping("/remove")
	@ApiOperation("删除指定多个id商品")
	public ResponseEntity<ResponseResult> remove(@ApiParam("id字符串") @RequestBody RemoveIdsDTO ids)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoProductService.deleteTaoProductByIds(ids)));
	}

	@GetMapping("/sort")
    @ApiOperation("返回按价格、成交数排序的所有商品")
	public ResponseEntity<ResponseResult> getSortedProducts()
	{
		return ResponseEntity.ok(ResponseResult.ok(taoProductService.getSortedProducts()));
	}

}
