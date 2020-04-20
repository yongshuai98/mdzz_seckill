package com.shuai.seckill.controller;

import com.shuai.seckill.dto.UserDto;
import com.shuai.seckill.entity.User;
import com.shuai.seckill.response.ResponseResult;
import com.shuai.seckill.response.ResponseResultMaker;
import com.shuai.seckill.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseResult<UserDto> getInfo(HttpServletRequest request) {
        // 获取 token 对应的用户
        User user = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        // 封装并返回结果
        UserDto userDto = new UserDto()
                .setUserId(user.getId())
                .setUsername(user.getUsername())
                .setAvatar(user.getHead())
                .setNickname(user.getNickname())
                .setToken(request.getParameter("access_token"))
                .setRole(user.getRole());

        return ResponseResultMaker.makeOkResponse("操作成功", userDto);
    }

    @PutMapping
    public ResponseResult<UserDto> updateUser(@RequestBody User user, HttpServletRequest request) {
        // 修改用户信息
        User userById = userService.updateUserById(user);
        // 封装并返回结果
        return ResponseResultMaker.makeOkResponse("操作成功",
                new UserDto().setUserId(userById.getId())
                        .setUsername(userById.getUsername())
                        .setAvatar(userById.getHead())
                        .setNickname(userById.getNickname())
                        .setToken(request.getParameter("access_token"))
                        .setRole(userById.getRole())
        );
    }

}
