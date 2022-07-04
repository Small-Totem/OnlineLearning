package com.cqu.online_learning.services.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqu.online_learning.entity.Article;
import com.cqu.online_learning.mapper.ArticleMapper;
import com.cqu.online_learning.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;
    @Override
    public void addArticle(Article a) {
        this.save(a);
    }

    @Override
    public List<Article> queryAllArticle() {
        return list();
    }

    @Override
    public Article getArticle(int id) {
       return this.getById(id);
    }

    @Override
    public void removeArticle(int id) {
        this.removeById(id);
    }

    @Override
    public IPage<Article> queryArticlePage(int currPage, int pageSize) {
        Page<Article> page= new Page<>(currPage,pageSize);
        articleMapper.selectPage(page,null);
        return page;
    }
}
