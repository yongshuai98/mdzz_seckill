package com.shuai.seckill.controller;

import com.shuai.seckill.service.StockService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yongshuai
 */
@RequestMapping("stock")
@RestController
public class StockController {

    @Reference
    private StockService stockService;

}
