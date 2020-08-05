package com.example.http;


import org.junit.Test;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpConnectionDemo {

    public static String is2String(InputStream tInputStream) {
        if (tInputStream != null) {
            try {
                BufferedReader tBufferedReader = new BufferedReader(new InputStreamReader(tInputStream));
                StringBuffer tStringBuffer = new StringBuffer();
                String sTempOneLine = "";
                while ((sTempOneLine = tBufferedReader.readLine()) != null) {
                    tStringBuffer.append(sTempOneLine);
                }
                return tStringBuffer.toString();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        return null;
    }

    @Test
    public void getConnect() {
        this.getConnect("http://127.0.0.1:8080/hello");
        this.getConnect("http://127.0.0.1:8080/hello");
        this.getConnect("http://127.0.0.1:8080/hello");
    }

    public void getConnect(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = null;
            connection.setRequestMethod("POST");
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
//            connection.setUseCaches(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");//设置参数类型是json格式
            connection.connect();
            String body = "{name:zhangsan,password:123456}";
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), StandardCharsets.UTF_8));
            writer.write(body);
            writer.close();
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                String result = is2String(inputStream);//将流转换为字符串
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
