package com.transample.demo.service.impl;

import java.util.Comparator;
import java.util.List;

import com.transample.demo.dto.RemoveIdsDTO;
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

    @Override
	public TaoProduct getProductById(Integer productId)
	{
	    return taoProductMapper.selectTaoProductById(productId);
	}
	
	@Override
	public List<TaoProduct> getTaoProductList(TaoProduct taoProduct) {
	    return taoProductMapper.selectTaoProductList(taoProduct);
	}

	@Override
	public TaoProduct getInfoBeforeAdd(Integer sellerId) {
		TaoProduct product = new TaoProduct();
		product.setDelete(1);
		product.setSellerId(sellerId);
		product.setExecutedOrder(0);
		return product;
	}

	@Override
	public int addTaoProduct(TaoProduct product) {
		return taoProductMapper.insertTaoProduct(product);
	}

	@Override
	public TaoProduct getInfoBeforeEdit(Integer productId) {
    	return taoProductMapper.selectTaoProductById(productId);
	}

	@Override
	public int editTaoProduct(TaoProduct product) {
    	return taoProductMapper.updateTaoProduct(product);
	}

	@Override
	public int deleteTaoProductByIds(RemoveIdsDTO ids)
	{
		int flag = 1;
		for (String id : ids.getIds().split(",")) {
			TaoProduct product = getProductById(Integer.parseInt(id));
			product.setDelete(0);
			flag = editTaoProduct(product);
			if (flag == 0) return flag;
		}
		return flag;
	}

	@Override
	public List<TaoProduct> getSortedProducts() {
    	TaoProduct product = new TaoProduct();
    	List<TaoProduct> products = getTaoProductList(product);
		products.sort(Comparator.comparing(TaoProduct::getProductPrice).thenComparing(TaoProduct::getExecutedOrder));
		return products;
	}
	
}
