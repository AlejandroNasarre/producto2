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

    private String username;

    private String surnames;
    private String email;
    private long phone;

    private String password;

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

    public User(String username, String surnames, String email, String password, long phone, Collection<Orders> orders){
        this.username = username;
        this.surnames = surnames;
        this.email = email;
        this.phone = phone;
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
