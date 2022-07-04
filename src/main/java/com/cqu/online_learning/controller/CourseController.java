package com.cqu.online_learning.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cqu.online_learning.entity.Course;
import com.cqu.online_learning.services.ArticleService;
import com.cqu.online_learning.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("/addCourse")
    public String addCourse(Course a){
        courseService.addCourse(a);
        return  "success";
    }

    @GetMapping("/queryAllCourse")
    public List<Course> queryAllCourse(){
        return courseService.queryAllCourse();
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

    @GetMapping("/getCourseBySubjectID/{id}")//按科目id查询课程
    public List<Course> getCourseBySubjectID(@PathVariable int id){
        return courseService.getCourseBySubjectID(id);
    }

}
