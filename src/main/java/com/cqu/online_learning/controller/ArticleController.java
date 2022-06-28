package com.cqu.online_learning.controller;

import com.cqu.online_learning.entity.Article;
import com.cqu.online_learning.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<Article> queryAllArticle(){
        return articleService.queryAllArticle();
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
}
