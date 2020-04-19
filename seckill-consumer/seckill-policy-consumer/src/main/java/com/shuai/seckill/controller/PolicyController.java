package com.shuai.seckill.controller;

import com.shuai.seckill.service.PolicyService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yongshuai
 */
@RequestMapping("policy")
@RestController
public class PolicyController {

    @Reference
    private PolicyService policyService;

}
