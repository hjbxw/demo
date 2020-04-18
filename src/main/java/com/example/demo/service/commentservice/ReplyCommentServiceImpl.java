package com.example.demo.service.commentservice;

import com.example.demo.mapper.ReplyCommentMapper;
import com.example.demo.model.ReplyComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReplyCommentServiceImpl implements ReplyCommentService{

    @Autowired
    private ReplyCommentMapper replyCommentMapper;
    @Override
    public int addReplyCommentMapper(ReplyComment replyComment) {
        return replyCommentMapper.addReplyCommentMapper(replyComment);
    }

    @Override
    public List<ReplyComment> getReplyCommentsByCommentId(String id) {
        return replyCommentMapper.getReplyCommentsByCommentId(id);
    }
}
