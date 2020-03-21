package com.shuai.seckill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yongshuai
 */
@RefreshScope
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class SeckillOauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(SeckillOauth2Application.class, args);
    }

}