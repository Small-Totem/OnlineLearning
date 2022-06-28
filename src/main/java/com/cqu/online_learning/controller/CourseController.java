package com.cqu.online_learning.controller;


import com.cqu.online_learning.entity.Course;
import com.cqu.online_learning.services.ArticleService;
import com.cqu.online_learning.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CourseController {
    @Autowired
    CourseService articleService;

    @PostMapping("/addCourse")
    public String addArticle(Course a){
        articleService.addCourse(a);
        return  "success";
    }

    @GetMapping("/queryAllCourse")
    public List<Course> queryAllCourse(){
        return articleService.queryAllCourse();
    }
}
