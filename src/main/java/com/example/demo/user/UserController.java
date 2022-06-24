package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    @GetMapping("/")
    public String homePage(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            User user = this.userService.getUserByEmail(((UserDetails) principal).getUsername());

            model.addAttribute("user", user);
            model.addAttribute("chatrooms", this.userService.getUserChatrooms(user.getId()));
        }

        return "homePage.html";
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
