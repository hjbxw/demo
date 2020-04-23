package com.example.demo.service.commentservice;

import com.example.demo.mapper.CommentFirstLevelMapper;
import com.example.demo.mapper.CommentSecondLevelMapper;
import com.example.demo.model.CommentFirstLevel;
import com.example.demo.model.CommentSecondLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentFirstLevelMapper commentFirstLevelMapper;
	
	@Autowired
	private CommentSecondLevelMapper commentSecondLevelMapper;

	@Override
	public void addFlcComment(CommentFirstLevel commentFirstLevel) {
		commentFirstLevelMapper.insertFlcComment(commentFirstLevel);
	}

	@Override
	public void removeFlcComment(String commentId, String sayingId) {
		commentFirstLevelMapper.deleteFlcComment(commentId, sayingId);
	}

	@Override
	public void addSlcComment(CommentSecondLevel commentSecondLevel) {
		commentSecondLevelMapper.insertSlcComment(commentSecondLevel);
	}

	@Override
	public void removeSlcComment(String commentId, String sayingId) {
		commentSecondLevelMapper.deleteSlcComment(sayingId, commentId);
	}

}
