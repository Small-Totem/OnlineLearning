package com.cqu.online_learning.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString
@TableName("edu_article")
public class Article {
    @TableId(type = IdType.AUTO)
    private Integer articleId;
    private Integer userId;
    private String title;
    private String content;
    private String summary;
    private Timestamp publishTime;
    private String link;
    private Integer clickNum;
    private Integer praiseCount;
}
