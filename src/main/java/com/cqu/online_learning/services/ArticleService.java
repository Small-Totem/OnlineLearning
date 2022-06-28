package com.cqu.online_learning.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqu.online_learning.entity.Article;

import java.util.List;

public interface ArticleService extends IService<Article> {
    void addArticle(Article a);
    List<Article> queryAllArticle();
    Article getArticle(int id);
    void removeArticle(int id);
}
