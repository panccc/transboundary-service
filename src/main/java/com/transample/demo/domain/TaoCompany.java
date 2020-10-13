package com.transample.demo.domain;


import java.util.Date;

/**
 * 物流公司表 tao_company
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
public class TaoCompany
{
	
	/** 物流公司id */
	private Integer companyId;
	/** 物流公司名称 */
	private String companyName;
	/** 物流公司类型（常规/村县） */
	private String companyType;
	/** 	主管姓名 */
	private String supervisorName;
	/** 	主管电话 */
	private String supervisorTel;
	/** 	创建时间 */
	private Date createTime;
	/** 	更新时间 */
	private Date updateTime;

	public void setCompanyId(Integer companyId) 
	{
		this.companyId = companyId;
	}

	public Integer getCompanyId() 
	{
		return companyId;
	}
	public void setCompanyName(String companyName) 
	{
		this.companyName = companyName;
	}

	public String getCompanyName() 
	{
		return companyName;
	}
	public void setCompanyType(String companyType) 
	{
		this.companyType = companyType;
	}

	public String getCompanyType() 
	{
		return companyType;
	}
	public void setSupervisorName(String supervisorName) 
	{
		this.supervisorName = supervisorName;
	}

	public String getSupervisorName() 
	{
		return supervisorName;
	}
	public void setSupervisorTel(String supervisorTel) 
	{
		this.supervisorTel = supervisorTel;
	}

	public String getSupervisorTel() 
	{
		return supervisorTel;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}

}
