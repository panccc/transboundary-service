package com.transample.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.transample.demo.utils.JSONUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transample.demo.mapper.TaoAddressMapper;
import com.transample.demo.domain.TaoAddress;
import com.transample.demo.service.ITaoAddressService;

import javax.annotation.Resource;

/**
 * 全国省市村统计 服务层实现
 * 
 * @author youcaihua
 * @date 2020-10-13
 */
@Service
public class TaoAddressServiceImpl implements ITaoAddressService 
{
	@Resource
	private TaoAddressMapper taoAddressMapper;

	/**
     * 查询全国省市村统计信息
     * 
     * @param id 全国省市村统计ID
     * @return 全国省市村统计信息
     */
    @Override
	public TaoAddress selectTaoAddressById(Integer id)
	{
	    return taoAddressMapper.selectTaoAddressById(id);
	}
	
	/**
     * 查询全国省市村统计列表
     * 
     * @param taoAddress 全国省市村统计信息
     * @return 全国省市村统计集合
     */
	@Override
	public List<TaoAddress> selectTaoAddressList(TaoAddress taoAddress)
	{
	    return taoAddressMapper.selectTaoAddressList(taoAddress);
	}
	
    /**
     * 新增全国省市村统计
     * 
     * @param taoAddress 全国省市村统计信息
     * @return 结果
     */
	@Override
	public int insertTaoAddress(TaoAddress taoAddress)
	{
	    return taoAddressMapper.insertTaoAddress(taoAddress);
	}
	
	/**
     * 修改全国省市村统计
     * 
     * @param taoAddress 全国省市村统计信息
     * @return 结果
     */
	@Override
	public int updateTaoAddress(TaoAddress taoAddress)
	{
	    return taoAddressMapper.updateTaoAddress(taoAddress);
	}

	/**
     * 删除全国省市村统计对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTaoAddressByIds(String ids)
	{
		String[] strss=ids.split(",");
		return taoAddressMapper.deleteTaoAddressByIds(strss);
	}

	@Override
	public void insertTaoAddressListFromJson(String fileName)
	{

		String base = "C:\\Users\\Administrator\\PycharmProjects\\pythonProject\\data\\";
		String path = base+fileName;
		String province = fileName.substring(0,fileName.indexOf("."));
		System.out.println(fileName);
		String s = JSONUtils.readJsonFile(path);
		System.out.println(s);
		JSONObject jobj = JSON.parseObject(s);
		for (String city : jobj.keySet())
		{

			JSONObject counties = jobj.getJSONObject(city);
			for (String county : counties.keySet())
			{
				JSONObject towns = counties.getJSONObject(county);
				for(String town:towns.keySet())
				{
					JSONArray villages = towns.getJSONArray(town);
					for(int i=0;i<villages.size();i++) {
						String village = villages.getString(i);
						TaoAddress address =new TaoAddress(province,city,county,town,village);
						System.out.println(address);
//						insertTaoAddress(address);
					}
				}
			}
		}

	}

	@Override
	public int insertAddressBySpider(String province, String url) {

			System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get(url);
			try{
				WebElement ant = driver.findElement(By.linkText("点击验证"));
				if(ant!=null)
					ant.click();
			}catch (Exception e)
			{
				e.printStackTrace();
			}


			for(int i=0;i<driver.findElement(By.id("d_qh")).findElements(By.tagName("li")).size();i++)
			{
				WebElement a = driver.findElement(By.id("d_qh")).findElements(By.tagName("li")).get(i).findElement(By.tagName("a"));
				String city = a.getText();
				String link = a.getAttribute("href");
				driver.get(link);

				for(int j=0;j<driver.findElement(By.id("d_qh")).findElements(By.tagName("li")).size();j++)
				{
					WebElement a2 = driver.findElement(By.id("d_qh")).findElements(By.tagName("li")).get(j).findElement(By.tagName("a"));
					String county = a2.getText();
					String link2 = a2.getAttribute("href");
					driver.get(link2);
//                List<WebElement> list3 = driver.findElement(By.id("d_qh")).findElements(By.tagName("li"));
					for(int k=0;k<driver.findElement(By.id("d_qh")).findElements(By.tagName("li")).size();k++)
					{
						List<WebElement> list4 = driver.findElement(By.id("d_qh")).findElements(By.tagName("li")).get(k).findElements(By.tagName("a"));
						String town = list4.get(0).getText();
						for(int p=1;p<list4.size();p++)
						{
							String village = list4.get(p).getText();
							insertTaoAddress(new TaoAddress(province, city,county,town,village));
							System.out.println(province+city+county+town+village);
						}
					}
					driver.get(link);

				}
				driver.get(url);

			}


			driver.quit();

		return 0;
	}
}
