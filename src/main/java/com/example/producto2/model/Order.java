package com.example.producto2.model;

import javax.persistence.*;

@Entity
@Table(name= "Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private Long orderNumber;
    private String address;

    public Order(Long orderNumber,String address){
        this.orderNumber = orderNumber;
        this.address = address;
    }

    public Order(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
