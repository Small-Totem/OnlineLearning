package com.cqu.online_learning.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqu.online_learning.entity.QuestionsComment;
import com.cqu.online_learning.mapper.QuestionsCommentMapper;
import com.cqu.online_learning.services.QuestionsCommentService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class QuestionsCommentServiceImpl extends ServiceImpl<QuestionsCommentMapper, QuestionsComment> implements QuestionsCommentService {
    @Override
    public void addQuesCom(QuestionsComment a) {
        this.save(a);
    }

    @Override
    public List<QuestionsComment> queryAllQuesCom() {
        return list();
    }

    @Override
    public QuestionsComment getQuesComById(int id) {
        return this.getById(id);
    }


    @Override
    public void removeQuesComById(int id) {
        this.removeById(id);
    }

    @Override
    public List<QuestionsComment> getAllQuestionCommentByQuestionId(int id) {
        HashMap<String, Object> columnMap = new HashMap<>();
        columnMap.put("QUESTION_ID", id);
        return listByMap(columnMap);
    }
}
