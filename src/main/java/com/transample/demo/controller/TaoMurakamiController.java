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
import com.transample.demo.domain.TaoMurakami;
import com.transample.demo.service.ITaoMurakamiService;
import com.transample.demo.common.ResponseResult;

/**
 * 村小二 信息操作处理
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Controller
@RequestMapping("/taoMurakami")
public class TaoMurakamiController
{
    private String prefix = "taoMurakami";
	
	@Autowired
	private ITaoMurakamiService taoMurakamiService;
	
	@GetMapping()
	public String taoMurakami()
	{
	    return prefix + "/taoMurakami";
	}
	
	/**
	 * 查询村小二列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public List<TaoMurakami> list(TaoMurakami taoMurakami)
	{
        List<TaoMurakami> list = taoMurakamiService.selectTaoMurakamiList(taoMurakami);
		return list;
	}
	
	
	/**
	 * 新增村小二
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存村小二
	 */
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity addSave(TaoMurakami taoMurakami)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoMurakamiService.insertTaoMurakami(taoMurakami)));
	}

	/**
	 * 修改村小二
	 */
	@GetMapping("/edit/{murakamiId}")
	public String edit(@PathVariable("murakamiId") Integer murakamiId, ModelMap mmap)
	{
		TaoMurakami taoMurakami = taoMurakamiService.selectTaoMurakamiById(murakamiId);
		mmap.put("taoMurakami", taoMurakami);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存村小二
	 */
	@PostMapping("/edit")
	@ResponseBody
	public ResponseEntity editSave(TaoMurakami taoMurakami)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoMurakamiService.updateTaoMurakami(taoMurakami)));
	}
	
	/**
	 * 删除村小二
	 */

	@PostMapping( "/remove")
	@ResponseBody
	public ResponseEntity remove(String ids)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoMurakamiService.deleteTaoMurakamiByIds(ids)));
	}
	
}
