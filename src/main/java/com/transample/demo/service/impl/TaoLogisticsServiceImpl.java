package com.transample.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transample.demo.mapper.TaoLogisticsMapper;
import com.transample.demo.domain.TaoLogistics;
import com.transample.demo.service.ITaoLogisticsService;

import javax.annotation.Resource;

/**
 * 物流 服务层实现
 * 
 * @author youcaihua
 * @date 2020-10-14
 */
@Service
public class TaoLogisticsServiceImpl implements ITaoLogisticsService 
{
	@Resource
	private TaoLogisticsMapper taoLogisticsMapper;

	/**
     * 查询物流信息
     * 
     * @param ticketId 物流ID
     * @return 物流信息
     */
    @Override
	public TaoLogistics selectTaoLogisticsById(String ticketId)
	{
	    return taoLogisticsMapper.selectTaoLogisticsById(ticketId);
	}
	
	/**
     * 查询物流列表
     * 
     * @param taoLogistics 物流信息
     * @return 物流集合
     */
	@Override
	public List<TaoLogistics> selectTaoLogisticsList(TaoLogistics taoLogistics)
	{
	    return taoLogisticsMapper.selectTaoLogisticsList(taoLogistics);
	}
	
    /**
     * 新增物流
     * 
     * @param taoLogistics 物流信息
     * @return 结果
     */
	@Override
	public int insertTaoLogistics(TaoLogistics taoLogistics)
	{
	    return taoLogisticsMapper.insertTaoLogistics(taoLogistics);
	}
	
	/**
     * 修改物流
     * 
     * @param taoLogistics 物流信息
     * @return 结果
     */
	@Override
	public int updateTaoLogistics(TaoLogistics taoLogistics)
	{
	    return taoLogisticsMapper.updateTaoLogistics(taoLogistics);
	}

	/**
     * 删除物流对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTaoLogisticsByIds(String ids)
	{
		return taoLogisticsMapper.deleteTaoLogisticsByIds(ids.split(","));
	}
	
}
