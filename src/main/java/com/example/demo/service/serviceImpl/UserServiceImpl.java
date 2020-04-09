package com.example.demo.service.serviceImpl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
   private UserMapper userMapper;

    //用户登录
    @Override
    public User userLogin(User user) {
        return userMapper.userLogin(user);
    }

    @Override
    public User findUserById(String id) {
        return userMapper.findUserById(id);
    }

    //用户注册
    @Override
    public int regUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
