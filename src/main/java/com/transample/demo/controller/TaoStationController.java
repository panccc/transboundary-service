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
import com.transample.demo.domain.TaoStation;
import com.transample.demo.service.ITaoStationService;
import com.transample.demo.common.ResponseResult;

/**
 * 村站 信息操作处理
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
//@CrossOrigin
@RestController
@RequestMapping("/taoStation")
@Api(tags = "村站相关API")
public class TaoStationController
{

	@Autowired
	private ITaoStationService taoStationService;
	
	@PostMapping("/list")
	@ApiOperation("查询村站列表")
	public ResponseEntity<ResponseResult> list(@RequestBody TaoStation taoStation) {
		return ResponseEntity.ok(ResponseResult.ok(taoStationService.getTaoStationList(taoStation)));
	}
	
	@GetMapping("/getInfoBeforeAdd")
	@ApiOperation("查询插入村站信息")
	public ResponseEntity<ResponseResult> getInfoBeforeAdd() {
		return ResponseEntity.ok(ResponseResult.ok(new TaoStation()));
	}
	
	@PostMapping("/add")
	@ApiOperation("新增村站")
	public ResponseEntity<ResponseResult> add(@RequestBody TaoStation taoStation) {
		return ResponseEntity.ok(ResponseResult.ok(taoStationService.insertTaoStation(taoStation)));
	}

	@GetMapping("/getInfoBeforeEdit")
    @ApiOperation("获取修改村站信息")
	public ResponseEntity<ResponseResult> getInfoBeforeEdit(@RequestParam("stationId") Integer stationId) {
		return ResponseEntity.ok(ResponseResult.ok(taoStationService.getTaoStationById(stationId)));
	}
	
	@PostMapping("/edit")
	@ApiOperation("修改村站信息")
	public ResponseEntity<ResponseResult> edit(@RequestBody TaoStation taoStation)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoStationService.updateTaoStation(taoStation)));
	}
	
	@PostMapping( "/remove")
	@ApiOperation("删除村站信息")
	public ResponseEntity<ResponseResult> remove(@RequestBody RemoveIdsDTO ids)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoStationService.deleteTaoStationByIds(ids.getIds())));
	}
	
}
