package com.cqu.online_learning.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString
@TableName("edu_questions_comment")
public class QuestionsComment {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer questionId;
    private String content;
    private Integer isBest;
    private Integer replyCount;
    private Integer praiseCount;
    private Timestamp addTime;
}
