package com.cqu.online_learning.controller;

import com.cqu.online_learning.entity.Question;
import com.cqu.online_learning.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    QuestionService QuestionService;

    @PostMapping("/addQuestion")
    public String addQuestion(Question a){
        QuestionService.addQuestion(a);
        return  "success";
    }

    @GetMapping("/queryAllQuestion")
    public List<Question> queryAllQuestion(){
        return QuestionService.queryAllQuestion();
    }


}
