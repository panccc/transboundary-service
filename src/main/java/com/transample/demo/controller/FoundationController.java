package com.transample.demo.controller;

import com.transample.demo.common.ResponseResult;
import com.transample.demo.common.ResultCode;
import com.transample.demo.constants.OrderConstant;
import com.transample.demo.domain.Foundation;
import com.transample.demo.service.FundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Date;

/***
 * 基金相关的接口
 * by maguorong
 * 20210107
 */
@Slf4j
@RestController
@Api(tags = "基金相关API")
@RequestMapping("/fund")
public class FoundationController {

    @Resource
    FundService fundService;

    @ApiOperation("获取基金的详细信息")
    @GetMapping("/info")
    public ResponseEntity getFoundationDetail(@ApiParam(value="基金id 可不填",required = false) @RequestParam(required = false) Integer id)
    {
        if(id==null)id = 123;
        Foundation foundation = fundService.getFoundation(id);
        if(foundation==null)
        {
            return ResponseEntity.ok(ResponseResult.fail(ResultCode.OBJECT_NOT_EXIST));
        }
        return ResponseEntity.ok(ResponseResult.ok(foundation));
    }
    @ApiOperation("获取基金的收入")
    @GetMapping("/getProfit")
    public ResponseEntity getProfit(@ApiParam("查询开始时间（可不填）yyyy-MM-dd") @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd")Date startTime, @ApiParam("查询终止时间（可不填）yyyy-MM-dd") @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd")Date endTime, @ApiParam("订单状态默认为已付款订单，50代表已完成") @RequestParam(required = false) Integer status)
    {
        double ratio = 0.1;
        if (status==null)status=OrderConstant.PAY;
        double ans = fundService.getProfit(startTime,endTime,ratio,status);
        ModelMap modelMap = new ModelMap();
        modelMap.put("profit",ans);
        return ResponseEntity.ok(ResponseResult.ok(modelMap));
    }


}
