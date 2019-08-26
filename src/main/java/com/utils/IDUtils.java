package com.utils;

import java.util.Random;

/**
 * @Auther: zayvion
 * @Date: 2019-08-11 21:34
 * @Description:ID生成工具类
 */
public class IDUtils {
    /**
     * 订单ID生成
     */

    public static long genItemId() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //long millis = System.nanoTime();
        //加上两位随机数
        Random random = new Random();
        int end2 = random.nextInt(99);
        //如果不足两位前面补0
        String str = millis + String.format("%02d", end2);
        long id = new Long(str);
        return id;

    }
}
