package com.zt.comsumer_8081.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zt
 * @Date: 2019/9/14 9:21 上午
 */
@Configuration
public class MainConfig {

    @Bean
    @LoadBalanced//轮询
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
