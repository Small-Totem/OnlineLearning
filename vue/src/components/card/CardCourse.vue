<template>
    <el-card :body-style="{ padding: '0px' }" shadow="hover" class="card_course"  >
        <div class="_img">
            <img src="../../assets/img/course2.png" width="280"/>
        </div>
        <div class="card_course_info">
            {{description}}
        </div>
    </el-card>
</template>

<script>
    export default {
        name: "CardCourse.vue",
        props: {
            description: {
                type: String,
                required: true
            },
            link: {
                type: String,
                required: true
            },
        }
    }
</script>

<style scoped>
    .el-card{
        width: 280px;
        height: 320px;
    }
    ._img{

    }
    .card_course_info{
        text-align:center
    }
    .card_course{
        margin: 10px;
    }
</style>
