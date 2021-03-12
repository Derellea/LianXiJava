package com.derellea.service.impl;

import com.derellea.domain.User;
import com.derellea.mapper.UserMapper;
import com.derellea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Transactional
    public User findByUsernameAndPassword(User user) {

        User u=null;
        try{
            u=userMapper.findByUsernameAndPassword(user);
        }catch (Exception e){

        }
       return  u;

    }
}
