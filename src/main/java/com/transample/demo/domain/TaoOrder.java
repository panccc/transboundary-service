package com.transample.demo.domain;


import java.util.Date;

/**
 * 订单表 tao_order
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
public class TaoOrder
{
	
	/** 订单号 */
	private Integer orderId;
	/** 村民Id */
	private Integer villagerId;
	/** 用户名 */
	private String userName;
	/** 商家Id */
	private Integer sellerId;
	/** 商家名称 */
	private String sellerName;
	/** 用户手机 */
	private String mobile;
	/** 详细地址 */
	private String address;
	/** 村站ID */
	private Integer stationId;
	/** 村站名称 */
	private String stationName;
	/** 商品总数 */
	private Integer totalNumber;
	/** 商品总价格 */
	private Double totalPrice;
	/** 状态10 未付款 11 已付款 12已审核,20 缺货 30 发货中 31已送达 32已签收 50 确认收货 */
	private Integer status;
	/** 备注 */
	private String remark;
	/** 订单创建时间 */
	private Date createTime;
	/** 订单发货时间 */
	private Date sendTime;
	/** 订单送达时间 */
	private Date arriveTime;
	/** 订单签收时间 */
	private Date shouTime;
	/** 订单确认收货时间 */
	private Date finishTime;

	public void setOrderId(Integer orderId) 
	{
		this.orderId = orderId;
	}

	public Integer getOrderId() 
	{
		return orderId;
	}
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
	public void setSellerId(Integer sellerId) 
	{
		this.sellerId = sellerId;
	}

	public Integer getSellerId() 
	{
		return sellerId;
	}
	public void setSellerName(String sellerName) 
	{
		this.sellerName = sellerName;
	}

	public String getSellerName() 
	{
		return sellerName;
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
	public void setTotalNumber(Integer totalNumber) 
	{
		this.totalNumber = totalNumber;
	}

	public Integer getTotalNumber() 
	{
		return totalNumber;
	}
	public void setTotalPrice(Double totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public Double getTotalPrice()
	{
		return totalPrice;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setSendTime(Date sendTime) 
	{
		this.sendTime = sendTime;
	}

	public Date getSendTime() 
	{
		return sendTime;
	}
	public void setArriveTime(Date arriveTime) 
	{
		this.arriveTime = arriveTime;
	}

	public Date getArriveTime() 
	{
		return arriveTime;
	}
	public void setShouTime(Date shouTime) 
	{
		this.shouTime = shouTime;
	}

	public Date getShouTime() 
	{
		return shouTime;
	}
	public void setFinishTime(Date finishTime) 
	{
		this.finishTime = finishTime;
	}

	public Date getFinishTime() 
	{
		return finishTime;
	}

}
