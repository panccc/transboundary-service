package com.transample.demo.domain;


import io.swagger.annotations.ApiModelProperty;

/**
 * 订单单类商品表 tao_order_item
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
public class TaoOrderItem
{
	
	/** 订单单个商品号 */
	@ApiModelProperty("不填")
	private Integer orderItemId;
	/** 产品Id */
	@ApiModelProperty(value = "商品id",required = true)
	private Integer goodsId;
	/** 规格 */
	@ApiModelProperty(value = "商品规格",required = true)
	private String specification;
	/** 数量 */
	@ApiModelProperty(value = "商品数量",required = true)
	private Integer amount;
	/** 价格 */
	@ApiModelProperty(value = "商品价格,可以不传")
	private Double price;
	/** 订单Id */
	private Integer orderId;

	public void setOrderItemId(Integer orderItemId) 
	{
		this.orderItemId = orderItemId;
	}

	public Integer getOrderItemId() 
	{
		return orderItemId;
	}
	public void setGoodsId(Integer goodsId) 
	{
		this.goodsId = goodsId;
	}

	public Integer getGoodsId() 
	{
		return goodsId;
	}
	public void setSpecification(String specification) 
	{
		this.specification = specification;
	}

	public String getSpecification() 
	{
		return specification;
	}
	public void setAmount(Integer amount) 
	{
		this.amount = amount;
	}

	public Integer getAmount() 
	{
		return amount;
	}
	public void setPrice(Double price)
	{
		this.price = price;
	}

	public Double getPrice()
	{
		return price;
	}
	public void setOrderId(Integer orderId) 
	{
		this.orderId = orderId;
	}

	public Integer getOrderId() 
	{
		return orderId;
	}

}
