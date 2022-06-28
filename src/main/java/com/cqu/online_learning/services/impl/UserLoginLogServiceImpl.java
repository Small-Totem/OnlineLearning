package com.cqu.online_learning.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqu.online_learning.entity.Course;
import com.cqu.online_learning.entity.UserLoginLog;
import com.cqu.online_learning.mapper.CourseMapper;
import com.cqu.online_learning.mapper.UserLoginLogMapper;
import com.cqu.online_learning.services.CourseService;
import com.cqu.online_learning.services.UserLoginLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginLogServiceImpl extends ServiceImpl<UserLoginLogMapper, UserLoginLog> implements UserLoginLogService {

    @Override
    public void addLog(UserLoginLog a) {
        save(a);
    }

    @Override
    public List<UserLoginLog> queryAllLog() {
        return list();
    }

    @Override
    public void removeLog(int id) {
        removeById(id);
    }

    @Override
    public UserLoginLog getLog(int id) {
        return getById(id);
    }
}
