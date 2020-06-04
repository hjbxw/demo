package com.example.demo.mapper;

import com.example.demo.model.Article;
import com.example.demo.model.JuBao;
import com.example.demo.model.Tuijian;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommonMapper {
    void createrp(JuBao juBao);

    List<JuBao> findAllRp(Integer pageSize, Integer pageNum);

    List<JuBao> findByType(String type,Integer pageSize, Integer pageNum);

    void delRp(String id);

    void delAllRp();

    void editrp(String id, String state);

    void addTj(Tuijian tuijian);
    List<Tuijian> selTjAll(Integer pageNum,Integer pageSize);
    List<Tuijian> selTjById(Integer pageNum,Integer pageSize,String vid);
    List<Tuijian> selTjByTypesSp(String types);
    List<Tuijian> selTjByTypesTz();
    void delTjById(String id);
    Integer checkHave(String vid);
    Integer checkCount(String types);
    Integer checkReg(String regdata);
}
