package com.boring.shardingjdbc.dao;

import com.boring.shardingjdbc.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author boring
 * @date 2020/11/3
 * @since 1.0
 */
@Mapper
@Repository
public interface OrderDAO {
    Integer create(OrderEntity orderEntity);
}
