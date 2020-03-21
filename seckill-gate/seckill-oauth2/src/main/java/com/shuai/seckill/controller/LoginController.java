package com.shuai.seckill.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shuai.seckill.dto.UserParam;
import com.shuai.seckill.entity.User;
import com.shuai.seckill.feignservice.FeignUserService;
import com.shuai.seckill.response.ResponseResult;
import com.shuai.seckill.response.ResponseResultMaker;
import com.shuai.seckill.service.UserService;
import com.shuai.seckill.utils.OkHttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author yongshuai
 */
@Slf4j
@RefreshScope
@RestController
public class LoginController {

    @Value("${oauth2.oauth_token_url}")
    private String oauthTokenUrl;

    @Value("${oauth2.grant_type}")
    private String grantType;

    @Value("${oauth2.client_id}")
    private String clientId;

    @Value("${oauth2.client_secret}")
    private String clientSecret;

    @Resource(name = "userDetailsService")
    private UserDetailsService userDetailsService;

    @Resource(name = "passwordEncoder")
    private BCryptPasswordEncoder passwordEncoder;

    @Resource(name = "tokenStore")
    private TokenStore tokenStore;

    @Resource
    private FeignUserService feignUserService;

    @Resource
    private ObjectMapper objectMapper;

    @Reference
    private UserService userService;

    /**
     * 用户注册
     *
     * @param userParam 用户的注册信息
     * @return 反馈信息，用户是否注册成功
     */
    @PostMapping("register")
    public ResponseResult<String> register(@RequestBody UserParam userParam) {
        User user = new User().setUsername(userParam.getUsername())
                .setPassword(userParam.getPassword());

        boolean canRegister = validateCanRegister(user);
        if (canRegister) {
            if (userService.saveUser(user) > 0) {
                return ResponseResultMaker.makeOkResponse("注册成功，为你跳转到登录页面");
            }
        }
        return ResponseResultMaker.makeErrResponse("您早已注册，可直接登录");
    }

    @PostMapping("/login")
    public ResponseResult<Map<String, Object>> login(@RequestBody UserParam userParam) {
        // 判断用户名和账户的正确性
        UserDetails userDetails = userDetailsService.loadUserByUsername(userParam.getUsername());
        // 用户不存在
        if (userDetails == null) {
            return ResponseResultMaker.makeResponse(ResponseResultMaker.StatusCode.USER_NOT_FOUND, "用户不存在");
        }
        // 密码错误
        else if (!passwordEncoder.matches(userParam.getPassword(), userDetails.getPassword())) {
            return ResponseResultMaker.makeResponse(ResponseResultMaker.StatusCode.ILLEGAL_TOKEN, "用户名或密码错误");
        }

        // 组装用来获取 token 的参数
        Map<String, String> param = new HashMap<>(5);
        param.put("username", userParam.getUsername());
        param.put("password", userParam.getPassword());
        param.put("grant_type", grantType);
        param.put("client_id", clientId);
        param.put("client_secret", clientSecret);

        log.info("接受到登录请求: " + param);

        // 获取 token
        Map<String, Object> map = new HashMap<>(1);
        try {
            Response response = OkHttpClientUtil.getInstance().postData(oauthTokenUrl, param);
            String resJson = Objects.requireNonNull(response.body()).string();
            Object accessToken = objectMapper.readValue(resJson, Map.class).get("access_token");
            map.put("token", accessToken);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseResultMaker.makeOkResponse("欢迎您登录", map);
    }

    @PostMapping("/logout")
    public ResponseResult<Void> logout(HttpServletRequest request) {
        // 获取 token
        String token = request.getParameter("access_token");
        // 删除 token 以注销
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token);
        tokenStore.removeAccessToken(oAuth2AccessToken);
        return ResponseResultMaker.makeOkResponse("用户已注销");
    }

    /**
     * 检查用户是否可以注册，不存在则可以注册
     *
     * @param user 要检验的用户信息
     * @return true：用户不存在，可以注册；false：用户已存在，不能再次注册
     */
    private boolean validateCanRegister(User user) {
        // 验证用户是否存在
        return Objects.equals(userService.getUserByUsername(user.getUsername()), null);
    }

}
