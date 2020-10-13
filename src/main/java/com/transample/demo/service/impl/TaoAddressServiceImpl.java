package com.transample.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transample.demo.mapper.TaoAddressMapper;
import com.transample.demo.domain.TaoAddress;
import com.transample.demo.service.ITaoAddressService;

/**
 * 全国省市村统计 服务层实现
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Service
public class TaoAddressServiceImpl implements ITaoAddressService 
{
	@Autowired
	private TaoAddressMapper taoAddressMapper;

	/**
     * 查询全国省市村统计信息
     * 
     * @param id 全国省市村统计ID
     * @return 全国省市村统计信息
     */
    @Override
	public TaoAddress selectTaoAddressById(Integer id)
	{
	    return taoAddressMapper.selectTaoAddressById(id);
	}
	
	/**
     * 查询全国省市村统计列表
     * 
     * @param taoAddress 全国省市村统计信息
     * @return 全国省市村统计集合
     */
	@Override
	public List<TaoAddress> selectTaoAddressList(TaoAddress taoAddress)
	{
	    return taoAddressMapper.selectTaoAddressList(taoAddress);
	}
	
    /**
     * 新增全国省市村统计
     * 
     * @param taoAddress 全国省市村统计信息
     * @return 结果
     */
	@Override
	public int insertTaoAddress(TaoAddress taoAddress)
	{
	    return taoAddressMapper.insertTaoAddress(taoAddress);
	}
	
	/**
     * 修改全国省市村统计
     * 
     * @param taoAddress 全国省市村统计信息
     * @return 结果
     */
	@Override
	public int updateTaoAddress(TaoAddress taoAddress)
	{
	    return taoAddressMapper.updateTaoAddress(taoAddress);
	}

	/**
     * 删除全国省市村统计对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTaoAddressByIds(String ids)
	{
		String[] strss=ids.split(",");
		return taoAddressMapper.deleteTaoAddressByIds(strss);
	}
	
}
