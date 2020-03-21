package com.shuai.seckill.service;

import com.shuai.seckill.mapper.dao.ProdOptionMapper;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @author yongshuai
 */
@Service
public class ProdOptionServiceImpl implements ProdOptionService {

    @Resource
    private ProdOptionMapper prodOptionMapper;

}
