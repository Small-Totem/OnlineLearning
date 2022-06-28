package com.cqu.online_learning.controller;

import com.cqu.online_learning.entity.Comment;
import com.cqu.online_learning.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/addComment")
    public String addComment(Comment a){
        commentService.addComment(a);
        return  "success";
    }

    @GetMapping("/getComment/{id}")
    public Comment getComment(@PathVariable int id){
        return commentService.getComment(id);
    }

    @GetMapping("/removeComment/{id}")
    public String removeComment(@PathVariable int id){
        commentService.removeComment(id);
        return "success";
    }

    @GetMapping("/queryAllCommentByCourseId/{courseId}")
    public List<Comment> queryAllCommentByCourseId(@PathVariable int courseId){
        return commentService.queryAllCommentByCourseId(courseId);
    }
}
