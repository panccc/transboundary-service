package com.transample.demo.domain;


import java.util.Date;

/**
 * 村站表 tao_station
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
public class TaoStation
{
	
	/** 	村站ID */
	private Integer stationId;
	/** 	村站名称 */
	private String stationName;
	/** 	村站地址 */
	private String stationAddr;
	/** 所属省份 */
	private String provence;
	/** 所属城市 */
	private String city;
	/** 所属县/区 */
	private String county;
	/** 所属村 */
	private String village;
	/** 二阶物流公司ID */
	private Integer companyId;
	/** 二阶物流公司名称 */
	private String companyName;
	/** 	创建时间 */
	private Date createTime;
	/** 	更新时间 */
	private Date updateTime;

	public void setStationId(Integer stationId) 
	{
		this.stationId = stationId;
	}

	public Integer getStationId() 
	{
		return stationId;
	}
	public void setStationName(String stationName) 
	{
		this.stationName = stationName;
	}

	public String getStationName() 
	{
		return stationName;
	}
	public void setStationAddr(String stationAddr) 
	{
		this.stationAddr = stationAddr;
	}

	public String getStationAddr() 
	{
		return stationAddr;
	}
	public void setProvence(String provence) 
	{
		this.provence = provence;
	}

	public String getProvence() 
	{
		return provence;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}

	public String getCity() 
	{
		return city;
	}
	public void setCounty(String county) 
	{
		this.county = county;
	}

	public String getCounty() 
	{
		return county;
	}
	public void setVillage(String village) 
	{
		this.village = village;
	}

	public String getVillage() 
	{
		return village;
	}
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
