<template>
    <div>
        <el-col>
            <swiper-3-d :source="source"></swiper-3-d>
            <el-container>
                <el-main class="me-articles">
                    <Course-scroll-page></Course-scroll-page>
                </el-main>
                <el-aside>
                    <card-article cardHeader="最新文章" :source="hotArticles"></card-article>
                    <card-question cardHeader="最新提问" :source="hotQuestions"></card-question>
                </el-aside>
            </el-container>
        </el-col>
    </div>
</template>

<script>
    import Swiper3D from "../components/Swiper3D.vue";
    import CardArticle from '../components/card/CardArticle.vue'
    import CardQuestion from '../components/card/CardQuestion.vue'
    import CourseScrollPage from './CourseScrollPage.vue'
    import {ElMessage} from 'element-plus'
    import { ref } from 'vue'

    import {getHotArticles} from '../api/article'
    import {getHotQuestion} from '../api/question'

    //banner的课程暂时不从数据库拿
    const source = [
        {   //https://ke.qq.com/course/3294069#term_id=103424518
            id:1,
            pic:"https://10.idqqimg.com/qqcourse_logo_ng/ajNVdqHZLLD4rM0ljOB5KyDyDQchicdiaps3PHibuHtMTfVnmygdXhOWNhOibHIct2pmvOpJ3r5cxDI/356",
            description:"日系绘画入门课",
            link:"/course/1"
        },
        {   //https://ke.qq.com/course/230866#term_id=100272363
            id:2,
            pic:"https://10.idqqimg.com/qqcourse_logo_ng/ajNVdqHZLLDaRTUFiciaoUz5Wvp5PE4hGsZWvsaibaCA0hXrEcwxrWOdKJkUWq8OacwrdCs50tyYias/356",
            description:"java架构师实战",
            link:"/course/2"
        },
        {   //https://ke.qq.com/course/325308#term_id=100386059
            id:3,
            pic:"https://10.idqqimg.com/qqcourse_logo_ng/ajNVdqHZLLAKcyBnRvjXQojmB5oUsN8dhqAPtibpdbfootEY4UqNT1gPFGZtVhs2byEJph5JdRP4/356",
            description:"硬笔书法课程",
            link:"/course/3"
        },
        {   //https://ke.qq.com/course/3416760#term_id=103550900
            id:4,
            pic:"https://10.idqqimg.com/qqcourse_logo_ng/ajNVdqHZLLD2JGvAKkgibR2N3wnFhuRy1I2RbL6NuyVicJd5RHkhS13vUrFfF2zg9ic1vN2Nzh3eHI/356",
            description:"游戏原画公开课",
            link:"/course/4"
        },
        {   //https://ke.qq.com/course/359177#term_id=100426902
            id:5,
            pic:"https://10.idqqimg.com/qqcourse_logo_ng/ajNVdqHZLLAASuNJvb12EmiboJ6PmP2IXl5gCz3Ru2sEBZb8eovDAa7ozLr8OHaFCYyduZJLPYN0/356",
            description:"PS全案速成",
            link:"/course/5"
        },
        {   //https://ke.qq.com/course/package/30766
            id:6,
            pic:"https://10.idqqimg.com/qqcourse_logo_ng/ajNVdqHZLLDicSGQgicV6Ith5s9zAF5dK2rd2MibfPGzmauLhfE9LjLXDBRT7NzVBjRwuun2St22qk/356",
            description:"华为存储HCIA+HCIP实战",
            link:"/course/5"
        },
    ]

    export default {
        name: 'MainContent.vue',
        components: {
            'card-article': CardArticle,
            'card-question': CardQuestion,
            CourseScrollPage: CourseScrollPage,
            Swiper3D,
        },
        setup(){
            /*这里经历了太多折磨 @ref https://blog.csdn.net/wsjzzcbq/article/details/123003859*/
            let hotArticles=ref()
            getHotArticles().then(data => {
                hotArticles.value = data.data
            }).catch(error => {
                if (error !== 'error') {
                    ElMessage({type: 'error', message: '最热文章加载失败!', showClose: true})
                }
            })

            let hotQuestions=ref()
            getHotQuestion().then(data => {
                hotQuestions.value = data.data
            }).catch(error => {
                if (error !== 'error') {
                    ElMessage({type: 'error', message: '最热问题加载失败!', showClose: true})
                }
            })
            return {
                hotArticles,
                hotQuestions,
                source,
            }
        },
    }
</script>

<style scoped>

    .el-col{
        width: 100%;
    }

    .el-container {
        width: 100%;
    }

    .el-aside {
        margin: 10px;
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
