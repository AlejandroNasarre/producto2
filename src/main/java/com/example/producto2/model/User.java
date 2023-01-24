package com.example.producto2.model;

import javax.persistence.*;

@Entity
@Table(name = "User")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String name;

    private String surnames;
    private String email;
    private long phone;

    public User(String name,String surnames,String email,long phone){
        this.name = name;
        this.surnames = surnames;
        this.email = email;
        this.phone = phone;
    }

    public User(){

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

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
