package com.transample.demo.dto;


import com.transample.demo.domain.TaoOrder;
import com.transample.demo.domain.TaoOrderItem;
import lombok.Data;

import java.util.List;
@Data
public class OrderDTO {

    /**
     * 下单时的DTO
     */
    TaoOrder order;

    List<TaoOrderItem> orderItemList;



}
