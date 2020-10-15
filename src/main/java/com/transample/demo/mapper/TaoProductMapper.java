package com.transample.demo.mapper;

import com.transample.demo.domain.TaoProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品 数据层
 * 
 * @author youcaihua
 * @date 2020-10-13
 */

public interface TaoProductMapper 
{
	/**
     * 查询商品信息
     * 
     * @param productId 商品ID
     * @return 商品信息
     */
	public TaoProduct selectTaoProductById(Integer productId);
	
	/**
     * 查询商品列表
     * 
     * @param taoProduct 商品信息
     * @return 商品集合
     */
	public List<TaoProduct> selectTaoProductList(TaoProduct taoProduct);
	
	/**
     * 新增商品
     * 
     * @param taoProduct 商品信息
     * @return 结果
     */
	public int insertTaoProduct(TaoProduct taoProduct);
	
	/**
     * 修改商品
     * 
     * @param taoProduct 商品信息
     * @return 结果
     */
	public int updateTaoProduct(TaoProduct taoProduct);
	
	/**
     * 删除商品
     * 
     * @param productId 商品ID
     * @return 结果
     */
	public int deleteTaoProductById(Integer productId);
	
	/**
     * 批量删除商品
     * 
     * @param productIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaoProductByIds(String productIds);
	
}