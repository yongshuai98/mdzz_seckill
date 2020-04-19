package com.shuai.seckill.controller;

import com.shuai.seckill.service.OrderService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yongshuai
 */
@RestController
@RequestMapping("order/")
public class OrderController {

    @Reference
    private OrderService orderService;
}
