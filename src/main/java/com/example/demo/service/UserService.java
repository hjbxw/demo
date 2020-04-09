package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

public interface UserService {


    public User findUserById(String id);

    public User userLogin(User user);

    public int regUser(User user);



}
