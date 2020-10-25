package com.transample.demo.dto;


import com.transample.demo.domain.TaoOrder;
import com.transample.demo.domain.TaoOrderItem;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
@Data
public class OrderDTO {

    /**
     * 下单时的DTO
     */
    @ApiModelProperty("输入一些订单的基本信息")
    TaoOrder order;

//    List<TaoOrderItem> orderItemList;
    @ApiModelProperty("按照sellerId返回商品的list")
    HashMap<Integer,List<TaoOrderItem>> orderItemHashMap;


}
