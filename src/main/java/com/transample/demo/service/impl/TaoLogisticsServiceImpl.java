package com.transample.demo.service.impl;

import java.util.Date;
import java.util.List;

import com.transample.demo.domain.TaoCompany;
import com.transample.demo.domain.TaoLogisticsState;
import com.transample.demo.domain.TaoOrder;
import com.transample.demo.mapper.TaoCompanyMapper;
import com.transample.demo.mapper.TaoLogisticsStateMapper;
import com.transample.demo.mapper.TaoOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transample.demo.mapper.TaoLogisticsMapper;
import com.transample.demo.domain.TaoLogistics;
import com.transample.demo.service.ITaoLogisticsService;

import javax.annotation.Resource;

/**
 * 物流 服务层实现
 * 
 * @author youcaihua
 * @date 2020-10-14
 */
@Service
public class TaoLogisticsServiceImpl implements ITaoLogisticsService 
{
	@Resource
	private TaoLogisticsMapper taoLogisticsMapper;

	@Resource
	private TaoOrderMapper taoOrderMapper;

	@Resource
	private TaoCompanyMapper taoCompanyMapper;


	/**
     * 查询物流信息
     * 
     * @param ticketId 物流ID
     * @return 物流信息
     */
    @Override
	public TaoLogistics selectTaoLogisticsById(String ticketId)
	{
	    return taoLogisticsMapper.selectTaoLogisticsById(ticketId);
	}
	
	/**
     * 查询物流列表
     * 
     * @param taoLogistics 物流信息
     * @return 物流集合
     */
	@Override
	public List<TaoLogistics> selectTaoLogisticsList(TaoLogistics taoLogistics)
	{
	    return taoLogisticsMapper.selectTaoLogisticsList(taoLogistics);
	}
	
    /**
     * 新增物流
     * 
     * @param taoLogistics 物流信息
     * @return 结果 0：插入失败； -1 参数错误;其他正常
     */
	@Override
	public int insertTaoLogistics(TaoLogistics taoLogistics)
	{
		/**
		 * 检查必要参数是否为空
		 */
		if(taoLogistics.getTicketId()==null||taoLogistics.getCompanyId()==null||taoLogistics.getOrderId()==null)return -1;

		TaoOrder order = taoOrderMapper.selectTaoOrderById(Integer.parseInt(taoLogistics.getOrderId()));
		TaoCompany company = taoCompanyMapper.selectTaoCompanyById(taoLogistics.getCompanyId());

		taoLogistics.setCompanyName(company.getCompanyName());


		if(company.getCompanyType().equals("常规"))
			taoLogistics.setPrice(order.getLogisticsOnePrice());
		else if(company.getCompanyType().equals("县村"))
		{
			taoLogistics.setPrice(order.getLogisticsTwoPrice());
		}

		/**
		 * 设置时间
		 */
		Date date = new Date();
		taoLogistics.setCreateTime(date);
		taoLogistics.setUpdateTime(date);

		taoLogistics.setCompanyType(company.getCompanyType());
		taoLogistics.setReceiverAddr(order.getAddress());
		taoLogistics.setReceiverTel(order.getMobile());


		return taoLogisticsMapper.insertTaoLogistics(taoLogistics);
	}
	
	/**
     * 修改物流
     * 
     * @param taoLogistics 物流信息
     * @return 结果
     */
	@Override
	public int updateTaoLogistics(TaoLogistics taoLogistics)
	{
	    return taoLogisticsMapper.updateTaoLogistics(taoLogistics);
	}

	/**
     * 删除物流对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTaoLogisticsByIds(String ids)
	{
		return taoLogisticsMapper.deleteTaoLogisticsByIds(ids.split(","));
	}

	@Override
	public TaoLogistics selectLogisticsByOrderId(Integer orderId) {
		return taoLogisticsMapper.selectLogisticsByOrderId(orderId);
	}
}
