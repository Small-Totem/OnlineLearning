package com.cqu.online_learning.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqu.online_learning.entity.Course;

import java.util.List;

public interface CourseService extends IService<Course> {
    void addCourse(Course a);
    List<Course> queryAllCourse();


}
