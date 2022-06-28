package com.cqu.online_learning.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqu.online_learning.entity.Comment;
import com.cqu.online_learning.mapper.CommentMapper;
import com.cqu.online_learning.services.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Override
    public void addComment(Comment c) {
        this.save(c);
    }

    @Override
    public void removeComment(int id) {
        this.removeById(id);
    }

    @Override
    public Comment getComment(int id) {
        return this.getById(id);
    }
}
