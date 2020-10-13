package com.transample.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transample.demo.mapper.TaoVillagerMapper;
import com.transample.demo.domain.TaoVillager;
import com.transample.demo.service.ITaoVillagerService;

/**
 * 村民 服务层实现
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Service
public class TaoVillagerServiceImpl implements ITaoVillagerService 
{
	@Autowired
	private TaoVillagerMapper taoVillagerMapper;

	/**
     * 查询村民信息
     * 
     * @param villagerId 村民ID
     * @return 村民信息
     */
    @Override
	public TaoVillager selectTaoVillagerById(Integer villagerId)
	{
	    return taoVillagerMapper.selectTaoVillagerById(villagerId);
	}
	
	/**
     * 查询村民列表
     * 
     * @param taoVillager 村民信息
     * @return 村民集合
     */
	@Override
	public List<TaoVillager> selectTaoVillagerList(TaoVillager taoVillager)
	{
	    return taoVillagerMapper.selectTaoVillagerList(taoVillager);
	}
	
    /**
     * 新增村民
     * 
     * @param taoVillager 村民信息
     * @return 结果
     */
	@Override
	public int insertTaoVillager(TaoVillager taoVillager)
	{
	    return taoVillagerMapper.insertTaoVillager(taoVillager);
	}
	
	/**
     * 修改村民
     * 
     * @param taoVillager 村民信息
     * @return 结果
     */
	@Override
	public int updateTaoVillager(TaoVillager taoVillager)
	{
	    return taoVillagerMapper.updateTaoVillager(taoVillager);
	}

	/**
     * 删除村民对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTaoVillagerByIds(String ids)
	{
		return taoVillagerMapper.deleteTaoVillagerByIds(ids.split(","));
	}
	
}
