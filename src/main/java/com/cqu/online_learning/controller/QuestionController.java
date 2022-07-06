package com.cqu.online_learning.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cqu.online_learning.entity.Question;
import com.cqu.online_learning.services.QuestionService;
import com.cqu.online_learning.services.QuestionsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.cqu.online_learning.utils.StaticUtils.wrap;

@RestController
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @Autowired
    QuestionsCommentService questionsCommentService;

    @PostMapping("/addQuestion")
    public String addQuestion(Question a){
        questionService.addQuestion(a);
        return "success";
    }

    @GetMapping("/queryAllQuestion")
    public Object queryAllQuestion(){
        return wrap(questionService.queryAllQuestion());
    }


    @GetMapping("/queryQuestionPage/{id}")
    public IPage<Question> queryQuestionPage(@PathVariable int id){
        return questionService.queryQuestionPage(id,5);
    }

    @GetMapping("/removeQuestion/{id}")
    public String removeCustomer(@PathVariable int id) {
        questionService.removeQuestionById(id);
        return "success";
    }

    @GetMapping("/getQuestionById/{id}")
    public List<Question> getQuestion(@PathVariable int id){
        List<Question> queryquestion=new ArrayList<>();
        queryquestion.add(questionService.getQuestionById(id));
        return  queryquestion;
    }

    @GetMapping("/getQuestionByType/{id}")//按类型查询问题
    public Object getQuestionByType(@PathVariable int id){
        return wrap(questionService.getQuestionByType(id));
    }

}
