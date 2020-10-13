package com.transample.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transample.demo.mapper.TaoCompanyMapper;
import com.transample.demo.domain.TaoCompany;
import com.transample.demo.service.ITaoCompanyService;

/**
 * 物流公司 服务层实现
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Service
public class TaoCompanyServiceImpl implements ITaoCompanyService 
{
	@Autowired
	private TaoCompanyMapper taoCompanyMapper;

	/**
     * 查询物流公司信息
     * 
     * @param companyId 物流公司ID
     * @return 物流公司信息
     */
    @Override
	public TaoCompany selectTaoCompanyById(Integer companyId)
	{
	    return taoCompanyMapper.selectTaoCompanyById(companyId);
	}
	
	/**
     * 查询物流公司列表
     * 
     * @param taoCompany 物流公司信息
     * @return 物流公司集合
     */
	@Override
	public List<TaoCompany> selectTaoCompanyList(TaoCompany taoCompany)
	{
	    return taoCompanyMapper.selectTaoCompanyList(taoCompany);
	}
	
    /**
     * 新增物流公司
     * 
     * @param taoCompany 物流公司信息
     * @return 结果
     */
	@Override
	public int insertTaoCompany(TaoCompany taoCompany)
	{
	    return taoCompanyMapper.insertTaoCompany(taoCompany);
	}
	
	/**
     * 修改物流公司
     * 
     * @param taoCompany 物流公司信息
     * @return 结果
     */
	@Override
	public int updateTaoCompany(TaoCompany taoCompany)
	{
	    return taoCompanyMapper.updateTaoCompany(taoCompany);
	}

	/**
     * 删除物流公司对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTaoCompanyByIds(String ids)
	{
		return taoCompanyMapper.deleteTaoCompanyByIds(ids.split(","));
	}
	
}
