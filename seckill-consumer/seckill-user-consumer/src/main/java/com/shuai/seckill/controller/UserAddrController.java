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

    @GetMapping("/get/{userAddrId}")
    public UserAddr getByUserAddrId(@PathVariable Integer userAddrId) {
        return userAddrService.getById(userAddrId);
    }

    @GetMapping("/all/{userId}")
    public ResponseResult<List<UserAddr>> getByUserId(@PathVariable Integer userId) {
        return ResponseResultMaker.makeOkResponse("获取地址列表成功", userAddrService.getByUserId(userId));
    }

    @PutMapping("/update")
    public String updateByUserAddrId(@RequestBody UserAddr userAddr) {
        if (userAddrService.updateByUserAddrId(userAddr) > 0) {
            return "修改成功";
        }
        return "修改失败";
    }

    @DeleteMapping("/delete/{userAddrId}")
    public String deleteByUserAddrId(@PathVariable Integer userAddrId) {
        if (userAddrService.deleteByUserAddrId(userAddrId) > 0) {
            return "删除成功";
        }
        return "删除失败";
    }

    @PostMapping("/insert")
    public String insertUserAddr(@RequestBody UserAddr userAddr) {
        if (userAddrService.saveUserAddr(userAddr) > 0) {
            return "增加成功";
        }
        return "增加失败";
    }
}
