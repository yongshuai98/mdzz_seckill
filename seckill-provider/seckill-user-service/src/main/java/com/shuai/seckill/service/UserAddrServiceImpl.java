package com.shuai.seckill.service;

import com.shuai.seckill.entity.UserAddr;
import com.shuai.seckill.exceptions.ApiException;
import com.shuai.seckill.exceptions.Result;
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
    public UserAddr updateByUserAddrId(UserAddr userAddr) {
        if (userAddrMapper.updateByPrimaryKeySelective(userAddr) > 0) {
            return userAddrMapper.selectByPrimaryKey(userAddr.getId());
        }
        throw new ApiException(Result.UPDATE_FAILED);
    }

    @Override
    public Integer deleteByUserAddrId(Integer userAddrId) {
        return userAddrMapper.deleteByPrimaryKey(userAddrId);
    }

    @Override
    public UserAddr saveUserAddr(UserAddr userAddr) {
        if (userAddrMapper.insertSelective(userAddr) > 0) {
            return userAddrMapper.selectByPrimaryKey(userAddr.getId());
        }
        throw new ApiException(Result.SAVE_FAILED);
    }
}
