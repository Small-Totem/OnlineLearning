package com.cqu.online_learning.controller;


import com.cqu.online_learning.entity.QuestionsComment;
import com.cqu.online_learning.services.QuestionsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.cqu.online_learning.utils.StaticUtils.wrap;

@RestController
public class QuestionsCommentController {

    @Autowired
    QuestionsCommentService questionscommentService;

    @PostMapping("/addQuesCom")
    public String addQuesCom(QuestionsComment a) {
        questionscommentService.addQuesCom(a);
        return "success";
    }

    @GetMapping("/queryAllQuesCom")
    public Object queryAllQuesCom() {
        return wrap(questionscommentService.queryAllQuesCom());
    }

    @GetMapping("/removeQuesComById/{id}")
    public String removeQuesComById(@PathVariable int id) {
        questionscommentService.removeQuesComById(id);
        return "success";
    }

    @GetMapping("/getQuesComById/{id}")
    public QuestionsComment getQuesComById(@PathVariable int id){
        return questionscommentService.getQuesComById(id);
    }

    @GetMapping("/getAllQuestionCommentByQuestionId/{id}")
    public Object getAllQuestionCommentByQuestionId(@PathVariable int id){
        return wrap(questionscommentService.getAllQuestionCommentByQuestionId(id));
    }

}
