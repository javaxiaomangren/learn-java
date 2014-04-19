package com.amap.cp.utils;



import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yang.hua on 14-3-26.
 */
public class Test {
    public static String encoderByMd5(String str)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // 确定计算方法

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        // 加密后的字符串
        String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }

    public static String decodeStr(String s) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        // 加密后的字符串

//        String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return s;
    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String req = "<KDT><REQUESTTYPE>26</REQUESTTYPE><APPID>gd</APPID><APPKEY>gd0325</APPKEY> <USERKEY>GDDT</USERKEY><BUSSINESS><LONGITUDE>116.327896</LONGITUDE><LATITUDE>39.959484</LATITUDE></BUSSINESS></KDT>";
        String r = "<KDT><REQUESTTYPE>26</REQUESTTYPE><APPID>gd</APPID><APPKEY>gd0325</APPKEY><BUSSINESS><LONGITUDE>116.523205</LONGITUDE><LATITUDE>39.922766</LATITUDE></BUSSINESS></KDT>GDDT";
        String s = "<KDT><REQUESTTYPE>26</REQUESTTYPE><APPID>gd</APPID><APPKEY>gd0325</APPKEY><TOKEN/><BUSSINESS><LONGITUDE>116.523205</LONGITUDE><LATITUDE>39.922766</LATITUDE></BUSSINESS></KDT>GDDT";
        System.out.println(encoderByMd5(s));
    }

}
