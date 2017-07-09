package com.hysky.cloud.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Created by Administrator on 2017/7/2.
 */
@Component
public class UserFallBackProvider implements ZuulFallbackProvider {

    @Override
    public String getRoute() {
        //表明为那个微服务提供路由 注意是微服务名称
        return "microservice-provider-user";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                //fallback时候的状态码
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                //数字类型状态码，本例返回200
                return this.getStatusCode().value();
            }

            @Override
            public String getStatusText() throws IOException {
                //返回 OK
                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                //响应体
                return new ByteArrayInputStream("用户微服务不可用，请稍后重试！".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                //headers 设置
                HttpHeaders headers = new HttpHeaders();
                MediaType mt = new MediaType("application","json", Charset.forName("UTF-8"));
                headers.setContentType(mt);
                return headers;
            }
        };
    }
}
