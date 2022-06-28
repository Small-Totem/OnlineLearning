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
    private Byte isStar;
    private String picPath;
    private String status;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer subjectId;
    private Integer sort;
}
