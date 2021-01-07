package com.transample.demo.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * tao_order
 * @author 
 */
public class TaoOrder implements Serializable {
    /**
     * 订单号
     */
    private Integer orderId;

    /**
     * 村民Id
     */
    private Integer villagerId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 商家Id
     */
    private Integer sellerId;

    /**
     * 商家名称
     */
    private String sellerName;

    /**
     * 用户手机
     */
    private String mobile;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 村站ID
     */
    private Integer stationId;

    /**
     * 村站名称
     */
    private String stationName;

    /**
     * 商品总数
     */
    private Integer totalNumber;

    /**
     * 商品总价格
     */
    private BigDecimal totalPrice;

    /**
     * 一阶段物流费用
     */
    private BigDecimal logisticsOnePrice;

    /**
     * 二阶段物流费用
     */
    private BigDecimal logisticsTwoPrice;

    /**
     * 状态10 未付款 11 已付款 12已审核,20 缺货 30 发货中 31已送达 32已签收 50 确认收货 60取消
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 订单创建时间
     */
    private Date createTime;

    /**
     * 订单发货时间
     */
    private Date sendTime;

    /**
     * 订单送达时间
     */
    private Date arriveTime;

    /**
     * 订单签收时间
     */
    private Date shouTime;

    /**
     * 订单确认收货时间
     */
    private Date finishTime;

    private static final long serialVersionUID = 1L;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getVillagerId() {
        return villagerId;
    }

    public void setVillagerId(Integer villagerId) {
        this.villagerId = villagerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getLogisticsOnePrice() {
        return logisticsOnePrice;
    }

    public void setLogisticsOnePrice(BigDecimal logisticsOnePrice) {
        this.logisticsOnePrice = logisticsOnePrice;
    }

    public BigDecimal getLogisticsTwoPrice() {
        return logisticsTwoPrice;
    }

    public void setLogisticsTwoPrice(BigDecimal logisticsTwoPrice) {
        this.logisticsTwoPrice = logisticsTwoPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Date getShouTime() {
        return shouTime;
    }

    public void setShouTime(Date shouTime) {
        this.shouTime = shouTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TaoOrder other = (TaoOrder) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getVillagerId() == null ? other.getVillagerId() == null : this.getVillagerId().equals(other.getVillagerId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getSellerId() == null ? other.getSellerId() == null : this.getSellerId().equals(other.getSellerId()))
            && (this.getSellerName() == null ? other.getSellerName() == null : this.getSellerName().equals(other.getSellerName()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getStationId() == null ? other.getStationId() == null : this.getStationId().equals(other.getStationId()))
            && (this.getStationName() == null ? other.getStationName() == null : this.getStationName().equals(other.getStationName()))
            && (this.getTotalNumber() == null ? other.getTotalNumber() == null : this.getTotalNumber().equals(other.getTotalNumber()))
            && (this.getTotalPrice() == null ? other.getTotalPrice() == null : this.getTotalPrice().equals(other.getTotalPrice()))
            && (this.getLogisticsOnePrice() == null ? other.getLogisticsOnePrice() == null : this.getLogisticsOnePrice().equals(other.getLogisticsOnePrice()))
            && (this.getLogisticsTwoPrice() == null ? other.getLogisticsTwoPrice() == null : this.getLogisticsTwoPrice().equals(other.getLogisticsTwoPrice()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getSendTime() == null ? other.getSendTime() == null : this.getSendTime().equals(other.getSendTime()))
            && (this.getArriveTime() == null ? other.getArriveTime() == null : this.getArriveTime().equals(other.getArriveTime()))
            && (this.getShouTime() == null ? other.getShouTime() == null : this.getShouTime().equals(other.getShouTime()))
            && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getVillagerId() == null) ? 0 : getVillagerId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getSellerId() == null) ? 0 : getSellerId().hashCode());
        result = prime * result + ((getSellerName() == null) ? 0 : getSellerName().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getStationId() == null) ? 0 : getStationId().hashCode());
        result = prime * result + ((getStationName() == null) ? 0 : getStationName().hashCode());
        result = prime * result + ((getTotalNumber() == null) ? 0 : getTotalNumber().hashCode());
        result = prime * result + ((getTotalPrice() == null) ? 0 : getTotalPrice().hashCode());
        result = prime * result + ((getLogisticsOnePrice() == null) ? 0 : getLogisticsOnePrice().hashCode());
        result = prime * result + ((getLogisticsTwoPrice() == null) ? 0 : getLogisticsTwoPrice().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getSendTime() == null) ? 0 : getSendTime().hashCode());
        result = prime * result + ((getArriveTime() == null) ? 0 : getArriveTime().hashCode());
        result = prime * result + ((getShouTime() == null) ? 0 : getShouTime().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", villagerId=").append(villagerId);
        sb.append(", userName=").append(userName);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", sellerName=").append(sellerName);
        sb.append(", mobile=").append(mobile);
        sb.append(", address=").append(address);
        sb.append(", stationId=").append(stationId);
        sb.append(", stationName=").append(stationName);
        sb.append(", totalNumber=").append(totalNumber);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", logisticsOnePrice=").append(logisticsOnePrice);
        sb.append(", logisticsTwoPrice=").append(logisticsTwoPrice);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", sendTime=").append(sendTime);
        sb.append(", arriveTime=").append(arriveTime);
        sb.append(", shouTime=").append(shouTime);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}