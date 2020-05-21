package com.shuai.seckill.controller;

import com.shuai.seckill.entity.Order;
import com.shuai.seckill.response.ResponseResult;
import com.shuai.seckill.response.ResponseResultMaker;
import com.shuai.seckill.service.OrderService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yongshuai
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Reference
    private OrderService orderService;

    @Resource
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public ResponseResult<String> insertOrder(@RequestBody Order order) {
        Map<String, Order> map = new HashMap<>();
        map.put("order", order);

        //将消息携带绑定键值：orderRouting 发送到交换机 orderExchange
        rabbitTemplate.convertAndSend("orderExchange", "orderRouting", map);
        return ResponseResultMaker.makeOkResponse("恭喜您，您已成功抢到商品！");
    }

}
