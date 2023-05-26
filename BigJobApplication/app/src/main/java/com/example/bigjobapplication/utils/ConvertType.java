package com.example.bigjobapplication.utils;

import com.google.gson.Gson;

public class ConvertType {

    public static String beanToJson(Object bean) {
        Gson gson = new Gson();
        String jsonStr = gson.toJson(bean);
        System.out.println(jsonStr);
        return jsonStr;
    }

}
