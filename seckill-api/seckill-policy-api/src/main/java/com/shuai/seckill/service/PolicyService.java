package com.shuai.seckill.service;

import com.shuai.seckill.entity.Policy;

/**
 * @author yongshuai
 */
public interface PolicyService {

    Integer savePolicy(Policy policy);

    Integer updatePolicyById(Policy policy);

    Policy getPolicyById(Integer policyId);

}
