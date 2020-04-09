package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
//    查找用户
    public User findUserById(String id);

    public User userLogin(User user);
//    添加用户
    public int insertUser(User user);
//    删除用户
    public void deleteUser(String id);
//    编辑用户信息
    public int updateUser(User user);
}
