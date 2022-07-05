package com.cqu.online_learning.services;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cqu.online_learning.entity.Question;
import com.cqu.online_learning.entity.QuestionsComment;

import java.util.List;

public interface QuestionService extends IService<Question> {
    void addQuestion(Question a);
    List<Question> queryAllQuestion();
    IPage<Question> queryQuestionPage(int currPage, int pageSize);
    Question getQuestionById(int id);//按id查询问题
    void removeQuestionById(int id);//按id删除
    List<Question> getQuestionByType(int id);//按类型查询问题（热门问题/非热门问题）
}
