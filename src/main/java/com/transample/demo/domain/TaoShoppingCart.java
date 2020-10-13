package com.transample.demo.domain;


/**
 * 购物车表 tao_shopping_cart
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
public class TaoShoppingCart
{
	
	/** 购物车id */
	private Integer cartId;
	/** 村民id */
	private Integer villagerId;

	public void setCartId(Integer cartId) 
	{
		this.cartId = cartId;
	}

	public Integer getCartId() 
	{
		return cartId;
	}
	public void setVillagerId(Integer villagerId) 
	{
		this.villagerId = villagerId;
	}

	public Integer getVillagerId() 
	{
		return villagerId;
	}

}
