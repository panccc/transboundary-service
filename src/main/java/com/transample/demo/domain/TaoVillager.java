package com.transample.demo.domain;


/**
 * 村民表 tao_villager
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
public class TaoVillager
{
	
	/** 村民Id */
	private Integer villagerId;
	/** 用户名 */
	private String userName;
	/** 用户手机 */
	private String mobile;
	/** 详细地址 */
	private String address;
	/** 所属省份 */
	private String provence;
	/** 所属城市 */
	private String city;
	/** 所属县/区 */
	private String county;
	/** 所属村 */
	private String village;
	/** 村站ID */
	private Integer stationId;
	/** 村站名称 */
	private String stationName;
	/** 登录密码 */
	private String password;

	public void setVillagerId(Integer villagerId) 
	{
		this.villagerId = villagerId;
	}

	public Integer getVillagerId() 
	{
		return villagerId;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getUserName() 
	{
		return userName;
	}
	public void setMobile(String mobile) 
	{
		this.mobile = mobile;
	}

	public String getMobile() 
	{
		return mobile;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getAddress() 
	{
		return address;
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
	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getPassword() 
	{
		return password;
	}

}
