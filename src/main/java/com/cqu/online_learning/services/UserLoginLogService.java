package com.cqu.online_learning.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqu.online_learning.entity.UserLoginLog;

import java.util.List;

public interface UserLoginLogService extends IService<UserLoginLog> {
    void addLog(UserLoginLog a);
    List<UserLoginLog> queryAllLog();
    void removeLog(int id);
    UserLoginLog getLog(int id);
}
