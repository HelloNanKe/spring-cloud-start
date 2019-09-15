package com.zt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerRibbon8083Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbon8083Application.class, args);
    }

}
