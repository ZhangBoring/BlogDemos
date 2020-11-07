package com.boring.shardingjdbc.controller;

import com.boring.shardingjdbc.entity.OrderEntity;
import com.boring.shardingjdbc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author boring
 * @date 2020/11/3
 * @since 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public OrderEntity createOrder(@RequestBody @Validated OrderEntity orderEntity) {
        return orderService.createOrder(orderEntity);
    }
}
