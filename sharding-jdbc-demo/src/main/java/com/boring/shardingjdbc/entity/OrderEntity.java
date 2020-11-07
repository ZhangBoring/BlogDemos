package com.boring.shardingjdbc.entity;

import java.math.BigDecimal;

/**
 * order data transfer object
 *
 * @author boring
 * @date 2020/11/3
 * @since 1.0
 */
public class OrderEntity {
    private Integer id;
    private Integer userId;
    private Integer orderId;
    private BigDecimal amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
