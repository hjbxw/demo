package com.example.demo.service.commentservice;

import com.example.demo.model.ReplyComment;

import java.util.List;

public interface ReplyCommentService {
    /*回复评论*/
    int addReplyCommentMapper(ReplyComment replyComment);

    List<ReplyComment> getReplyCommentsByCommentId(String id);
}
