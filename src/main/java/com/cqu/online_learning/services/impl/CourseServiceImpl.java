package com.cqu.online_learning.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqu.online_learning.entity.Course;
import com.cqu.online_learning.mapper.CourseMapper;
import com.cqu.online_learning.services.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    @Override
    public void addCourse(Course a) {
        this.save(a);
    }
    @Override
    public List<Course> queryAllCourse() {
        return list();
    }
}
