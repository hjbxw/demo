package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.Video;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {


    public User findUserById(String id);

    public User userLogin(User user);

    public int regUser(User user);

    public int updateUser(User user);

    public List<Video> findMyVideo(String id);
    public List<Video> findMyVideoPage(Integer pageNum,Integer pageSize,String id);
    public List<User> findAllUser(Integer pageNum,Integer pageSize);
    public List<User> findUserByName(Integer pageNum,Integer pageSize,String username);

    public void  deleteUser(String id);

}
