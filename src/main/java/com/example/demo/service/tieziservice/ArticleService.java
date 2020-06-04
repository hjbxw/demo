package com.example.demo.service.tieziservice;


import com.example.demo.model.Article;
import java.util.List;

public interface ArticleService {
    void createArticle(Article article);
    void editArt(Article article);
    List<Article> findArList(Integer pageNum, Integer pageSize);

    List<Article> findArByUserId(String id, Integer pageSize, Integer pageNum);

    String findArUserAll(String userid);

    Article findArById(String id);

    void delTiezi(String id);

    void incatrlook(String id);

    void incatrgood(String id,Integer num);
    List<Article> findArByTitle(String title,Integer pageNum, Integer pageSize);

}
