package com.shuai.seckill.service;

import com.shuai.seckill.entity.Order;

import java.util.List;
import java.util.Map;

/**
 * @author yongshuai
 */
public interface OrderService {

    void saveOrder(Map<String, Object> orderMap);

    Integer updateById(Order order);

    List<Order> getByUserId(Integer userId);

    Order getById(Integer orderId);

}
