package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/signIn")
    public String signIn() {
        return "signIn";
    }

    @GetMapping("/user/{id}")
    public String pageView(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", this.userService.getUserById(id));
        return "viewUser.html";
    }
}
