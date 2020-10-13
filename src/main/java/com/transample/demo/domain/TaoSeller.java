package com.transample.demo.domain;


/**
 * 商家表 tao_seller
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
public class TaoSeller
{
	
	/** 商家id */
	private Integer sellerId;
	/** 商家描述 */
	private String description;
	/** 	商家分类 */
	private String sellerCategory;
	/** 商家名称店名 */
	private String sellerName;
	/** 商家地址 */
	private String sellerLocation;
	/** 	商家联系电话 */
	private String sellerPhone;
	/** 登录密码 */
	private String password;

	public void setSellerId(Integer sellerId) 
	{
		this.sellerId = sellerId;
	}

	public Integer getSellerId() 
	{
		return sellerId;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	public void setSellerCategory(String sellerCategory) 
	{
		this.sellerCategory = sellerCategory;
	}

	public String getSellerCategory() 
	{
		return sellerCategory;
	}
	public void setSellerName(String sellerName) 
	{
		this.sellerName = sellerName;
	}

	public String getSellerName() 
	{
		return sellerName;
	}
	public void setSellerLocation(String sellerLocation) 
	{
		this.sellerLocation = sellerLocation;
	}

	public String getSellerLocation() 
	{
		return sellerLocation;
	}
	public void setSellerPhone(String sellerPhone) 
	{
		this.sellerPhone = sellerPhone;
	}

	public String getSellerPhone() 
	{
		return sellerPhone;
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
