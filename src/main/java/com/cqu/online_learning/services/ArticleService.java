package com.cqu.online_learning.services;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cqu.online_learning.entity.Article;

import java.util.List;

public interface ArticleService extends IService<Article> {
    void addArticle(Article a);
    void updateArticle(Article a);
    List<Article> queryAllArticle();
    Article getArticle(int id);
    void removeArticle(int id);
    IPage<Article> queryArticlePage(int currPage, int pageSize);//分页查询
}
