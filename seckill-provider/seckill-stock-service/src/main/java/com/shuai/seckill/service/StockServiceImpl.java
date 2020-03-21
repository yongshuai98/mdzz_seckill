package com.shuai.seckill.service;

import com.shuai.seckill.mapper.dao.StockMapper;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @author yongshuai
 */
@Service
public class StockServiceImpl implements StockService {

    @Resource
    private StockMapper stockMapper;

}
