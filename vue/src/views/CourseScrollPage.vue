<template>
  <scroll-page :loading="loading" :no-data="noData">
    <el-col v-for="item in hotCourses">
      <card-course :description=item.courseName :link="item.logo" :course-id="item.courseId">
      </card-course>
    </el-col>
  </scroll-page>
</template>

<script>
  import ScrollPage from '../components/scrollpage/index.vue'
  import {ref,reactive} from 'vue'
  import {ElMessage} from 'element-plus'
  import CardCourse from "../components/card/CardCourse.vue"
  import {getHotCourses} from "../api/course";

  export default {
    name: "CourseScrollPage",
    setup(){
      const loading=ref(true)
      const noData=ref(false)

      let hotCourses=ref()
      getHotCourses().then(_data => {
        hotCourses.value = _data.data
      }).catch(error => {
        if (error !== 'error') {
          ElMessage({type: 'error', message: '最热课程加载失败!', showClose: true})
        }
      }).finally(() => {
        loading.value = false
      })

      return {
        loading,
        noData,
        hotCourses
      }
    },
    methods: {
      view(id) {
        this.$router.push({path: `/view/${id}`})
      }
    },
    components: {
      'card-course':CardCourse,
      'scroll-page': ScrollPage,
    }
  }
</script>

<style scoped>
  .el-card {
    border-radius: 10px;
  }

  .el-card:not(:first-child) {
    margin-top: 10px;
  }
</style>
