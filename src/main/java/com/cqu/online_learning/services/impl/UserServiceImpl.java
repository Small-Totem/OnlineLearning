package com.cqu.online_learning.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqu.online_learning.entity.User;
import com.cqu.online_learning.mapper.UserMapper;
import com.cqu.online_learning.services.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

import static com.cqu.online_learning.utils.StaticUtils.getMD5;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public void addUser(User a) {
        //System.out.println(a.getPassword()+"->"+getMD5(a.getPassword()));
        a.setPassword(getMD5(a.getPassword()));
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

    @Override
    public int verify(String account, String pwd) {
        //System.out.println(account+" "+pwd);
        /*todo （低优先）重复注册情况的排除没做（并不会导致崩溃）*/
        HashMap<String, Object> columnMap1 = new HashMap<>();
        columnMap1.put("mobile", account);
        HashMap<String, Object> columnMap2 = new HashMap<>();
        columnMap2.put("email", account);
        List<User> users = listByMap(columnMap1);
        users.addAll(listByMap(columnMap2));//合并两个查询的结果

        //System.out.println(Arrays.toString(users.toArray()));
        for(User i : users){
            if((account.equals(Integer.toString(i.getMobile()))||account.equals(i.getEmail()))
                    && getMD5(pwd).equals(i.getPassword()))
                return i.getUserId();
        }
        return -1;
    }

}
