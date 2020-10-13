package com.transample.demo.domain;


import java.util.Date;

/**
 * 物流表 tao_logistics
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
public class TaoLogistics
{
	
	/** 物流订单号 */
	private String ticketId;
	/** 对应订单号 */
	private String orderId;
	/** 物流价格 */
	private Double price;
	/** 收货地址 */
	private String receiverAddr;
	/** 	收货人姓名 */
	private String receiverName;
	/** 收货人联系方式 */
	private String receiverTel;
	/** 创建时间 */
	private Date createTime;
	/** 	更新时间 */
	private Date updateTime;

	public void setTicketId(String ticketId) 
	{
		this.ticketId = ticketId;
	}

	public String getTicketId() 
	{
		return ticketId;
	}
	public void setOrderId(String orderId) 
	{
		this.orderId = orderId;
	}

	public String getOrderId() 
	{
		return orderId;
	}
	public void setPrice(Double price)
	{
		this.price = price;
	}

	public Double getPrice()
	{
		return price;
	}
	public void setReceiverAddr(String receiverAddr) 
	{
		this.receiverAddr = receiverAddr;
	}

	public String getReceiverAddr() 
	{
		return receiverAddr;
	}
	public void setReceiverName(String receiverName) 
	{
		this.receiverName = receiverName;
	}

	public String getReceiverName() 
	{
		return receiverName;
	}
	public void setReceiverTel(String receiverTel) 
	{
		this.receiverTel = receiverTel;
	}

	public String getReceiverTel() 
	{
		return receiverTel;
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
