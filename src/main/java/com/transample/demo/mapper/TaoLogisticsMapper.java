package com.transample.demo.mapper;

import com.transample.demo.domain.TaoLogistics;
import java.util.List;	

/**
 * 物流 数据层
 * 
 * @author youcaihua
 * @date 2020-10-14
 */
public interface TaoLogisticsMapper
{
	/**
     * 查询物流信息
     * 
     * @param ticketId 物流ID
     * @return 物流信息
     */
	public TaoLogistics selectTaoLogisticsById(String ticketId);
	
	/**
     * 查询物流列表
     * 
     * @param taoLogistics 物流信息
     * @return 物流集合
     */
	public List<TaoLogistics> selectTaoLogisticsList(TaoLogistics taoLogistics);
	
	/**
     * 新增物流
     * 
     * @param taoLogistics 物流信息
     * @return 结果
     */
	public int insertTaoLogistics(TaoLogistics taoLogistics);
	
	/**
     * 修改物流
     * 
     * @param taoLogistics 物流信息
     * @return 结果
     */
	public int updateTaoLogistics(TaoLogistics taoLogistics);
	
	/**
     * 删除物流
     * 
     * @param ticketId 物流ID
     * @return 结果
     */
	public int deleteTaoLogisticsById(String ticketId);
	
	/**
     * 批量删除物流
     * 
     * @param ticketIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaoLogisticsByIds(String[] ticketIds);
	
}