package com.example.producto2.service.userService;

import com.example.producto2.model.User;

import java.util.Optional;

public interface IUserService {
    Object findAll();
    Optional<User> findById(Long id);
    User create(User user);
    User update(User user);
    void delete(Long id);
    public User findByUsername(String username);
    public User registrar (User u);
}
