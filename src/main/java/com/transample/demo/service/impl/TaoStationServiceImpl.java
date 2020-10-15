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

    @Override
	public TaoStation getTaoStationById(Integer stationId) {
	    return taoStationMapper.selectTaoStationById(stationId);
	}
	@Override
	public List<TaoStation> getTaoStationList(TaoStation taoStation) {
	    return taoStationMapper.selectTaoStationList(taoStation);
	}
	
	@Override
	public int insertTaoStation(TaoStation taoStation) {
	    return taoStationMapper.insertTaoStation(taoStation);
	}
	@Override
	public int updateTaoStation(TaoStation taoStation) {
	    return taoStationMapper.updateTaoStation(taoStation);
	}
	@Override
	public int deleteTaoStationByIds(String ids) {
		return taoStationMapper.deleteTaoStationByIds(ids.split(","));
	}
}
