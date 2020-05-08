package com.example.demo.service.attentionservice;

import com.example.demo.model.UserLikes;

import java.util.List;

public interface AttentionService {
    public List<UserLikes> findGz(Integer pageNum, Integer pageSize, String attid);
    public Boolean inserGz(UserLikes userLikes);
    public Boolean delGz(String uid,String attid);

}
