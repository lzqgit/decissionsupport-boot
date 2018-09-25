package com.phy.decisionsupport.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientUtils {

    //传入接口地址
    public static String getResult(String remote_url){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = "";
        try{
            HttpPost httpPost = new HttpPost(remote_url);
            HttpResponse pos = httpClient.execute(httpPost);
            HttpEntity responseEntity = pos.getEntity();
            if(responseEntity!=null){
                result=EntityUtils.toString(responseEntity, "UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
