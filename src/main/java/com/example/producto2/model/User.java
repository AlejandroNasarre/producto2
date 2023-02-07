package com.example.producto2.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "num_user")
    private Long id;

    private String name;

    private String surnames;
    private String email;
    private long phone;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "users_roles",
            joinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName =
                            "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Set<Role> rolesAssociated = new HashSet<>();
//    @OneToMany()
//    private Collection<Orders> orders;

    public User(String name,String surnames,String email,long phone, Collection<Orders> orders){
        this.name = name;
        this.surnames = surnames;
        this.email = email;
        this.phone = phone;

//        this.orders = orders;
    }

//    public Collection<Orders> getOrders() {
//        return orders;
//    }

//    public void setOrders(Collection<Orders> orders) {
//        this.orders = orders;
//    }



    public Set<Role> getRolesAssociated() {
        return rolesAssociated;
    }

    public void setRolesAssociated(Set<Role> rolesAssociated) {
        this.rolesAssociated = rolesAssociated;
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
