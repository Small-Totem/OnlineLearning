<template>
    <div style="margin-top: 20px;">
        <CardTag class="course_tag" :tags="tags">
        </CardTag>
        <div style="width: 80%; margin: 10px auto">
            <course-scroll-page></course-scroll-page>
        </div>
    </div>
</template>

<script>
    import CardTag from "../components/card/CardTag.vue";
    import CourseScrollPage from "./CourseScrollPage.vue";
    export default {
        name: "CoursePage",
        components: {CourseScrollPage, CardTag},
        setup(){
            const tags=[{
                id:1,
                tagName:"全部"
            },{
                id:2,
                tagName:"电竞"
            },{
                id:3,
                tagName:"职场"
            },{
                id:4,
                tagName:"IT"
            },{
                id:5,
                tagName:"运动"
            },{
                id:6,
                tagName:"艺术"
            }]
            return {
                tags
            }
        }
    }
</script>

<style scoped>
    .course_tag{
        width: 60%;
        height: 120px;
        border-radius: 20px;
        text-align: center;
        margin: 0 auto;
    }

    .select{
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        line-height: 60px;
    }
    .content {
        background-color: #E9EEF3;
        color: #333;
        text-align: center;
        line-height: 160px;
    }
    body > .el-container {
        margin-bottom: 40px;
    }

</style>
