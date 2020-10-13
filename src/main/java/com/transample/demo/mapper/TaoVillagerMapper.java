package com.transample.demo.mapper;

import com.transample.demo.domain.TaoVillager;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 村民 数据层
 * 
 * @author youcaihua
 * @date 2020-10-13
 */

public interface TaoVillagerMapper 
{
	/**
     * 查询村民信息
     * 
     * @param villagerId 村民ID
     * @return 村民信息
     */
	public TaoVillager selectTaoVillagerById(Integer villagerId);
	
	/**
     * 查询村民列表
     * 
     * @param taoVillager 村民信息
     * @return 村民集合
     */
	public List<TaoVillager> selectTaoVillagerList(TaoVillager taoVillager);
	
	/**
     * 新增村民
     * 
     * @param taoVillager 村民信息
     * @return 结果
     */
	public int insertTaoVillager(TaoVillager taoVillager);
	
	/**
     * 修改村民
     * 
     * @param taoVillager 村民信息
     * @return 结果
     */
	public int updateTaoVillager(TaoVillager taoVillager);
	
	/**
     * 删除村民
     * 
     * @param villagerId 村民ID
     * @return 结果
     */
	public int deleteTaoVillagerById(Integer villagerId);
	
	/**
     * 批量删除村民
     * 
     * @param villagerIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaoVillagerByIds(String[] villagerIds);
	
}