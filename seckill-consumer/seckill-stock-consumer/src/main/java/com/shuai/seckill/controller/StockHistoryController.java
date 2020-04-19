package com.shuai.seckill.controller;

import com.shuai.seckill.service.StockHistoryService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yongshuai
 */
@RequestMapping("stock/history")
@RestController
public class StockHistoryController {

    @Reference
    private StockHistoryService stockHistoryService;

}
