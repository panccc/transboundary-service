package com.transample.demo.service;

import com.transample.demo.domain.TaoCompany;
import java.util.List;

/**
 * 物流公司 服务层
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
public interface ITaoCompanyService 
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
     * 删除物流公司信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaoCompanyByIds(String ids);
	
}
