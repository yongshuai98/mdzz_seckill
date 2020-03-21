package com.shuai.seckill.service;

import com.shuai.seckill.entity.UserAddr;

import java.util.List;

/**
 * @author yongshuai
 */
public interface UserAddrService {

    UserAddr getById(Integer userAddrId);

    List<UserAddr> getByUserId(Integer userId);

    Integer updateByUserAddrId(UserAddr userAddr);

    Integer deleteByUserAddrId(Integer userAddrId);

    Integer saveUserAddr(UserAddr userAddr);

}
