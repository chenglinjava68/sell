package com.xby.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author :xby
 * @date :2019/2/12 13:49
 * @description :
 */
public class JsonUtil {
    public static String toJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
