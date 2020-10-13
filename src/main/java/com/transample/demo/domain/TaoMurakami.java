package com.transample.demo.domain;


import java.util.Date;

/**
 * 村小二表 tao_murakami
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
public class TaoMurakami
{
	
	/** 	村小二ID */
	private Integer murakamiId;
	/** 服务村站ID */
	private Integer stationId;
	/** 村站名称 */
	private String stationName;
	/** 	村小二姓名 */
	private String murakamiName;
	/** 	村小二联系方式 */
	private String murakamiTel;
	/** 	创建时间 */
	private Date createTime;
	/** 登录密码 */
	private String password;

	public void setMurakamiId(Integer murakamiId) 
	{
		this.murakamiId = murakamiId;
	}

	public Integer getMurakamiId() 
	{
		return murakamiId;
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
	public void setMurakamiName(String murakamiName) 
	{
		this.murakamiName = murakamiName;
	}

	public String getMurakamiName() 
	{
		return murakamiName;
	}
	public void setMurakamiTel(String murakamiTel) 
	{
		this.murakamiTel = murakamiTel;
	}

	public String getMurakamiTel() 
	{
		return murakamiTel;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
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
