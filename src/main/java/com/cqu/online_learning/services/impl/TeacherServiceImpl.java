package com.cqu.online_learning.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqu.online_learning.entity.Teacher;
import com.cqu.online_learning.mapper.TeacherMapper;
import com.cqu.online_learning.services.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Override
    public void addTeacher(Teacher a) { this.save(a); }

    @Override
    public List<Teacher> queryAllTeacher() {
        return list();
    }

    @Override
    public Teacher getTeacher(int id) {
        return this.getById(id);
    }

    @Override
    public void removeTeacher(int id) {
        this.removeById(id);
    }
}
