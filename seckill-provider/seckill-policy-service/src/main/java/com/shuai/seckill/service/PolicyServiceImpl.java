package com.shuai.seckill.service;

import com.shuai.seckill.entity.Policy;
import com.shuai.seckill.mapper.dao.PolicyMapper;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @author yongshuai
 */
@Service
public class PolicyServiceImpl implements PolicyService {

    @Resource
    private PolicyMapper policyMapper;

    @Override
    public Integer savePolicy(Policy policy) {
        return policyMapper.insertSelective(policy);
    }

    @Override
    public Integer updatePolicyById(Policy policy) {
        return policyMapper.updateByPrimaryKeySelective(policy);
    }

    @Override
    public Policy getPolicyById(Integer policyId) {
        return policyMapper.selectByPrimaryKey(policyId);
    }

}
