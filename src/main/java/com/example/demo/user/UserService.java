package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = this.userRepository.findByEmail(email);

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UsernameNotFoundException("User with email " + email + " not found");
        }
    }

    public String signUpUser(User user) {
        boolean emailTaken = this.userRepository.findByEmail(user.getEmail()).isPresent();

        if (emailTaken) {
            throw new IllegalStateException("Email taken");
        }

        String encodedPassword = this.bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        this.userRepository.save(user);

        return null;
    }

    public User getUserById(Long id) {
        Optional<User> userFind = this.userRepository.findById(id);
        if (userFind.isPresent()) {
            return userFind.get();
        }
        return null;
    }

    public User getUserByEmail(String email) {
        Optional<User> userFind = this.userRepository.findByEmail(email);
        if (userFind.isPresent()) {
            return userFind.get();
        }
        return null;
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }
}
