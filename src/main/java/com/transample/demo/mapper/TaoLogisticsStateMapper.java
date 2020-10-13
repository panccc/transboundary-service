package com.transample.demo.mapper;

import com.transample.demo.domain.TaoLogisticsState;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 物流状态 数据层
 * 
 * @author youcaihua
 * @date 2020-10-13
 */

public interface TaoLogisticsStateMapper 
{
	/**
     * 查询物流状态信息
     * 
     * @param id 物流状态ID
     * @return 物流状态信息
     */
	public TaoLogisticsState selectTaoLogisticsStateById(Integer id);
	
	/**
     * 查询物流状态列表
     * 
     * @param taoLogisticsState 物流状态信息
     * @return 物流状态集合
     */
	public List<TaoLogisticsState> selectTaoLogisticsStateList(TaoLogisticsState taoLogisticsState);
	
	/**
     * 新增物流状态
     * 
     * @param taoLogisticsState 物流状态信息
     * @return 结果
     */
	public int insertTaoLogisticsState(TaoLogisticsState taoLogisticsState);
	
	/**
     * 修改物流状态
     * 
     * @param taoLogisticsState 物流状态信息
     * @return 结果
     */
	public int updateTaoLogisticsState(TaoLogisticsState taoLogisticsState);
	
	/**
     * 删除物流状态
     * 
     * @param id 物流状态ID
     * @return 结果
     */
	public int deleteTaoLogisticsStateById(Integer id);
	
	/**
     * 批量删除物流状态
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaoLogisticsStateByIds(String[] ids);
	
}