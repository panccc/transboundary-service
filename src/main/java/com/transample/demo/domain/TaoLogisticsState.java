package com.transample.demo.domain;


import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 物流状态表 tao_logistics_state
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
public class TaoLogisticsState
{
	
	/** 唯一标识 */
	@ApiModelProperty("唯一标识 数据库自动生成")
	private Integer id;
	/** 物流订单号 */
	@ApiModelProperty("物流订单号")
	private String ticketId;
	/** 	订单当前状态（已下单、已揽收、运输中、县级中心揽收、派件中、待取件、已签收） */
	@ApiModelProperty("订单当前状态（已下单、已揽收、运输中、县级中心揽收、派件中、待取件、已签收）")
	private String curState;
	/** 	物流中转站 list */

	@ApiModelProperty("物流中转站 list ")
	private String deliveryPath;
	/** 	创建时间 */
	@ApiModelProperty("创建时间即到达中转站")
	private Date createTime;
	/** 	更新时间 */
	@ApiModelProperty("更新时间即离开中转站")
	private Date updateTime;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setTicketId(String ticketId) 
	{
		this.ticketId = ticketId;
	}

	public String getTicketId() 
	{
		return ticketId;
	}
	public void setCurState(String curState) 
	{
		this.curState = curState;
	}

	public String getCurState() 
	{
		return curState;
	}
	public void setDeliveryPath(String deliveryPath) 
	{
		this.deliveryPath = deliveryPath;
	}

	public String getDeliveryPath() 
	{
		return deliveryPath;
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
