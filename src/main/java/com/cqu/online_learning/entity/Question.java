package com.cqu.online_learning.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString
@TableName("edu_questions")
public class Question {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private String title;
    private String content;
    private String type;
    private String status;
    private Integer reply_count;
    private Integer browse_count;
    private Integer praiseCount;
    private Timestamp add_time;

}
