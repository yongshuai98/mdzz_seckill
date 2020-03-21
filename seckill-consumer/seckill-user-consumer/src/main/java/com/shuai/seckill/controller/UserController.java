package com.shuai.seckill.controller;

import com.shuai.seckill.dto.MdzzUserDto;
import com.shuai.seckill.entity.User;
import com.shuai.seckill.response.ResponseResult;
import com.shuai.seckill.response.ResponseResultMaker;
import com.shuai.seckill.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yongshuai
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;

    @GetMapping
    public ResponseResult<MdzzUserDto> info(HttpServletRequest request) {
        // 获取 token 对应的用户
        User user = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        // 封装并返回结果
        MdzzUserDto mdzzUserDto = new MdzzUserDto()
                .setUserId(user.getId())
                .setUsername(user.getUsername())
                .setAvatar(user.getHead())
                .setNickname(user.getNickname())
                .setToken(request.getParameter("access_token"))
                .setRole(user.getRole());

        return ResponseResultMaker.makeOkResponse("获取用户信息成功", mdzzUserDto);
    }


}
