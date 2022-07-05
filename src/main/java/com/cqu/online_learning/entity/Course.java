package com.cqu.online_learning.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import java.sql.Timestamp;

@Data
@ToString
@TableName("edu_course")
public class Course {
    @TableId(type = IdType.AUTO)
    private Integer courseId;
    private Integer teacherId;
    private String courseName;
    private String subject;
    private String subjectLink;
    private Timestamp addTime;
    private String title;
    private String logo;
    private Integer pageViewcount;
}
