package com.transample.demo.controller;

import java.util.List;

import com.transample.demo.common.ResultCode;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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
	
//	@GetMapping()
//	public String taoCompany()
//	{
//	    return prefix + "/taoCompany";
//	}
	
	/**
	 * 查询物流公司列表
	 */
	@ApiOperation(value = "查询物流公司列表 支持模糊查询")
	@PostMapping("/list")
	@ResponseBody
	public List<TaoCompany> list(TaoCompany taoCompany)
	{
        List<TaoCompany> list = taoCompanyService.selectTaoCompanyList(taoCompany);
		return list;
	}
	
	
//	/**
//	 * 新增物流公司
//	 */
//	@GetMapping("/add")
//	public String add()
//	{
//	    return prefix + "/add";
//	}
	
	/**
	 * 新增保存物流公司
	 */
	@ApiOperation(value = "新增保存物流公司")
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity addSave(@RequestBody  TaoCompany taoCompany)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoCompanyService.insertTaoCompany(taoCompany)));
	}

	/**
	 * 修改物流公司
	 */
	@ApiOperation(value = "修改物流公司，返回物流公司的基本信息")
	@GetMapping("/edit/{companyId}")
	public ResponseEntity edit(@PathVariable("companyId") @ApiParam(name = "物流公司的id") Integer companyId, ModelMap mmap)
	{
		TaoCompany taoCompany = taoCompanyService.selectTaoCompanyById(companyId);
		if(taoCompany==null)
		{
			return ResponseEntity.ok(ResponseResult.fail(ResultCode.FILED_VALUE_INVALID));
		}
		mmap.put("taoCompany", taoCompany);
		return ResponseEntity.ok(ResponseResult.ok(mmap));
//	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存物流公司
	 */
	@ApiOperation(value = "修改保存物流公司，返回状态")
	@PostMapping("/edit")
	@ResponseBody
	public ResponseEntity editSave(@RequestBody TaoCompany taoCompany)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoCompanyService.updateTaoCompany(taoCompany)));
	}
	
//	/**
//	 * 删除物流公司
//	 */
//
//	@PostMapping( "/remove")
//	@ResponseBody
//	public ResponseEntity remove(String ids)
//	{
//		return ResponseEntity.ok(ResponseResult.ok(taoCompanyService.deleteTaoCompanyByIds(ids)));
//	}
	
}
