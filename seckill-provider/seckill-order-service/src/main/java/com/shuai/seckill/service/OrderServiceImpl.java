package com.shuai.seckill.service;

import com.shuai.seckill.entity.Order;
import com.shuai.seckill.mapper.dao.OrderMapper;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yongshuai
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public Integer saveOrder(Order order) {
        return orderMapper.insertSelective(order);
    }

    @Override
    public Integer updateById(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public List<Order> getByUserId(Integer userId) {
        return orderMapper.selectByUserId(userId);
    }

    @Override
    public Order getById(Integer orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }
}
