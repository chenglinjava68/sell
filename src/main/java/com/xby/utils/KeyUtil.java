package com.xby.utils;

import java.util.Random;

/**
 * @author :xby
 * @date :2019/1/25 16:52
 * @description :生成唯一的主键
 *          格式: 时间（13位）+随机数（6位）
 */
public class KeyUtil {

    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}