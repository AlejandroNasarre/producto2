package com.example.producto2.model;

import javax.persistence.*;

@Entity
@Table(name = "Producto")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String name;

    private String description;


    private double price;

    private double kcal;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(String name, String description, double kcal){
        this.name = name;
        this.description = description;
        this.kcal = kcal;
    }

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getKcal() {
        return kcal;
    }

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }
}