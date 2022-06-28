package com.cqu.online_learning.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqu.online_learning.entity.Question;

import java.util.List;

public interface QuestionService extends IService<Question> {
    void addQuestion(Question a);
    List<Question> queryAllQuestion();


}
