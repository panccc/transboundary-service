package com.transample.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.transample.demo.domain.TaoProduct;
import com.transample.demo.domain.TaoShoppingCart;
import com.transample.demo.mapper.TaoProductMapper;
import com.transample.demo.mapper.TaoShoppingCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transample.demo.mapper.TaoCartOrderItemMapper;
import com.transample.demo.domain.TaoCartOrderItem;
import com.transample.demo.service.ITaoCartOrderItemService;

import javax.annotation.Resource;

/**
 * 购物车单类商品 服务层实现
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Service
public class TaoCartOrderItemServiceImpl implements ITaoCartOrderItemService 
{
	@Resource
	private TaoCartOrderItemMapper taoCartOrderItemMapper;

	@Resource
	private TaoProductMapper taoProductMapper;

	@Resource
	private TaoShoppingCartMapper taoShoppingCartMapper;


	/**
     * 查询购物车单类商品信息
     * 
     * @param orderItemId 购物车单类商品ID
     * @return 购物车单类商品信息
     */
    @Override
	public TaoCartOrderItem selectTaoCartOrderItemById(Integer orderItemId)
	{
	    return taoCartOrderItemMapper.selectTaoCartOrderItemById(orderItemId);
	}
	
	/**
     * 查询购物车单类商品列表
     * 
     * @param taoCartOrderItem 购物车单类商品信息
     * @return 购物车单类商品集合
     */
	@Override
	public List<TaoCartOrderItem> selectTaoCartOrderItemList(TaoCartOrderItem taoCartOrderItem)
	{
	    return taoCartOrderItemMapper.selectTaoCartOrderItemList(taoCartOrderItem);
	}
	
    /**
     * 新增购物车单类商品
     * 
     * @param taoCartOrderItem 购物车单类商品信息
     * @return 结果
     */
	@Override
	public int insertTaoCartOrderItem(TaoCartOrderItem taoCartOrderItem)
	{

		if(taoCartOrderItem.getOrderItemId()!=null)taoCartOrderItem.setOrderItemId(null);
		int productId = taoCartOrderItem.getGoodsId();
		TaoProduct product = taoProductMapper.selectTaoProductById(productId);
		if(product==null)return 0;

		taoCartOrderItem.setPrice(product.getProductPrice()*taoCartOrderItem.getAmount());
		//System.out.println(taoCartOrderItem.getOrderItemId());
		return taoCartOrderItemMapper.insertTaoCartOrderItem(taoCartOrderItem);
	}
	
	/**
     * 修改购物车单类商品
     * 
     * @param taoCartOrderItem 购物车单类商品信息
     * @return 结果
     */
	@Override
	public int updateTaoCartOrderItem(TaoCartOrderItem taoCartOrderItem)
	{
		int productId = taoCartOrderItem.getGoodsId();
		TaoProduct product = taoProductMapper.selectTaoProductById(productId);
		if(product==null)return 0;
		taoCartOrderItem.setPrice(product.getProductPrice()*taoCartOrderItem.getAmount());
		return taoCartOrderItemMapper.updateTaoCartOrderItem(taoCartOrderItem);
	}

	/**
     * 删除购物车单类商品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTaoCartOrderItemByIds(String ids)
	{
		return taoCartOrderItemMapper.deleteTaoCartOrderItemByIds(ids.split(","));
	}

	/**
	 * 根据购物车id，获取购物车商品list，并按照商家分类
	 *
	 * @param cartId
	 * @return
	 */
	@Override
	public HashMap<Integer, List<TaoCartOrderItem>> getCartItemListGroupBySeller(Integer cartId) {

		HashMap<Integer,List<TaoCartOrderItem>> ans = new HashMap<>();
		TaoCartOrderItem taoCartOrderItem = new TaoCartOrderItem();
		taoCartOrderItem.setCartId(cartId);
		List<TaoCartOrderItem> list = selectTaoCartOrderItemList(taoCartOrderItem);
		for(int i=0;i<list.size();i++)
		{
			TaoCartOrderItem cartOrderItem = list.get(i);
			TaoProduct product = taoProductMapper.selectTaoProductById(cartOrderItem.getGoodsId());
			int sellerId = product.getSellerId();
			if(ans.get(sellerId)==null)
			{
				List<TaoCartOrderItem> ansList = new ArrayList<>();
				ansList.add(cartOrderItem);
				ans.put(sellerId,ansList);
			}else
			{
				ans.get(sellerId).add(cartOrderItem);
			}
		}


		return ans;
	}
}
