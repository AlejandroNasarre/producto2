package com.example.producto2.service.roleService;

import com.example.producto2.model.Role;
import java.util.List;
import java.util.Optional;

public interface IRoleService {
    List<Role> findAll();
    Optional<Role> findById(Long id);
    Role create(Role menu);
    Role update(Role menu);
    void delete(Long id);
}
