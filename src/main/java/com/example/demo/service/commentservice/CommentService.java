package com.example.demo.service.commentservice;

import com.example.demo.model.CommentFirstLevel;
import com.example.demo.model.CommentSecondLevel;

import java.util.List;

public interface CommentService {
	
	public void addFlcComment(CommentFirstLevel commentFirstLevel);
	
	public void removeFlcComment(String commentId, String sayingId);
	
	public void addSlcComment(CommentSecondLevel commentSecondLevel);
	
	public void removeSlcComment(String commentId, String sayingId);

	public List<CommentFirstLevel> selectFlcAll(Integer pageNum,Integer pageSize);
	public List<CommentFirstLevel> selectFlBy(Integer pageNum,Integer pageSize,String comments);

	public List<CommentSecondLevel> selectSlcAll(Integer pageNum,Integer pageSize);

	public List<CommentSecondLevel> selectSlBy(Integer pageNum,Integer pageSize,String comments);
}
