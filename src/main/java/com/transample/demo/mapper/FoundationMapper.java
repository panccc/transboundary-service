package com.transample.demo.mapper;

import com.transample.demo.domain.Foundation;
import com.transample.demo.domain.FoundationExample;
import com.transample.demo.domain.FoundationWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FoundationMapper {
    long countByExample(FoundationExample example);

    int deleteByExample(FoundationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FoundationWithBLOBs record);

    int insertSelective(FoundationWithBLOBs record);

    List<FoundationWithBLOBs> selectByExampleWithBLOBs(FoundationExample example);

    List<Foundation> selectByExample(FoundationExample example);

    FoundationWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FoundationWithBLOBs record, @Param("example") FoundationExample example);

    int updateByExampleWithBLOBs(@Param("record") FoundationWithBLOBs record, @Param("example") FoundationExample example);

    int updateByExample(@Param("record") Foundation record, @Param("example") FoundationExample example);

    int updateByPrimaryKeySelective(FoundationWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(FoundationWithBLOBs record);

    int updateByPrimaryKey(Foundation record);
}