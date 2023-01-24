package com.example.producto2.service.orderService;

import com.example.producto2.model.Menu;
import com.example.producto2.model.Order;
import com.example.producto2.repository.MenuRepository;
import com.example.producto2.repository.OrderRepository;
import com.example.producto2.service.menuService.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Object findAll() {
        return this.orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        Order currentOrder = orderRepository.findById(order.getId()).get();
        currentOrder.setOrderNumber(order.getOrderNumber());
        currentOrder.setAddress(order.getAddress());
        return orderRepository.save(currentOrder);
    }
    @Override
    public void delete(Long id) {
        Optional<Order> menu = orderRepository.findById(id);
        System.out.println(menu);
        orderRepository.deleteById(id);
    }
}
