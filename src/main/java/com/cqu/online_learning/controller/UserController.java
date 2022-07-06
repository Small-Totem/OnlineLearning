package com.cqu.online_learning.controller;

import com.cqu.online_learning.entity.User;
import com.cqu.online_learning.entity.UserLoginLog;
import com.cqu.online_learning.services.UserLoginLogService;
import com.cqu.online_learning.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.cqu.online_learning.utils.StaticUtils.wrap;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserLoginLogService logService;

    @PostMapping("/addUser")
    public String addUser(User a) {
        userService.addUser(a);
        return "success";
    }

    //登陆验证，account是邮箱或手机都行 验证成功返回登录账号的uid 否则返回-1
    @PostMapping("/loginVerify/{account}/{pwd}")//不是很好但是将就了
    public int loginVerify(@PathVariable String account,@PathVariable String pwd) {
        int result=userService.verify(account,pwd);
        if (result!=-1){
            //加登录log todo:os,ip等信息的添加
            UserLoginLog log = new UserLoginLog();
            log.setUserId(result);
            logService.addLog(log);
        }
        return result;
    }

    @GetMapping("/queryAllUser")
    public Object queryAllUser() {
        return wrap(userService.queryAllUser());

    }

    //根据编号删除用户
    @GetMapping("/removeUser/{id}")
    public String removeUser(@PathVariable int id) {
        userService.removeUserById(id);
        return "success";

    }

    @GetMapping("/getUserById/{id}")
    public List<User> getUser(@PathVariable int id){
        List<User> queryuser = new ArrayList<>();
        queryuser.add(userService.getUserById(id));
        return queryuser;
    }

}
