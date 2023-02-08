package com.example.producto2.service.roleService;

import com.example.producto2.model.Role;
import com.example.producto2.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll(){
        return this.roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Role role) {
        Role currentRole = roleRepository.findById(role.getId()).get();
        currentRole.setName(role.getName());
        return roleRepository.save(currentRole);
    }

    @Override
    public void delete(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        roleRepository.deleteById(role.get().getId());
    }
}
