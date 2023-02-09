package com.example.facebookClone.service;

import com.example.facebookClone.entity.User;

public interface UserService {
    Object signup(User user);

    User getUser(String name);
}
