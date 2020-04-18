package com.example.demo.mapper;

import com.example.demo.model.ArticleComment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArticleCommentMapper {
    List<ArticleComment> getArticleCommentsByArticleId(String id);
    int addArticleComment(ArticleComment articleComment);
}
