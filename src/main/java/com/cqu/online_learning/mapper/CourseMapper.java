package com.cqu.online_learning.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqu.online_learning.entity.Course;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseMapper extends BaseMapper<Course> {
    @Select("select edu_course.* from edu_course where edu_course.id=#{id}")
    List<Course> queryCourseByTeacher(int id);//按教师id查询课程

    @Select("select edu_course.* from edu_course where edu_course.subject_id=#{id}")
    List<Course> getCourseBySubjectID(int id);//按学科id查询课程
}
