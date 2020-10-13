package com.transample.demo.mapper;

import com.transample.demo.domain.TaoShoppingCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 购物车 数据层
 * 
 * @author youcaihua
 * @date 2020-10-13
 */

public interface TaoShoppingCartMapper 
{
	/**
     * 查询购物车信息
     * 
     * @param cartId 购物车ID
     * @return 购物车信息
     */
	public TaoShoppingCart selectTaoShoppingCartById(Integer cartId);
	
	/**
     * 查询购物车列表
     * 
     * @param taoShoppingCart 购物车信息
     * @return 购物车集合
     */
	public List<TaoShoppingCart> selectTaoShoppingCartList(TaoShoppingCart taoShoppingCart);
	
	/**
     * 新增购物车
     * 
     * @param taoShoppingCart 购物车信息
     * @return 结果
     */
	public int insertTaoShoppingCart(TaoShoppingCart taoShoppingCart);
	
	/**
     * 修改购物车
     * 
     * @param taoShoppingCart 购物车信息
     * @return 结果
     */
	public int updateTaoShoppingCart(TaoShoppingCart taoShoppingCart);
	
	/**
     * 删除购物车
     * 
     * @param cartId 购物车ID
     * @return 结果
     */
	public int deleteTaoShoppingCartById(Integer cartId);
	
	/**
     * 批量删除购物车
     * 
     * @param cartIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaoShoppingCartByIds(String[] cartIds);
	
}