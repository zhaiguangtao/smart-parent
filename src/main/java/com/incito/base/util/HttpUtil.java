/**
 * Copyright (c) 2010 S9,Inc.All rights reserved. Created by 2010-9-9
 */
package com.incito.base.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

/**
 * @title :http相关的功能处理工具类
 * @author: zhaiguangtao
 * @date: 2012-11-27
 */
public class HttpUtil {

  private static int connectTimeout = 3000;// 连接超时值 ,单位:毫秒

  /**
   * @title 以GET的方式请求一个http资源,并将结果以字符串的方式返回
   * @param url url链接字符串
   * @param encoding 请求编码设置 ，UTF-8 或GBK或其他
   * @return 结果字符串
   * @throws IOException
   * */
  public static String sendGet(String url, String charset) throws IOException {
    StringBuilder result = new StringBuilder();

    URL u = new URL(url);
    URLConnection conn = u.openConnection();
    conn.connect();
    conn.setConnectTimeout(connectTimeout);// 设置链接超时时间
    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
    String line;
    while ((line = in.readLine()) != null) {
      result.append(line);
    }
    in.close();
    return result.toString();
  }

  /**
   * @title 以POST的方式请求一个http资源,并将结果以字符串的方式返回
   * @param url url链接字符串
   * @param param 请求参数
   * @param charset 请求编码设置 ，UTF-8 或GBK或其他
   * @param timeout 连接超时值
   * @return 结果字符串
   * @throws IOException
   * */
  public static String sendPost(String url, String param, String contentType, final String charset, int timeout) throws IOException {
    StringBuilder result = new StringBuilder();
    URL httpurl = new URL(url);
    HttpURLConnection httpConn = (HttpURLConnection) httpurl.openConnection();
    httpConn.setDoOutput(true);
    // HttpUtil.class.getd
    httpConn.setDoInput(true);
    httpConn.setRequestProperty("Accept-Encoding", "gzip");// 设置gzip请求支持
    httpConn.addRequestProperty("Content-Type", contentType);
    // httpConn.setRequestProperty("Accept",
    // "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");//设置gzip请求支持
    // httpConn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");//设置gzip请求支持
    // httpConn.setRequestProperty("Pragma", "no-cache");// 不缓存
    // httpConn.setRequestProperty("Cache-Control", "no-cache");// 不缓存
    httpConn.setConnectTimeout(timeout);
    PrintWriter out = new PrintWriter(httpConn.getOutputStream());
    out.print(param);
    out.flush();
    out.close();
    BufferedReader in = null;
    String str = httpConn.getContentEncoding();

    if (!(str == null || str.indexOf("gzip") == -1)) {
      GZIPInputStream gin = new GZIPInputStream(httpConn.getInputStream());
      in = new BufferedReader(new InputStreamReader(gin, charset));
    } else {
      in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), charset));
    }
    String line;
    while ((line = in.readLine()) != null) {
      result.append(line);
    }
    in.close();
    httpConn.disconnect();
    return result.toString();
  }
}
