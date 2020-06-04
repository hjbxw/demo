package com.example.demo.service.tieziservice.tieziServiceImpl;

import com.example.demo.mapper.ArticleMapper;
import com.example.demo.model.Article;
import com.example.demo.service.tieziservice.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
     ArticleMapper articleMapper;

    @Override
    public void createArticle(Article article) {
        articleMapper.createArticle(article);
    }

    @Override
    public List<Article> findArList(Integer pageNum, Integer pageSize) {
        return articleMapper.findArList(pageNum, pageSize);
    }

    @Override
    public List<Article> findArByUserId(String id, Integer pageSize, Integer pageNum) {
        return articleMapper.findArByUserId(id, pageSize, pageNum);
    }

    @Override
    public String findArUserAll(String userid) {
        return articleMapper.findArUserAll(userid);
    }

    @Override
    public Article findArById(String id) {
        return articleMapper.findArById(id);
    }

    @Override
    public void editArt(Article article) {
        articleMapper.editArt(article);
    }

    @Override
    public void delTiezi(String id) {
        articleMapper.delTiezi(id);
    }

    @Override
    public void incatrlook(String id) {
        articleMapper.incatrlook(id);
    }

    @Override
    public void incatrgood(String id,Integer num) {
        articleMapper.incatrgood(id,num);
    }

    @Override
    public List<Article> findArByTitle(String title,Integer pageNum,Integer pageSize ) {
        return articleMapper.findArByTitle(title,pageNum,pageSize);
    }
}
