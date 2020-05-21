package com.shuai.seckill;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author yongshuai
 */
@RefreshScope
@EnableRabbit
@EnableDiscoveryClient
@SpringBootApplication
public class SeckillOrderConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillOrderConsumerApplication.class, args);
    }

}
