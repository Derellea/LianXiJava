package com.derellea.service;

import com.derellea.domain.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User findByUsernameAndPassword(User user);
}
