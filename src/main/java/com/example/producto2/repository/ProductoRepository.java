package com.example.producto2.repository;

import com.example.producto2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<User, Long> {
}