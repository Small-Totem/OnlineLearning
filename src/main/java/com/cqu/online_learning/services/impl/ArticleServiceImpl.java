package com.cqu.online_learning.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqu.online_learning.entity.Article;
import com.cqu.online_learning.mapper.ArticleMapper;
import com.cqu.online_learning.services.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public void addArticle(Article a) {
        this.save(a);
    }

    @Override
    public List<Article> queryAllArticle() {
        return list();
    }
}
