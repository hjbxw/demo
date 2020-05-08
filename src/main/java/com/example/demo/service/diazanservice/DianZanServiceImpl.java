package com.example.demo.service.diazanservice;

import com.example.demo.mapper.DianZanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class DianZanServiceImpl implements DianZService{

    @Autowired
    DianZanMapper dianZanMapper;

    @Override
    public Boolean findDianZ(String dzuserid, String bdzuserid) {
        Boolean flag;
        if (StringUtils.isEmpty(dianZanMapper.findDianZ(dzuserid,bdzuserid))){
            flag = false;
        }else {
            flag = true;
        }
        return flag;
    }

    @Override
    public Boolean insertDianZ(String dzuserid, String bdzuserid) {
        return dianZanMapper.insertDianZ(dzuserid,bdzuserid);
    }

    @Override
    public Boolean deltDianZ(String dzuserid, String bdzuserid) {
        return dianZanMapper.deltDianZ(dzuserid,bdzuserid);
    }
}
