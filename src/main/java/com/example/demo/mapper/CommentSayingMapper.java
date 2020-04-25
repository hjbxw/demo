package com.example.demo.mapper;

import com.example.demo.model.CommentSaying;
import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
@Mapper
public interface CommentSayingMapper {

	public List<CommentSaying> selectListBySectionId(Integer pageNum,Integer pageSize,String id);

	public void insertComment(CommentSaying commentSaying);

	public CommentSaying selectOneById(String id);

	public void deleteById(String sayingId);

	public void updateLikesById(@Param("id") String id, @Param("likes") String likes);


}
