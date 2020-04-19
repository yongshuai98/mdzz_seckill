package com.shuai.seckill.controller;

import com.shuai.seckill.entity.Prod;
import com.shuai.seckill.response.ResponseResult;
import com.shuai.seckill.response.ResponseResultMaker;
import com.shuai.seckill.service.ProdService;
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
@RequestMapping("prod")
@RestController
public class ProdController {

    @Reference
    private ProdService prodService;

    @PostMapping
    public ResponseResult<Prod> insertProd(@RequestBody Prod prod) {
        if (prodService.saveProd(prod) > 0) {
            Prod prodById = prodService.getProdById(prod.getId());
            return ResponseResultMaker.makeOkResponse("操作成功", prodById);
        }
        return ResponseResultMaker.makeErrResponse("操作失败");
    }

    @GetMapping("{prodId}")
    public ResponseResult<Prod> getProd(@PathVariable String prodId) {
        Prod prodById = prodService.getProdById(Integer.parseInt(prodId));
        if (prodById != null) {
            return ResponseResultMaker.makeOkResponse("操作成功", prodById);
        }
        return ResponseResultMaker.makeErrResponse("操作失败");
    }

    @GetMapping("list")
    public ResponseResult<List<Prod>> getAllProd() {
        List<Prod> allProd = prodService.getAllProd();
        return ResponseResultMaker.makeOkResponse("操作成功", allProd);
    }

    @DeleteMapping("{prodId}")
    public ResponseResult<String> deleteProd(@PathVariable Integer prodId) {
        if (prodService.deleteProdById(prodId) > 0) {
            return ResponseResultMaker.makeOkResponse("操作成功");
        }
        return ResponseResultMaker.makeErrResponse("操作失败");
    }

    @PutMapping
    public ResponseResult<Prod> updateProd(@RequestBody Prod prod) {
        if (prodService.updateProdById(prod) > 0) {
            Prod prodById = prodService.getProdById(prod.getId());
            return ResponseResultMaker.makeOkResponse("操作成功", prodById);
        }
        return ResponseResultMaker.makeErrResponse("操作失败");
    }

}
