package com.example.demo.service.attentionservice;

import com.example.demo.mapper.AttentionMapper;
import com.example.demo.model.User;
import com.example.demo.model.UserLikes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class AttentionServiceImpl implements  AttentionService {

    @Autowired
    AttentionMapper attentionMapper;

    @Override
    public List<UserLikes> findGz(Integer pageNum, Integer pageSize, String attid,String uid) {
        return attentionMapper.findGz(pageNum,pageSize,attid,uid);
    }

    @Override
    public List<User> findGzList(Integer pageNum, Integer pageSize, String uid) {
        return attentionMapper.findGzList(pageNum, pageSize, uid);
    }

    @Override
    public Boolean inserGz(UserLikes userLikes) {
        return attentionMapper.inserGz(userLikes);
    }

    @Override
    public Boolean delGz(String uid, String attid) {
        return attentionMapper.delGz(uid,attid);
    }


    @Override
    public Boolean findSc(String scrid, String zpid) {
        Boolean flag;
        if (StringUtils.isEmpty(attentionMapper.findSc(scrid, zpid))){
            flag = false;
        }else {
            flag = true;
        }
        return flag;
    }

    @Override
    public Boolean insertSc(String scrid, String zpid) {
        return attentionMapper.insertSc(scrid,zpid);
    }

    @Override
    public Boolean delSc(String scrid, String zpid) {
        return attentionMapper.delSc(scrid, zpid);
    }
}
