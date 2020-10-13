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
import com.transample.demo.domain.TaoCompany;
import com.transample.demo.service.ITaoCompanyService;
import com.transample.demo.common.ResponseResult;

/**
 * 物流公司 信息操作处理
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Controller
@RequestMapping("/taoCompany")
public class TaoCompanyController
{
    private String prefix = "taoCompany";
	
	@Autowired
	private ITaoCompanyService taoCompanyService;
	
	@GetMapping()
	public String taoCompany()
	{
	    return prefix + "/taoCompany";
	}
	
	/**
	 * 查询物流公司列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public List<TaoCompany> list(TaoCompany taoCompany)
	{
        List<TaoCompany> list = taoCompanyService.selectTaoCompanyList(taoCompany);
		return list;
	}
	
	
	/**
	 * 新增物流公司
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存物流公司
	 */
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity addSave(TaoCompany taoCompany)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoCompanyService.insertTaoCompany(taoCompany)));
	}

	/**
	 * 修改物流公司
	 */
	@GetMapping("/edit/{companyId}")
	public String edit(@PathVariable("companyId") Integer companyId, ModelMap mmap)
	{
		TaoCompany taoCompany = taoCompanyService.selectTaoCompanyById(companyId);
		mmap.put("taoCompany", taoCompany);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存物流公司
	 */
	@PostMapping("/edit")
	@ResponseBody
	public ResponseEntity editSave(TaoCompany taoCompany)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoCompanyService.updateTaoCompany(taoCompany)));
	}
	
	/**
	 * 删除物流公司
	 */

	@PostMapping( "/remove")
	@ResponseBody
	public ResponseEntity remove(String ids)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoCompanyService.deleteTaoCompanyByIds(ids)));
	}
	
}
