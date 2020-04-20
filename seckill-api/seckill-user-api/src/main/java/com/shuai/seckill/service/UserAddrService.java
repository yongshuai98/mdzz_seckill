package com.shuai.seckill.service;

import com.shuai.seckill.entity.UserAddr;

import java.util.List;

/**
 * @author yongshuai
 */
public interface UserAddrService {

    /**
     * 通过主键获取用户地址
     *
     * @param userAddrId 用户地址表主键
     * @return {@link UserAddr}
     */
    UserAddr getById(Integer userAddrId);

    /**
     * 通过用户主键获取该用户所有的用户地址
     *
     * @param userId 用户表主键
     * @return {@link UserAddr}
     */
    List<UserAddr> getByUserId(Integer userId);

    /**
     * 修改一个用户地址
     *
     * @param userAddr {@link UserAddr}
     * @return {@link UserAddr} 修改成功后将修改的用户地址返回
     */
    UserAddr updateByUserAddrId(UserAddr userAddr);

    /**
     * 删除一个用户地址
     *
     * @param userAddrId 要删除的用户地址的主键
     * @return 此操作对数据表记录的影响条数
     */
    Integer deleteByUserAddrId(Integer userAddrId);

    /**
     * 新增保存一个用户地址
     *
     * @param userAddr {@link UserAddr}
     * @return {@link UserAddr} 新增成功后将新增的用户地址返回
     */
    UserAddr saveUserAddr(UserAddr userAddr);

}
