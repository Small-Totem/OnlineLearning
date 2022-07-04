package com.cqu.online_learning.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString
@TableName("edu_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer userId;
    private String mobile;
    private String email;
    private String password;
    private String showName;
    private String sex;
    private Timestamp createTime;
    private String permission;
    private String picImg;
}
