package com.transample.demo.domain;


import io.swagger.annotations.ApiModelProperty;

/**
 * 购物车单类商品表 tao_cart_order_item
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
public class TaoCartOrderItem
{
	/** 订单单个商品号 */
	@ApiModelProperty("新增时不填")
	private Integer orderItemId;
	/** 产品Id */
	@ApiModelProperty(value = "商品id",required = true)
	private Integer goodsId;
	/** 规格 */
	@ApiModelProperty(value = "规格",required = true)
	private String specification;
	/** 数量 */
	@ApiModelProperty(value = "数量",required = true)
	private Integer amount;
	/** 价格 */
	@ApiModelProperty(value = "价格",required = true)
	private Double price;
	/** 购物车Id */
	@ApiModelProperty(value = "购物车id，与村民id对应，也可传村民id，待确认",required = true)
	private Integer cartId;

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
	public void setCartId(Integer cartId) 
	{
		this.cartId = cartId;
	}

	public Integer getCartId() 
	{
		return cartId;
	}

}
