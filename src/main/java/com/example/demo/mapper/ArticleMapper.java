package com.example.demo.mapper;

import com.example.demo.model.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface ArticleMapper {
    void createArticle(Article article);
    void editArt(Article article);

    List<Article> findArList(Integer pageNum, Integer pageSize);
    List<Article> findArByTitle(String title,Integer pageNum, Integer pageSize);

    List<Article> findArByUserId(String id, Integer pageNum, Integer pageSize);

    String findArUserAll(String userid);

    Article findArById(String id);

    void delTiezi(String id);

    void incatrlook(String id);

    void incatrgood(String id,Integer num);

}
