package com.cqu.online_learning.controller;

import com.cqu.online_learning.entity.UserLoginLog;
import com.cqu.online_learning.services.UserLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserLoginLogController {
    @Autowired
    UserLoginLogService userLoginLogService;


    //这个api不该手动调用。在用户登录后会自动增加（实现于UserController.loginVerify()）
    @PostMapping("/addLog")
    public String addLog(UserLoginLog a) {
        userLoginLogService.addLog(a);
        return "success";
    }

    @GetMapping("/queryAllLog")
    public List<UserLoginLog> queryAllLog(){
        return userLoginLogService.queryAllLog();
    }

    @GetMapping("/getLog/{id}")
    public UserLoginLog getLog(@PathVariable int id){
        return userLoginLogService.getLog(id);
    }

    @GetMapping("/removeLog/{id}")
    public String removeLog(@PathVariable int id) {
        userLoginLogService.removeLog(id);
        return "success";
    }
}
