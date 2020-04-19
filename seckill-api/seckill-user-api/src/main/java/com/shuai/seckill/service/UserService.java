package com.shuai.seckill.service;

import com.shuai.seckill.entity.User;

/**
 * @author yongshuai
 */
public interface UserService {

    /**
     * 新增用户
     *
     * @param user {@link User}
     * @return 大于 0 则表示新增成功
     */
    Integer saveUser(User user);

    /**
     * 修改用户信息
     *
     * @param user {@link User}
     * @return 大于 0 则表示修改成功
     */
    Integer updateUserById(User user);

    /**
     * 根据用户账户获取用户
     *
     * @param username 用户账户
     * @return {@link User}
     */
    User getUserByUsername(String username);

    /**
     * 根据用户主键获取用户
     *
     * @param userId 用户表主键
     * @return {@link User}
     */
    User getUserById(Integer userId);

}
