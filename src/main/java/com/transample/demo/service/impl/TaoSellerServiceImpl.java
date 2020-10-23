package com.transample.demo.service.impl;

import java.util.List;

import com.transample.demo.domain.TaoMurakami;
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

    @Override
	public TaoSeller getTaoSellerById(Integer sellerId)
	{
	    return taoSellerMapper.selectTaoSellerById(sellerId);
	}
	
	@Override
	public List<TaoSeller> getTaoSellerList(TaoSeller taoSeller)
	{
	    return taoSellerMapper.selectTaoSellerList(taoSeller);
	}
	
	@Override
	public int insertTaoSeller(TaoSeller taoSeller)
	{
	    return taoSellerMapper.insertTaoSeller(taoSeller);
	}
	
	@Override
	public int updateTaoSeller(TaoSeller taoSeller)
	{
	    return taoSellerMapper.updateTaoSeller(taoSeller);
	}

	@Override
	public int deleteTaoSellerByIds(String ids)
	{
		return taoSellerMapper.deleteTaoSellerByIds(ids.split(","));
	}

	@Override
	public TaoSeller login(TaoSeller taoSeller) {
		TaoSeller seller = new TaoSeller();
		seller.setSellerName(taoSeller.getSellerName());
		List<TaoSeller> sellers = taoSellerMapper.selectTaoSellerList(seller);
		if (sellers.size() == 1 && sellers.get(0).getPassword().equals(taoSeller.getPassword())) {
			return sellers.get(0);
		} else {
			return null;
		}
	}

}
