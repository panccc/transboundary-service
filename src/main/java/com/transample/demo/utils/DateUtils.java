package com.transample.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {
    public static String pattern3 = "yyyy-MM";
    public static String pattern = "yyyy-MM-dd";
    public static String pattern2 = "yyyy-MM-dd HH:mm:ss";
    public static String pattern4 = "yyyyMMddHHmmss";
    public static SimpleDateFormat formatter = new SimpleDateFormat(pattern);
    public static SimpleDateFormat formatter2 = new SimpleDateFormat(pattern2);
    public static SimpleDateFormat formatter3 = new SimpleDateFormat(pattern3);
    public static SimpleDateFormat formatter4 = new SimpleDateFormat(pattern4);
    public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

    /**
     * 获取现在时间
     * return
     *
     * @return 返回时间类型 yyyy-MM
     */
    public static String getNowDate3() {
        String dateString = formatter2.format(new Date());
        return dateString;
    }

    /**
     * 获取现在时间
     * return
     *
     * @return 返回时间类型 yyyy-MM-dd
     */
    public static String getNowDate() {
        String dateString = formatter.format(new Date());
        return dateString;
    }

    public static Date getNowDate2() {
        Date date = null;
        try {
            date = formatter.parse(getNowDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    public static String getNowDate4() {
        String dateString = formatter4.format(new Date());
        return dateString;
    }


    public static Date getDate(String date)
    {
        if(null == date)
        {
            return null;
        }
        Date newDate = null;
        date = date.split("T")[0];
        try {
            newDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDate;
    }
}
