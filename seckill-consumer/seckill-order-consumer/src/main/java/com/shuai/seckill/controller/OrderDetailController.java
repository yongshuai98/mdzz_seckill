package com.shuai.seckill.controller;

import com.shuai.seckill.service.OrderDetailService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yongshuai
 */
@RequestMapping("order/detail")
@RestController
public class OrderDetailController {

    @Reference
    OrderDetailService orderDetailService;
}
