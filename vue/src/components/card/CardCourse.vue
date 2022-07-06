<template>
    <el-card style="cursor:pointer" @click="course(courseId)" :body-style="{ padding: '0px' }"
             shadow="hover" class="card_course" v-if="currFilter===subject || currFilter==='null'">
        <div class="_img" >
            <img :src=link width="280" height="280"/>
        </div>
        <div class="card_course_info">
            <span class="card_course_info_description">{{ description }}</span>
            <div class="card_course_info_teacher">
                <el-col :span="8">
                    <i class="el-icon-lx-service">{{ teacher }}</i>
                </el-col>
                <el-col style="float: right" :span="8">
                    <i class="el-icon-lx-tag">{{ subject }}</i>
                </el-col>
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
            },
            subject:{
                type: String,
            },
            currFilter: {
                type: String,
            }
        },
        setup(props,context){
            const router = useRouter();
            //console.log(props.currFilter)

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
        margin-right: 10px;
        margin-top: 10px;
    }
    .card_course_info_description{
        font-size: 18px;
    }
</style>
