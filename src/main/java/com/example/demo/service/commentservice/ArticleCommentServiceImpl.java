package com.example.demo.service.commentservice;

import com.example.demo.mapper.ArticleCommentMapper;
import com.example.demo.model.ArticleComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleCommentServiceImpl implements ArticleCommentService {

    @Autowired
    private ArticleCommentMapper articleCommentMapper;
    @Override
    public List<ArticleComment> getArticleCommentsByArticleId(String id) {
        return articleCommentMapper.getArticleCommentsByArticleId(id);
    }

    @Override
    public int addArticleComment(ArticleComment articleComment) {
        return articleCommentMapper.addArticleComment(articleComment);
    }
}
