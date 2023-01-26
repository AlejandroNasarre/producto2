package com.example.producto2.service.orderService;

import com.example.producto2.model.Orders;

import java.util.Optional;

public interface IOrdersService {
    Object findAll();
    Optional<Orders> findById(Long id);
    Orders create(Orders order);
    Orders update(Orders order);
    void delete(Long id);
}
