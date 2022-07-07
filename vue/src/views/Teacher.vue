<template>
        <el-card style="cursor:pointer" :body-style="{ padding: '0px' }" shadow="hover" class="card_teacherDetail" >
            <div class="_img" align="center">
                <el-avatar :size="200" :src="teacher.picPath" ></el-avatar>
            </div>
            <div class="teacher_name">
                {{teacher.name }}
            </div>
            <div class="teacher_education">
                {{teacher.education}}
            </div>
            <div class="teacher_career">
                {{teacher.career}}
            </div ><br/>
            <div class="teacher_info">
                {{teacher.info}}
            </div>
        </el-card>
</template>

<script>
    import { useRouter } from "vue-router";
    import {ref,reactive} from 'vue'
    import axios from 'axios'
    export default {
        name: "CardTeacher",
       setup() {

           const router = useRouter();

            return {
                router
            }
        },
        data(){
            return {
                teacher:[]
            }
        },
        created(){
            this.getTeacher()
        },
        activated(){
            this.getTeacher()
        },
        methods:{
            getTeacher(){
                let _this=this
                const url = 'http://localhost:8080/getTeacher/'+_this.$router.currentRoute.value.params.id;
                axios.get(url).then( res => {
                    _this.teacher = res.data
                }).catch(error => {
                    if (error !== 'error') {
                        ElMessage({type: 'error', message: '加载失败!', showClose: true})
                    }
                })
            }
        }
    }
</script>

<style scoped>
    .teacher_name{
        text-align:center;
        margin-top: 10px;
        line-height: 30px;
        font-size: 17px;
    }
    .teacher_education,.teacher_career{
        text-align:center;
        margin-top: 10px;
        line-height: 15px;
        font-size: 15px;
        color: #999999;
    }
    .teacher_info{
        text-align:center;
        margin-top: 10px;
        line-height: 30px;
        font-size: 20px;
        color: #666666;
    }
    .card_teacherDetail{
        margin: 20px;
    }
</style>