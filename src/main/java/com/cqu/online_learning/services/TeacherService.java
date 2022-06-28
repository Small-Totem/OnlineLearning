package com.cqu.online_learning.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqu.online_learning.entity.Teacher;

import java.util.List;

public interface TeacherService extends IService<Teacher> {
    void addTeacher(Teacher a);
    List<Teacher> queryAllTeacher();
    Teacher getTeacher(int id);
    void removeTeacher(int id);
}
