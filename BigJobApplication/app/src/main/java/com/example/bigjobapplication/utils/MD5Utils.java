package com.example.bigjobapplication.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    //md5 加密算法
    public static String md5(String text) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(text.getBytes());
            //创建StringBuilder对象 然后建议StringBuffer，安全性高
            StringBuffer sb = new StringBuffer();
            // for 循环数组byte[] result;
            for (byte b : result){
                int number = b & 0xff;
                // number值 转换 字符串 Integer.toHexString( );
                String hex = Integer.toHexString(number);
                if (hex.length() == 1){
                    sb.append("0"+hex);
                }else {
                    sb.append(hex);
                }
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            //发送异常return空字符串
            return "";
        }
    }
}