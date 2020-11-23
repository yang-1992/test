package com.ctsi.block.utils;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.jasig.cas.client.util.URIBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zhaohy
 * @version 1.0.1
 * @Description:
 * @date 2020-08-27 16:00:29
 * @Copyright 中国电信集团系统集成有限责任公司
 */
public class HttpRequestDcoosUtils {
    /**
     * 调用接口
     * @return
     */
    public static String invokeGet(URIBuilder builder){
        HttpClient httpClient = null;
        HttpGet httpGet = null;
        String jsonStr = null;
        String result = "";
        try {
            httpClient = new SSLClient();
            httpGet = new HttpGet(builder.build());

            HttpResponse response = httpClient.execute(httpGet);
            System.out.println(response.getStatusLine().getStatusCode());
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "utf-8"));
            StringBuilder sb = new StringBuilder();
            try {
                while ((jsonStr = reader.readLine()) != null) {
                    sb.append(jsonStr);
                }
                result = sb.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            reader.close();// 关闭输入流
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * 调用接口
     * @return
     */
    public static String invokePost(String url, String reqJson){
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String jsonStr = null;
        String result = "";
        try {
            httpClient = new SSLClient();
            httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/json;charset=utf-8");

            StringEntity se = new StringEntity(reqJson, "UTF-8");

            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
                    "application/json"));
            httpPost.setEntity(se);
            HttpResponse response = httpClient.execute(httpPost);
            System.out.println(response.getStatusLine().getStatusCode());
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "utf-8"));

            StringBuilder sb = new StringBuilder();
            try {
                while ((jsonStr = reader.readLine()) != null) {
                    sb.append(jsonStr);
                }
                result = sb.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            reader.close();// 关闭输入流
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }


    public static void main(String[] args) {
        invokePost("http://192.168.203.150:9000/api/systemSelect?systemLevel=1&systemCode=1","");
    }

}
