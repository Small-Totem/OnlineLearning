package com.cqu.online_learning.services;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cqu.online_learning.entity.Teacher;

import java.util.List;

public interface TeacherService extends IService<Teacher> {
    void addTeacher(Teacher a);
    List<Teacher> queryAllTeacher();
    Teacher getTeacher(int id);
    void removeTeacher(int id);
    IPage<Teacher> queryTeacherPage(int currPage, int pageSize);//分页查询
    List<Teacher> getTeacherBySubjectID(int id);//按科目id查询教师

}
