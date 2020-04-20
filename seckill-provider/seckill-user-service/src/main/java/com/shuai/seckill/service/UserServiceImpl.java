package com.shuai.seckill.service;

import com.shuai.seckill.entity.User;
import com.shuai.seckill.exceptions.ApiException;
import com.shuai.seckill.exceptions.Result;
import com.shuai.seckill.mapper.dao.UserMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

/**
 * @author yongshuai
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Integer saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.insertSelective(user);
    }

    @Override
    public User updateUserById(User user) {
        if (userMapper.updateByPrimaryKeySelective(user) > 0) {
            return userMapper.selectByPrimaryKey(user.getId());
        }
        throw new ApiException(Result.UPDATE_FAILED);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

}
