package com.transample.demo.controller;

import java.util.List;

import com.transample.demo.dto.RemoveIdsDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.transample.demo.domain.TaoSeller;
import com.transample.demo.service.ITaoSellerService;
import com.transample.demo.common.ResponseResult;

/**
 * 商家 信息操作处理
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
//@CrossOrigin
@RestController
@RequestMapping("/taoSeller")
@Api(tags = "商家相关API")
public class TaoSellerController
{

	@Autowired
	private ITaoSellerService taoSellerService;
	
	@PostMapping("/list")
	@ApiOperation("查询商家列表")
	public ResponseEntity<ResponseResult> list(@RequestBody TaoSeller taoSeller)
	{
		return ResponseEntity.ok(ResponseResult.ok(taoSellerService.getTaoSellerList(taoSeller)));
	}

	@GetMapping("/getInfoBeforeAdd")
    @ApiOperation("获取新增商家信息")
	public ResponseEntity<ResponseResult> getInfoBeforeAdd()
	{
		return ResponseEntity.ok(ResponseResult.ok(new TaoSeller()));
	}
	
	@PostMapping("/add")
	@ApiOperation("新增商家")
	public ResponseEntity<ResponseResult> add(@RequestBody TaoSeller taoSeller)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoSellerService.insertTaoSeller(taoSeller)));
	}

	@GetMapping("/getInfoBeforeEdit/{sellerId}")
    @ApiOperation("获取修改商家信息")
	public ResponseEntity<ResponseResult> getInfoBeforeEdit(@PathVariable("sellerId") Integer sellerId)
	{
		return ResponseEntity.ok(ResponseResult.ok(taoSellerService.getTaoSellerById(sellerId)));
	}
	
	@PostMapping("/edit")
	@ApiOperation("修改商家信息")
	public ResponseEntity<ResponseResult> edit(@RequestBody TaoSeller taoSeller)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoSellerService.updateTaoSeller(taoSeller)));
	}
	
	@PostMapping( "/remove")
	@ApiOperation("删除商家")
	public ResponseEntity<ResponseResult> remove(@RequestBody RemoveIdsDTO ids)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoSellerService.deleteTaoSellerByIds(ids.getIds())));
	}

	@PostMapping( "/search/{id}")
	@ApiOperation("查找商家")
	public ResponseEntity<ResponseResult> search(@PathVariable Integer id)
	{
		return ResponseEntity.ok(ResponseResult.ok(taoSellerService.getTaoSellerById(id)));
	}

}
