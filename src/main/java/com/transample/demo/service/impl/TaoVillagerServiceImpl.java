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

    @Override
	public TaoVillager getTaoVillagerById(Integer villagerId)
	{
	    return taoVillagerMapper.selectTaoVillagerById(villagerId);
	}
	
	@Override
	public List<TaoVillager> getTaoVillagerList(TaoVillager taoVillager)
	{
	    return taoVillagerMapper.selectTaoVillagerList(taoVillager);
	}
	
	@Override
	public int insertTaoVillager(TaoVillager taoVillager)
	{
	    return taoVillagerMapper.insertTaoVillager(taoVillager);
	}
	
	@Override
	public int updateTaoVillager(TaoVillager taoVillager)
	{
	    return taoVillagerMapper.updateTaoVillager(taoVillager);
	}

	@Override
	public int deleteTaoVillagerByIds(String ids)
	{
		return taoVillagerMapper.deleteTaoVillagerByIds(ids.split(","));
	}

	@Override
	public boolean login(TaoVillager taoVillager) {
        TaoVillager villager = new TaoVillager();
        villager.setUserName(taoVillager.getUserName());
    	List<TaoVillager> villagers = taoVillagerMapper.selectTaoVillagerList(villager);
		return villagers.size() == 1 && villagers.get(0).getPassword().equals(taoVillager.getPassword());
	}

}
