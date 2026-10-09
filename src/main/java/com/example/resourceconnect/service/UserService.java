package com.example.resourceconnect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.resourceconnect.entity.User;
import com.example.resourceconnect.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User loginUser(String email, String password) {

        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent() &&
                user.get().getPassword().equals(password)) {

            return user.get();
        }

        return null;
    }
}

