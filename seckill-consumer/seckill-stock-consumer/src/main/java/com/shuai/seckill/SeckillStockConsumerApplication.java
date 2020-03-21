package com.shuai.seckill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author yongshuai
 */
@RefreshScope
@EnableDiscoveryClient
@SpringBootApplication
public class SeckillStockConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillStockConsumerApplication.class, args);
    }

}
