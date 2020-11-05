package com.transample.demo.mapper;

import com.transample.demo.domain.TaoAddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 全国省市村统计 数据层
 * 
 * @author youcaihua
 * @date 2020-10-13
 */

public interface TaoAddressMapper 
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
     * 删除全国省市村统计
     * 
     * @param id 全国省市村统计ID
     * @return 结果
     */
	public int deleteTaoAddressById(Integer id);
	
	/**
     * 批量删除全国省市村统计
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaoAddressByIds(String[] ids);


	public List<TaoAddress> getAllProvinces();

	public List<TaoAddress> getAllCitiesByProvince(String province);


	public List<TaoAddress> getAllCountiesByProvinceAndCity(@Param("province") String province, @Param("city") String city);


	public List<TaoAddress> getAllTownsByProvinceAndCityAndCounty(@Param("province") String province, @Param("city") String city, @Param("county")String county);

	public List<TaoAddress> getAllVillagesByProvinceAndCityAndCountyAndTown(@Param("province") String province, @Param("city") String city, @Param("county")String county, @Param("town")String town);

}
