package com.cqu.online_learning.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqu.online_learning.entity.User;
import com.cqu.online_learning.mapper.UserMapper;
import com.cqu.online_learning.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSeviceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public void addUser(User a) {
        this.save(a);
    }

    @Override
    public List<User> queryAllUser() {
        return list();
    }

    @Override
    public User getUserById(int id) {
        return this.getById(id);
    }

    @Override
    public void removeUserById(int id) {
        this.removeById(id);
    }

}
