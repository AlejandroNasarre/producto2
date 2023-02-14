package com.example.producto2.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Product")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String name;

    private String description;

    private double price;

    private double kcal;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "menu_products",
            joinColumns = {
                    @JoinColumn(name = "product_id", referencedColumnName =
                            "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "menu_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Set<Menu> menusAssociated = new HashSet<>();

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

    public Set<Menu> getMenusAssociated() {
        return menusAssociated;
    }

    public void setMenusAssociated(Set<Menu> menusAssociated) {
        this.menusAssociated = menusAssociated;
    }

}