package com.transample.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transample.demo.mapper.TaoSellerMapper;
import com.transample.demo.domain.TaoSeller;
import com.transample.demo.service.ITaoSellerService;

/**
 * 商家 服务层实现
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Service
public class TaoSellerServiceImpl implements ITaoSellerService 
{
	@Autowired
	private TaoSellerMapper taoSellerMapper;

	/**
     * 查询商家信息
     * 
     * @param sellerId 商家ID
     * @return 商家信息
     */
    @Override
	public TaoSeller selectTaoSellerById(Integer sellerId)
	{
	    return taoSellerMapper.selectTaoSellerById(sellerId);
	}
	
	/**
     * 查询商家列表
     * 
     * @param taoSeller 商家信息
     * @return 商家集合
     */
	@Override
	public List<TaoSeller> selectTaoSellerList(TaoSeller taoSeller)
	{
	    return taoSellerMapper.selectTaoSellerList(taoSeller);
	}
	
    /**
     * 新增商家
     * 
     * @param taoSeller 商家信息
     * @return 结果
     */
	@Override
	public int insertTaoSeller(TaoSeller taoSeller)
	{
	    return taoSellerMapper.insertTaoSeller(taoSeller);
	}
	
	/**
     * 修改商家
     * 
     * @param taoSeller 商家信息
     * @return 结果
     */
	@Override
	public int updateTaoSeller(TaoSeller taoSeller)
	{
	    return taoSellerMapper.updateTaoSeller(taoSeller);
	}

	/**
     * 删除商家对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTaoSellerByIds(String ids)
	{
		return taoSellerMapper.deleteTaoSellerByIds(ids.split(","));
	}
	
}
