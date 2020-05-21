package com.shuai.seckill.service;

import com.shuai.seckill.entity.Prod;
import com.shuai.seckill.exceptions.ApiException;
import com.shuai.seckill.exceptions.Result;
import com.shuai.seckill.mapper.dao.ProdMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yongshuai
 */
@Slf4j
@CacheConfig(cacheNames = "prod", cacheManager = "cacheManager")
@Service
public class ProdServiceImpl implements ProdService {

    @Resource
    private ProdMapper prodMapper;

    @Override
    @CachePut(key = "#result.id")
    public Prod saveProd(Prod prod) {
        if (prodMapper.insertSelective(prod) > 0) {
            return prodMapper.selectByPrimaryKey(prod.getId());
        }
        throw new ApiException(Result.SAVE_FAILED);
    }

    @Override
    @CachePut(key = "#result.id")
    public Prod updateProdById(Prod prod) {
        if (prodMapper.updateByPrimaryKey(prod) > 0) {
            return prodMapper.selectByPrimaryKey(prod.getId());
        }
        throw new ApiException(Result.UPDATE_FAILED);
    }

    @Override
    @CacheEvict(beforeInvocation = true, key = "#prodId")
    public Integer deleteProdById(Integer prodId) {
        return prodMapper.deleteByPrimaryKey(prodId);
    }

    @Override
    @Cacheable(key = "#prodId")
    public Prod getProdById(Integer prodId) {
        return prodMapper.selectByPrimaryKey(prodId);
    }

    @Override
    @Cacheable
    public List<Prod> getAllProd() {
        return prodMapper.selectAll();
    }

}
