package com.transample.demo.utils;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * 将参数转化为json字符串的工具类
 */
public class ParamsUtil {

    public HashMap<String, Object> hashMap;

    public ParamsUtil() {
        this.hashMap = new HashMap<>();
    }

    public void add(String key, Object value)
    {
        this.hashMap.put(key,value);
    }
    public String toJson()
    {
        return JSON.toJSONString(this.hashMap);

    }

}
