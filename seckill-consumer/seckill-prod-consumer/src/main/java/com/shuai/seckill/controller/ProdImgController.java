package com.shuai.seckill.controller;

import com.shuai.seckill.service.ProdImgService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yongshuai
 */
@RequestMapping("prod/img")
@RestController
public class ProdImgController {

    @Reference
    private ProdImgService prodImgService;

}
