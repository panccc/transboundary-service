package com.transample.demo.mapper;

import com.transample.demo.domain.TaoOrder;
import com.transample.demo.domain.TaoOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaoOrderDao {
    long countByExample(TaoOrderExample example);

    int deleteByExample(TaoOrderExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(TaoOrder record);

    int insertSelective(TaoOrder record);

    List<TaoOrder> selectByExample(TaoOrderExample example);

    TaoOrder selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") TaoOrder record, @Param("example") TaoOrderExample example);

    int updateByExample(@Param("record") TaoOrder record, @Param("example") TaoOrderExample example);

    int updateByPrimaryKeySelective(TaoOrder record);

    int updateByPrimaryKey(TaoOrder record);
}