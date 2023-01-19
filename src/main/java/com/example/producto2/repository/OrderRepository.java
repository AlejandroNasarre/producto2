package com.example.producto2.repository;

import com.example.producto2.model.Menu;
import com.example.producto2.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
