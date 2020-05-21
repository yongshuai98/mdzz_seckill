package com.shuai.seckill;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author yongshuai
 */
@RefreshScope
@EnableRabbit
@MapperScan("com.shuai.seckill.mapper.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class SeckillOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillOrderServiceApplication.class, args);
    }

}
