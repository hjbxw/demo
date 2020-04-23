package com.example.demo.mapper;

import com.example.demo.model.CommentSecondLevel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CommentSecondLevelMapper {
	
	public int insertSlcComment(CommentSecondLevel commentSecondLevel);
	public void deleteSlcComment(@Param("sayingId") String sayingId, @Param("commentId") String commentId);
}
