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
import com.transample.demo.domain.TaoMurakami;
import com.transample.demo.service.ITaoMurakamiService;
import com.transample.demo.common.ResponseResult;

/**
 * 村小二 信息操作处理
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@RestController
@RequestMapping("/taoMurakami")
@Api(tags = "村小二相关API")
public class TaoMurakamiController
{

	@Autowired
	private ITaoMurakamiService taoMurakamiService;
	
	@PostMapping("/list")
	@ApiOperation("查询村小二列表")
	public ResponseEntity<ResponseResult> list(@RequestBody TaoMurakami taoMurakami) {
		return ResponseEntity.ok(ResponseResult.ok(taoMurakamiService.getTaoMurakamiList(taoMurakami)));
	}
	
	
	@GetMapping("/getInfoBeforeAdd")
    @ApiOperation("获取新增村小二信息")
	public ResponseEntity<ResponseResult> getInfoBeforeAdd() {
		return ResponseEntity.ok(ResponseResult.ok(new TaoMurakami()));
	}
	
	@PostMapping("/add")
	@ApiOperation("新增村小二")
	public ResponseEntity<ResponseResult> add(@RequestBody TaoMurakami taoMurakami)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoMurakamiService.insertTaoMurakami(taoMurakami)));
	}

	@GetMapping("/getInfoBeforeEdit/{murakamiId}")
    @ApiOperation("获取修改村小二信息")
	public ResponseEntity<ResponseResult> getInfoBeforeEdit(@PathVariable("murakamiId") Integer murakamiId)
	{
		return ResponseEntity.ok(ResponseResult.ok(taoMurakamiService.getTaoMurakamiById(murakamiId)));
	}
	
	@PostMapping("/edit")
	@ApiOperation("修改村小二信息")
	public ResponseEntity<ResponseResult> edit(@RequestBody TaoMurakami taoMurakami)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoMurakamiService.updateTaoMurakami(taoMurakami)));
	}
	
	@PostMapping( "/remove")
	@ApiOperation("删除村小二")
	public ResponseEntity<ResponseResult> remove(@RequestBody RemoveIdsDTO ids)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoMurakamiService.deleteTaoMurakamiByIds(ids.getIds())));
	}
	
}
