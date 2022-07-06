<template>
    <scroll-page :loading="loading" :no-data="noData">
        <el-col v-for="item in hotTeachers">
            <card-teacher :teacher_name=item.Name :teacher_education="item.education"
                          :teacher_career="item.career" :teacher_description="item.info" :teacher_id="item.id">
            </card-teacher>
        </el-col>
    </scroll-page>
</template>

<script>
    import ScrollPage from '../components/scrollpage/index.vue'
    import {ref,reactive} from 'vue'
    import {ElMessage} from 'element-plus'
    import CardTeacher from "../components/card/CardTeacher.vue"
    import {getHotTeachers} from "../api/teacher";
    export default {
        name: "TeacherScrollPage",
        setup(){
            const loading=ref(true)
            const noData=ref(false)

            let hotTeachers=ref()
            getHotTeachers().then(_data => {
                hotTeachers.value = _data.data
            }).catch(error => {
                if (error !== 'error') {
                    ElMessage({type: 'error', message: '讲师列表加载失败!', showClose: true})
                }
            }).finally(() => {
                loading.value = false
            })

            return {
                loading,
                noData,
                hotTeachers
            }
        },
        methods: {
            view(id) {
                this.$router.push({path: `/view/${id}`})
            }
        },
        components: {
            'card-teacher':CardTeacher,
            'scroll-page': ScrollPage,
        }
    }
</script>

<style scoped>

</style>