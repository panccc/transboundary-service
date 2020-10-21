package com.transample.demo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.transample.demo.domain.TaoAddress;
import com.transample.demo.mapper.TaoAddressMapper;
import com.transample.demo.service.ITaoAddressService;
import com.transample.demo.service.impl.TaoAddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSONUtils {








    public static String readJsonFile(String fileName) {

        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "gb2312");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 获取某文件夹下所有文件名的list
     * @param directory
     * @return
     */
    public static List<String> getFileList(String directory) {
        List<String> ans = new ArrayList<>();
        File f = new File(directory);
        File[] files = f.listFiles();
        for (int i = 0; i < files.length; i++) {

            ans.add(files[i].getName());
        }
        return ans;
    }

    public static void main(String[] args) {

    }



}
