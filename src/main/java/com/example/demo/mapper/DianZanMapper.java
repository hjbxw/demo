package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DianZanMapper {

    public Integer findDianZ(String dzuserid,String bdzuserid);
    public Boolean insertDianZ(String dzuserid,String bdzuserid);
    public Boolean deltDianZ(String dzuserid,String bdzuserid);
}
