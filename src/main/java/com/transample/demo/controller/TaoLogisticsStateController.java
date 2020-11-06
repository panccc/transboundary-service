package com.transample.demo.controller;

import java.util.*;

import com.transample.demo.annotation.ApiQualityLog;
import com.transample.demo.common.ResultCode;
import com.transample.demo.constants.OrderConstant;
import com.transample.demo.domain.TaoLogistics;
import com.transample.demo.domain.TaoOrder;
import com.transample.demo.service.ITaoLogisticsService;
import com.transample.demo.service.ITaoOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.transample.demo.domain.TaoLogisticsState;
import com.transample.demo.service.ITaoLogisticsStateService;
import com.transample.demo.common.ResponseResult;

import javax.annotation.Resource;

/**
 * 物流状态 信息操作处理
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Api(tags = "物流状态相关API")
//@CrossOrigin
@RestController
@RequestMapping("/taoLogisticsState")
public class TaoLogisticsStateController
{
    private String prefix = "taoLogisticsState";
	
	@Resource
	private ITaoLogisticsStateService taoLogisticsStateService;

	@Resource
	private ITaoLogisticsService taoLogisticsService;

	@Resource
	private ITaoOrderService taoOrderService;
	
//	@GetMapping()
//	public String taoLogisticsState()
//	{
//	    return prefix + "/taoLogisticsState";
//	}
	
	/**
	 * 查询物流状态列表
	 */
	@ApiOperation("按照物流单号查询物流状态列表")
	@PostMapping("/list/{ticketId}")
	@ResponseBody
	public List<TaoLogisticsState> list(@PathVariable @ApiParam(value = "物流单号",required = true) String ticketId)
	{
        TaoLogisticsState taoLogisticsState = new TaoLogisticsState();
        taoLogisticsState.setTicketId(ticketId);
		List<TaoLogisticsState> list = taoLogisticsStateService.selectTaoLogisticsStateList(taoLogisticsState);
		return list;
	}
	
	
//	/**
//	 * 新增物流状态
//	 */
//	@GetMapping("/add")
//	public String add()
//	{
//	    return prefix + "/add";
//	}
//
	/**
	 * 新增保存物流状态
	 */
	@ApiQualityLog(methodDesc = "新增物流状态",indexParams = "firstLogisticTime,secondLogisticTime,damaged")
	@ApiOperation("新增物流状态")
	@PostMapping("/add/{ticketId}")
	public ResponseEntity addLogisticsState(@PathVariable @ApiParam(value = "物流单号",required = true) String ticketId, @RequestBody TaoLogisticsState taoLogisticsState)
	{
		taoLogisticsState.setTicketId(ticketId);
		int res = taoLogisticsStateService.insertTaoLogisticsState(taoLogisticsState);
		if(res==0)
		{
			ResponseEntity.ok(ResponseResult.fail(ResultCode.DATA_CREATE_ERROR));
		}
		/**
		 * 更新订单状态
		 */
		TaoLogistics logistics = taoLogisticsService.selectTaoLogisticsById(ticketId);
		TaoOrder order = new TaoOrder();
		order.setOrderId(Integer.parseInt(logistics.getOrderId()));
		switch (taoLogisticsState.getCurState())
		{
			case "已下单":
				order.setStatus(OrderConstant.TRANSPORT);
				order.setSendTime(new Date());
				break;
			case "待取件":
				order.setStatus(OrderConstant.ARRIVE);
				order.setArriveTime(new Date());
				break;
			case "已签收":
				order.setStatus(OrderConstant.RECEIVE);
				order.setShouTime(new Date());
				break;
			default:
				return ResponseEntity.ok(ResponseResult.ok(ResultCode.OK));
		}
		res = taoOrderService.updateTaoOrder(order);
		if(res==0)
		{
			return ResponseEntity.ok(ResponseResult.fail(ResultCode.DATA_UPDATE_ERROR));
		}

		/*
		 * 感知逻辑（业务无关）
		 */
		HashMap<String,String> indexes=new HashMap<>();
		TaoOrder order1=taoOrderService.selectTaoOrderById(order.getOrderId());
//		一级时间
		Date sendTime=order1.getSendTime();
		Date arriveTime=order1.getArriveTime();
		Date receiveTime=order1.getShouTime();
		if(sendTime!=null&&arriveTime!=null)
			indexes.put("firstLogisticTime",Long.toString(arriveTime.getTime()-sendTime.getTime()));
//		二级时间
		if(receiveTime!=null&&arriveTime!=null)
			indexes.put("secondLogisticTime",Long.toString(receiveTime.getTime()-arriveTime.getTime()));
		if(taoLogisticsState.getCurState().equals("已签收")){
			//		签收是否破损（随机）
			Random r=new Random(10);
			int a = r.nextInt(100);//随机产生[0,100)的整数，每个数字出现的概率为1%
			int b,c;
			if(a< 10){ //前10个数字的区间，代表10%的几率
				b = 0;
			}else{//(10,100)，10个数字区间，代表92%的几率
				b =1;
			}
			indexes.put("damaged",Integer.toString(b));
			if(a< 10) c=1;
			else if(a<20) c=2;
			else if(a<40) c=3;
			else if(a<75) c=4;
			else c=5;
			indexes.put("distributorGrade", Integer.toString(c));
		}


		indexes.put("orderId",order.getOrderId().toString());

		return ResponseEntity.ok(ResponseResult.ok(ResultCode.OK,indexes));
	}

	/**
	 * 修改物流状态
	 */
	@ApiOperation("更新前返回给前端的必要信息")
	@GetMapping("/getInfoBeforeEdit/{ticketId}")
	public ResponseEntity getInfoBeforeEdit(@PathVariable("ticketId") Integer id)
	{
		TaoLogisticsState taoLogisticsState = taoLogisticsStateService.selectTaoLogisticsStateById(id);
		if(taoLogisticsState==null)
		{
			return ResponseEntity.ok(ResponseResult.fail(ResultCode.OBJECT_NOT_EXIST));
		}

	    return ResponseEntity.ok(ResponseResult.ok(taoLogisticsState));
	}
	
	/**
	 * 修改保存物流状态
	 */
	@ApiOperation("修改物流状态")
	@PostMapping("/edit")
	public ResponseEntity editLogisticsState(TaoLogisticsState taoLogisticsState)
	{		
		return ResponseEntity.ok(ResponseResult.ok(taoLogisticsStateService.updateTaoLogisticsState(taoLogisticsState)));
	}
	
//	/**
//	 * 删除物流状态
//	 */
//	@PostMapping( "/remove")
//	@ResponseBody
//	public ResponseEntity remove(String ids)
//	{
//		return ResponseEntity.ok(ResponseResult.ok(taoLogisticsStateService.deleteTaoLogisticsStateByIds(ids)));
//	}
	
}
