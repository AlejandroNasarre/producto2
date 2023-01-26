package com.example.producto2.model;

import javax.persistence.*;

@Entity
@Table(name= "Orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private Long orderNumber;
    private String address;

    @ManyToOne
    @JoinColumn(name = "num_user", referencedColumnName = "num_user")
    private User user;

    public Orders(Long orderNumber, String address,User user){
        this.orderNumber = orderNumber;
        this.address = address;
        this.user = user;
    }

    public Orders(){

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
