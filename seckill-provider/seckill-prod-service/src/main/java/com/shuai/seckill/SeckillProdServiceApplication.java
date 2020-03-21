package com.shuai.seckill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author yongshuai
 */
@EnableCaching
@RefreshScope
@MapperScan("com.shuai.seckill.mapper.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class SeckillProdServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillProdServiceApplication.class, args);
    }

}
