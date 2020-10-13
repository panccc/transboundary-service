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
import com.transample.demo.domain.TaoVillager;
import com.transample.demo.service.ITaoVillagerService;
import com.transample.demo.common.ResponseResult;

/**
 * 村民 信息操作处理
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Controller
@RequestMapping("/taoVillager")
public class TaoVillagerController
{
    private String prefix = "taoVillager";
	
	@Autowired
	private ITaoVillagerService taoVillagerService;
	
	@GetMapping()
	public String taoVillager()
	{
	    return prefix + "/taoVillager";
	}
	
	/**
	 * 查询村民列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public List<TaoVillager> list(TaoVillager taoVillager)
	{
        List<TaoVillager> list = taoVillagerService.selectTaoVillagerList(taoVillager);
		return list;
	}
	
	
	/**
	 * 新增村民
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存村民
	 */
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity addSave(TaoVillager taoVillager)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoVillagerService.insertTaoVillager(taoVillager)));
	}

	/**
	 * 修改村民
	 */
	@GetMapping("/edit/{villagerId}")
	public String edit(@PathVariable("villagerId") Integer villagerId, ModelMap mmap)
	{
		TaoVillager taoVillager = taoVillagerService.selectTaoVillagerById(villagerId);
		mmap.put("taoVillager", taoVillager);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存村民
	 */
	@PostMapping("/edit")
	@ResponseBody
	public ResponseEntity editSave(TaoVillager taoVillager)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoVillagerService.updateTaoVillager(taoVillager)));
	}
	
	/**
	 * 删除村民
	 */

	@PostMapping( "/remove")
	@ResponseBody
	public ResponseEntity remove(String ids)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoVillagerService.deleteTaoVillagerByIds(ids)));
	}
	
}
