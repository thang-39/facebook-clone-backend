package com.example.facebookClone.service;

import com.example.facebookClone.entity.User;
import com.example.facebookClone.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  BCryptPasswordEncoder encoder;

    @Override
    public Object signup(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return user = userRepository.save(user);
    }

//    @Override
//    public void login(User user) {
//        User user1 = userRepository.findByUsername(user.getUsername());
//        if (user1.getPassword().equals(encoder.encode(user.getPassword()))) {
//
//        }
//    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username).get();
    }



}
