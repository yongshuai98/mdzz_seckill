package com.shuai.seckill.controller;

import com.shuai.seckill.entity.UserAddr;
import com.shuai.seckill.response.ResponseResult;
import com.shuai.seckill.response.ResponseResultMaker;
import com.shuai.seckill.service.UserAddrService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yongshuai
 */
@RestController
@RequestMapping("/user-addr")
public class UserAddrController {

    @Reference
    private UserAddrService userAddrService;

    @GetMapping("{userAddrId}")
    public ResponseResult<UserAddr> getUserAddr(@PathVariable Integer userAddrId) {
        UserAddr addr = userAddrService.getById(userAddrId);
        return ResponseResultMaker.makeOkResponse("操作成功", addr);
    }

    @GetMapping("/all/{userId}")
    public ResponseResult<List<UserAddr>> getUserAddrs(@PathVariable Integer userId) {
        List<UserAddr> addrs = userAddrService.getByUserId(userId);
        return ResponseResultMaker.makeOkResponse("操作成功", addrs);
    }

    @PutMapping
    public ResponseResult<UserAddr> updateUserAddr(@RequestBody UserAddr userAddr) {
        if (userAddrService.updateByUserAddrId(userAddr) > 0) {
            UserAddr addrById = userAddrService.getById(userAddr.getId());
            return ResponseResultMaker.makeOkResponse("操作成功", addrById);
        }
        return ResponseResultMaker.makeErrResponse("操作失败");
    }

    @DeleteMapping("{userAddrId}")
    public ResponseResult<String> deleteUserAddr(@PathVariable Integer userAddrId) {
        if (userAddrService.deleteByUserAddrId(userAddrId) > 0) {
            return ResponseResultMaker.makeOkResponse("操作成功");
        }
        return ResponseResultMaker.makeErrResponse("操作失败");
    }

    @PostMapping
    public ResponseResult<List<UserAddr>> insertUserAddr(@RequestBody UserAddr userAddr) {
        if (userAddrService.saveUserAddr(userAddr) > 0) {
            List<UserAddr> addrs = userAddrService.getByUserId(userAddr.getUserId());
            return ResponseResultMaker.makeOkResponse("操作成功", addrs);
        }
        return ResponseResultMaker.makeErrResponse("操作失败");
    }

}
