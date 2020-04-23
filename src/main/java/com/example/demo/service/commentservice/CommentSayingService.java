package com.example.demo.service.commentservice;

import com.example.demo.model.CommentSaying;

import java.util.List;

public interface CommentSayingService {

	public void insertComment(CommentSaying commentSaying);

	public List<CommentSaying> selectListBySectionId(String id);

	public CommentSaying queryOneSaying(String id);

	public void deleteById(String sayingId);

	public void modifySayingLikes(String id, String likes);

}