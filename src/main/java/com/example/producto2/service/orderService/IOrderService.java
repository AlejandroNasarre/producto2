package com.example.producto2.service.orderService;

import com.example.producto2.model.Order;

import java.util.Optional;

public interface IOrderService {
    Object findAll();
    Optional<Order> findById(Long id);
    Order create(Order order);
    Order update(Order order);
    void delete(Long id);
}
