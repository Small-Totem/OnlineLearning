package com.cqu.online_learning.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cqu.online_learning.entity.Question;
import com.cqu.online_learning.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
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


    @GetMapping("/queryQuestionPage/{id}")
    public IPage<Question> queryQuestionPage(@PathVariable int id){
        return QuestionService.queryQuestionPage(id,5);
    }

    @GetMapping("/removeQuestion/{id}")
    public String removeCustomer(@PathVariable int id) {
        QuestionService.removeQuestionById(id);
        return "success";
    }

    @GetMapping("/getQuestionById/{id}")
    public Question getQuestion(@PathVariable int id){
        return QuestionService.getQuestionById(id);
    }

}
