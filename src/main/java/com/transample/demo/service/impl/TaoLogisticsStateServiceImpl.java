package com.transample.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transample.demo.mapper.TaoLogisticsStateMapper;
import com.transample.demo.domain.TaoLogisticsState;
import com.transample.demo.service.ITaoLogisticsStateService;

/**
 * 物流状态 服务层实现
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Service
public class TaoLogisticsStateServiceImpl implements ITaoLogisticsStateService 
{
	@Autowired
	private TaoLogisticsStateMapper taoLogisticsStateMapper;

	/**
     * 查询物流状态信息
     * 
     * @param id 物流状态ID
     * @return 物流状态信息
     */
    @Override
	public TaoLogisticsState selectTaoLogisticsStateById(Integer id)
	{
	    return taoLogisticsStateMapper.selectTaoLogisticsStateById(id);
	}
	
	/**
     * 查询物流状态列表
     * 
     * @param taoLogisticsState 物流状态信息
     * @return 物流状态集合
     */
	@Override
	public List<TaoLogisticsState> selectTaoLogisticsStateList(TaoLogisticsState taoLogisticsState)
	{
	    return taoLogisticsStateMapper.selectTaoLogisticsStateList(taoLogisticsState);
	}
	
    /**
     * 新增物流状态
     * 
     * @param taoLogisticsState 物流状态信息
     * @return 结果
     */
	@Override
	public int insertTaoLogisticsState(TaoLogisticsState taoLogisticsState)
	{
	    return taoLogisticsStateMapper.insertTaoLogisticsState(taoLogisticsState);
	}
	
	/**
     * 修改物流状态
     * 
     * @param taoLogisticsState 物流状态信息
     * @return 结果
     */
	@Override
	public int updateTaoLogisticsState(TaoLogisticsState taoLogisticsState)
	{
	    return taoLogisticsStateMapper.updateTaoLogisticsState(taoLogisticsState);
	}

	/**
     * 删除物流状态对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTaoLogisticsStateByIds(String ids)
	{
		return taoLogisticsStateMapper.deleteTaoLogisticsStateByIds(ids.split(","));
	}
	
}
