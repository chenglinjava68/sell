package com.xby.utils;

import com.xby.enums.CodeEnum;

/**
 * @author :xby
 * @date :2019/2/7 10:38
 * @description :
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each:enumClass.getEnumConstants()) {
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
