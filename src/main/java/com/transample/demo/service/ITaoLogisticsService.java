package com.transample.demo.service;

import com.transample.demo.domain.TaoLogistics;
import java.util.List;

/**
 * 物流 服务层
 * 
 * @author youcaihua
 * @date 2020-10-14
 */
public interface ITaoLogisticsService 
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
     * 删除物流信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaoLogisticsByIds(String ids);

	/**
	 * 根据订单id来查询物流信息
	 * @param orderId
	 * @return
	 */
	public List<TaoLogistics> selectLogisticsByOrderId(Integer orderId);
	
}
