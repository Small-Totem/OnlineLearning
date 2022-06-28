package com.cqu.online_learning.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqu.online_learning.entity.Article;
import com.cqu.online_learning.entity.Comment;
import com.cqu.online_learning.mapper.CommentMapper;
import com.cqu.online_learning.services.CommentService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Override
    public void addComment(Comment c) {
        save(c);
    }

    @Override
    public List<Comment> queryAllCommentByCourseId(int id) {
        HashMap<String, Object> columnMap = new HashMap<>();
        columnMap.put("COURSE_ID", id);
        return listByMap(columnMap);
    }

    @Override
    public void removeComment(int id) {
        removeById(id);
    }

    @Override
    public Comment getComment(int id) {
        return getById(id);
    }
}
