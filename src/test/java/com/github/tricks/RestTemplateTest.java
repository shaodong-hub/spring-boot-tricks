package com.github.tricks;

import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * @author 石少东
 * @date 2020-10-09 21:37
 * @since 1.0
 */

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class RestTemplateTest {

    private final RestTemplate restTemplate = new RestTemplate();




    @Test
    public void init() {
        String url = "http://ddns.oray.com/checkip";
        //发送请求
        String result = getRestTemplate().getForObject(url, String.class);
        System.out.println(result);  //打印响应结果

    }


    private RestTemplate getRestTemplate(){
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(outerHttpClient());
        return new RestTemplate(clientHttpRequestFactory);
    }
    public CloseableHttpClient outerHttpClient() {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        // Increase max total connection to 200
        cm.setMaxTotal(200);
        // Increase default max connection per route to 20
        cm.setDefaultMaxPerRoute(20);
        HttpHost proxy = new HttpHost("112.80.255.29", 80);
        return HttpClients.custom()
                .setConnectionManager(cm)
                .setProxy(proxy)
                .build();
    }


}
