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

insert into edu_article (USER_ID,TITLE,SUMMARY,CONTENT,CLICK_NUM,PRAISE_COUNT) values (1,"我是理塘丁真","我只抽电子烟","史文文，男，1984年出生于江西省湖口县，2013年毕业于华中师范大学体育学院，获教育学博士学位。主要研究方向为运动心理学与体育人力资源管理，围绕研究方向已相继在在《北京体育大学学报》、《心理科学进展》、《中国体育科技》、《上海体育学院学报》等国内核心期刊发表论文数十篇，研究成果多次在全国体育科学大会、全国体育管理科学大会、全国运动心理学学术大会、中部心理学学术论坛、国际运动心理学大会等国内外学术会议上做口头报告与交流，合著学术专著1部（体育彩民购彩心理与行为特征研究）。作为项目主要成员参与国家社科基金项目2项，省部级项目3项。",345,121);
insert into edu_article (USER_ID,TITLE,SUMMARY,CONTENT,CLICK_NUM,PRAISE_COUNT) values (1,"都什么时代了，还在抽传统烟？","电子烟入门教学","孩子不懂事抽着玩的",3245,221);
insert into edu_article (USER_ID,TITLE,SUMMARY,CONTENT,CLICK_NUM,PRAISE_COUNT) values (3,"鸡哥篮球速成班","篮球速成","鸡你太美",3345,221);
insert into edu_article (USER_ID,TITLE,SUMMARY,CONTENT,CLICK_NUM,PRAISE_COUNT) values (2,"滑雪教学","滑了","狠狠地滑",3245,231);
insert into edu_article (USER_ID,TITLE,SUMMARY,CONTENT,CLICK_NUM,PRAISE_COUNT) values (5,"大家好，我是带带大师兄","我正式入驻在线教育平台了","我会持续高强度更新日语教学视频",4396,234);


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
insert into edu_comment (COURSE_ID,USER_ID,CONTENT,PRAISE_COUNT) values (2,2,"我踏马直接入土",3);
insert into edu_comment (COURSE_ID,USER_ID,CONTENT,PRAISE_COUNT) values (2,1,"这不有手就行？",1);
insert into edu_comment (COURSE_ID,USER_ID,CONTENT,PRAISE_COUNT) values (1,1,"php是世界上最好的语言！",14);
insert into edu_comment (COURSE_ID,USER_ID,CONTENT,PRAISE_COUNT) values (1,3,"javascript是世界上最烂的语言！",16);


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


insert into edu_course (TEACHER_ID,COURSE_NAME,SUBJECT,TITLE,LOGO) values (1,"java:从入门到入土","IT","java:从入门到入土","https://p2.itc.cn/images01/20210720/9c5ad1a36bd54ac4a621c9b357423081.jpeg");
insert into edu_course (TEACHER_ID,COURSE_NAME,SUBJECT,TITLE,LOGO) values (2,"php:从入门到入土","IT","php:从入门到入土","https://img2.baidu.com/it/u=2692009492,3096513359&fm=253&fmt=auto&app=138&f=JPEG?w=550&h=370");
insert into edu_course (TEACHER_ID,COURSE_NAME,SUBJECT,TITLE,LOGO) values (4,"围棋:AI是怎么让围棋变得无趣的","围棋","围棋:AI是怎么让围棋变得无趣的","http://mms1.baidu.com/it/u=4137928886,1380956632&fm=253&app=138&f=JPEG&fmt=auto&q=75?w=590&h=500");
insert into edu_course (TEACHER_ID,COURSE_NAME,SUBJECT,TITLE,LOGO) values (2,"c++:从入门到入土","IT","c++:从入门到入土","https://img1.baidu.com/it/u=2432038776,1994590296&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500");
insert into edu_course (TEACHER_ID,COURSE_NAME,SUBJECT,TITLE,LOGO) values (2,"kotlin:从基础到实战","IT","kotlin:从基础到实战","http://mms0.baidu.com/it/u=2188006861,2500630587&fm=253&app=138&f=JPEG&fmt=auto&q=75?w=500&h=500");
insert into edu_course (TEACHER_ID,COURSE_NAME,SUBJECT,TITLE,LOGO) values (3,"vue:前端开发实战","IT","vue:前端开发实战","http://mms0.baidu.com/it/u=4101935789,3368351456&fm=253&app=138&f=JPEG&fmt=auto&q=75?w=474&h=383");
insert into edu_course (TEACHER_ID,COURSE_NAME,SUBJECT,TITLE,LOGO) values (5,"电子烟的发展史","历史","电子烟的发展史","https://img1.baidu.com/it/u=1043431332,3800419241&fm=253&fmt=auto&app=138&f=JPEG?w=749&h=500");
insert into edu_course (TEACHER_ID,COURSE_NAME,SUBJECT,TITLE,LOGO) values (3,"apex进阶技巧","电竞","apex进阶技巧","https://img1.baidu.com/it/u=1785571183,2132428175&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500");
insert into edu_course (TEACHER_ID,COURSE_NAME,SUBJECT,TITLE,LOGO) values (2,"药酱教你高情商为人处世","职场","药酱教你高情商为人处世","https://img2.baidu.com/it/u=3280602308,123718325&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500");

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

insert into edu_questions_comment (USER_ID,QUESTION_ID,CONTENT,IS_BEST,PRAISE_COUNT) values (2,1,"npm install 就行了",1,4);
insert into edu_questions_comment (USER_ID,QUESTION_ID,CONTENT,IS_BEST,PRAISE_COUNT) values (3,1,"楼上正解",0,2);

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

insert into edu_teacher (NAME,EDUCATION,CAREER,IS_STAR,PIC_PATH,INFO,SUBJECT) values ("虎哥","重庆带专","教授",0,"https://p2.itc.cn/images01/20210720/9c5ad1a36bd54ac4a621c9b357423081.jpeg","史文文，男，1984年出生于江西省湖口县，2013年毕业于华中师范大学体育学院，获教育学博士学位。主要研究方向为运动心理学与体育人力资源管理，围绕研究方向已相继在在《北京体育大学学报》、《心理科学进展》、《中国体育科技》、《上海体育学院学报》等国内核心期刊发表论文数十篇，研究成果多次在全国体育科学大会、全国体育管理科学大会、全国运动心理学学术大会、中部心理学学术论坛、国际运动心理学大会等国内外学术会议上做口头报告与交流，合著学术专著1部（体育彩民购彩心理与行为特征研究）。作为项目主要成员参与国家社科基金项目2项，省部级项目3项。","计算机科学");
insert into edu_teacher (NAME,EDUCATION,CAREER,IS_STAR,PIC_PATH,INFO,SUBJECT) values ("药水哥","重庆带专","教授",0,"https://img2.baidu.com/it/u=2692009492,3096513359&fm=253&fmt=auto&app=138&f=JPEG?w=550&h=370","史文文，男，1984年出生于江西省湖口县，2013年毕业于华中师范大学体育学院，获教育学博士学位。主要研究方向为运动心理学与体育人力资源管理，围绕研究方向已相继在在《北京体育大学学报》、《心理科学进展》、《中国体育科技》、《上海体育学院学报》等国内核心期刊发表论文数十篇，研究成果多次在全国体育科学大会、全国体育管理科学大会、全国运动心理学学术大会、中部心理学学术论坛、国际运动心理学大会等国内外学术会议上做口头报告与交流，合著学术专著1部（体育彩民购彩心理与行为特征研究）。作为项目主要成员参与国家社科基金项目2项，省部级项目3项。","大数据");
insert into edu_teacher (NAME,EDUCATION,CAREER,IS_STAR,PIC_PATH,INFO,SUBJECT) values ("动力小子","重庆带专","教授",0,"https://img.3dmgame.com/uploads/images/xiaz/20210617/1623917007_655536.jpg","史文文，男，1984年出生于江西省湖口县，2013年毕业于华中师范大学体育学院，获教育学博士学位。主要研究方向为运动心理学与体育人力资源管理，围绕研究方向已相继在在《北京体育大学学报》、《心理科学进展》、《中国体育科技》、《上海体育学院学报》等国内核心期刊发表论文数十篇，研究成果多次在全国体育科学大会、全国体育管理科学大会、全国运动心理学学术大会、中部心理学学术论坛、国际运动心理学大会等国内外学术会议上做口头报告与交流，合著学术专著1部（体育彩民购彩心理与行为特征研究）。作为项目主要成员参与国家社科基金项目2项，省部级项目3项。","软件工程");
insert into edu_teacher (NAME,EDUCATION,CAREER,IS_STAR,PIC_PATH,INFO,SUBJECT) values ("柯洁","重庆带专","教授",0,"https://img.3dmgame.com/uploads/images/xiaz/20210617/1623917007_655536.jpg","史文文，男，1984年出生于江西省湖口县，2013年毕业于华中师范大学体育学院，获教育学博士学位。主要研究方向为运动心理学与体育人力资源管理，围绕研究方向已相继在在《北京体育大学学报》、《心理科学进展》、《中国体育科技》、《上海体育学院学报》等国内核心期刊发表论文数十篇，研究成果多次在全国体育科学大会、全国体育管理科学大会、全国运动心理学学术大会、中部心理学学术论坛、国际运动心理学大会等国内外学术会议上做口头报告与交流，合著学术专著1部（体育彩民购彩心理与行为特征研究）。作为项目主要成员参与国家社科基金项目2项，省部级项目3项。","软件工程");
insert into edu_teacher (NAME,EDUCATION,CAREER,IS_STAR,PIC_PATH,INFO,SUBJECT) values ("丁真","重庆带专","教授",0,"https://img.3dmgame.com/uploads/images/xiaz/20210617/1623917007_655536.jpg","史文文，男，1984年出生于江西省湖口县，2013年毕业于华中师范大学体育学院，获教育学博士学位。主要研究方向为运动心理学与体育人力资源管理，围绕研究方向已相继在在《北京体育大学学报》、《心理科学进展》、《中国体育科技》、《上海体育学院学报》等国内核心期刊发表论文数十篇，研究成果多次在全国体育科学大会、全国体育管理科学大会、全国运动心理学学术大会、中部心理学学术论坛、国际运动心理学大会等国内外学术会议上做口头报告与交流，合著学术专著1部（体育彩民购彩心理与行为特征研究）。作为项目主要成员参与国家社科基金项目2项，省部级项目3项。","人工智能");

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

