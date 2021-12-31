package com.example.autoservice.controller;

import com.example.autoservice.global.GlobalData;
import com.example.autoservice.model.Role;
import com.example.autoservice.model.User;
import com.example.autoservice.repository.RoleRepository;
import com.example.autoservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/login")
    public String login() {
        GlobalData.booking.clear();
        return "login";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@ModelAttribute("user") User user, HttpServletRequest request) throws ServletException {
        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));

        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findById(2).get());

        user.setRoles(roles);
        userRepository.save(user);

        request.login(user.getEmail(), password);

        return "redirect:/";
    }
}
