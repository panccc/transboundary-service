package com.transample.demo.domain;


/**
 * 购物车单类商品表 tao_cart_order_item
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
public class TaoCartOrderItem
{
	
	/** 订单单个商品号 */
	private Integer orderItemId;
	/** 产品Id */
	private Integer goodsId;
	/** 规格 */
	private String specification;
	/** 数量 */
	private Integer amount;
	/** 价格 */
	private Double price;
	/** 购物车Id */
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
