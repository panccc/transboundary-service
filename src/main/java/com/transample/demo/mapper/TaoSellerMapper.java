package com.transample.demo.mapper;

import com.transample.demo.domain.TaoSeller;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商家 数据层
 * 
 * @author youcaihua
 * @date 2020-10-13
 */

public interface TaoSellerMapper 
{
	/**
     * 查询商家信息
     * 
     * @param sellerId 商家ID
     * @return 商家信息
     */
	public TaoSeller selectTaoSellerById(Integer sellerId);
	
	/**
     * 查询商家列表
     * 
     * @param taoSeller 商家信息
     * @return 商家集合
     */
	public List<TaoSeller> selectTaoSellerList(TaoSeller taoSeller);
	
	/**
     * 新增商家
     * 
     * @param taoSeller 商家信息
     * @return 结果
     */
	public int insertTaoSeller(TaoSeller taoSeller);
	
	/**
     * 修改商家
     * 
     * @param taoSeller 商家信息
     * @return 结果
     */
	public int updateTaoSeller(TaoSeller taoSeller);
	
	/**
     * 删除商家
     * 
     * @param sellerId 商家ID
     * @return 结果
     */
	public int deleteTaoSellerById(Integer sellerId);
	
	/**
     * 批量删除商家
     * 
     * @param sellerIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaoSellerByIds(String[] sellerIds);
	
}