<template>
<div class="mainbox">
  <el-row type="flex" justify="center" class="box">
    <el-col :span="20">
  <div class="clearfix" style="margin-top: 0px;width: 100%;align-self: center">
  <div style="width: 70%;background-color: #fff;padding: 10px 20px;float: left;">
    <el-tabs>
      <el-tab-pane label="全部问答" class="course-descriptiont" >
        <el-row v-for="o in 5">
          <el-card class="box-card">
            <el-col>
            <div style="float: left;width: 100px;height: 100px">
              <el-image
                  style="width: 100%; height: 100%"
                  :src="url"
                  :fit="fit"></el-image>
            </div>
            </el-col>
            <el-col style="width: 550px">
               <div >
                   <span >问题内容</span>
               </div>
               <div >
                   <span >问题回答</span>
            </div>
            </el-col>
            <el-col>
            <div style="text-align: center ">
              <span style="color:#adadad">{{ course.price }}</span>
            </div>
            <div style="margin-top: 30px">
              <span style="color: #adadad">{{ "回答数" }}</span>
            </div>
            </el-col>
            <el-col style="float: right">
              <div style="text-align: center ">
                <span style="color: #adadad">{{ course.price }}</span>
              </div>
              <div style="margin-top: 30px">
                <span style="color: #adadad">{{ "浏览数" }}</span>
              </div>
            </el-col>

        </el-card>
        </el-row>
      </el-tab-pane>

      <el-tab-pane label="课程问答" lazy>
        <el-row v-for="o in 5">
          <el-card class="box-card">
            <el-col>
              <div style="float: left;width: 100px;height: 100px">
                <el-image
                    style="width: 100%; height: 100%"
                    :src="url"
                    :fit="fit"></el-image>
              </div>
            </el-col>
            <el-col style="width: 550px">
              <div >
                <span >问题内容</span>
              </div>
              <div >
                <span >问题回答</span>
              </div>
            </el-col>
            <el-col>
              <div style="text-align: center ">
                <span style="color:#adadad">{{ course.price }}</span>
              </div>
              <div style="margin-top: 30px">
                <span style="color: #adadad">{{ "回答数" }}</span>
              </div>
            </el-col>
            <el-col style="float: right">
              <div style="text-align: center ">
                <span style="color: #adadad">{{ course.price }}</span>
              </div>
              <div style="margin-top: 30px">
                <span style="color: #adadad">{{ "浏览数" }}</span>
              </div>
            </el-col>

          </el-card>
        </el-row>
      </el-tab-pane>
    </el-tabs>

  </div>
  </div>
      <div style="width: 300px;background-color: #fff;float: right">
          <div style="width: 10px;text-align: center">
            <el-button
                type="primary"
                style="width: 300px;font-size: 18px"
                icon="el-icon-plus"
                @click="openBuyCourseDialog"
            >
              我要提问
            </el-button>
          </div>
        <div>
          <h5 style="font-size: 30px;color: #afafaf">热门问答推荐</h5>
        </div>
        <el-row v-for="o in 5">
          <el-card style="width: 300px;height: 70px">
            <div style="float: left">
            <i class="el-icon-s-promotion" ></i>
             </div>
            <!--<span style="color: #000000;margin-bottom: 5px">{{ " 问题标题" }}</span>-->
            <el-link href="https://element.eleme.io" target="_blank">问题标题</el-link>
            <div style="float: right">
              <span style="color: #ff876b">{{ course.price }}</span>
            </div>
            <div>
              <span style="color: #adadad;float: right">{{ "回答数" }}</span>
            </div>
          </el-card>
        </el-row>
      </div>
    </el-col>
  </el-row>
</div>
</template>

<script>
export default {
  name: "Question",
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

<style scoped>

.mainbox{
  background-color: #d2d2d2;
}


.text {
  font-size: 14px;
}

.item {
  padding: 18px 0;
}




</style>