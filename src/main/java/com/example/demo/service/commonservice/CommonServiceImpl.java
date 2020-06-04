package com.example.demo.service.commonservice;

import com.example.demo.mapper.CommonMapper;
import com.example.demo.model.JuBao;
import com.example.demo.model.Tuijian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonServiceImpl implements CommonService{

    @Autowired
    private CommonMapper commonMapper;


    @Override
    public void createrp(JuBao juBao) {
        commonMapper.createrp(juBao);
    }

    @Override
    public List<JuBao> findAllRp(Integer pageNum, Integer pageSize) {
        return commonMapper.findAllRp(pageNum, pageSize);
    }

    @Override
    public void delRp(String id) {
        commonMapper.delRp(id);
    }

    @Override
    public void delAllRp() {
        commonMapper.delAllRp();
    }

    @Override
    public void editrp(String id, String state) {
        commonMapper.editrp(id, state);
    }

    @Override
    public List<JuBao> findByType(String type, Integer pageNum, Integer pageSize) {
        return commonMapper.findByType(type, pageNum, pageSize);
    }

    @Override
    public void addTj(Tuijian tuijian) {
        commonMapper.addTj(tuijian);
    }

    @Override
    public List<Tuijian> selTjAll(Integer pageNum, Integer pageSize) {
        return commonMapper.selTjAll(pageNum, pageSize);
    }

    @Override
    public List<Tuijian> selTjById(Integer pageNum, Integer pageSize, String vid) {
        return commonMapper.selTjById(pageNum, pageSize, vid);
    }

    @Override
    public void delTjById(String id) {
        commonMapper.delTjById(id);
    }

    @Override
    public Integer checkHave(String vid) {
        return commonMapper.checkHave(vid);
    }

    @Override
    public Integer checkCount(String types) {
        return commonMapper.checkCount(types);
    }

    @Override
    public List<Tuijian> selTjByTypesSp(String types) {
        return commonMapper.selTjByTypesSp(types);
    }

    @Override
    public List<Tuijian> selTjByTypesTz() {
        return commonMapper.selTjByTypesTz();
    }

    @Override
    public Integer checkReg(String regdata) {
        return commonMapper.checkReg(regdata);
    }
}
