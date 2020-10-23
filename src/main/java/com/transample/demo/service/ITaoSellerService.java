package com.transample.demo.service;

import com.transample.demo.domain.TaoSeller;
import java.util.List;

/**
 * 商家 服务层
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
public interface ITaoSellerService 
{
	/**
     * 查询商家信息
     * 
     * @param sellerId 商家ID
     * @return 商家信息
     */
	public TaoSeller getTaoSellerById(Integer sellerId);
	
	/**
     * 查询商家列表
     * 
     * @param taoSeller 商家信息
     * @return 商家集合
     */
	public List<TaoSeller> getTaoSellerList(TaoSeller taoSeller);
	
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
     * 删除商家信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaoSellerByIds(String ids);

	/**
	 * 商家登陆
	 *
	 * @param taoSeller 商家信息
	 * @return 是否登陆成功
	 */
	public TaoSeller login(TaoSeller taoSeller);

}
