package com.transample.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transample.demo.mapper.TaoStationMapper;
import com.transample.demo.domain.TaoStation;
import com.transample.demo.service.ITaoStationService;

/**
 * 村站 服务层实现
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Service
public class TaoStationServiceImpl implements ITaoStationService 
{
	@Autowired
	private TaoStationMapper taoStationMapper;

	/**
     * 查询村站信息
     * 
     * @param stationId 村站ID
     * @return 村站信息
     */
    @Override
	public TaoStation selectTaoStationById(Integer stationId)
	{
	    return taoStationMapper.selectTaoStationById(stationId);
	}
	
	/**
     * 查询村站列表
     * 
     * @param taoStation 村站信息
     * @return 村站集合
     */
	@Override
	public List<TaoStation> selectTaoStationList(TaoStation taoStation)
	{
	    return taoStationMapper.selectTaoStationList(taoStation);
	}
	
    /**
     * 新增村站
     * 
     * @param taoStation 村站信息
     * @return 结果
     */
	@Override
	public int insertTaoStation(TaoStation taoStation)
	{
	    return taoStationMapper.insertTaoStation(taoStation);
	}
	
	/**
     * 修改村站
     * 
     * @param taoStation 村站信息
     * @return 结果
     */
	@Override
	public int updateTaoStation(TaoStation taoStation)
	{
	    return taoStationMapper.updateTaoStation(taoStation);
	}

	/**
     * 删除村站对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTaoStationByIds(String ids)
	{
		return taoStationMapper.deleteTaoStationByIds(ids.split(","));
	}
	
}
