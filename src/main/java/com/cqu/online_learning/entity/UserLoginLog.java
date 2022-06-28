package com.cqu.online_learning.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.sql.Time;
import java.sql.Timestamp;

@Data
@ToString
@TableName("edu_user_login_log")
public class UserLoginLog {
    @TableId(type = IdType.AUTO)
    private Integer logId;
    private Integer userId;
    private Timestamp loginTime;
    private String ip;
    private String osName;
    private String userAgent;
}
