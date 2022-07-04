<template>
    <el-card style="cursor:pointer" @click="course(2)" :body-style="{ padding: '0px' }" shadow="hover" class="card_course"  >
        <div class="_img">
            <img src="../../assets/img/course2.png" width="280"/>
        </div>
        <div class="card_course_info">
            {{description}}
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
                required: true
            },
            link: {
                type: String,
                required: true
            },
            course_id:{
                type: Number,
                required:true
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
