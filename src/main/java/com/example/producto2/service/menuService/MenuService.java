package com.example.producto2.service.menuService;

import com.example.producto2.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.producto2.model.Menu;

import java.util.Optional;


@Service
public class MenuService implements IMenuService {
    @Autowired
    private MenuRepository menuRepository;

    public Object findAll() {
        return this.menuRepository.findAll();
    }

    @Override
    public Optional<Menu> findById(Long id) {
        return menuRepository.findById(id);
    }

    @Override
    public Menu create(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu update(Menu menu) {
        Menu currentMenu = menuRepository.findById(menu.getId()).get();
        currentMenu.setPrice(menu.getPrice());
        currentMenu.setName(menu.getName());
        return menuRepository.save(currentMenu);
    }
    @Override
    public void delete(Long id) {
        Optional<Menu> menu = menuRepository.findById(id);
        System.out.println(menu);
        menuRepository.deleteById(id);
    }

}
