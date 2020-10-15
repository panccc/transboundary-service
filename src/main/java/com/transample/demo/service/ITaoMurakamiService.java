package com.transample.demo.service;

import com.transample.demo.domain.TaoMurakami;
import java.util.List;

/**
 * 村小二 服务层
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
public interface ITaoMurakamiService 
{
	/**
     * 查询村小二信息
     * 
     * @param murakamiId 村小二ID
     * @return 村小二信息
     */
	public TaoMurakami getTaoMurakamiById(Integer murakamiId);
	
	/**
     * 查询村小二列表
     * 
     * @param taoMurakami 村小二信息
     * @return 村小二集合
     */
	public List<TaoMurakami> getTaoMurakamiList(TaoMurakami taoMurakami);
	
	/**
     * 新增村小二
     * 
     * @param taoMurakami 村小二信息
     * @return 结果
     */
	public int insertTaoMurakami(TaoMurakami taoMurakami);
	
	/**
     * 修改村小二
     * 
     * @param taoMurakami 村小二信息
     * @return 结果
     */
	public int updateTaoMurakami(TaoMurakami taoMurakami);
		
	/**
     * 删除村小二信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaoMurakamiByIds(String ids);
	
}
