package com.cqu.online_learning.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqu.online_learning.entity.Question;
import com.cqu.online_learning.mapper.QuestionMapper;
import com.cqu.online_learning.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

    @Override
    public void addQuestion(Question a) {
        this.save(a);
    }

    @Override
    public List<Question> queryAllQuestion() {
        return list();
    }
}
