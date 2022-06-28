package com.cqu.online_learning.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString
@TableName("edu_comment")
public class Comment {
    @TableId(type = IdType.AUTO)
    private Integer commentId;
    private Integer courseId;
    private Integer userId;
    private String content;
    private Timestamp addtime;
    private Integer praiseCount;
}
