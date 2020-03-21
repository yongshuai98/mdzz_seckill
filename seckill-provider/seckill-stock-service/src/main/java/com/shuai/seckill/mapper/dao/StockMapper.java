package com.shuai.seckill.mapper.dao;

import com.shuai.seckill.entity.Stock;
import com.shuai.seckill.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author liyongshuai
 * @date 2020/3/18 16:12
 */
@Mapper
@Repository
public interface StockMapper extends BaseMapper<Stock> {
}
