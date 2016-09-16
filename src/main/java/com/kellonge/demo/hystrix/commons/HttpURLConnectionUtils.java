package com.kellonge.demo.hystrix.commons;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by kellonge on 16/9/9.
 * 使用原生的http请求
 */
public class HttpURLConnectionUtils {

    public static String get(String urlStr) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String tmp = "";
        StringBuilder sb = new StringBuilder();
        while ((tmp = bufferedReader.readLine()) != null) {
            sb.append(tmp);
        }
        return sb.toString();
    }
}
