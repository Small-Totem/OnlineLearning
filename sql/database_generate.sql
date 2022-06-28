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
   ARTICLE_ID           int not null,
   USER_ID              int,
   TITLE                text,
   SUMMARY              text,
   PUBLISH_TIME         timestamp,
   LINK                 text,
   CLICK_NUM            int,
   PRAISE_COUNT         int,
   primary key (ARTICLE_ID)
);

/*==============================================================*/
/* Table: edu_comment                                           */
/*==============================================================*/
create table edu_comment
(
   COMMENT_ID           int not null,
   COURSE_ID            int,
   USER_ID              int,
   CONTENT              text,
   ADDTIME              timestamp,
   PRAISE_COUNT         int,
   primary key (COMMENT_ID)
);

/*==============================================================*/
/* Table: edu_course                                            */
/*==============================================================*/
create table edu_course
(
   COURSE_ID            int not null,
   ID                   int,
   COURSE_NAME          text,
   SUBJECT_ID           int,
   SUBJECT_LINK         text,
   ADD_TIME             timestamp,
   TITLE                text,
   LOGO                 text,
   PAGE_VIEWCOUNT       int,
   primary key (COURSE_ID)
);

/*==============================================================*/
/* Table: edu_course_favorites                                  */
/*==============================================================*/
create table edu_course_favorites
(
   ID                   int not null,
   USER_ID              int,
   COURSE_ID            int,
   ADD_TIME             timestamp,
   primary key (ID)
);

/*==============================================================*/
/* Table: edu_questions                                         */
/*==============================================================*/
create table edu_questions
(
   ID                   int not null,
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

/*==============================================================*/
/* Table: edu_questions_comment                                 */
/*==============================================================*/
create table edu_questions_comment
(
   ID                   int not null,
   USER_ID              int,
   QUESTION_ID          int,
   CONTENT              text,
   IS_BEST              bool,
   REPLY_COUNT          int,
   PRAISE_COUNT         int,
   ADD_TIME             timestamp,
   primary key (ID)
);

/*==============================================================*/
/* Table: edu_teacher                                           */
/*==============================================================*/
create table edu_teacher
(
   ID                   int not null,
   NAME                 text,
   EDUCATION            text,
   CAREER               text,
   IS_STAR              bool,
   PIC_PATH             text,
   STATUS               text,
   CREATE_TIME          timestamp,
   UPDATE_TIME          timestamp,
   SUBJECT_ID           int,
   SORT                 int,
   primary key (ID)
);

/*==============================================================*/
/* Table: edu_user                                              */
/*==============================================================*/
create table edu_user
(
   USER_ID              int not null,
   MOBILE               int,
   EMAIL                text,
   PASSWORD             text,
   SHOW_NAME            text,
   SEX                  text,
   CREATE_TIME          timestamp,
   PERMISSION           text,
   PIC_IMG              text,
   primary key (USER_ID)
);

/*==============================================================*/
/* Table: edu_user_login_log                                    */
/*==============================================================*/
create table edu_user_login_log
(
   LOG_ID               int not null,
   USER_ID              int,
   LOGIN_TIME           timestamp,
   IP                   text,
   OS_NAME              text,
   USER_AGENT           text,
   primary key (LOG_ID)
);

