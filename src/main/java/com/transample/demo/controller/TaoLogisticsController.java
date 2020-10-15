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
import com.transample.demo.domain.TaoLogistics;
import com.transample.demo.service.ITaoLogisticsService;
import com.transample.demo.common.ResponseResult;

/**
 * 物流 信息操作处理
 * 
 * @author youcaihua
 * @date 2020-10-14
 */
@Controller
@RequestMapping("/taoLogistics")
public class TaoLogisticsController
{
    private String prefix = "taoLogistics";
	
	@Autowired
	private ITaoLogisticsService taoLogisticsService;
	
	@GetMapping()
	public String taoLogistics()
	{
	    return prefix + "/taoLogistics";
	}
	
	/**
	 * 查询物流列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public List<TaoLogistics> list(TaoLogistics taoLogistics)
	{
        List<TaoLogistics> list = taoLogisticsService.selectTaoLogisticsList(taoLogistics);
		return list;
	}
	
	/**
	 * 新增物流
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存物流
	 */
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity addSave(TaoLogistics taoLogistics)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoLogisticsService.insertTaoLogistics(taoLogistics)));
	}

	/**
	 * 修改物流
	 */
	@GetMapping("/edit/{ticketId}")
	public String edit(@PathVariable("ticketId") String ticketId, ModelMap mmap)
	{
		TaoLogistics taoLogistics = taoLogisticsService.selectTaoLogisticsById(ticketId);
		mmap.put("taoLogistics", taoLogistics);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存物流
	 */
	@PostMapping("/edit")
	@ResponseBody
	public ResponseEntity editSave(TaoLogistics taoLogistics)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoLogisticsService.updateTaoLogistics(taoLogistics)));
	}
	
	/**
	 * 删除物流
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public ResponseEntity remove(String ids)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoLogisticsService.deleteTaoLogisticsByIds(ids)));
	}
	
}
