package com.shuai.seckill.service;

import com.shuai.seckill.entity.OrderDetail;

import java.util.List;

/**
 * @author yongshuai
 */
public interface OrderDetailService {

    Integer saveOrderDetail(OrderDetail orderDetail);

    List<OrderDetail> getByOrderId(Integer orderId);

    OrderDetail getById(Integer orderDetailId);

}
