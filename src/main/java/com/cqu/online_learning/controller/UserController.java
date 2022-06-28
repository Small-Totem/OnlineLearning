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

    @PostMapping("/adduser")
    public String addUser(User a) {
        userService.addUser(a);
        return "success";
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
