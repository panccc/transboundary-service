package com.transample.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.transample.demo.common.ResultCode;
import com.transample.demo.constants.OrderConstant;
import com.transample.demo.domain.TaoLogisticsState;
import com.transample.demo.domain.TaoOrder;
import com.transample.demo.dto.LogisticsDTO;
import com.transample.demo.service.ITaoLogisticsStateService;
import com.transample.demo.service.ITaoOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.transample.demo.domain.TaoLogistics;
import com.transample.demo.service.ITaoLogisticsService;
import com.transample.demo.common.ResponseResult;

import javax.annotation.Resource;

/**
 * 物流 信息操作处理
 * 
 * @author youcaihua
 * @date 2020-10-14
 */
@Api(tags = "物流相关API")
@RestController
//@CrossOrigin
@RequestMapping("/taoLogistics")
public class TaoLogisticsController
{
    private String prefix = "taoLogistics";
	
	@Resource
	private ITaoLogisticsService taoLogisticsService;

	@Resource
	private ITaoLogisticsStateService taoLogisticsStateService;

	@Resource
	private ITaoOrderService taoOrderService;
//	@GetMapping()
//	public String taoLogistics()
//	{
//	    return prefix + "/taoLogistics";
//	}
	
//	/**
//	 * 查询物流列表
//	 */
//	@PostMapping("/list")
//	@ResponseBody
//	public List<TaoLogistics> list(TaoLogistics taoLogistics)
//	{
//        List<TaoLogistics> list = taoLogisticsService.selectTaoLogisticsList(taoLogistics);
//		return list;
//	}
	
	/**
	 * 新增物流
	 */
	@ApiOperation("新增物流信息时返显给前端的信息 待确认")
	@GetMapping("/getInfoBeforeAdd")
	public String getInfoBeforeAdd()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存物流
	 */
	@ApiOperation("商家发货时，向物流表新增一条记录")
	@PostMapping("/addLogistics")
	public ResponseEntity addLogistics(@RequestBody TaoLogistics taoLogistics)
	{		
		int res1 = taoLogisticsService.insertTaoLogistics(taoLogistics);
		if(res1==0)return ResponseEntity.ok(ResponseResult.fail(ResultCode.DATA_CREATE_ERROR));

		/**
		 * 插入一条物流状态
		 */
		TaoLogisticsState taoLogisticsState = new TaoLogisticsState();
		taoLogisticsState.setTicketId(taoLogistics.getTicketId());
		taoLogisticsState.setCurState("已下单");
		taoLogisticsState.setCreateTime(new Date());
		int res2 = taoLogisticsStateService.insertTaoLogisticsState(taoLogisticsState);
		if(res2==0)return ResponseEntity.ok(ResponseResult.fail(ResultCode.DATA_CREATE_ERROR));

		/**
		 * 更新订单状态
		 */
		TaoOrder order = new TaoOrder();
		order.setOrderId(Integer.parseInt(taoLogistics.getOrderId()));
		order.setStatus(OrderConstant.TRANSPORT);
		order.setSendTime(new Date());

		int res3 = taoOrderService.updateTaoOrder(order);
		if(res3==0)return ResponseEntity.ok(ResponseResult.fail(ResultCode.DATA_UPDATE_ERROR));

		return ResponseEntity.ok(ResponseResult.ok(ResultCode.OK));


	}

	/**
	 * 修改物流
	 */
	@ApiOperation("修改物流时返显给前端的信息，待确认")
	@GetMapping("/getInfoBeforeEdit")
	public ResponseEntity getInfoBeforeEdit(@RequestParam("ticketId") String ticketId, ModelMap mmap)
	{
		TaoLogistics taoLogistics = taoLogisticsService.selectTaoLogisticsById(ticketId);
		if(taoLogistics==null)
		{
			return ResponseEntity.ok(ResponseResult.fail(ResultCode.OBJECT_NOT_EXIST));
		}
	    return ResponseEntity.ok(ResponseResult.ok(taoLogistics));
	}
	
	/**
	 * 修改保存物流
	 */
	@PostMapping("/edit")
	@ResponseBody
	public ResponseEntity editLogistics(TaoLogistics taoLogistics)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoLogisticsService.updateTaoLogistics(taoLogistics)));
	}


	/**
	 * 根据订单id来查询物流信息
	 */
	@ApiOperation("根据订单id来查询物流信息")
	@GetMapping("getLogistics")
	public ResponseEntity getLogisticsById(@RequestParam("orderId") Integer orderId)
	{
		List<TaoLogistics> taoLogisticsList= taoLogisticsService.selectLogisticsByOrderId(orderId);
		if(taoLogisticsList==null)
			return ResponseEntity.ok(ResponseResult.fail(ResultCode.OBJECT_NOT_EXIST));

		List<LogisticsDTO> ans = new ArrayList<>();

		for(int i=0;i<taoLogisticsList.size();i++)
		{
			LogisticsDTO logisticsDTO = new LogisticsDTO();
			logisticsDTO.setLogistics(taoLogisticsList.get(i));
			TaoLogisticsState taoLogisticsState = new TaoLogisticsState();
			taoLogisticsState.setTicketId(taoLogisticsList.get(i).getTicketId());
			List<TaoLogisticsState> logisticsStateList = taoLogisticsStateService.selectTaoLogisticsStateList(taoLogisticsState);
			logisticsDTO.setLogisticsStateList(logisticsStateList);
			ans.add(logisticsDTO);
		}
		return ResponseEntity.ok(ResponseResult.ok(ans));
	}


//	/**
//	 * 删除物流
//	 */
//	@PostMapping( "/remove")
//	@ResponseBody
//	public ResponseEntity remove(String ids)
//	{
//		return ResponseEntity.ok(ResponseResult.ok(taoLogisticsService.deleteTaoLogisticsByIds(ids)));
//	}
	
}
