package com.shuai.seckill.service;

import com.shuai.seckill.entity.Order;

import java.util.List;

/**
 * @author yongshuai
 */
public interface OrderService {

    Integer saveOrder(Order order);

    Integer updateById(Order order);

    List<Order> getByUserId(Integer userId);

    Order getById(Integer orderId);

}
