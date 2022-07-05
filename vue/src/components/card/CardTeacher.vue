<template>
    <el-card style="cursor:pointer" @click="course(2)" :body-style="{ padding: '0px' }" shadow="hover" class="card_teacher"  >
        <div class="_img">
            <img src="../../assets/img/course2.png" width="280"/>
        </div>
        <div class="card_course_name">
            {{teacher_name}}
        </div>
        <div class="card_course_education">
            {{teacher_education}}
        </div>
        <div class="card_course_career">
            {{teacher_career}}
        </div>
        <div class="card_course_info">
            {{teacher_description}}
        </div>
    </el-card>
</template>

<script>
    export default {
        name: "CardTeacher",
        props: {
            teacher_name: {
                type: String,
                required: true
            },
            teacher_education: {
                type: String,
                required: true
            },
            teacher_career: {
                type: String,
                required: true
            },
            teacher_description: {
                type: String,
                required: true
            },
            link: {
                type: String,
                required: true
            },
            teacher_id:{
                type: Number,
                required:true
            }
        },setup() {
            const router = useRouter();

            function teacher(id) {
                router.push("/teacher/" + id)
            }

            return {
                teacher,
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
    .card_course_info,.card_course_name,.card_course_education,.card_course_career{
        text-align:center
    }
    .card_teacher{
        margin: 10px;
    }
</style>