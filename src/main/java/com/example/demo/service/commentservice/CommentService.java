package com.example.demo.service.commentservice;

import com.example.demo.model.CommentFirstLevel;
import com.example.demo.model.CommentSecondLevel;

public interface CommentService {
	
	public void addFlcComment(CommentFirstLevel commentFirstLevel);
	
	public void removeFlcComment(String commentId, String sayingId);
	
	public void addSlcComment(CommentSecondLevel commentSecondLevel);
	
	public void removeSlcComment(String commentId, String sayingId);
}
