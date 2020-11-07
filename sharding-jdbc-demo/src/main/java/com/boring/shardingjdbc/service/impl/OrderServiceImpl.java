package com.boring.shardingjdbc.service.impl;

import com.boring.shardingjdbc.dao.OrderDAO;
import com.boring.shardingjdbc.entity.OrderEntity;
import com.boring.shardingjdbc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author boring
 * @date 2020/11/3
 * @since 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;

    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public OrderEntity createOrder(OrderEntity orderEntity) {
        orderEntity.setId(orderDAO.create(orderEntity));
        return orderEntity;
    }
}
