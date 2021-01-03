package com.spdb.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: ApplicationContextConfig
 * @Author: DELL
 * @Date: 2020/12/27 23:00
 * @Description: TODO
 **/
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced // 给RestTemplate赋予默认的负载均衡能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
