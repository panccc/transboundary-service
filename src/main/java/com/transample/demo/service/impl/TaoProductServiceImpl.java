package com.transample.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transample.demo.mapper.TaoProductMapper;
import com.transample.demo.domain.TaoProduct;
import com.transample.demo.service.ITaoProductService;

/**
 * 商品 服务层实现
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Service
public class TaoProductServiceImpl implements ITaoProductService 
{
	@Autowired
	private TaoProductMapper taoProductMapper;

	/**
     * 查询商品信息
     * 
     * @param imgUrl 商品ID
     * @return 商品信息
     */
    @Override
	public TaoProduct selectTaoProductById(String imgUrl)
	{
	    return taoProductMapper.selectTaoProductById(imgUrl);
	}
	
	/**
     * 查询商品列表
     * 
     * @param taoProduct 商品信息
     * @return 商品集合
     */
	@Override
	public List<TaoProduct> selectTaoProductList(TaoProduct taoProduct)
	{
	    return taoProductMapper.selectTaoProductList(taoProduct);
	}
	
    /**
     * 新增商品
     * 
     * @param taoProduct 商品信息
     * @return 结果
     */
	@Override
	public int insertTaoProduct(TaoProduct taoProduct)
	{
	    return taoProductMapper.insertTaoProduct(taoProduct);
	}
	
	/**
     * 修改商品
     * 
     * @param taoProduct 商品信息
     * @return 结果
     */
	@Override
	public int updateTaoProduct(TaoProduct taoProduct)
	{
	    return taoProductMapper.updateTaoProduct(taoProduct);
	}

	/**
     * 删除商品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTaoProductByIds(String ids)
	{
		return taoProductMapper.deleteTaoProductByIds(ids.split(","));
	}
	
}
