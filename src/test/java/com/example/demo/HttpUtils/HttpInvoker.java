package com.example.demo.HttpUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.*;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author jxchenac
 * @create 3/23/2021 3:28 PM
 */

@Component
public class HttpInvoker {

    private static CloseableHttpClient httpClient = HttpClients.createDefault();
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static String Cookie = null;
    private static String URL = "https://www.baidu.com";



    private static void buildHeaderParams(HttpRequestBase httpMethod, Map<String, String> headers) {
        if (headers== null) {
            return;
        }
        for (String headName : headers.keySet()) {
            String headValue = headers.get(headName);
            httpMethod.addHeader(headName, headValue);
        }
    }
    private static void buildPostBody(HttpPost httpPost, Map<String, String> body) {
        List<NameValuePair> bodyPair = new ArrayList<NameValuePair>();
        if (body != null) {
            for (Map.Entry<String, String> entry : body.entrySet()) {
                bodyPair.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        httpPost.setEntity(new UrlEncodedFormEntity(bodyPair, Consts.UTF_8));
    }
    private static  void buildQueryParams(HttpRequestBase httpMethod, String url,
                                          Map<String, String> queryParam) throws URISyntaxException {

        URIBuilder uriBuilder = new URIBuilder(url);

        if (queryParam == null) {
            httpMethod.setURI(uriBuilder.build());
            return;
        }
        Map<String, String> query = queryParam;
        reBuildQueryParam(uriBuilder, query);
        httpMethod.setURI(uriBuilder.build());
    }

    public static void reBuildQueryParam(URIBuilder uriBuilder, Map<String, String> query) {
        Set<Map.Entry<String, String>> entry = query.entrySet();
        for (Map.Entry<String, String> inner : entry) {
            Object value = inner.getValue();
            if (value instanceof Map) {
                Map<String, String> innerMap = (Map<String, String>) value;
                reBuildQueryParam(uriBuilder, innerMap);
            } else {
                uriBuilder.addParameter(inner.getKey(), inner.getValue());
            }
        }
    }
    private static String buildResult(CloseableHttpResponse response, Boolean ... saveCookie) throws IOException {
        String body = "";
        int status = response.getStatusLine().getStatusCode();
        //http request code (i.e 404)
        if (status >= 200 && status < 300) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                body = EntityUtils.toString(entity, Consts.UTF_8);
            }
            if (saveCookie.length>0&&saveCookie[0].booleanValue()){
                Header[] header =response.getHeaders("Set-Cookie");
                StringBuffer cookieBuffer = new StringBuffer();
                for (int i = 0;i<header.length;i++) {
                    String str = header[i].getValue();
                    cookieBuffer.append(str.substring(0,str.indexOf(";"))).append(";");
                }
                Cookie = cookieBuffer.toString();
            }
            EntityUtils.consume(entity);
            response.close();
        } else {
            return "[Error] response status " + status;
        }

        return body;
    }
    public  String get(String url, Map<String, String> queryParam, Map<String, String> headers) throws IOException, URISyntaxException {

        // 1. GET请求
        HttpGet httpMethod = new HttpGet();

        // 2. 构建请求URL，query参数
        buildQueryParams(httpMethod, url, queryParam);

        // 3 构建HTTP HEAD
        buildHeaderParams(httpMethod, headers);

        // 4. 执行HTTP请求
        return httpClient.execute(httpMethod, new ResponseHandler<String>() {
            @Override
            public String handleResponse(final HttpResponse response) throws IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity1 = response.getEntity();
                    return entity1 != null ? EntityUtils.toString(entity1) : null;
                } else {
                    return "[Error] response status " + status;
                }
            }
        });
    }
    public static String postForm( Map<String, String> headers, Map<String,String> body,Boolean ... saveCookie) throws URISyntaxException, IOException {
        HttpPost httpPost = new HttpPost();
        if (StringUtils.isEmpty(Cookie)){
            headers.put("Cookie",Cookie);
        }
        buildHeaderParams(httpPost,headers);
        buildPostBody(httpPost,body);
        httpPost.setURI(new URIBuilder(URL).build());
        String responseBody = buildResult(httpClient.execute(httpPost),saveCookie);
        System.out.println("Response : " + responseBody);
        return responseBody;
    }

    public static String postUrlEncoded(String url, String postData)  throws IOException {

        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(postData, Consts.UTF_8);
        entity.setContentType("application/x-www-form-urlencoded");
        httpPost.setEntity(entity);
        return httpClient.execute(httpPost, new ResponseHandler<String>() {
            @Override
            public String handleResponse(final HttpResponse response) throws IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity1 = response.getEntity();
                    return entity1 != null ? EntityUtils.toString(entity1) : null;
                } else {
                    return "[Error] response status " + status;
                }
            }
        });

    }


    public static String postJsonStr(String url,String jsonStr) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("User-Agent", "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_0) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11");
        httpPost.setHeader("Content-Type", "application/json");
        StringEntity entity = new StringEntity(jsonStr, Consts.UTF_8);
        httpPost.setEntity(entity);

        return httpClient.execute(httpPost, new ResponseHandler<String>() {
            @Override
            public String handleResponse(final HttpResponse response) throws IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity1 = response.getEntity();
                    return entity1 != null ? EntityUtils.toString(entity1) : null;
                } else {
                    return "[Error] response status " + status;
                }
            }
        });
    }
}
