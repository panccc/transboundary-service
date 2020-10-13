package com.transample.demo.mapper;

import com.transample.demo.domain.TaoCompany;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 物流公司 数据层
 * 
 * @author youcaihua
 * @date 2020-10-13
 */

public interface TaoCompanyMapper 
{
	/**
     * 查询物流公司信息
     * 
     * @param companyId 物流公司ID
     * @return 物流公司信息
     */
	public TaoCompany selectTaoCompanyById(Integer companyId);
	
	/**
     * 查询物流公司列表
     * 
     * @param taoCompany 物流公司信息
     * @return 物流公司集合
     */
	public List<TaoCompany> selectTaoCompanyList(TaoCompany taoCompany);
	
	/**
     * 新增物流公司
     * 
     * @param taoCompany 物流公司信息
     * @return 结果
     */
	public int insertTaoCompany(TaoCompany taoCompany);
	
	/**
     * 修改物流公司
     * 
     * @param taoCompany 物流公司信息
     * @return 结果
     */
	public int updateTaoCompany(TaoCompany taoCompany);
	
	/**
     * 删除物流公司
     * 
     * @param companyId 物流公司ID
     * @return 结果
     */
	public int deleteTaoCompanyById(Integer companyId);
	
	/**
     * 批量删除物流公司
     * 
     * @param companyIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaoCompanyByIds(String[] companyIds);
	
}