/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2022/6/28 17:00:40                           */
/*==============================================================*/


drop table if exists edu_article;

drop table if exists edu_comment;

drop table if exists edu_course;

drop table if exists edu_course_favorites;

drop table if exists edu_questions;

drop table if exists edu_questions_comment;

drop table if exists edu_teacher;

drop table if exists edu_user;

drop table if exists edu_user_login_log;

/*==============================================================*/
/* Table: edu_article                                           */
/*==============================================================*/
create table edu_article
(
   ARTICLE_ID           int not null AUTO_INCREMENT,
   USER_ID              int,
   TITLE                text,
   SUMMARY              text,
   PUBLISH_TIME         timestamp,
   CONTENT              text,
   LINK                 text,
   CLICK_NUM            int,
   PRAISE_COUNT         int,
   primary key (ARTICLE_ID)
);

insert into edu_article (USER_ID,TITLE,SUMMARY,CONTENT,CLICK_NUM,PRAISE_COUNT) values (1,"我是理塘丁真","我只抽电子烟","我是来自理塘的丁真",345,121);
insert into edu_article (USER_ID,TITLE,SUMMARY,CLICK_NUM,PRAISE_COUNT) values (1,"都什么时代了，还在抽传统烟？","电子烟入门教学",3245,221);
insert into edu_article (USER_ID,TITLE,SUMMARY,CLICK_NUM,PRAISE_COUNT) values (3,"鸡哥篮球速成班","篮球速成",3345,221);
insert into edu_article (USER_ID,TITLE,SUMMARY,CLICK_NUM,PRAISE_COUNT) values (2,"滑雪教学","滑了",3245,231);


/*==============================================================*/
/* Table: edu_comment                                           */
/*==============================================================*/
create table edu_comment
(
   COMMENT_ID           int not null AUTO_INCREMENT,
   COURSE_ID            int,
   USER_ID              int,
   CONTENT              text,
   ADDTIME              timestamp,
   PRAISE_COUNT         int,
   primary key (COMMENT_ID)
);
insert into edu_comment (COURSE_ID,USER_ID,CONTENT,PRAISE_COUNT) values (0,2,"我踏马直接入土",3);
insert into edu_comment (COURSE_ID,USER_ID,CONTENT,PRAISE_COUNT) values (0,0,"这不有手就行？",1);
insert into edu_comment (COURSE_ID,USER_ID,CONTENT,PRAISE_COUNT) values (1,0,"php是世界上最好的语言！",14);


/*==============================================================*/
/* Table: edu_course                                            */
/*==============================================================*/
create table edu_course
(
   COURSE_ID            int not null AUTO_INCREMENT,
   TEACHER_ID           int,
   COURSE_NAME          text,
   SUBJECT              text,
   SUBJECT_LINK         text,
   ADD_TIME             timestamp,
   TITLE                text,
   LOGO                 text,
   PAGE_VIEWCOUNT       int,
   primary key (COURSE_ID)
);


insert into edu_course (TEACHER_ID,COURSE_NAME,TITLE) values (1,"java:从入门到入土","java:从入门到入土");
insert into edu_course (TEACHER_ID,COURSE_NAME,TITLE) values (2,"php:从入门到入土","php:从入门到入土");
insert into edu_course (TEACHER_ID,COURSE_NAME,TITLE) values (2,"python:从入门到入土","python:从入门到入土");
insert into edu_course (TEACHER_ID,COURSE_NAME,TITLE) values (2,"c++:从入门到入土","c++:从入门到入土");
insert into edu_course (TEACHER_ID,COURSE_NAME,TITLE) values (2,"kotlin:从入门到入土","kotlin:从入门到入土");
insert into edu_course (TEACHER_ID,COURSE_NAME,TITLE) values (3,"vue:前端开发实战","vue:前端开发实战");
insert into edu_course (TEACHER_ID,COURSE_NAME,TITLE) values (0,"电子烟实战","电子烟实战");

/*==============================================================*/
/* Table: edu_course_favorites                                  */
/*==============================================================*/
create table edu_course_favorites
(
   ID                   int not null AUTO_INCREMENT,
   USER_ID              int,
   COURSE_ID            int,
   ADD_TIME             timestamp,
   primary key (ID)
);

insert into edu_course_favorites (USER_ID,COURSE_ID) values (0,6);
insert into edu_course_favorites (USER_ID,COURSE_ID) values (1,1);
insert into edu_course_favorites (USER_ID,COURSE_ID) values (2,2);
insert into edu_course_favorites (USER_ID,COURSE_ID) values (2,3);

/*==============================================================*/
/* Table: edu_questions                                         */
/*==============================================================*/
create table edu_questions
(
   ID                   int not null AUTO_INCREMENT,
   USER_ID              int,
   TITLE                text,
   CONTENT              text,
   TYPE                 text,
   STATUS               text,
   REPLY_COUNT          int,
   BROWSE_COUNT         int,
   PRAISE_COUNT         int,
   ADD_TIME             timestamp,
   primary key (ID)
);

insert into edu_questions (USER_ID,TITLE,CONTENT,REPLY_COUNT,BROWSE_COUNT,PRAISE_COUNT) values ("1","node别人的模块怎么装？","求教,不知道怎么装",2,14,10);
insert into edu_questions (USER_ID,TITLE,CONTENT,REPLY_COUNT,BROWSE_COUNT,PRAISE_COUNT) values ("2","vue报错怎么办","求大神",0,12,10);
insert into edu_questions (USER_ID,TITLE,CONTENT,REPLY_COUNT,BROWSE_COUNT,PRAISE_COUNT) values ("3","java报错怎么办","求大神",0,11,9);

/*==============================================================*/
/* Table: edu_questions_comment                                 */
/*==============================================================*/
create table edu_questions_comment
(
   ID                   int not null AUTO_INCREMENT,
   USER_ID              int,
   QUESTION_ID          int,
   CONTENT              text,
   IS_BEST              bool,
   REPLY_COUNT          int,
   PRAISE_COUNT         int,
   ADD_TIME             timestamp,
   primary key (ID)
);

insert into edu_questions_comment (USER_ID,QUESTION_ID,CONTENT,IS_BEST,PRAISE_COUNT) values ("2","0","npm install 就行了",1,4);
insert into edu_questions_comment (USER_ID,QUESTION_ID,CONTENT,IS_BEST,PRAISE_COUNT) values ("3","0","楼上正解",0,2);

/*==============================================================*/
/* Table: edu_teacher                                           */
/*==============================================================*/
create table edu_teacher
(
   ID                   int not null AUTO_INCREMENT,
   NAME                 text,
   EDUCATION            text,
   CAREER               text,
   IS_STAR              bool,
   PIC_PATH             text,
   INFO                 text,
   CREATE_TIME          timestamp,
   SUBJECT              text,
   primary key (ID)
);

insert into edu_teacher (NAME,IS_STAR,SUBJECT) values ("虎哥",0,"职场");
insert into edu_teacher (NAME,IS_STAR,SUBJECT) values ("药水哥",0,"情感");
insert into edu_teacher (NAME,IS_STAR,SUBJECT) values ("动力小子",0,"电竞");
insert into edu_teacher (NAME,IS_STAR,SUBJECT) values ("柯洁",0,"围棋");
insert into edu_teacher (NAME,IS_STAR,SUBJECT) values ("丁真",1,"养身");

/*==============================================================*/
/* Table: edu_user                                              */
/*==============================================================*/
create table edu_user
(
   USER_ID              int not null AUTO_INCREMENT,
   MOBILE               text,
   EMAIL                text,
   PASSWORD             text,
   SHOW_NAME            text,
   SEX                  text,
   CREATE_TIME          timestamp,
   PERMISSION           text,
   PIC_IMG              text,
   primary key (USER_ID)
);

-- 此处密码明文是abc123 (a906449d5769fa7361d7ecc6aa3f6d28)
insert into edu_user (EMAIL,PASSWORD,SEX,SHOW_NAME) values ("abc@xyz.com","a906449d5769fa7361d7ecc6aa3f6d28","男",'丁真');
insert into edu_user (EMAIL,PASSWORD,SEX,SHOW_NAME) values ("abcd@xyz.com","a906449d5769fa7361d7ecc6aa3f6d28","女",'谷爱凌');
insert into edu_user (MOBILE,PASSWORD,SEX,SHOW_NAME) values ("13579246810","a906449d5769fa7361d7ecc6aa3f6d28","男",'蔡徐坤');
insert into edu_user (MOBILE,PASSWORD,SEX,SHOW_NAME) values ("13579246811","a906449d5769fa7361d7ecc6aa3f6d28","男",'柯洁');
insert into edu_user (MOBILE,PASSWORD,SEX,SHOW_NAME) values ("13579246812","a906449d5769fa7361d7ecc6aa3f6d28","男",'孙笑川');

/*==============================================================*/
/* Table: edu_user_login_log                                    */
/*==============================================================*/
create table edu_user_login_log
(
   LOG_ID               int not null AUTO_INCREMENT,
   USER_ID              int,
   LOGIN_TIME           timestamp,
   IP                   text,
   OS_NAME              text,
   USER_AGENT           text,
   primary key (LOG_ID)
);

insert into edu_user_login_log (USER_ID,LOGIN_TIME,IP,OS_NAME) values (0,'2022-07-05 10:08:48','10.123.234.321','Windows12');
insert into edu_user_login_log (USER_ID,LOGIN_TIME,IP,OS_NAME) values (4,'2022-07-05 10:28:48','10.123.234.123','Windows9');
