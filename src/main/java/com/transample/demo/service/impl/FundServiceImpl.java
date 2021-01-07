package com.transample.demo.service.impl;

import com.transample.demo.domain.Foundation;
import com.transample.demo.domain.TaoOrder;
import com.transample.demo.domain.TaoOrderItem;
import com.transample.demo.mapper.FoundationMapper;
import com.transample.demo.service.FundService;
import com.transample.demo.service.ITaoOrderItemService;
import com.transample.demo.service.ITaoOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class FundServiceImpl implements FundService {

    @Resource
    FoundationMapper foundationMapper;
    @Resource
    ITaoOrderItemService taoOrderItemService;
    @Resource
    ITaoOrderService taoOrderService;

    @Override
    public double getProfit(Date startTime, Date endTime, double ratio, Integer status) {

        double ans = 0.0;
        List<TaoOrder> orderList = taoOrderService.getTaoOrderByTimeAndStatus(startTime,endTime,status);
        for(TaoOrder order : orderList)
        {
            TaoOrderItem orderItem = new TaoOrderItem();
            orderItem.setOrderId(order.getOrderId());
            List<TaoOrderItem> items = taoOrderItemService.selectTaoOrderItemList(orderItem);
            for(TaoOrderItem item:items)
            {
                ans += item.getAmount()*item.getPrice()*ratio;
            }
        }


        return ans;
    }

    @Override
    public Foundation getFoundation(Integer id) {

        return foundationMapper.selectByPrimaryKey(id);
    }

    @Override
    public Foundation login(Integer id, String password) {
        Foundation foundation = getFoundation(id);
        if(foundation.getPassword().equals(password))return foundation;
        return null;
    }
}
