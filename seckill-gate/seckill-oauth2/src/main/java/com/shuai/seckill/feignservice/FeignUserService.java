package com.shuai.seckill.feignservice;

import com.shuai.seckill.entity.User;
import com.shuai.seckill.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yongshuai
 */
@FeignClient("seckill-user-consumer")
public interface FeignUserService {

    /**
     * 获取用户信息
     *
     * @param username 用户名
     * @return {@link User}
     */
    @GetMapping("/user/profile/{username}")
    ResponseResult<User> profile(@PathVariable("username") String username);

}
