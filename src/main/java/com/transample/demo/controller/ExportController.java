package com.transample.demo.controller;/*
 * @Author: panc
 * @Date:2020/11/20 16:56*/


import com.transample.demo.common.ResponseResult;
import com.transample.demo.domain.*;
import com.transample.demo.mapper.TaoOrderMapper;
import com.transample.demo.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/export")
@Api(tags = "数据相关API")
public class ExportController {

    @Autowired
    private ITaoOrderService taoOrderService;

    @Autowired
    private ITaoVillagerService taoVillagerService;

    @Autowired
    private ITaoSellerService taoSellerService;

    @Autowired
    private ITaoLogisticsService taoLogisticsService;

    @Autowired
    private ITaoLogisticsStateService taoLogisticsStateService;
    /**
     * 查询订单统计信息
     */
    @ApiOperation("中控统计信息")
    @GetMapping("/getOrdersInfo")
    public ResponseEntity getOrdersInfo() {
        TaoOrder taoOrder=new TaoOrder();
        TaoVillager taoVillager=new TaoVillager();
        Map<String,String> ordersInfoMap=new HashMap<>();
        List<TaoOrder> list=taoOrderService.selectTaoOrderList(taoOrder);
        List<TaoVillager> taoVillagerList=taoVillagerService.getTaoVillagerList(taoVillager);
//        获取当前月份
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int month = cal.get(Calendar.MONTH) + 1;
//        订单总数以及订单总额
        int totalOrders=0;
        BigDecimal totalPrice=new BigDecimal("0");
        
        for(TaoOrder order:list){
            if(order.getCreateTime()!=null&&month==order.getCreateTime().getMonth()+1){
                totalOrders++;
                totalPrice=totalPrice.add(order.getTotalPrice());
            }
        }

        ordersInfoMap.put("totalOrdersPerMonth",String.valueOf(totalOrders));
        ordersInfoMap.put("totalPricePerMonth",totalPrice.toString());
        ordersInfoMap.put("totalVillager",String.valueOf(taoVillagerList.size()));
        return ResponseEntity.ok(ResponseResult.ok(ordersInfoMap));
    }

    /**
     * 农村淘宝指标信息
     */
    @ApiOperation("农村淘宝指标信息")
    @GetMapping("/getCuntaoInfo")
    public ResponseEntity getCuntaoInfo() {
        TaoOrder taoOrder=new TaoOrder();
        TaoVillager taoVillager=new TaoVillager();
        Map<String,Object> ordersInfoMap=new HashMap<>();
        List<TaoOrder> list=taoOrderService.selectTaoOrderList(taoOrder);
        List<TaoVillager> taoVillagerList=taoVillagerService.getTaoVillagerList(taoVillager);
        int listSize=list.size();
//        获取当前月份,日期
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        Date today=cal.getTime();

        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);



//        日均下单会员数(近五日)
        Map<Date,Integer> orderNum=new HashMap<>();
        for(TaoOrder order:list){
            Date createTime=order.getCreateTime();
            if(createTime==null) continue;
            try {
                if(getDayDiffer(createTime,today)<5&&getDayDiffer(createTime,today)>=0){
                    int ordersNum=orderNum.getOrDefault(parseDate(createTime),0);
                    orderNum.put(parseDate(createTime),ordersNum+1);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        /*对于当天没有销量的补0*/
        for(int i=0;i<=4;i++){
            Date tmpTime=cal.getTime();
            try {
                Date dayTime=parseDate(tmpTime);
                orderNum.putIfAbsent(dayTime,0);
                cal.add(Calendar.DAY_OF_MONTH,-1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

//        客单价
        int totalOrders=0;
        double pricePerOrder=0;
        BigDecimal totalPrice=new BigDecimal("0");

        for(TaoOrder order:list){
            if(order.getCreateTime()!=null&&month==order.getCreateTime().getMonth()+1){
                totalOrders++;
                totalPrice=totalPrice.add(order.getTotalPrice());
            }
        }
        pricePerOrder=totalPrice.doubleValue()/totalOrders;

//        商家平均订单量
        double ordersPerMerchant=(double)listSize/taoSellerService.getTaoSellerList(new TaoSeller()).size();


//        指标整合
        ordersInfoMap.put("orderNumPerDay",orderNum);
        ordersInfoMap.put("pricePerOrder",pricePerOrder);
        ordersInfoMap.put("ordersPerMerchant",ordersPerMerchant);
        return ResponseEntity.ok(ResponseResult.ok(ordersInfoMap));
    }


    /**
     * 菜鸟物流指标信息
     */
    @ApiOperation("菜鸟物流指标信息")
    @GetMapping("/getCainiaoLogisticsInfo")
    public ResponseEntity getCainiaoLogisticsInfo() {
        TaoOrder taoOrder=new TaoOrder();
        TaoVillager taoVillager=new TaoVillager();
        Map<String,Object> ordersInfoMap=new HashMap<>();
//        寄件量
        List<TaoLogistics> logisticsList=taoLogisticsService.selectTaoLogisticsList(new TaoLogistics());
        int cityDeliveryVolume=0;
//        收寄营业额
        double cityDeliveryTurnover=0;
        for(TaoLogistics taoLogistics:logisticsList) {
            if (taoLogistics.getCompanyType().equals("城市物流")) {
                cityDeliveryVolume++;
                cityDeliveryTurnover += taoLogistics.getPrice()!=null?taoLogistics.getPrice().doubleValue():0;
            }
        }
//      运输准时率（五天准时）
        List<TaoLogisticsState> taoLogisticsStateList=taoLogisticsStateService.selectTaoLogisticsStateList(new TaoLogisticsState());
        Map<String,Map<String,Date>> logisticsIdMap=new HashMap<>();
        double cityOnTimeDeliveryRate=0;
//        平均运输时长
        double aveDeliveryTime=0;
        for(TaoLogisticsState taoLogisticsState:taoLogisticsStateList){
            String ticketId=taoLogisticsState.getTicketId();
            if(taoLogisticsState.getCurState().equals("已发出")||taoLogisticsState.getCurState().equals("已送达")){
                Map<String,Date> tmpMap=logisticsIdMap.getOrDefault(ticketId,new HashMap<>());
                tmpMap.put(taoLogisticsState.getCurState(),taoLogisticsState.getUpdateTime());
                logisticsIdMap.put(ticketId,tmpMap);
            }
        }
        int onTimes=0;
        int totalDay=0;
        int finishDeliveryOrders=0;
        /*超时阈值*/
        int dayThreshold=5;
        for(Map<String,Date> map:logisticsIdMap.values()){
            Date sendTime=map.get("已发出");
            Date arriveTime=map.get("已送达");
            if(sendTime==null||arriveTime==null) continue;
            /*计算已经完成配送的订单数*/
            finishDeliveryOrders++;
            try {
                totalDay+=getDayDiffer(sendTime,arriveTime)+1;
                if(getDayDiffer(sendTime,arriveTime)<dayThreshold)
                    onTimes++;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        cityOnTimeDeliveryRate=((double)onTimes/finishDeliveryOrders)*100;
        aveDeliveryTime=((double)totalDay)/logisticsIdMap.size();
//        指标整合
        ordersInfoMap.put("cityDeliveryVolume",cityDeliveryVolume);
        ordersInfoMap.put("cityOnTimeDeliveryRate",cityOnTimeDeliveryRate);
        ordersInfoMap.put("aveDeliveryTime",aveDeliveryTime);
        ordersInfoMap.put("cityDeliveryTurnover",cityDeliveryTurnover);

        return ResponseEntity.ok(ResponseResult.ok(ordersInfoMap));
    }

//    获取两个日期的天数差异
    public  int getDayDiffer(Date startDate, Date endDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long startDateTime = dateFormat.parse(dateFormat.format(startDate)).getTime();
        long endDateTime = dateFormat.parse(dateFormat.format(endDate)).getTime();
        return (int) ((endDateTime - startDateTime) / (1000 * 3600 * 24));
    }
//    转为"yyyy-MM-dd"
    public Date parseDate(Date time)throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTime = dateFormat.parse(dateFormat.format(time));
        return dateTime;
    }
}
