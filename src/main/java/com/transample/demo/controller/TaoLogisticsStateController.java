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
import com.transample.demo.domain.TaoLogisticsState;
import com.transample.demo.service.ITaoLogisticsStateService;
import com.transample.demo.common.ResponseResult;

/**
 * 物流状态 信息操作处理
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Controller
@RequestMapping("/taoLogisticsState")
public class TaoLogisticsStateController
{
    private String prefix = "taoLogisticsState";
	
	@Autowired
	private ITaoLogisticsStateService taoLogisticsStateService;
	
	@GetMapping()
	public String taoLogisticsState()
	{
	    return prefix + "/taoLogisticsState";
	}
	
	/**
	 * 查询物流状态列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public List<TaoLogisticsState> list(TaoLogisticsState taoLogisticsState)
	{
        List<TaoLogisticsState> list = taoLogisticsStateService.selectTaoLogisticsStateList(taoLogisticsState);
		return list;
	}
	
	
	/**
	 * 新增物流状态
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存物流状态
	 */
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity addSave(TaoLogisticsState taoLogisticsState)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoLogisticsStateService.insertTaoLogisticsState(taoLogisticsState)));
	}

	/**
	 * 修改物流状态
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TaoLogisticsState taoLogisticsState = taoLogisticsStateService.selectTaoLogisticsStateById(id);
		mmap.put("taoLogisticsState", taoLogisticsState);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存物流状态
	 */
	@PostMapping("/edit")
	@ResponseBody
	public ResponseEntity editSave(TaoLogisticsState taoLogisticsState)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoLogisticsStateService.updateTaoLogisticsState(taoLogisticsState)));
	}
	
	/**
	 * 删除物流状态
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public ResponseEntity remove(String ids)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoLogisticsStateService.deleteTaoLogisticsStateByIds(ids)));
	}
	
}
