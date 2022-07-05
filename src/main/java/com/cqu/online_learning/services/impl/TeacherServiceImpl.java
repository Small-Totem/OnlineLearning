package com.cqu.online_learning.services.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqu.online_learning.entity.Teacher;
import com.cqu.online_learning.mapper.TeacherMapper;
import com.cqu.online_learning.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Autowired
   TeacherMapper teacherMapper;
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

    @Override
    public IPage<Teacher> queryTeacherPage(int currPage, int pageSize) {//分页查询
        Page<Teacher> page= new Page<>(currPage,pageSize);
        teacherMapper.selectPage(page,null);
        return page;
    }

    @Override
    public List<Teacher> getTeacherBySubject(String subject) {//按科目查询教师
        return this.baseMapper.getTeacherBySubject(subject);
    }

}
