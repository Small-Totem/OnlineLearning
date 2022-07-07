<template>
    <div>
        <el-container>

<!--            <el-header class="select">讲师介绍</el-header>-->
            <el-main class="content">
                <br/>
                学科：
                <el-radio-group v-model="subject" @change="SelectSubject">
                    <el-radio-button label="全部"></el-radio-button>
                    <el-radio-button label="计算机科学"></el-radio-button>
                    <el-radio-button label="软件工程"></el-radio-button>
                    <el-radio-button label="大数据"></el-radio-button>
                    <el-radio-button label="人工智能"></el-radio-button>
                </el-radio-group><br/><br/>
                <scroll-page :loading="loading" :no-data="noData">
                    <el-col v-for="(item,index) in TeacherList">
                        <card-teacher :squareUrl="item.picPath" :teacher_name=item.name :teacher_education="item.education"
                                      :teacher_career="item.career" :teacher_description="item.info" :teacher_id="item.id">
                        </card-teacher>
                    </el-col>
                </scroll-page>
            </el-main>
        </el-container>
    </div>
</template>

<script>
    import ScrollPage from '../components/scrollpage/index.vue'
    import {ref,reactive} from 'vue'
    import {ElMessage} from 'element-plus'
    import CardTeacher from "../components/card/CardTeacher.vue"
    import {getHotTeachers} from "../api/teacher";
    import {getTeachersBySubject} from "../api/teacher";
    import axios from 'axios'
    export default {
        name: "TeacherPage",
        components: {
            'card-teacher':CardTeacher,
            'scroll-page': ScrollPage
        },
        data () {
            return {
                subject: '全部'
            }
        },
        setup(){
            const loading=ref(true)
            const noData=ref(false)

            let TeacherList=ref()
            getHotTeachers().then(_data => {
                TeacherList.value = _data.data
               //console.log(TeacherList);//test
            }).catch(error => {
                if (error !== 'error') {
                    ElMessage({type: 'error', message: '讲师列表加载失败!', showClose: true})
                }
            }).finally(() => {
                loading.value = false
            })

            function SelectSubject(value){
                const url = ref()
                console.log(value)
                url.value='http://localhost:8080/getTeacherBySubject/'+value
                 if(value=="全部")
                     url.value='http://localhost:8080/queryAllTeacher/'
                axios.get(url.value).then(_data =>{
                    TeacherList.value = _data.data.data
                })
            }

            return {
                loading,
                noData,
                TeacherList,
                SelectSubject
            }
        }
    }
</script>

<style >
    .select{
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        line-height: 60px;
    }
    .content {
        background-color: #F8F8F8;
        color: #333;
        text-align: center;
        line-height: 60px;
    }
    body > .el-container {
        margin-bottom: 40px;
    }
    .el-card {
        border-radius: 10px;
        margin-right: 10px;
    }

    .el-card:not(:first-child) {
        margin-top: 20px;

    }

</style>