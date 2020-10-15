package com.transample.demo.service;

import com.transample.demo.domain.TaoProduct;
import com.transample.demo.dto.RemoveIdsDTO;

import java.util.List;

/**
 * 商品 服务层
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
public interface ITaoProductService 
{

	/**
	 * 通过id获取product
	 *
	 * @param productId integer
	 * @return product
	 */
	public TaoProduct getProductById(Integer productId);

	/**
	 * 获取相似product列表
	 *
	 * @param product 包含指定相似属性的product
	 * @return product list
	 */
	public List<TaoProduct> getTaoProductList(TaoProduct product);

	/**
     * 获取自动生成的product信息
     * 
     * @return taoProduct
     */
	public TaoProduct getInfoBeforeAdd(Integer sellerId);

	/**
	 * 插入product信息
	 *
	 * @param product taoProduct
	 * @return 1 if success else 0
	 */
	public int addTaoProduct(TaoProduct product);

	/**
	 * 获取已有商品信息
	 *
	 * @param productId unique id
	 * @return TaoProduct
 	 */
	public TaoProduct getInfoBeforeEdit(Integer productId);

	/**
	 * 修改product信息
	 *
	 * @param product TaoProduct
	 * @return 1 if success else 0
	 */
	public int editTaoProduct(TaoProduct product);

	/**
	 * 删除商品对象，将delete状态改为0
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteTaoProductByIds(RemoveIdsDTO ids);

	/**
	 * 返回根据商品价格，成交订单数量排序的商品
	 *
	 * @return product list
	 */
	public List<TaoProduct> getSortedProducts();
}
