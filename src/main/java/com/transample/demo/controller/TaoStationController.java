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
import com.transample.demo.domain.TaoStation;
import com.transample.demo.service.ITaoStationService;
import com.transample.demo.common.ResponseResult;

/**
 * 村站 信息操作处理
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Controller
@RequestMapping("/taoStation")
public class TaoStationController
{
    private String prefix = "taoStation";
	
	@Autowired
	private ITaoStationService taoStationService;
	
	@GetMapping()
	public String taoStation()
	{
	    return prefix + "/taoStation";
	}
	
	/**
	 * 查询村站列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public List<TaoStation> list(TaoStation taoStation)
	{
        List<TaoStation> list = taoStationService.selectTaoStationList(taoStation);
		return list;
	}
	
	
	/**
	 * 新增村站
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存村站
	 */
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity addSave(TaoStation taoStation)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoStationService.insertTaoStation(taoStation)));
	}

	/**
	 * 修改村站
	 */
	@GetMapping("/edit/{stationId}")
	public String edit(@PathVariable("stationId") Integer stationId, ModelMap mmap)
	{
		TaoStation taoStation = taoStationService.selectTaoStationById(stationId);
		mmap.put("taoStation", taoStation);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存村站
	 */
	@PostMapping("/edit")
	@ResponseBody
	public ResponseEntity editSave(TaoStation taoStation)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoStationService.updateTaoStation(taoStation)));
	}
	
	/**
	 * 删除村站
	 */

	@PostMapping( "/remove")
	@ResponseBody
	public ResponseEntity remove(String ids)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoStationService.deleteTaoStationByIds(ids)));
	}
	
}
