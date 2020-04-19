package com.shuai.seckill.controller;

import com.shuai.seckill.service.ProdOptionService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yongshuai
 */
@RequestMapping("prod/option")
@RestController
public class ProdOptionController {

    @Reference
    private ProdOptionService prodOptionService;

}
