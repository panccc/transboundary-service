package com.transample.demo.controller;

import java.util.List;

import com.transample.demo.dto.RemoveIdsDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.transample.demo.domain.TaoVillager;
import com.transample.demo.service.ITaoVillagerService;
import com.transample.demo.common.ResponseResult;

/**
 * 村民 信息操作处理
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@RestController
@RequestMapping("/taoVillager")
@Api(tags = "村民相关API")
public class TaoVillagerController
{

	@Autowired
	private ITaoVillagerService taoVillagerService;
	
	@PostMapping("/list")
    @ApiOperation("查询村民列表")
	public ResponseEntity<ResponseResult> list(@RequestBody TaoVillager taoVillager)
	{
		return ResponseEntity.ok(ResponseResult.ok(taoVillagerService.getTaoVillagerList(taoVillager)));
	}
	
	/**
	 * 新增村民
	 */
	@GetMapping("/getInfoBeforeAdd")
    @ApiOperation("获取新增村民信息")
	public ResponseEntity<ResponseResult> getInfoBeforeAdd()
	{
		return ResponseEntity.ok(ResponseResult.ok(new TaoVillager()));
	}
	
	@PostMapping("/add")
	@ApiOperation("新增村民")
	public ResponseEntity<ResponseResult> add(@RequestBody TaoVillager taoVillager)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoVillagerService.insertTaoVillager(taoVillager)));
	}

	@GetMapping("/edit/{villagerId}")
    @ApiOperation("获取村民信息")
	public ResponseEntity<ResponseResult> getInfoBeforeEdit(@PathVariable("villagerId") Integer villagerId)
	{
		return ResponseEntity.ok(ResponseResult.ok(taoVillagerService.getTaoVillagerById(villagerId)));
	}

	@PostMapping("/edit")
	@ApiOperation("修改村民信息")
	public ResponseEntity<ResponseResult> edit(@RequestBody TaoVillager taoVillager)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoVillagerService.updateTaoVillager(taoVillager)));
	}

	@PostMapping( "/remove")
	@ApiOperation("删除村民")
	public ResponseEntity<ResponseResult> remove(@RequestBody RemoveIdsDTO ids)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoVillagerService.deleteTaoVillagerByIds(ids.getIds())));
	}
	
}
