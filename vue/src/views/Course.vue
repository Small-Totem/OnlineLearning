<template>
  <el-row type="flex" justify="center" class="box">
    <el-col :span="20">
      <!-- 面包屑 -->
      <el-breadcrumb separator-class="el-icon-arrow-right" style="margin: 20px 0;color: #333">
        <el-breadcrumb-item>全部课程</el-breadcrumb-item>
        <el-breadcrumb-item >
          子路径
        </el-breadcrumb-item>
        <el-breadcrumb-item>课程标题 </el-breadcrumb-item>
      </el-breadcrumb>

      <!-- 播放器 -->
      <div style="position: relative;width: 100%">

        <!--<v-course-player ref="CoursePlayer" />-->
        <el-image
            style="width: 100%; height: 500px"
            :src="url"
            :fit="fit"></el-image>

        <div v-if="true" class="sub-course">
          <div>
            <div style="color: #FFFFFF;font-size: 20px;">
              {{ course.title }}
              <span style="color: #ff4f23;margin-left: 20px;">￥{{ course.price }}</span>

            </div>
            <div style="color: #999;font-size: 13px;margin-top: 5px">
              <span style="margin-right: 26px">{{ course.lessonNum }} 总课时</span>
              <span style="margin-right: 26px">{{ course.buyCount }} 人订阅过</span>
              <span>{{ course.viewCount }} 人观看过</span>
            </div>
          </div>
          <div style="margin-left: auto">
            <div style="width: 22vw;text-align: center">
              <el-button
                  type="primary"
                  style="width: 18vw;font-size: 18px"
                  icon="el-icon-plus"
                  @click="openBuyCourseDialog"
              >
                订阅课程
              </el-button>
            </div>
          </div>
        </div>
      </div>
      <!-- 课程简介、评价 -->
      <div class="clearfix" style="margin-top: 20px;width: 100%">
        <div style="width: 70%;background-color: #fff;padding: 10px 20px;float: left;">
          <el-tabs>
            <el-tab-pane label="课程概述" class="course-descriptiont" >课程描述</el-tab-pane>
            <el-tab-pane label="课程评价" lazy>
              课程评价
            </el-tab-pane>
          </el-tabs>
        </div>
        <!-- 讲师简介 -->
        <div style="width: 300px;background-color: #fff;float: right">
          <el-card>
            <div slot="header">讲师简介</div>
            <div style="display: flex;align-items: center;">
              {{头像}}
              <div>
                <div style="color: #20a0ff;font-size: 18px;cursor: pointer" @click="linkToTeacher(teacher.id)">
                  {{ teacher.name }}
                </div>
                <div style="margin-top: 10px;font-size: 14px" :title="teacher.email">
                  <i class="el-icon-message" />
                  {{ teacher.email }}
                </div>
              </div>
            </div>
            <div style="margin-top: 12px;font-size: 15px;line-height: 24px;color: #666">
              {{ teacher.intro }}
            </div>
          </el-card>
        </div>
      </div>
    </el-col>
  </el-row>
</template>

<script>

export default {
  name: 'Course',

  data: function () {
    return {
      url:"../src/assets/photo/course/1442295379715.jpg",
      course: {
        courseName: "课程名称",
        title:"课程名称",
        cover: "~/src/assets/photo/wb-icon.png",
        price: 13,
        teacherName: "教师名",
        buyCount: 10,
        lessonNum: 13,
        viewCount: 20,
        courseIntro: "课程详情",
        teacherId: 1,

        avatar: "~/src/assets/img/wb-icon.png",

      },
      teacher:{
        name:"教师名称",
        email:"142@163.com",
        intro:"教师描述" +
            "曾担任阿里大文娱事业部Java高级后端工程师，长期扎根于一线编码开发、系统架构设计与项目管理，拥有多年开发与管理经验，目前是一名互联网行业的创业者； 出版的书籍：《分布式中间件技术实战（Java版）》、《Spring Boot企业级项目开发-入门到精通》 ，51CTO学院、CSDN学院、网易云课堂等教育平台知名讲师，教授学生上万人，拥有大量原创博客，博客访问量达百万人次； 追求技术，热爱分享，相信技术改变生活，技术成就梦想，一直在不断的学习和积累新的知识，秉承修罗之道，花名“阿修罗”（修罗debug）。 熟悉行业Java领域流行技术，包括Spring、SpringMVC、Hibernate、Mybatis、SpringBoot、SpringCloud等核心框架，拥有缓存组件Redis、消息中间件RabbitMQ、服务调度框架Dubbo、服务调度协调管理中心Zookeeper、分布式任务调度框架Elastic-Job、全文搜索引擎Elastic-Search等三方框架、中间件多年实战经验"
      }
    }}


}

</script>
<style >
.box{
  width: 100%;


  margin: 0 auto;
  background-color: #eae5e5;
}
.sub-course{
  background-color: #333333;
  position:relative;
  bottom: 0;
  width: 1233px;
  min-height: 80px;
  z-index: 3;
  padding: 14px 16px;
  display: flex;
  align-items: center;
}
</style>
