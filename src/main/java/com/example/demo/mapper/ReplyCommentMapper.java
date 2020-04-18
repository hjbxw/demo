package com.example.demo.mapper;

import com.example.demo.model.ReplyComment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReplyCommentMapper {

    int addReplyCommentMapper(ReplyComment replyComment);
    List<ReplyComment> getReplyCommentsByCommentId(String id);
}
