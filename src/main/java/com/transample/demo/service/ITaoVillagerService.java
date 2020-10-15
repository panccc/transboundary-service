package com.transample.demo.service;

import com.transample.demo.domain.TaoVillager;
import java.util.List;

/**
 * 村民 服务层
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
public interface ITaoVillagerService 
{
	/**
     * 查询村民信息
     * 
     * @param villagerId 村民ID
     * @return 村民信息
     */
	public TaoVillager getTaoVillagerById(Integer villagerId);
	
	/**
     * 查询村民列表
     * 
     * @param taoVillager 村民信息
     * @return 村民集合
     */
	public List<TaoVillager> getTaoVillagerList(TaoVillager taoVillager);
	
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
     * 删除村民信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaoVillagerByIds(String ids);
	
}
