package com.transample.demo.domain;


/**
 * 商品表 tao_product
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
public class TaoProduct
{
	
	/** 商品图片url地址 */
	private String imgUrl;
	/** 商品id */
	private Integer productId;
	/** 商品名称 */
	private String productName;
	/** 商品分类 */
	private String productCategory;
	/** 商品描述 */
	private String productDescription;
	/** 商品价格 */
	private Double productPrice;
	/** 	商品规格 */
	private String productSpecification;
	/** 成交订单数 */
	private Integer executedOrder;
	/** 删除0/未删除1 */
	private Integer delete;
	/** 商家id */
	private Integer sellerId;

	public void setImgUrl(String imgUrl) 
	{
		this.imgUrl = imgUrl;
	}

	public String getImgUrl() 
	{
		return imgUrl;
	}
	public void setProductId(Integer productId) 
	{
		this.productId = productId;
	}

	public Integer getProductId() 
	{
		return productId;
	}
	public void setProductName(String productName) 
	{
		this.productName = productName;
	}

	public String getProductName() 
	{
		return productName;
	}
	public void setProductCategory(String productCategory) 
	{
		this.productCategory = productCategory;
	}

	public String getProductCategory() 
	{
		return productCategory;
	}
	public void setProductDescription(String productDescription) 
	{
		this.productDescription = productDescription;
	}

	public String getProductDescription() 
	{
		return productDescription;
	}
	public void setProductPrice(Double productPrice)
	{
		this.productPrice = productPrice;
	}

	public Double getProductPrice()
	{
		return productPrice;
	}
	public void setProductSpecification(String productSpecification) 
	{
		this.productSpecification = productSpecification;
	}

	public String getProductSpecification() 
	{
		return productSpecification;
	}
	public void setExecutedOrder(Integer executedOrder) 
	{
		this.executedOrder = executedOrder;
	}

	public Integer getExecutedOrder() 
	{
		return executedOrder;
	}
	public void setDelete(Integer delete) 
	{
		this.delete = delete;
	}

	public Integer getDelete() 
	{
		return delete;
	}
	public void setSellerId(Integer sellerId) 
	{
		this.sellerId = sellerId;
	}

	public Integer getSellerId() 
	{
		return sellerId;
	}

}
