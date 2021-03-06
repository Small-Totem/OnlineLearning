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


insert into edu_article (USER_ID,TITLE,SUMMARY,CONTENT,CLICK_NUM,PRAISE_COUNT) values (4,"在没有其它高级语言的时候，那些高级语言的编译器又是怎么写出来的呢？",'程序语言都是怎么发明的？','      在计算机科学里，这个问题对应于所谓的自举 (Bootstrapping) 概念。一般来说，某种新语言 X 的第一个编译器 C1，需要用另一种语言来编写。接下来你就可以用 C1 编译出一个部分用 X 来写的新编译器 C2，而 C2 又可以编译出一个支持更多 X 特性的 C3，然后 C3 编译出 X 支持更好的 C4……'
                                                                                                                                       '\n      更通俗的理解，是将编译器想像成一个加工零件的机床。这个机床既可以加工出普通零件，也可以加工出高级零件，最后组装出一台新的机床。第一台机床的零件都需要手工打造，造出的零件比较粗糙，但用第一台机床加工出的第二台机床，可能还有一些零件要靠手工，但机械化比例肯定比第一台机床高一些，加工效果也会更好一些。多重复几次这种【用粗糙机床制造更高精度机床】的过程后，即便制造第一台机床的手工技术失传，我们仍然可以标准化地用机床来制造机床。'
                                                                                                                                       '\n      历史上，最早的 C 编译器就是汇编实现的。而最早的 C++ 编译器，则是用 C with Class 这种介于 C 和 C++ 之间的语言来实现的。当时已经有了能编译 C with Class 的编译器，用这种编译器编译出来的第一个 C++ 编译器还比较简陋，只是把 C++ 转成 C，然后再用 C 编译器去编译。但有了这个起点后，人们就能用 C++ 来开发越来越强的 C++ 编译器了。所谓道生一，一生二，二生三，三生万物，大抵如此。',11932,1672);
insert into edu_article (USER_ID,TITLE,SUMMARY,CONTENT,CLICK_NUM,PRAISE_COUNT) values (4,"福建舰下水后，中国会建造更多航母吗？中方回应来了！","福建舰下水后，中国会建造更多航母吗？中方回应来了！",'      中国国防部举行了例行的记者会，在记者会中，中国外交部发言人谭克非回答了记者提问的相关问题。在记者会中有记者提问，最近一段时间，中国的第三艘航母举行了命名仪式并且正式下水了，这使得外界都很关注中国在军事领域的动向，那么在这艘航母之后中国还不会继续建造更大更多的航母，这是不是也意味着中国正在改变有关的国防政策呢？'
                                                                                                                                                 '\n      中国国防部发言人谭克非回应称，中国发展的这些军事武器准备并不针对世界上的任何一个国家，也不会对任何国家造成威胁，中国只是为了提升自己，加强自身的实力，设施维护好自己国家的主权、领土、利益和国家安全。对于中国日后还会不会继续再建造大型的航母，这是根据中国的需要和有关技术的情况来考虑的。中国国防部发言人还表示称，中国是一个社会主义国家，而且中国一直以来奉行的就是和平相处的外交政策，这些都决定着中国持续执行的是防御性的国防政府，这是永远都不会改变的。时间和事实都将继续证明，中国是切实维护国家安全的，为全球的经济恢复和提升作出贡献，也会坚定维护国际秩序，为全世界提供更多的公共产品。'
                                                                                                                                                 '\n      此前，我国第三艘航母命名并正式下水了。中央军委副主席出现了该仪式，经过中央军委的批准，这艘航母命名为福建舰，舷号为18。这艘航母是中国第一艘自己独立建造的大型航母，并且还安装了电磁弹射和阻拦的装置，排水量为八万多吨。在这艘航母下水之后，将进行航行的实验和系泊试验。'
                                                                                                                                                 '\n      关于福建舰今后将部署在哪里，中国人民解放军海军新闻发言人表示称，这将根据国家的需要和该艘航母的性能、特点来科学合理安排该艘航母的部署地。中国人民解放军海军新闻发言人还介绍称，这艘航母是中国第一艘自己完全建造的弹射型航母，使用的是平直通厂的甲板，并且还安装了电磁弹射和阻拦的装置，排水量为八万多吨。在这艘航母下水之后，将进行航行的实验和系泊试验，目前更各项工作都进入交接状态。'
                                                                                                                                                 '\n      随着中国的不断发展，中国的军事实力也在不断增强，但中国仅仅只是为了发展自己，并不会对世界上任何一个国家造成威胁，更不存在什么所谓的中国威胁论，中国只是为了保护自己。',7343,850);
insert into edu_article (USER_ID,TITLE,SUMMARY,CONTENT,CLICK_NUM,PRAISE_COUNT) values (3,"坤哥篮球速成班","篮球速成","鸡你太美",3345,221);
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
insert into edu_course (TEACHER_ID,COURSE_NAME,SUBJECT,TITLE,LOGO) values (5,"烟草行业的发展史","历史","烟草行业的发展史","https://img1.baidu.com/it/u=1043431332,3800419241&fm=253&fmt=auto&app=138&f=JPEG?w=749&h=500");
insert into edu_course (TEACHER_ID,COURSE_NAME,SUBJECT,TITLE,LOGO) values (3,"apex进阶技巧","电竞","apex进阶技巧","https://img1.baidu.com/it/u=1785571183,2132428175&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500");
insert into edu_course (TEACHER_ID,COURSE_NAME,SUBJECT,TITLE,LOGO) values (3,"apex英雄:武器完全解析","电竞","apex英雄:武器完全解析","https://img1.baidu.com/it/u=1960041980,2043975107&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500");
insert into edu_course (TEACHER_ID,COURSE_NAME,SUBJECT,TITLE,LOGO) values (2,"药酱教你高情商为人处世","职场","药酱教你高情商为人处世","https://img2.baidu.com/it/u=3280602308,123718325&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500");
insert into edu_course (TEACHER_ID,COURSE_NAME,SUBJECT,TITLE,LOGO) values (6,"鸡哥的篮球基础教学","运动","鸡哥的篮球基础教学","https://img0.baidu.com/it/u=4090386160,4004136615&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=414");
insert into edu_course (TEACHER_ID,COURSE_NAME,SUBJECT,TITLE,LOGO) values (1,"东百抽象艺术","艺术","东百抽象艺术","https://img2.baidu.com/it/u=574407957,1694974694&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500");


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

insert into edu_teacher (NAME,EDUCATION,CAREER,IS_STAR,PIC_PATH,INFO,SUBJECT) values ("虎哥","东百大学","教授",0,"https://p2.itc.cn/images01/20210720/9c5ad1a36bd54ac4a621c9b357423081.jpeg","史文文，男，1984年出生于江西省湖口县，2013年毕业于华中师范大学体育学院，获教育学博士学位。主要研究方向为运动心理学与体育人力资源管理，围绕研究方向已相继在在《北京体育大学学报》、《心理科学进展》、《中国体育科技》、《上海体育学院学报》等国内核心期刊发表论文数十篇，研究成果多次在全国体育科学大会、全国体育管理科学大会、全国运动心理学学术大会、中部心理学学术论坛、国际运动心理学大会等国内外学术会议上做口头报告与交流，合著学术专著1部（体育彩民购彩心理与行为特征研究）。作为项目主要成员参与国家社科基金项目2项，省部级项目3项。","计算机科学");
insert into edu_teacher (NAME,EDUCATION,CAREER,IS_STAR,PIC_PATH,INFO,SUBJECT) values ("药水哥","药水学院","教授",0,"https://img2.baidu.com/it/u=2692009492,3096513359&fm=253&fmt=auto&app=138&f=JPEG?w=550&h=370","史文文，男，1984年出生于江西省湖口县，2013年毕业于华中师范大学体育学院，获教育学博士学位。主要研究方向为运动心理学与体育人力资源管理，围绕研究方向已相继在在《北京体育大学学报》、《心理科学进展》、《中国体育科技》、《上海体育学院学报》等国内核心期刊发表论文数十篇，研究成果多次在全国体育科学大会、全国体育管理科学大会、全国运动心理学学术大会、中部心理学学术论坛、国际运动心理学大会等国内外学术会议上做口头报告与交流，合著学术专著1部（体育彩民购彩心理与行为特征研究）。作为项目主要成员参与国家社科基金项目2项，省部级项目3项。","大数据");
insert into edu_teacher (NAME,EDUCATION,CAREER,IS_STAR,PIC_PATH,INFO,SUBJECT) values ("动力小子","奥林匹斯大学","教授",0,"https://img.3dmgame.com/uploads/images/xiaz/20210617/1623917007_655536.jpg","史文文，男，1984年出生于江西省湖口县，2013年毕业于华中师范大学体育学院，获教育学博士学位。主要研究方向为运动心理学与体育人力资源管理，围绕研究方向已相继在在《北京体育大学学报》、《心理科学进展》、《中国体育科技》、《上海体育学院学报》等国内核心期刊发表论文数十篇，研究成果多次在全国体育科学大会、全国体育管理科学大会、全国运动心理学学术大会、中部心理学学术论坛、国际运动心理学大会等国内外学术会议上做口头报告与交流，合著学术专著1部（体育彩民购彩心理与行为特征研究）。作为项目主要成员参与国家社科基金项目2项，省部级项目3项。","软件工程");
insert into edu_teacher (NAME,EDUCATION,CAREER,IS_STAR,PIC_PATH,INFO,SUBJECT) values ("柯洁","清华大学","教授",0,"https://img.3dmgame.com/uploads/images/xiaz/20210617/1623917007_655536.jpg","史文文，男，1984年出生于江西省湖口县，2013年毕业于华中师范大学体育学院，获教育学博士学位。主要研究方向为运动心理学与体育人力资源管理，围绕研究方向已相继在在《北京体育大学学报》、《心理科学进展》、《中国体育科技》、《上海体育学院学报》等国内核心期刊发表论文数十篇，研究成果多次在全国体育科学大会、全国体育管理科学大会、全国运动心理学学术大会、中部心理学学术论坛、国际运动心理学大会等国内外学术会议上做口头报告与交流，合著学术专著1部（体育彩民购彩心理与行为特征研究）。作为项目主要成员参与国家社科基金项目2项，省部级项目3项。","软件工程");
insert into edu_teacher (NAME,EDUCATION,CAREER,IS_STAR,PIC_PATH,INFO,SUBJECT) values ("丁真","纯真学院","教授",0,"https://img.3dmgame.com/uploads/images/xiaz/20210617/1623917007_655536.jpg","史文文，男，1984年出生于江西省湖口县，2013年毕业于华中师范大学体育学院，获教育学博士学位。主要研究方向为运动心理学与体育人力资源管理，围绕研究方向已相继在在《北京体育大学学报》、《心理科学进展》、《中国体育科技》、《上海体育学院学报》等国内核心期刊发表论文数十篇，研究成果多次在全国体育科学大会、全国体育管理科学大会、全国运动心理学学术大会、中部心理学学术论坛、国际运动心理学大会等国内外学术会议上做口头报告与交流，合著学术专著1部（体育彩民购彩心理与行为特征研究）。作为项目主要成员参与国家社科基金项目2项，省部级项目3项。","人工智能");
insert into edu_teacher (NAME,EDUCATION,CAREER,IS_STAR,PIC_PATH,INFO,SUBJECT) values ("蔡徐坤","体育学院","练习生",0,"https://img.3dmgame.com/uploads/images/xiaz/20210617/1623917007_655536.jpg","史文文，男，1984年出生于江西省湖口县，2013年毕业于华中师范大学体育学院，获教育学博士学位。主要研究方向为运动心理学与体育人力资源管理，围绕研究方向已相继在在《北京体育大学学报》、《心理科学进展》、《中国体育科技》、《上海体育学院学报》等国内核心期刊发表论文数十篇，研究成果多次在全国体育科学大会、全国体育管理科学大会、全国运动心理学学术大会、中部心理学学术论坛、国际运动心理学大会等国内外学术会议上做口头报告与交流，合著学术专著1部（体育彩民购彩心理与行为特征研究）。作为项目主要成员参与国家社科基金项目2项，省部级项目3项。","人工智能");

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

-- 此处密码明文是abc123 (md5:a906449d5769fa7361d7ecc6aa3f6d28)
insert into edu_user (EMAIL,PASSWORD,SEX,SHOW_NAME,PERMISSION,PIC_IMG) values ("abc@xyz.com","a906449d5769fa7361d7ecc6aa3f6d28","男",'丁真','student','src/assets/photo/teacher/1442297885942.jpg');
insert into edu_user (EMAIL,PASSWORD,SEX,SHOW_NAME,PERMISSION,PIC_IMG) values ("abcd@xyz.com","a906449d5769fa7361d7ecc6aa3f6d28","女",'谷爱凌','teacher','src/assets/photo/teacher/1442297919077.jpg');
insert into edu_user (MOBILE,PASSWORD,SEX,SHOW_NAME,PERMISSION,PIC_IMG) values ("13579246810","a906449d5769fa7361d7ecc6aa3f6d28","男",'蔡徐坤','student','src/assets/photo/teacher/1442297927029.jpg');
insert into edu_user (MOBILE,PASSWORD,SEX,SHOW_NAME,PERMISSION,PIC_IMG) values ("13579246811","a906449d5769fa7361d7ecc6aa3f6d28","男",'柯洁','teacher','src/assets/photo/teacher/1442297935589.jpg');
insert into edu_user (MOBILE,PASSWORD,SEX,SHOW_NAME,PERMISSION,PIC_IMG) values ("13579246812","a906449d5769fa7361d7ecc6aa3f6d28","男",'孙笑川','teacher','src/assets/photo/teacher/1442297957332.jpg');

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

