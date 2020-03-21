package com.shuai.seckill.controller;

import com.shuai.seckill.entity.Prod;
import com.shuai.seckill.response.ResponseResult;
import com.shuai.seckill.response.ResponseResultMaker;
import com.shuai.seckill.service.ProdService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RequestMapping("prod")
@RestController
public class ProdController {

    @Reference
    private ProdService prodService;

    @PostMapping
    public String insertProd(@RequestBody Prod prod) {
        if (prodService.saveProd(prod) > 0) {
            return "插入成功";
        }
        return "插入失败";
    }

    @GetMapping("{prodId}")
    public ResponseResult<Prod> getProdById(@PathVariable String prodId) {
        return ResponseResultMaker
                .makeOkResponse("获取商品成功", prodService.getProdById(Integer.parseInt(prodId)));
    }

    @GetMapping("list")
    public ResponseResult<List<Prod>> getAllProd() {
        List<Prod> allProd = prodService.getAllProd();
        log.info(allProd + "");
        return ResponseResultMaker.makeOkResponse("获取商品列表成功", allProd);
    }

    @DeleteMapping("{prodId}")
    public String deleteProd(@PathVariable Integer prodId) {
        if (prodService.deleteProdById(prodId) > 0) {
            return "删除成功";
        }
        return "删除失败";
    }

    @PutMapping
    public String updateProd(@RequestBody Prod prod) {
        if (prodService.updateProdById(prod) > 0) {
            return "修改成功";
        }
        return "修改失败";
    }

}
