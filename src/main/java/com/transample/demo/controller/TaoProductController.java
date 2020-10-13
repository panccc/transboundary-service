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
import com.transample.demo.domain.TaoProduct;
import com.transample.demo.service.ITaoProductService;
import com.transample.demo.common.ResponseResult;

/**
 * 商品 信息操作处理
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Controller
@RequestMapping("/taoProduct")
public class TaoProductController
{
    private String prefix = "taoProduct";
	
	@Autowired
	private ITaoProductService taoProductService;
	
	@GetMapping()
	public String taoProduct()
	{
	    return prefix + "/taoProduct";
	}
	
	/**
	 * 查询商品列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public List<TaoProduct> list(TaoProduct taoProduct)
	{
        List<TaoProduct> list = taoProductService.selectTaoProductList(taoProduct);
		return list;
	}
	
	
	/**
	 * 新增商品
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商品
	 */
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity addSave(TaoProduct taoProduct)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoProductService.insertTaoProduct(taoProduct)));
	}

	/**
	 * 修改商品
	 */
	@GetMapping("/edit/{productId}")
	public String edit(@PathVariable("productId") Integer productId, ModelMap mmap)
	{
		TaoProduct taoProduct = taoProductService.selectTaoProductById(productId);
		mmap.put("taoProduct", taoProduct);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商品
	 */
	@PostMapping("/edit")
	@ResponseBody
	public ResponseEntity editSave(TaoProduct taoProduct)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoProductService.updateTaoProduct(taoProduct)));
	}
	
	/**
	 * 删除商品
	 */

	@PostMapping( "/remove")
	@ResponseBody
	public ResponseEntity remove(String ids)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoProductService.deleteTaoProductByIds(ids)));
	}
	
}
