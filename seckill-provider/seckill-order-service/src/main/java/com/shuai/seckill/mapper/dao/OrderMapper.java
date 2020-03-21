package com.shuai.seckill.mapper.dao;

import com.shuai.seckill.entity.Order;
import com.shuai.seckill.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liyongshuai
 * @date 2020/3/18 16:05
 */
@Mapper
@Repository
public interface OrderMapper extends BaseMapper<Order> {

    List<Order> selectByUserId(Integer userId);

}
