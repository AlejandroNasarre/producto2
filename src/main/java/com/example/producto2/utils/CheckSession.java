package com.example.producto2.utils;

import com.example.producto2.model.Role;
import com.example.producto2.model.User;
import com.example.producto2.service.roleService.RoleService;
import com.example.producto2.service.userService.IUserService;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CheckSession {
    private final Authentication auth;
    private final HttpSession session;
    private final IUserService userService;
    private final RoleService roleService;

    public CheckSession(Authentication auth, HttpSession session,
                        IUserService userService, RoleService roleService) {
        this.auth = auth;
        this.session = session;
        this.userService = userService;
        this.roleService = roleService;
    }

    public void validate(){
        String userName = null;
        if(auth != null) {
            userName = auth.getName();
        }
        if(session.getAttribute("usuario") == null) {
            User user = this.userService.findByUsername(userName);

            if (user != null) {
                Set<Role> userRoles = user.getRolesAssociated();
                List<String> roles = new ArrayList<>();
                for (Role userRole : userRoles) {
                    assert false;
                    roles.add(userRole.getName());
                }
                assert false;
                session.setAttribute("role", roles.get(0));
                user.setPassword(null);
                session.setAttribute("usuario", user);
            }
        }
    }
}
