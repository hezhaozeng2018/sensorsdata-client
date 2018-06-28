package com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.remote;

import org.apache.http.Consts;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * http接口请求工具类
 *
 * @author tangdengke
 * @date 2016/11/14 20:19
 * @copyright www.qguanzi.com Inc. All rights reserved.
 */
public class HttpProvider {


    private static final Logger logger = LoggerFactory.getLogger(HttpProvider.class);
    private static final int TIMEOUT = 5000;

    private HttpProvider() {

    }

    public static String httpPost(Map<String, String> requestParams, String url) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {

            List<NameValuePair> formparams = new ArrayList<>();
            for (Map.Entry<String, String> entry : requestParams.entrySet()) {
                formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(TIMEOUT)
                    .setConnectTimeout(TIMEOUT)
                    .build();
            HttpPost post = new HttpPost(url);
            post.setConfig(requestConfig);
            post.setEntity(formEntity);

            httpClient = HttpClients.createDefault();
            response = httpClient.execute(post);
            if (logger.isInfoEnabled()) {
                logger.info("httpPost|http请求，responseCode={}", response.getStatusLine().getStatusCode());
            }
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                return EntityUtils.toString(response.getEntity());
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {
                // IGNORE ERROR
            }
            try {
                HttpClientUtils.closeQuietly(httpClient);
            } catch (Exception e) {
                // IGNORE ERROR
            }
        }
        return null;
    }

}
