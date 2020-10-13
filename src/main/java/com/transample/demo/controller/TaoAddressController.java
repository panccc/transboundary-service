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
import com.transample.demo.domain.TaoAddress;
import com.transample.demo.service.ITaoAddressService;
import com.transample.demo.common.ResponseResult;

/**
 * 全国省市村统计 信息操作处理
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Controller
@RequestMapping("/taoAddress")
public class TaoAddressController
{
    private String prefix = "taoAddress";
	
	@Autowired
	private ITaoAddressService taoAddressService;
	
	@GetMapping()
	public String taoAddress()
	{
	    return prefix + "/taoAddress";
	}
	
	/**
	 * 查询全国省市村统计列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public List<TaoAddress> list(TaoAddress taoAddress)
	{
        List<TaoAddress> list = taoAddressService.selectTaoAddressList(taoAddress);
		return list;
	}
	
	
	/**
	 * 新增全国省市村统计
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存全国省市村统计
	 */
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity addSave(TaoAddress taoAddress)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoAddressService.insertTaoAddress(taoAddress)));
	}

	/**
	 * 修改全国省市村统计
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TaoAddress taoAddress = taoAddressService.selectTaoAddressById(id);
		mmap.put("taoAddress", taoAddress);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存全国省市村统计
	 */
	@PostMapping("/edit")
	@ResponseBody
	public ResponseEntity editSave(TaoAddress taoAddress)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoAddressService.updateTaoAddress(taoAddress)));
	}
	
	/**
	 * 删除全国省市村统计
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public ResponseEntity remove(String ids)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoAddressService.deleteTaoAddressByIds(ids)));
	}
	
}
