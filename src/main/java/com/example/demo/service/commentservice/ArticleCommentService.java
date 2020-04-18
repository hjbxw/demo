package com.example.demo.service.commentservice;

import com.example.demo.model.ArticleComment;

import java.util.List;

public interface ArticleCommentService{
    List<ArticleComment> getArticleCommentsByArticleId(String id);
    int addArticleComment(ArticleComment articleComment);
}
