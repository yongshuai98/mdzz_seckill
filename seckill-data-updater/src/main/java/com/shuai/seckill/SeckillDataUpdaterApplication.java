package com.shuai.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author yongshuai
 */
@RefreshScope
@MapperScan("com.shuai.seckill.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class SeckillDataUpdaterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillDataUpdaterApplication.class, args);
    }

}
