package com.example.demo.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.user.User;
import com.example.demo.user.UserService;

@Service
public class RegistrationService {

    private final UserService userService;

    @Autowired
    public RegistrationService(UserService userService) {
        this.userService = userService;
    }

    public String register(RegistrationRequest request) {
        User user = new User(request.getFname(), request.getLname(), request.getEmail(), request.getPassword());

        this.userService.signUpUser(user);

        // Return the password hash just for testing purposes
        return this.userService.getUsers().get(1).getPassword();
    }

}
