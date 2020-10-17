package com.transample.demo.utils;

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
     * @param villageAddress
     * @param amount
     * @param isSecondaryLogistics
     * @return
     */
    public static double generateFare(String sellerAddress, String villageAddress,int amount,boolean isSecondaryLogistics)
    {
        double ans = 0.0;
        /**
         * 获得商家的省市
         */
        int sIndex = sellerAddress.indexOf("省");
        int cIndex = sellerAddress.indexOf("市");
        String sProvince = sellerAddress.substring(0,sIndex);
        String sCity = sellerAddress.substring(sIndex+1,cIndex);
        /**
         * 获得买家的省市
         */
        int vSIndex = villageAddress.indexOf("省");
        int vCIndex = villageAddress.indexOf("市");
        String vProvince = villageAddress.substring(0,vSIndex);
        String vCity = villageAddress.substring(sIndex+1,vCIndex);



        if(!isSecondaryLogistics)
        {
            /**
             * 一级物流
             */
            if(!sProvince.equals(vProvince))
            {
                /**
                 * 省外
                 */
                ans = generateRandom(12,20);
            }else
            {
                if(sCity.equals(vCity))
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
