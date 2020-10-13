package com.transample.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transample.demo.mapper.TaoMurakamiMapper;
import com.transample.demo.domain.TaoMurakami;
import com.transample.demo.service.ITaoMurakamiService;

/**
 * 村小二 服务层实现
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Service
public class TaoMurakamiServiceImpl implements ITaoMurakamiService 
{
	@Autowired
	private TaoMurakamiMapper taoMurakamiMapper;

	/**
     * 查询村小二信息
     * 
     * @param murakamiId 村小二ID
     * @return 村小二信息
     */
    @Override
	public TaoMurakami selectTaoMurakamiById(Integer murakamiId)
	{
	    return taoMurakamiMapper.selectTaoMurakamiById(murakamiId);
	}
	
	/**
     * 查询村小二列表
     * 
     * @param taoMurakami 村小二信息
     * @return 村小二集合
     */
	@Override
	public List<TaoMurakami> selectTaoMurakamiList(TaoMurakami taoMurakami)
	{
	    return taoMurakamiMapper.selectTaoMurakamiList(taoMurakami);
	}
	
    /**
     * 新增村小二
     * 
     * @param taoMurakami 村小二信息
     * @return 结果
     */
	@Override
	public int insertTaoMurakami(TaoMurakami taoMurakami)
	{
	    return taoMurakamiMapper.insertTaoMurakami(taoMurakami);
	}
	
	/**
     * 修改村小二
     * 
     * @param taoMurakami 村小二信息
     * @return 结果
     */
	@Override
	public int updateTaoMurakami(TaoMurakami taoMurakami)
	{
	    return taoMurakamiMapper.updateTaoMurakami(taoMurakami);
	}

	/**
     * 删除村小二对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTaoMurakamiByIds(String ids)
	{
		return taoMurakamiMapper.deleteTaoMurakamiByIds(ids.split(","));
	}
	
}
