package com.example.producto2.service.menuService;

import com.example.producto2.model.Menu;

import java.util.Optional;

public interface IMenuService {
    Object findAll();
    Optional<Menu> findById(Long id);
    Menu create(Menu menu);
    Menu update(Menu menu);
    void delete(Long id);

}
