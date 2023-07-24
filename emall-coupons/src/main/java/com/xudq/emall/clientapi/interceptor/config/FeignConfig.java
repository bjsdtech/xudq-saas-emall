package com.xudq.emall.clientapi.interceptor.config;

import com.xudq.emall.clientapi.interceptor.HeaderInterceptor;
import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * Created by smlz on 2020/2/2.
 */
public class FeignConfig {

    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new HeaderInterceptor();
    }

}
