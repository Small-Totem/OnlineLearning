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
@TableName("edu_course")
public class Course {
    @TableId(type = IdType.AUTO)
    private Integer courseId;
    private Integer id;
    private String courseName;
    private Integer subjectId;
    private String subjectLink;
    private Timestamp addTime;
    private String title;
    private Integer lessonNum;
    private String logo;
    private Timestamp updateTime;
    private Integer pageViewcount;
    private Timestamp endTime;
}
