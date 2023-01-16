package com.example.producto2.service.menuService;

import com.example.producto2.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.producto2.model.Menu;

import java.util.Optional;


@Service
public class MenuService implements IMenuService{
    @Autowired
    private MenuRepository menuRepository;

    public Object findAll() { return this.menuRepository.findAll();}

    @Override
    public Optional<Menu> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Menu create(Menu menu) {
        return null;
    }

    @Override
    public Menu update(Menu menu) {
        return null;
    }

    @Override
    public Menu delete(Long id) {
        return null;
    }


}
