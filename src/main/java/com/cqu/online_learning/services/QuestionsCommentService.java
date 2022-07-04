package com.cqu.online_learning.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqu.online_learning.entity.QuestionsComment;

import java.util.List;

public interface QuestionsCommentService extends IService<QuestionsComment> {

    void addQuesCom(QuestionsComment a);//添加问题评论
    List<QuestionsComment> queryAllQuesCom();//查询所有问题评论
    QuestionsComment getQuesComById(int id);//按评论id查询问题评论
    //List<QuestionsComment> queryAllQuesCom(int qid);//按问题id查询所有评论
    void removeQuesComById(int id);//按id删除
    List<QuestionsComment> getAllQuestionCommentByQuestionId(int id);
}
