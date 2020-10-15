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

    @Override
	public TaoMurakami getTaoMurakamiById(Integer murakamiId)
	{
	    return taoMurakamiMapper.selectTaoMurakamiById(murakamiId);
	}
	
	@Override
	public List<TaoMurakami> getTaoMurakamiList(TaoMurakami taoMurakami)
	{
	    return taoMurakamiMapper.selectTaoMurakamiList(taoMurakami);
	}

	@Override
	public int insertTaoMurakami(TaoMurakami taoMurakami)
	{
	    return taoMurakamiMapper.insertTaoMurakami(taoMurakami);
	}
	
	@Override
	public int updateTaoMurakami(TaoMurakami taoMurakami)
	{
	    return taoMurakamiMapper.updateTaoMurakami(taoMurakami);
	}

	@Override
	public int deleteTaoMurakamiByIds(String ids)
	{
		return taoMurakamiMapper.deleteTaoMurakamiByIds(ids.split(","));
	}
	
}
