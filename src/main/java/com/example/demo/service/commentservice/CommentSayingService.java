package com.example.demo.service.commentservice;

import com.example.demo.model.CommentSaying;

import java.util.List;

public interface CommentSayingService {

	public void insertComment(CommentSaying commentSaying);

	public List<CommentSaying> selectListBySectionId(Integer pageNum,Integer pageSize,String id);
	public List<CommentSaying> selectSayBy(Integer pageNum,Integer pageSize,String SayingMap);

	public List<CommentSaying> selectCommentAll(Integer pageNum,Integer pageSize);

	public CommentSaying queryOneSaying(String id);

	public void deleteById(String sayingId);

	public void modifySayingLikes(String id, String likes);

}