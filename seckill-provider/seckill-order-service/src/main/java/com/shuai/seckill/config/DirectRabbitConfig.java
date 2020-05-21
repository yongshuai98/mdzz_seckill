package com.shuai.seckill.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ配置类
 *
 * @author : yongshuai
 */
@Configuration
public class DirectRabbitConfig {

    @Bean
    public Queue TestDirectQueue() {
        //true 是否持久
        return new Queue("OrderQueue", true);
    }

    @Bean
    DirectExchange orderExchange() {
        return new DirectExchange("orderExchange");
    }

    @Bean
    Binding bindingDirect() {
        return BindingBuilder
                .bind(TestDirectQueue())
                .to(orderExchange())
                .with("orderRouting");
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}