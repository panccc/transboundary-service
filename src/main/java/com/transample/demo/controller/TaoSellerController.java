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
import com.transample.demo.domain.TaoSeller;
import com.transample.demo.service.ITaoSellerService;
import com.transample.demo.common.ResponseResult;

/**
 * 商家 信息操作处理
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Controller
@RequestMapping("/taoSeller")
public class TaoSellerController
{
    private String prefix = "taoSeller";
	
	@Autowired
	private ITaoSellerService taoSellerService;
	
	@GetMapping()
	public String taoSeller()
	{
	    return prefix + "/taoSeller";
	}
	
	/**
	 * 查询商家列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public List<TaoSeller> list(TaoSeller taoSeller)
	{
        List<TaoSeller> list = taoSellerService.selectTaoSellerList(taoSeller);
		return list;
	}
	
	
	/**
	 * 新增商家
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商家
	 */
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity addSave(TaoSeller taoSeller)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoSellerService.insertTaoSeller(taoSeller)));
	}

	/**
	 * 修改商家
	 */
	@GetMapping("/edit/{sellerId}")
	public String edit(@PathVariable("sellerId") Integer sellerId, ModelMap mmap)
	{
		TaoSeller taoSeller = taoSellerService.selectTaoSellerById(sellerId);
		mmap.put("taoSeller", taoSeller);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商家
	 */
	@PostMapping("/edit")
	@ResponseBody
	public ResponseEntity editSave(TaoSeller taoSeller)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoSellerService.updateTaoSeller(taoSeller)));
	}
	
	/**
	 * 删除商家
	 */

	@PostMapping( "/remove")
	@ResponseBody
	public ResponseEntity remove(String ids)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoSellerService.deleteTaoSellerByIds(ids)));
	}
	
}
