<template>
    <div>
        <el-col>
            <swiper-3-d :source="source"></swiper-3-d>
            <el-container>
                <el-main class="me-articles">
                    <Course-scroll-page :data="courseList"></Course-scroll-page>
                </el-main>
                <el-aside>
                    <card-article cardHeader="最热课程" :articles="hotArticles"></card-article>
                    <card-archive cardHeader="最新讨论" :archives="archives"></card-archive>
                    <card-article cardHeader="最新文章" :articles="hotArticles"></card-article>
                </el-aside>
            </el-container>
        </el-col>
    </div>
</template>

<script>
    import Swiper3D from "../components/Swiper3D.vue";
    import CardArticle from '../components/card/CardArticle.vue'
    import CourseScrollPage from './CourseScrollPage.vue'
    import {ElMessage} from 'element-plus'
    import { ref } from 'vue'

    import {getHotArtices} from '../api/article'
    //import {getHotTags} from '@/api/tag'
    //import {listArchives} from '@/api/article'

    const source = [
        {
            id:1,
            pic:require("../assets/img/course1.png"),
            description:"课程介绍1",
            link:"/course/1"
        },
        {
            id:2,
            pic:require("../assets/img/course2.png"),
            description:"课程2",
            link:"/course/2"
        }
    ]

    export default {
        name: 'MainContent.vue',
        components: {
            'card-article': CardArticle,
            CourseScrollPage: CourseScrollPage,
            Swiper3D,
        },
        setup(){

            const courseList = [
                {
                    courseId:1,
                    description:"courseA",
                    link:"/course/1",
                },
                {
                    courseId:2,
                    description:"courseB",
                    link:"/course/2",
                },
                {
                    courseId:3,
                    description:"courseC",
                    link:"/course/3",
                },
                {
                    courseId:4,
                    description:"courseD",
                    link:"/course/4",
                },
            ]

            /*这里经历了太多折磨 @ref https://blog.csdn.net/wsjzzcbq/article/details/123003859*/
            let hotArticles=ref()
            getHotArtices().then(data => {
                //console.log("success!")
                //console.log(data.data)
                hotArticles.value = data.data
            }).catch(error => {
                if (error !== 'error') {
                    //console.log(error)
                    ElMessage({type: 'error', message: '最热文章加载失败!', showClose: true})
                }
            })
            return {
                hotArticles,
                source,
                courseList,
            }
        },
    }
</script>

<style scoped>

    .el-col{
        width: 100%;
    }
    .el-row {
        margin-bottom: 20px;
    }


    .el-container {
        width: 100%;
    }

    .el-aside {
        margin-left: 20px;
        margin-top: 20px;
        width: 260px;
    }

    .el-main {
        padding: 0px;
        line-height: 16px;
    }

    .el-card {
        border-radius: 10px;
        margin-right: 10px;
    }

    .el-card:not(:first-child) {
        margin-top: 20px;

    }


</style>
