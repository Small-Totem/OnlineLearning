package com.cqu.online_learning.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cqu.online_learning.entity.Teacher;
import com.cqu.online_learning.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping("/addTeacher")
    public String addTeacher(Teacher a){
        teacherService.addTeacher(a);
        return  "success";
    }

    @GetMapping("/queryAllTeacher")
    public List<Teacher> queryAllTeacher(){
        return teacherService.queryAllTeacher();
    }

    @GetMapping("/getTeacher/{id}")
    public Teacher getTeacher(@PathVariable int id){
        return teacherService.getTeacher(id);
    }

    @GetMapping("/removeTeacher/{id}")
    public String removeTeacher(@PathVariable int id){
        teacherService.removeTeacher(id);
        return"success";
    }

    @GetMapping("/queryTeacherPage/{id}")//分页查询Teacher
    public IPage<Teacher> queryTeacherPage(@PathVariable int id){
        return teacherService.queryTeacherPage(id,2);
    }


    @GetMapping("/getTeacherBySubject/{subject}")//按科目查询教师
    public List<Teacher> getTeacherBySubject(@PathVariable String subject){
        return teacherService.getTeacherBySubject(subject);
    }

}
