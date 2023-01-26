package com.example.producto2;

import com.example.producto2.repository.OrderRepository;
import com.example.producto2.seeds.Seeds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.producto2.repository.MenuRepository;

@SpringBootApplication
public class Producto2Application {
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    OrderRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(Producto2Application.class, args);
    }

    @Bean
    void commandLineRunner() {
        Seeds seeds = new Seeds(menuRepository, orderRepository);
        seeds.generateSeeds();
    }
}
