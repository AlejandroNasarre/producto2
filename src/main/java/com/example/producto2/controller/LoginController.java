package com.example.producto2.controller;

import com.example.producto2.model.Role;
import com.example.producto2.model.User;
import com.example.producto2.repository.UserRepository;
import com.example.producto2.service.roleService.RoleService;
import com.example.producto2.service.userService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    private IUserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/auth/login")
    public String login (Model model) {
        model.addAttribute("usuario", new User());
        return "login";
    }

    @PostMapping("/auth/login")
    public String loginPost () {
        return "home";
    }

    @GetMapping("/auth/registro")
    public String registroForm (Model model) {
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("usuario", new User());
        return "register";
    }

    @PostMapping("/auth/registro")
    public String registro (@Valid @ModelAttribute User user,
                            @RequestParam("role") String roleId,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/auth/registro";
        } else {
            Optional<Role> selectedRole = roleService.findById(Long.parseLong(roleId));
            if(selectedRole.isPresent()){
                userService.registrar(user);
                user.getRolesAssociated().addAll((List.of(selectedRole.get())));
                userRepository.save(user);
            }
            System.out.println("selectedRole: " + selectedRole.get().getName());
            System.out.println("usuario: " + user.getUsername());
            model.addAttribute("usuario", user);

            if(Objects.equals(selectedRole.get().getName(), "admin")){
                return "redirect:/";
            }
        }
        return "redirect:/auth/login";
    }
}
