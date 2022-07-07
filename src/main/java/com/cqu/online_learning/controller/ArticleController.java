package com.cqu.online_learning.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cqu.online_learning.entity.Article;
import com.cqu.online_learning.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.cqu.online_learning.utils.StaticUtils.wrap;

@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @PostMapping("/addArticle")
    public String addArticle(Article a){
        articleService.addArticle(a);
        return  "success";
    }

    @GetMapping("/queryAllArticle")
    public Object queryAllArticle(){
        return wrap(articleService.queryAllArticle());
    }

    @GetMapping("/getArticle/{id}")
    public Article getArticle(@PathVariable int id){
        return articleService.getArticle(id);
    }

    @GetMapping("/removeArticle/{id}")
    public String removeArticle(@PathVariable int id){
        articleService.removeArticle(id);
        return "success";
    }

    @GetMapping("/queryArticlePage/{id}")//分页查询Article
    public IPage<Article> queryArticlePage(@PathVariable int id){
        return articleService.queryArticlePage(id,2);
    }

}
