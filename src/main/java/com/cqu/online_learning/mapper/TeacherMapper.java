package com.cqu.online_learning.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqu.online_learning.entity.Teacher;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherMapper extends BaseMapper<Teacher> {
    @Select("select edu_teacher.* from edu_teacher where edu_teacher.subject_id=#{id}")
    List<Teacher> getTeacherBySubjectID(int id);//按学科id查询教师

}
