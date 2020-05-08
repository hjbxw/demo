package com.example.demo.mapper;

import com.example.demo.model.UserLikes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AttentionMapper {
    public List<UserLikes> findGz(Integer pageNum,Integer pageSize,String attid);
    public Boolean inserGz(UserLikes userLikes);
    public Boolean delGz(String uid,String attid);
}
