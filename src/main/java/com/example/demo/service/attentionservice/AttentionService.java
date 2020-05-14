package com.example.demo.service.attentionservice;

import com.example.demo.model.User;
import com.example.demo.model.UserLikes;

import java.util.List;

public interface AttentionService {
    /*关注*/
    public List<UserLikes> findGz(Integer pageNum, Integer pageSize, String attid,String uid);
    public List<User> findGzList(Integer pageNum, Integer pageSize, String uid);
    public Boolean inserGz(UserLikes userLikes);
    public Boolean delGz(String uid,String attid);

    /*收藏*/
    public Boolean findSc(String scrid, String zpid);
    public Boolean insertSc(String scrid, String zpid);
    public Boolean delSc(String scrid, String zpid);

}
