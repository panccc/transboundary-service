package com.transample.demo.mapper;

import com.transample.demo.domain.TaoInterface;
import com.transample.demo.domain.TaoInterfaceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaoInterfaceDao {
    long countByExample(TaoInterfaceExample example);

    int deleteByExample(TaoInterfaceExample example);

    int insert(TaoInterface record);

    int insertSelective(TaoInterface record);

    List<TaoInterface> selectByExample(TaoInterfaceExample example);

    int updateByExampleSelective(@Param("record") TaoInterface record, @Param("example") TaoInterfaceExample example);

    int updateByExample(@Param("record") TaoInterface record, @Param("example") TaoInterfaceExample example);
}