package com.cqu.online_learning.services.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqu.online_learning.entity.Question;
import com.cqu.online_learning.entity.QuestionsComment;
import com.cqu.online_learning.mapper.QuestionMapper;
import com.cqu.online_learning.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.HashMap;
import java.util.List;

@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {
    @Autowired
    QuestionMapper questionMapper;
    @Override
    public void addQuestion(Question a) {
        this.save(a);
    }

    @Override
    public List<Question> queryAllQuestion() {
        return list();
    }
    @Override
    public IPage<Question> queryQuestionPage(int currPage, int pageSize) {

        Page<Question> page= new Page<>(currPage,pageSize);
        //LambdaQueryWrapper<Question> queryWrapper = new LambdaQueryWrapper<>();
        //Page<Question> articlePage =QuestionMapper.selectPage(page, queryWrapper);
        questionMapper.selectPage(page,null);

        return page;
    }

    @Override
    public Question getQuestionById(int id) {
        return this.getById(id);
    }

    @Override
    public void removeQuestionById(int id) {
        this.removeById(id);
    }

}
