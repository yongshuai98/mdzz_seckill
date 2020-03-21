package com.shuai.seckill.service;

import com.shuai.seckill.mapper.dao.StockHistoryMapper;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @author yongshuai
 */
@Service
public class StockHistoryServiceImpl implements StockHistoryService {

    @Resource
    private StockHistoryMapper stockHistoryMapper;

}
