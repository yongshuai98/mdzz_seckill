package com.shuai.seckill.service;

import com.shuai.seckill.entity.OrderDetail;
import com.shuai.seckill.mapper.dao.OrderDetailMapper;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yongshuai
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Resource
    private OrderDetailMapper orderDetailMapper;

    @Override
    public Integer saveOrderDetail(OrderDetail orderDetail) {
        return orderDetailMapper.insertSelective(orderDetail);
    }

    @Override
    public List<OrderDetail> getByOrderId(Integer orderId) {
        return orderDetailMapper.selectByOrderId(orderId);
    }

    @Override
    public OrderDetail getById(Integer orderDetailId) {
        return orderDetailMapper.selectByPrimaryKey(orderDetailId);
    }
}
