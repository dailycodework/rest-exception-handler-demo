package com.fixdecode.restexceptiondemo.model;

import com.fixdecode.restexceptiondemo.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public List<User> getAllUsers() {
       return userRepository.findAll().stream().toList();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->new UserNotFoundException(String.format("User with Id %s not fond",id)));
    }
}
