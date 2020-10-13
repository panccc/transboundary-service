package com.transample.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transample.demo.mapper.TaoShoppingCartMapper;
import com.transample.demo.domain.TaoShoppingCart;
import com.transample.demo.service.ITaoShoppingCartService;

/**
 * 购物车 服务层实现
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Service
public class TaoShoppingCartServiceImpl implements ITaoShoppingCartService 
{
	@Autowired
	private TaoShoppingCartMapper taoShoppingCartMapper;

	/**
     * 查询购物车信息
     * 
     * @param cartId 购物车ID
     * @return 购物车信息
     */
    @Override
	public TaoShoppingCart selectTaoShoppingCartById(Integer cartId)
	{
	    return taoShoppingCartMapper.selectTaoShoppingCartById(cartId);
	}
	
	/**
     * 查询购物车列表
     * 
     * @param taoShoppingCart 购物车信息
     * @return 购物车集合
     */
	@Override
	public List<TaoShoppingCart> selectTaoShoppingCartList(TaoShoppingCart taoShoppingCart)
	{
	    return taoShoppingCartMapper.selectTaoShoppingCartList(taoShoppingCart);
	}
	
    /**
     * 新增购物车
     * 
     * @param taoShoppingCart 购物车信息
     * @return 结果
     */
	@Override
	public int insertTaoShoppingCart(TaoShoppingCart taoShoppingCart)
	{
	    return taoShoppingCartMapper.insertTaoShoppingCart(taoShoppingCart);
	}
	
	/**
     * 修改购物车
     * 
     * @param taoShoppingCart 购物车信息
     * @return 结果
     */
	@Override
	public int updateTaoShoppingCart(TaoShoppingCart taoShoppingCart)
	{
	    return taoShoppingCartMapper.updateTaoShoppingCart(taoShoppingCart);
	}

	/**
     * 删除购物车对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTaoShoppingCartByIds(String ids)
	{
		return taoShoppingCartMapper.deleteTaoShoppingCartByIds(ids.split(","));
	}
	
}
