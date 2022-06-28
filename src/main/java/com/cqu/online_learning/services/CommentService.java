package com.cqu.online_learning.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqu.online_learning.entity.Comment;
import java.util.List;

public interface CommentService extends IService<Comment> {
    void addComment(Comment c);
    List<Comment> queryAllCommentByCourseId(int id);
    void removeComment(int id);
    Comment getComment(int id);
}
