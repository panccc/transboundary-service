package com.transample.demo.service;

import com.transample.demo.domain.TaoAddress;
import java.util.List;

/**
 * 全国省市村统计 服务层
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
public interface ITaoAddressService 
{
	/**
     * 查询全国省市村统计信息
     * 
     * @param id 全国省市村统计ID
     * @return 全国省市村统计信息
     */
	public TaoAddress selectTaoAddressById(Integer id);
	
	/**
     * 查询全国省市村统计列表
     * 
     * @param taoAddress 全国省市村统计信息
     * @return 全国省市村统计集合
     */
	public List<TaoAddress> selectTaoAddressList(TaoAddress taoAddress);
	
	/**
     * 新增全国省市村统计
     * 
     * @param taoAddress 全国省市村统计信息
     * @return 结果
     */
	public int insertTaoAddress(TaoAddress taoAddress);
	
	/**
     * 修改全国省市村统计
     * 
     * @param taoAddress 全国省市村统计信息
     * @return 结果
     */
	public int updateTaoAddress(TaoAddress taoAddress);
		
	/**
     * 删除全国省市村统计信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaoAddressByIds(String ids);

	public void insertTaoAddressListFromJson(String fileName);

	public int insertAddressBySpider(String province,String url);

	/**
	 * 获得所有的省list
	 * @return
	 */
	public List<TaoAddress> getAllProvince();

	/**
	 * 根据省的名字查询所有城市的列表
	 * @param province
	 * @return
	 */
	public List<TaoAddress> getCityListByProvince(String province);

	/**
	 * 根据省市名字查询所有区的列表
	 * @param province
	 * @return
	 */
	public List<TaoAddress> getCountyListByProvinceAndCity(String province,String city);


	/**
	 * 根据省市区名字查询所有镇的列表
	 * @param province
	 * @param city
	 * @param county
	 * @return
	 */
	public List<TaoAddress> getTownListByProvinceAndCityAndCounty(String province,String city,String county);

	/**
	 * 根据省市区镇名字查询所有村的列表
	 * @param province
	 * @param city
	 * @param county
	 * @param town
	 * @return
	 */
	public List<TaoAddress> getVillageListByProvinceAndCityAndCountyAndTown(String province,String city,String county, String town);

}
