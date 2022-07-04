package com.cqu.online_learning.services;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cqu.online_learning.entity.Course;

import java.util.List;

public interface CourseService extends IService<Course> {
    void addCourse(Course a);
    List<Course> queryAllCourse();
    void removeCourse(int id);
    Course getCourse(int courseId);
    IPage<Course> queryCoursePage(int currPage, int pageSize);//分页查询
    List<Course> queryCourseByTeacher(int id);//按教师id查询课程
    List<Course> getCourseBySubjectID(int id);//按科目id查询课程
}
