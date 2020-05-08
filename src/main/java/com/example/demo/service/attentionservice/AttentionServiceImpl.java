package com.example.demo.service.attentionservice;

import com.example.demo.mapper.AttentionMapper;
import com.example.demo.model.UserLikes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttentionServiceImpl implements  AttentionService {

    @Autowired
    AttentionMapper attentionMapper;

    @Override
    public List<UserLikes> findGz(Integer pageNum, Integer pageSize, String attid) {
        return attentionMapper.findGz(pageNum,pageSize,attid);
    }

    @Override
    public Boolean inserGz(UserLikes userLikes) {
        return attentionMapper.inserGz(userLikes);
    }

    @Override
    public Boolean delGz(String uid, String attid) {
        return attentionMapper.delGz(uid,attid);
    }
}
