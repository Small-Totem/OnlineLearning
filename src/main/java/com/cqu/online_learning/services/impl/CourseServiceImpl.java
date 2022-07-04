package com.cqu.online_learning.services.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqu.online_learning.entity.Course;
import com.cqu.online_learning.mapper.CourseMapper;
import com.cqu.online_learning.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    @Autowired
    CourseMapper courseMapper;
    @Override
    public void addCourse(Course a) {
        this.save(a);
    }
    @Override
    public List<Course> queryAllCourse() {
        return list();
    }
    @Override
    public Course getCourse(int courseId){
        Course course = this.getById(courseId);
        return course;
    }

    @Override
    public IPage<Course> queryCoursePage(int currPage, int pageSize) {//分页查询
        Page<Course> page= new Page<>(currPage,pageSize);
        courseMapper.selectPage(page,null);
        return page;
    }

    @Override
    public List<Course> queryCourseByTeacher(int id) {//按教师id查询课程
        return this.baseMapper.queryCourseByTeacher(id);
    }

    @Override
    public List<Course> getCourseBySubjectID(int id) {//按科目id查询课程
        return this.baseMapper.getCourseBySubjectID(id);
    }

    @Override
    public void removeCourse(int id){//按课程id查询删除课程

        this.removeById(id);
    }
}
