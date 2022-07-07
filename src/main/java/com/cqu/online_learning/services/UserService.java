package com.cqu.online_learning.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqu.online_learning.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    void addUser(User a);//添加用户
    void updateUser(User a);//修改用户
    List<User> queryAllUser();//查询所有用户
    User getUserById(int id);//按id查询用户
    void removeUserById(int id);//按id删除
    int verify(String account,String pwd);//登陆验证
}
