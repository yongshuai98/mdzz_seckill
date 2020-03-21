package com.shuai.seckill.service;

import com.shuai.seckill.entity.UserAddr;
import com.shuai.seckill.mapper.dao.UserAddrMapper;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yongshuai
 */
@Service
public class UserAddrServiceImpl implements UserAddrService {

    @Resource
    private UserAddrMapper userAddrMapper;

    @Override
    public UserAddr getById(Integer userAddrId) {
        return userAddrMapper.selectByPrimaryKey(userAddrId);
    }

    @Override
    public List<UserAddr> getByUserId(Integer userId) {
        return userAddrMapper.selectByUserId(userId);
    }

    @Override
    public Integer updateByUserAddrId(UserAddr userAddr) {
        return userAddrMapper.updateByPrimaryKeySelective(userAddr);
    }

    @Override
    public Integer deleteByUserAddrId(Integer userAddrId) {
        return userAddrMapper.deleteByPrimaryKey(userAddrId);
    }

    @Override
    public Integer saveUserAddr(UserAddr userAddr) {
        return userAddrMapper.insertSelective(userAddr);
    }
}
