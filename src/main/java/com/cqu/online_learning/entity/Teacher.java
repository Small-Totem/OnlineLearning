package com.cqu.online_learning.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString
@TableName("edu_teacher")
public class Teacher {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String education;
    private String career;
    private Byte isStar;//0表示否 1表示是
    private String picPath;
    private String info;
    private Timestamp createTime;
    private String subject;
}
