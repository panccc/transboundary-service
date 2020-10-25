package com.transample.demo.utils;

import com.transample.demo.constants.OrderConstant;

public class OrderUtils {


    /**
     * 根据地址随机产生运费
     * 运费规则：
     * 如果物流公司类型是常规，物流费用计算方式是：
     * 一阶段物流省外的话就是在在12-20之间随机，省内就在8-12之间随机，同城就在4-8之间随机。一般商品数小于3的话就算一个运费，每增加一个商品，运费就在1-3之间随机加一个数。
     * 县村，物流费用计算方式是：
     * 二段物流在3-5之间随机一个数就可以了，不用算商品件数。
     *
     * 商家发货，需要在这个表里面新增一条数据：
     * @param sellerAddress
     * @param province
     * @param city
     * @param amount
     * @param isSecondaryLogistics
     * @return
     */
    public static double generateFare(String sellerAddress, String province, String city, int amount,boolean isSecondaryLogistics)
    {
        double ans = 0.0;
        /**
         * 获得商家的省市
         */
        int sIndex = 0;
        String sProvince = "";

        if(sellerAddress.contains("省"))
        {
            sIndex = sellerAddress.indexOf("省");
            sProvince = sellerAddress.substring(0,sIndex);
        }else if(sellerAddress.contains("自治区"))
        {
            sIndex = sellerAddress.indexOf("自治区");
            sProvince = sellerAddress.substring(0,sIndex+3);
        }else
        {
            /**
             * 直辖市特殊处理
             */
            sIndex = sellerAddress.indexOf("市");
            sProvince = sellerAddress.substring(0,sIndex);
            if(!isSecondaryLogistics)
            {
                if(sProvince.equals(province))
                {
                    /**
                     * 同市
                     */
                    ans = generateRandom(4,8);
                }else
                {
                    /**
                     * 省外
                     */
                    ans = generateRandom(12,20);
                }
                if(amount>3)
                {
                    ans += (amount-3)*generateRandom(1,3);
                }

            }else
            {
                /**
                 * 二级物流
                  */
                ans = generateRandom(3,5);
            }
            return ans;
        }


        boolean isSameCity = sellerAddress.contains(city);


        if(!isSecondaryLogistics)
        {
            /**
             * 一级物流
             */
            if(!sProvince.equals(province))
            {
                /**
                 * 省外
                 */
                ans = generateRandom(12,20);
            }else
            {
                if(isSameCity)
                {
                    /**
                     * 同城
                     */
                    ans = generateRandom(4,8);
                }else
                {
                    /**
                     * 省内
                     */
                    ans = generateRandom(8,12);
                }
            }

            if(amount>3)
            {
                ans += (amount-3)*generateRandom(1,3);
            }

        }else
        {
            ans = generateRandom(3,5);
        }

        return ans;
    }

    /**
     * 产生一个 l~r的随机数
     * @param l
     * @param r
     * @return
     */
    public static double generateRandom(int l,int r)
    {

        return l+(Math.random()*(r-l));
    }



}
