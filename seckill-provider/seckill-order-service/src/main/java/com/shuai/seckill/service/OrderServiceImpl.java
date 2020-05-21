package com.shuai.seckill.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shuai.seckill.entity.Order;
import com.shuai.seckill.mapper.dao.OrderMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author yongshuai
 */
@Service
@RabbitListener(queues = "OrderQueue")
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private ObjectMapper objectMapper;

    @Override
    @RabbitHandler
    public void saveOrder(Map<String, Object> orderMap) {
        Object orderObject = orderMap.get("order");
        Order order = new Order();
        try {
            String s = objectMapper.writeValueAsString(orderObject);
            order = objectMapper.readValue(s, Order.class);
        } catch (IOException ignored) {
        }
        orderMapper.insertSelective(order);
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
