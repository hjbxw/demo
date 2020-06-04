package com.example.demo.service.commonservice;

import com.example.demo.model.JuBao;
import com.example.demo.model.Tuijian;

import java.util.List;

public interface CommonService {
    void createrp(JuBao juBao);

    List<JuBao> findAllRp(Integer pageNum, Integer pageSize);

    void delRp(String id);

    void delAllRp();

    void editrp(String id, String state);

    List<JuBao> findByType(String type,Integer pageNum, Integer pageSize);

    void addTj(Tuijian tuijian);
    List<Tuijian> selTjAll(Integer pageNum,Integer pageSize);
    List<Tuijian> selTjById(Integer pageNum,Integer pageSize,String vid);
    void delTjById(String id);
    Integer checkHave(String vid);
    Integer checkCount(String types);
    List<Tuijian> selTjByTypesSp(String types);
    List<Tuijian> selTjByTypesTz();
    Integer checkReg(String regdata);
}
