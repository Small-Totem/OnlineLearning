<template>
    <el-card style="cursor:pointer" @click="teacher(2)" :body-style="{ padding: '0px' }" shadow="hover" class="card_teacher"  >
        <div class="_img">
            <el-avatar :size="100" :src="squareUrl" ></el-avatar>
        </div>
        <div class="card_teacher_name">
            {{teacher_name}}
        </div>
        <div class="card_teacher_education">
            {{teacher_education}}
        </div>
        <div class="card_teacher_career">
            {{teacher_career}}
        </div ><br/>
        <hr width="350" size="1" align="center" color="#EBEBEB" />
        <div class="card_teacher_info">
            {{teacher_description}}
        </div>
    </el-card>
</template>

<script>
    import { useRouter } from "vue-router";
    export default {
        name: "CardTeacher",
        props: {
            teacher_name: {
                type: String
            },
            teacher_education: {
                type: String,
            },
            teacher_career: {
                type: String,
            },
            teacher_description: {
                type: String,
            },
            link: {
                type: String,
            },
            teacher_id:{
                type: Number,
            },
            squareUrl:{
                type: String,
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
        width: 350px;
        height: 500px;
        background-color: #FFFFFF;
        line-height: 30px;
    }
    .card_teacher_name{
        text-align:center;
        margin-left: 10px;
        margin-top: 10px;
        line-height: 30px;

    }
    .card_teacher_education,.card_teacher_career{
        text-align:center;
        margin-left: 10px;
        margin-top: 10px;
        line-height: 15px;
        font-size: 12px;
        color: #999999;
    }
    .card_teacher_info{
        text-align:center;
        margin-left: 10px;
        margin-top: 10px;
        line-height: 30px;
        font-size: 13px;
        color: #666666;
    }
    .card_teacher{
        margin: 20px;
    }
</style>