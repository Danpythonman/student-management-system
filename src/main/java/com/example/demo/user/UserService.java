package com.example.demo.user;

import com.example.demo.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        Optional<User> userFind = this.userRepository.findById(id);
        if (userFind.isPresent()) {
            return userFind.get();
        }
        return null;
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }
}
