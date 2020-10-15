package com.transample.demo.service;

import com.transample.demo.domain.TaoStation;
import java.util.List;

/**
 * 村站 服务层
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
public interface ITaoStationService 
{
	/**
     * 查询村站信息
     * 
     * @param stationId 村站ID
     * @return 村站信息
     */
	public TaoStation getTaoStationById(Integer stationId);
	
	/**
     * 查询村站列表
     * 
     * @param taoStation 村站信息
     * @return 村站集合
     */
	public List<TaoStation> getTaoStationList(TaoStation taoStation);
	
	/**
     * 新增村站
     * 
     * @param taoStation 村站信息
     * @return 结果
     */
	public int insertTaoStation(TaoStation taoStation);
	
	/**
     * 修改村站
     * 
     * @param taoStation 村站信息
     * @return 结果
     */
	public int updateTaoStation(TaoStation taoStation);
		
	/**
     * 删除村站信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaoStationByIds(String ids);
	
}
