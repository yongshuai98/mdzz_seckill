package com.shuai.seckill.service;

import com.shuai.seckill.entity.Prod;
import com.shuai.seckill.mapper.dao.ProdMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.cache.annotation.CacheConfig;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yongshuai
 */
@Slf4j
@CacheConfig(cacheNames = "prod")
@Service
public class ProdServiceImpl implements ProdService {

    @Resource
    private ProdMapper prodMapper;

    @Override
    public Integer saveProd(Prod prod) {
        return prodMapper.insertSelective(prod);
    }

    @Override
    public Integer updateProdById(Prod prod) {
        return prodMapper.updateByPrimaryKey(prod);
    }

    @Override
    public Integer deleteProdById(Integer prodId) {
        return prodMapper.deleteByPrimaryKey(prodId);
    }

    @Override
    public Prod getProdById(Integer prodId) {
        return prodMapper.selectByPrimaryKey(prodId);
    }

    @Override
    public List<Prod> getAllProd() {
        List<Prod> prods = prodMapper.selectAll();
        log.info(prods + "");
        return prods;
    }
}
