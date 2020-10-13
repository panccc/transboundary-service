package com.transample.demo.mapper;

import com.transample.demo.domain.TaoMurakami;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 村小二 数据层
 * 
 * @author youcaihua
 * @date 2020-10-13
 */

public interface TaoMurakamiMapper 
{
	/**
     * 查询村小二信息
     * 
     * @param murakamiId 村小二ID
     * @return 村小二信息
     */
	public TaoMurakami selectTaoMurakamiById(Integer murakamiId);
	
	/**
     * 查询村小二列表
     * 
     * @param taoMurakami 村小二信息
     * @return 村小二集合
     */
	public List<TaoMurakami> selectTaoMurakamiList(TaoMurakami taoMurakami);
	
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
     * 删除村小二
     * 
     * @param murakamiId 村小二ID
     * @return 结果
     */
	public int deleteTaoMurakamiById(Integer murakamiId);
	
	/**
     * 批量删除村小二
     * 
     * @param murakamiIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaoMurakamiByIds(String[] murakamiIds);
	
}