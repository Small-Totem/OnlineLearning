<template>
    <div>
        <el-container>
            <el-header class="TeacherIntroduce">讲师介绍</el-header>
            <el-main class="TeacherContent">
                <el-descriptions title="讲师信息">
                    <el-descriptions-item label="姓名：" >{{name}}</el-descriptions-item>
                    <el-descriptions-item label="所属机构：">{{education}}</el-descriptions-item>
                    <el-descriptions-item label="职称：">{{career}}</el-descriptions-item>
                    <el-descriptions-item label="详细介绍：">{{detail}}</el-descriptions-item>
                </el-descriptions>
                <br/>
                所教授课程
            </el-main>
        </el-container>
    </div>
</template>

<script>
    export default {
        name: "Teacher",
        data(){
            return{
                name:"史文文",
                education:"湖北大学 体育学院",
                career:"副教授",
                detail:"史文文，男，1984年出生于江西省湖口县，2013年毕业于华中师范大学体育学院，获教育学博士学位。主要研究方向为运动心理学与体育人力资源管理，围绕研究方向已相继在在《北京体育大学学报》、《心理科学进展》、《中国体育科技》、《上海体育学院学报》等国内核心期刊发表论文数十篇，研究成果多次在全国体育科学大会、全国体育管理科学大会、全国运动心理学学术大会、中部心理学学术论坛、国际运动心理学大会等国内外学术会议上做口头报告与交流，合著学术专著1部（体育彩民购彩心理与行为特征研究）。作为项目主要成员参与国家社科基金项目2项，省部级项目3项。目前正在主持的研究项目有：湖北休闲体育发展研究中心开放基金课题（青少年学生体育博彩行为的心理机制研究）；湖北大学青年基金课题（青少年博彩成瘾的形成与发展机制）；武汉市体育委托课题（2014年对中小学生免费游泳开放活动第三方评估）等。 主讲课程：体育心理学、体育消费行为心理学、体育市场营销案例分析、体育市场调查与分析、体育科研方法（本科）、体育运动心理学（研究生）。"
            }
        }
    }
</script>

<style >
    .TeacherIntroduce{
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        line-height: 60px;
    }
    .TeacherContent {
        background-color: #E9EEF3;
        color: #333;
        text-align: center;
        line-height: 10px;
    }
    body > .el-container {
        margin-bottom: 40px;
    }

</style>