package com.cqu.online_learning.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cqu.online_learning.entity.Course;
import com.cqu.online_learning.services.CourseService;
import com.cqu.online_learning.utils.ReturnWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.cqu.online_learning.utils.StaticUtils.wrap;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("/addCourse")
    public String addCourse(Course a){
        courseService.addCourse(a);
        return "success";
    }

    //注意：这个函数原来的返回值是List<Course> 需要改成现在这样（用ReturnWrap包装一下）
    //原因详见ReturnWrap.java
    @GetMapping("/queryAllCourse")
    public Object queryAllCourse(){
        //return "{\"code\":0,\"data\":"+courseService.queryAllCourse().toString()+",\"msg\":\"成功\"}";
        return wrap(courseService.queryAllCourse());
    }

    @GetMapping("/getCourse/{courseId}")
    public Course queryCourse(@PathVariable int courseId){
        return courseService.getCourse(courseId);

    }
    @GetMapping("/removeCourse/{id}")
    public String removeCourse(@PathVariable int id){
        courseService.removeCourse(id);
        return "success";
    }

    @GetMapping("/queryCoursePage/{id}")//分页查询Course
    public IPage<Course> queryCoursePage(@PathVariable int id){
        return courseService.queryCoursePage(id,2);
    }

    @GetMapping("/queryCourseByTeacher/{id}")//按教师id查询课程
    public List<Course> queryCourseByTeacher(@PathVariable int id){
        return courseService.queryCourseByTeacher(id);
    }

    @GetMapping("/getCourseBySubject/{subject}")//按科目查询课程
    public List<Course> getCourseBySubject(@PathVariable String subject){
        return courseService.getCourseBySubject(subject);
    }

}
