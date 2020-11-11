package com.transample.demo.controller;

import java.util.List;

import com.transample.demo.common.ResultCode;
import com.transample.demo.utils.JSONUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.transample.demo.domain.TaoAddress;
import com.transample.demo.service.ITaoAddressService;
import com.transample.demo.common.ResponseResult;

/**
 * 全国省市村统计 信息操作处理
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
//@CrossOrigin
@RestController
@RequestMapping("/taoAddress")
public class TaoAddressController
{
    private String prefix = "taoAddress";
	
	@Autowired
	private ITaoAddressService taoAddressService;
	
//	@GetMapping()
//	public String taoAddress()
//	{
//	    return prefix + "/taoAddress";
//	}
	
	/**
	 * 查询全国省的列表
	 */
	@ApiOperation("获取全国省的列表")
	@GetMapping("/getProvinceList")
	public ResponseEntity getProvinceList()
	{
        List<TaoAddress> list = taoAddressService.getAllProvince();
		return ResponseEntity.ok(ResponseResult.ok(list));
	}


	@ApiOperation("获取城市的列表根据省名")
	@GetMapping("/getCityList/{province}")
	public ResponseEntity getCityList(@PathVariable String province)
	{
		List<TaoAddress> list = taoAddressService.getCityListByProvince(province);
		return ResponseEntity.ok(ResponseResult.ok(list));
	}

	@ApiOperation("获取该县区的列表根据省市名")
	@GetMapping("/getCountryList/{province}/{city}")
	public ResponseEntity getCountyList(@PathVariable String province,@PathVariable String city)
	{
		List<TaoAddress> list = taoAddressService.getCountyListByProvinceAndCity(province, city);
		return ResponseEntity.ok(ResponseResult.ok(list));
	}

	@ApiOperation("获取该镇的列表根据省市县名")
	@GetMapping("/getTownList/{province}/{city}/{county}")
	public ResponseEntity getTownList(@PathVariable String province,@PathVariable String city,@PathVariable String county)
	{
		List<TaoAddress> list = taoAddressService.getTownListByProvinceAndCityAndCounty(province, city, county);
		return ResponseEntity.ok(ResponseResult.ok(list));
	}

	@ApiOperation("获取村的列表根据省市县镇名")
	@GetMapping("/getVillageList/{province}/{city}/{county}/{town}")
	public ResponseEntity getVillageList(@PathVariable String province,@PathVariable String city,@PathVariable String county,@PathVariable String town)
	{
		List<TaoAddress> list = taoAddressService.getVillageListByProvinceAndCityAndCountyAndTown(province, city, county, town);
		return ResponseEntity.ok(ResponseResult.ok(list));
	}




	
//
//	/**
//	 * 新增全国省市村统计
//	 */
//	@GetMapping("/add")
//	public String add()
//	{
//	    return prefix + "/add";
//	}
	
	/**
	 * 新增保存全国省市村统计
	 */
//	@PostMapping("/add")
//	@ResponseBody
//	public ResponseEntity addSave(TaoAddress taoAddress)
//	{
//		return ResponseEntity.ok(ResponseResult.ok(taoAddressService.insertTaoAddress(taoAddress)));
//	}

//	/**
//	 * 修改全国省市村统计
//	 */
//	@GetMapping("/edit/{id}")
//	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
//	{
//		TaoAddress taoAddress = taoAddressService.selectTaoAddressById(id);
//		mmap.put("taoAddress", taoAddress);
//	    return prefix + "/edit";
//	}
//
//	/**
//	 * 修改保存全国省市村统计
//	 */
//	@PostMapping("/edit")
//	@ResponseBody
//	public ResponseEntity editSave(TaoAddress taoAddress)
//	{
//		return ResponseEntity.ok(ResponseResult.ok(taoAddressService.updateTaoAddress(taoAddress)));
//	}
	
//	/**
//	 * 删除全国省市村统计
//	 */
//	@PostMapping( "/remove")
//	@ResponseBody
//	public ResponseEntity remove(String ids)
//	{
//		return ResponseEntity.ok(ResponseResult.ok(taoAddressService.deleteTaoAddressByIds(ids)));
//	}

//	@PostMapping("/insert")
//	@ResponseBody
//	public ResponseEntity insert(@RequestParam("fileName") String fileName)
//	{
//		String base = "C:\\Users\\Administrator\\PycharmProjects\\pythonProject\\data";
//		List<String> files = JSONUtils.getFileList(base);
//
//		taoAddressService.insertTaoAddressListFromJson(fileName);
//		return ResponseEntity.ok(ResponseResult.ok(ResultCode.OK));
//	}
//	@PostMapping("/insert")
//	@ResponseBody
//	public ResponseEntity insert(String province, String url)
//	{
////		String base = "C:\\Users\\Administrator\\PycharmProjects\\pythonProject\\data";
////		List<String> files = JSONUtils.getFileList(base);
//		return ResponseEntity.ok(ResponseResult.ok(taoAddressService.insertAddressBySpider(province,url)));
//	}
}
