package com.transample.demo.controller;

import java.util.List;

import com.transample.demo.common.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
@RestController
//@CrossOrigin
@Api(tags = "物流公司API")
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
	@ApiOperation(value = "查询物流公司列表 按照物流公司类型查找")
	@GetMapping("/list")
	public ResponseEntity list(@RequestParam @ApiParam(value = "物流公司类型 1常规， 2县村",required = true) Integer companyType)
	{
		TaoCompany taoCompany = new TaoCompany();
		if(companyType==1)
		{
			taoCompany.setCompanyType("城市物流");
		}else if(companyType==2)
		{
			taoCompany.setCompanyType("县乡村物流");
		}
		return ResponseEntity.ok(ResponseResult.ok(taoCompanyService.selectTaoCompanyList(taoCompany)));
	}
	
	
	/**
	 * 新增时需要反显给前端的信息
	 */
	@ApiOperation("新增时需要反显给前端的信息,待确认")
	@GetMapping("/getInfoBeforeAdd")
	public String getInfoBeforeAdd()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存物流公司
	 */
	@ApiOperation(value = "新增保存物流公司")
	@PostMapping("/add")
	public ResponseEntity addCompany(@RequestBody  TaoCompany taoCompany)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoCompanyService.insertTaoCompany(taoCompany)));
	}

	/**
	 * 修改物流公司
	 */
	@ApiOperation(value = "修改物流公司，返回物流公司的基本信息")
	@GetMapping("/getInfoBeforeEdit")
	public ResponseEntity getInfoBeforeEdit(@RequestParam("companyId") Integer companyId)
	{
		TaoCompany taoCompany = taoCompanyService.selectTaoCompanyById(companyId);
		if(taoCompany==null)
		{
			return ResponseEntity.ok(ResponseResult.fail(ResultCode.FILED_VALUE_INVALID));
		}

		return ResponseEntity.ok(ResponseResult.ok(taoCompany));
//	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存物流公司
	 */
	@ApiOperation(value = "修改保存物流公司，返回状态")
	@PostMapping("/edit")
	public ResponseEntity editCompany(@RequestBody TaoCompany taoCompany)
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
