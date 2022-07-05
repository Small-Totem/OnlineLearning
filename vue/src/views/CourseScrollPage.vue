<template>
    <el-col v-for="(item,index) in hotCourses.coursesData">
      <card-course :description=item.courseName :link="item.logo"
                   :course-id="item.courseId" :teacher="hotCourses.teacherName[index]">
      </card-course>
    </el-col>
</template>

<script>
  import ScrollPage from '../components/scrollpage/index.vue'
  import {ref,reactive} from 'vue'
  import {ElMessage} from 'element-plus'
  import CardCourse from "../components/card/CardCourse.vue"
  import {getHotCourses} from "../api/course";
  import axios from 'axios'

  export default {
    name: "CourseScrollPage_Course",
    setup(){
      const loading=ref(true)
      const noData=ref(false)

      let hotCourses=reactive({
        coursesData:[],
        teacherName:[],
      })

      getHotCourses().then(_data => {
        hotCourses.coursesData = _data.data

        //循环，从每个课程的老师id获取老师名字
        const url = ref()
        for (let i=0; i<hotCourses.coursesData.length; i++){
          url.value='http://localhost:8080/getTeacher/'+hotCourses.coursesData[i].teacherId
          axios.get(url.value).then(function (res) {
            hotCourses.teacherName[i]=res.data.name
          });
        }

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
</style>
