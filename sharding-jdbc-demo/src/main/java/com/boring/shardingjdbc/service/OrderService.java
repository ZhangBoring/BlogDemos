package com.boring.shardingjdbc.service;

import com.boring.shardingjdbc.entity.OrderEntity;

/**
 * @author boring
 * @date 2020/11/3
 * @since 1.0
 */
public interface OrderService {
    OrderEntity createOrder(OrderEntity orderEntity);
}
