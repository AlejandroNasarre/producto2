package com.example.producto2.service.userService;

import com.example.producto2.model.Order;
import com.example.producto2.model.User;
import com.example.producto2.repository.OrderRepository;
import com.example.producto2.repository.UserRepository;
import com.example.producto2.service.orderService.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService implements IUserService {
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
        currentUser.setName(user.getName());
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
}
