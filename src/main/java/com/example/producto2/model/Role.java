package com.example.producto2.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public Role(){}

    @ManyToMany(mappedBy = "rolesAssociated", fetch = FetchType.LAZY)
    private Set<User> usersAssociated = new LinkedHashSet<>();

    public Set<User> getUsersAssociated() {
        return usersAssociated;
    }

    public void setUsersAssociated(Set<User> usersAssociated) {
        this.usersAssociated = usersAssociated;
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
}