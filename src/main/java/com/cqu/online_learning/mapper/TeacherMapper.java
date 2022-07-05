package com.cqu.online_learning.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqu.online_learning.entity.Teacher;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherMapper extends BaseMapper<Teacher> {
    @Select("select edu_teacher.* from edu_teacher where edu_teacher.subject=#{subject}")
    List<Teacher> getTeacherBySubject(String subject);//按学科查询教师

}
