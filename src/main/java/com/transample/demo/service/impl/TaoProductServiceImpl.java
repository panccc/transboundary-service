package com.transample.demo.service.impl;

import java.io.IOException;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.transample.demo.constants.ImgConstants;
import com.transample.demo.constants.ServiceNetworkConstants;
import com.transample.demo.dto.RemoveIdsDTO;
import com.transample.demo.utils.JSONUtils;
import lombok.SneakyThrows;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import com.transample.demo.mapper.TaoProductMapper;
import com.transample.demo.domain.TaoProduct;
import com.transample.demo.service.ITaoProductService;

import javax.annotation.Resource;

/**
 * 商品 服务层实现
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Service
public class TaoProductServiceImpl implements ITaoProductService 
{
	@Resource
	private TaoProductMapper taoProductMapper;

	private final OkHttpClient httpClient = new OkHttpClient();

    @SneakyThrows
	@Override
	public TaoProduct getProductById(Integer productId)
	{
//	    TaoProduct taoProduct = taoProductMapper.selectTaoProductById(productId);
//	    taoProduct.setImgUrl(ImgConstants.BASEURL+taoProduct.getImgUrl());
		/***
		 * 修改为调用服务网络
		 */
//		TaoProduct taoProduct = new TaoProduct();

		MediaType mediaType= MediaType.parse("application/json; charset=utf-8");
		JSONObject jsonObject = new JSONObject();

		String url = ServiceNetworkConstants.ADDRESS+ServiceNetworkConstants.INVOKEINTERFACE;
		HashMap<String, Integer> hashMap = new HashMap<>();
		hashMap.put("productId",productId);
		String params = JSON.toJSONString(hashMap);
//		System.out.println(params);
		String interfaceId = "1515652101257-1515648412249-1604237392244";

		try{
			jsonObject.put("interfaceId",interfaceId);
			jsonObject.put("params",params);
		}catch (JSONException e)
		{
			e.printStackTrace();
		}

		RequestBody requestBody =RequestBody.create(mediaType, String.valueOf(jsonObject));
		Response res =null;
		try {
			res = httpClient.newCall(new Request.Builder().url(url).post(requestBody).build()).execute();

		} catch (IOException e) {
			e.printStackTrace();
		}
//		if(res == null)return null;
		JSONObject jsonObject1 = JSON.parseObject(res.body().string());
		if(jsonObject1==null)return null;
		try
		{

			TaoProduct taoProduct = jsonObject1.getJSONObject("data").getJSONObject("data").toJavaObject(TaoProduct.class);
			return taoProduct;
		}catch (Exception e)
		{
			return null;
		}

	}
	
	@Override
	public List<TaoProduct> getTaoProductList(TaoProduct taoProduct) {
    	List<TaoProduct> list = taoProductMapper.selectTaoProductList(taoProduct);
    	for(int i=0;i<list.size();i++)
		{
			String imgUrl = list.get(i).getImgUrl();
			list.get(i).setImgUrl(ImgConstants.BASEURL +imgUrl);
		}

	    return list;
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
//    	return getProductById(productId);
		return null;
	}

	@Override
	public int editTaoProduct(TaoProduct product) {
    	return taoProductMapper.updateTaoProduct(product);
	}

	@Override
	public int deleteTaoProductByIds(RemoveIdsDTO ids)
	{
		int flag = 1;
//		for (String id : ids.getIds().split(",")) {
////			TaoProduct product = getProductById(Integer.parseInt(id));
//			product.setDelete(0);
//			flag = editTaoProduct(product);
//			if (flag == 0) return flag;
//		}
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
