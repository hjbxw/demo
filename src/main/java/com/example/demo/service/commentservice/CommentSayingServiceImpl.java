package com.example.demo.service.commentservice;

import com.example.demo.mapper.CommentSayingMapper;
import com.example.demo.model.CommentSaying;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CommentSayingServiceImpl implements CommentSayingService {
	
	@Autowired
    private CommentSayingMapper commentSayingMapper;

	@Override
	public void insertComment(CommentSaying commentSaying){
		commentSayingMapper.insertComment(commentSaying);}

	@Override
	public List<CommentSaying> selectListBySectionId(Integer pageNum,Integer pageSize,String id){
		return commentSayingMapper.selectListBySectionId(pageNum,pageSize,id);
	}

	@Override
	public CommentSaying queryOneSaying(String id) {
		return commentSayingMapper.selectOneById(id);
	}

	@Override
	public void deleteById(String sayingId) {
		commentSayingMapper.deleteById(sayingId);
	}

	@Override
	public void modifySayingLikes(String id, String likes) {
		commentSayingMapper.updateLikesById(id, likes);
	}

	@Override
	public List<CommentSaying> selectCommentAll(Integer pageNum, Integer pageSize) {
		return commentSayingMapper.selectCommentAll(pageNum,pageSize);
	}

	@Override
	public List<CommentSaying> selectSayBy(Integer pageNum, Integer pageSize, String sayingContent) {
		return commentSayingMapper.selectSayBy(pageNum,pageSize,sayingContent);
	}
}
