<template>
    <el-card style="cursor:pointer" @click="course(2)" :body-style="{ padding: '0px' }" shadow="hover" class="card_course"  >
        <div class="_img">
            <img :src=link width="280" height="280"/>
        </div>
        <div class="card_course_info">
            <span class="card_course_info_description">{{description}}</span>
            <div class="card_course_info_teacher">
                <i class="el-icon-lx-service"></i>
                <span >{{ teacher }}</span>
                <!--todo-->
            </div>
        </div>
    </el-card>
</template>

<script>
    import { useRouter } from "vue-router";

    export default {
        name: "CardCourse.vue",
        props: {
            description: {
                type: String,
            },
            link: {
                type: String,
            },
            teacher: {
                type: String,
            },
            courseId:{
                type: Number,
            }
        },
        setup(){
            const router = useRouter();
            function course(id) {
                router.push("/course/"+id)
            }
            return{
                course,
                router,
            };
        }
    }
</script>

<style scoped>
    .el-card{
        width: 280px;
        height: 340px;
        padding-bottom: 10px;
    }
    .card_course_info{
        margin-top: 5px;
        text-align: center;
    }
    .card_course{
        margin: 8px;
    }
    .card_course_info_teacher{
        text-align:left;
        margin-left: 10px;
        margin-top: 10px;
    }
    .card_course_info_description{
        font-size: 18px;
    }
</style>
