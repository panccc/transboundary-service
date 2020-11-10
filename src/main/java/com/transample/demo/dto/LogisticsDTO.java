package com.transample.demo.dto;

import com.transample.demo.domain.TaoLogistics;
import com.transample.demo.domain.TaoLogisticsState;
import lombok.Data;

import java.util.List;


@Data
public class LogisticsDTO {
    private TaoLogistics logistics;
    private List<TaoLogisticsState> logisticsStateList;


}
