package com.shuai.seckill.mapper.dao;

import com.shuai.seckill.entity.OrderDetail;
import com.shuai.seckill.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liyongshuai
 * @date 2020/3/18 16:01
 */
@Mapper
@Repository
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {

    List<OrderDetail> selectByOrderId(Integer orderId);

}
