package com.example.demo.mapper;

import com.example.demo.model.CommentFirstLevel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface CommentFirstLevelMapper {
	public void insertFlcComment(CommentFirstLevel commentFirstLevel);
	public List<CommentFirstLevel> selectFlcAll(Integer pageNum,Integer pageSize);
	public void deleteFlcComment(@Param("commentId") String commentId, @Param("sayingId") String sayingId);
}
