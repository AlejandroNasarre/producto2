package com.example.producto2.service.orderService;

import com.example.producto2.model.Orders;
import com.example.producto2.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class OrdersService implements IOrdersService {
    @Autowired
    private OrderRepository orderRepository;

    public Object findAll() {
        return this.orderRepository.findAll();
    }

    @Override
    public Optional<Orders> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Orders create(Orders order) {
        return orderRepository.save(order);
    }

    @Override
    public Orders update(Orders order) {
        Orders currentOrder = orderRepository.findById(order.getId()).get();
        currentOrder.setOrderNumber(order.getOrderNumber());
        currentOrder.setAddress(order.getAddress());
        return orderRepository.save(currentOrder);
    }
    @Override
    public void delete(Long id) {
        Optional<Orders> menu = orderRepository.findById(id);
        System.out.println(menu);
        orderRepository.deleteById(id);
    }
}
