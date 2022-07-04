package com.cqu.online_learning.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cqu.online_learning.entity.Article;
import com.cqu.online_learning.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/queryArticlePage/{id}")//分页查询Article
    public IPage<Article> queryArticlePage(@PathVariable int id){
        return articleService.queryArticlePage(id,2);
    }

    //test
    @CrossOrigin(origins={"http://localhost:3000","http://localhost:8081"})//允许跨域访问 @ref https://www.csdn.net/tags/MtjaIg0sMzYzMC1ibG9n.html
    @GetMapping("/article_test")
    public String article_test(){
        System.out.println("/article_test");
        return "{\"code\":0,\"data\":[{\"id\":1,\"title\":\"2022年3月30号\"},{\"id\":72,\"title\":\"Vue.js 3.0\"},{\"id\"" +
                ":75,\"title\":\"应用 & 组件实例\"},{\"id\":74,\"title\":\"测试Markdown语法\"},{\"id\":71,\"title\":\"测试" +
                "图片\"},{\"id\":73,\"title\":\"测试评论\"}],\"msg\":\"成功\"}";
    }

}
