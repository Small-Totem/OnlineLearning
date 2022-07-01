package com.cqu.online_learning.controller;


import com.cqu.online_learning.entity.User;
import com.cqu.online_learning.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public String addUser(User a) {
        userService.addUser(a);
        return "success";
    }

    //登陆验证，account是邮箱或手机都行
    @PostMapping("/loginVerify/{account}/{pwd}")//不是很好但是将就了
    public boolean loginVerify(@PathVariable String account,@PathVariable String pwd) {
        return userService.verify(account,pwd);
    }

    @GetMapping("/queryAllUser")
    public List<User> queryAllUser() {
        return userService.queryAllUser();

    }

    //根据编号删除用户
    @GetMapping("/removeUser/{id}")
    public String removeUser(@PathVariable int id) {
        userService.removeUserById(id);
        return "success";

    }

    @GetMapping("/getUserById/{id}")
    public User getUser(@PathVariable int id){
        return userService.getUserById(id);
    }
}
