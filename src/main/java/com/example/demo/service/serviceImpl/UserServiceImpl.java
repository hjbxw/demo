package com.example.demo.service.serviceImpl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.model.Video;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Video> findMyVideo(String id) {
        return userMapper.findMyVideo(id);
    }

    @Override
    public List<User> findAllUser(Integer pageNum,Integer pageSize) {
        return userMapper.findAllUser(pageNum,pageSize);
    }

    @Override
    public void deleteUser(String id) {
         userMapper.deleteUser(id);
    }

    @Override
    public List<User> findUserByName(Integer pageNum, Integer pageSize, String username) {
        return userMapper.findUserByName(pageNum,pageSize,username);
    }
}
