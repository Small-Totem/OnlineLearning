package com.cqu.online_learning.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqu.online_learning.entity.Comment;

public interface CommentService extends IService<Comment> {
    void addComment(Comment c);
    void removeComment(int id);
    Comment getComment(int id);
}
