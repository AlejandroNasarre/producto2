package com.example.producto2.service.userService;

import com.example.producto2.model.User;
import com.example.producto2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService implements IUserService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public Object findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        User currentUser = userRepository.findById(user.getId()).get();
        currentUser.setUsername(user.getUsername());
        currentUser.setSurnames(user.getSurnames());
        currentUser.setEmail(user.getEmail());
        currentUser.setPhone(user.getPhone());
        return userRepository.save(currentUser);
    }

    @Override
    public void delete(Long id) {
        Optional<User> menu = userRepository.findById(id);
        System.out.println(menu);
        userRepository.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User registrar(User u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return userRepository.save(u);
    }
}
