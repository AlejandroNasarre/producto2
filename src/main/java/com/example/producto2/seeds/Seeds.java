package com.example.producto2.seeds;

import com.example.producto2.model.Menu;
import com.example.producto2.model.Orders;
import com.example.producto2.model.User;
import com.example.producto2.repository.MenuRepository;
import com.example.producto2.repository.OrderRepository;

import java.util.LinkedList;
import java.util.List;

public class Seeds {
    private MenuRepository menuRepository;
    private OrderRepository orderRepository;

    public Seeds(MenuRepository menuRepository, OrderRepository orderRepository) {
        this.menuRepository = menuRepository;
        this.orderRepository = orderRepository;
    }

    public void generateSeeds() {

        Menu menuLibanes = new Menu("Libanes", 30.5);
        Menu menuVeggie = new Menu("Veggie", 20);
        Menu menuBurguer = new Menu("Libanes", 25);

        User user = new User("1", "11", "1@gmail.com", 1, new LinkedList<Orders>());
        User user2 = new User("2","22","2@gmail.com",2,new LinkedList<Orders>());
        User user3 = new User("3","33","1@gmail.com",3,new LinkedList<Orders>());

        Orders order = new Orders(1l, "calle pedido numero 1",user);
        Orders order2 = new Orders(2l, "calle pedido numero 2",user2);
        Orders order3 = new Orders(3l, "calle pedido numero 3",user3);

        menuRepository.save(menuLibanes);
        menuRepository.save(menuVeggie);
        menuRepository.save(menuBurguer);

        orderRepository.save(order);
        orderRepository.save(order2);
        orderRepository.save(order3);
    }
}
