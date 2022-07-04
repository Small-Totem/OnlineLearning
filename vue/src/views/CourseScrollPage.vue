<template>
  <scroll-page :loading="loading" :offset="offset" :no-data="noData" v-on:load="load">
    <el-col v-for="item in data">
      <card-course :description=item.description :link="item.link">
      </card-course>
    </el-col>
  </scroll-page>
</template>

<script>
  import ScrollPage from '../components/scrollpage/index.vue'
  import {getArticles} from '../api/article.js'
  import {ref,reactive} from 'vue'
  import {ElMessage} from 'element-plus'
  import {getArticles_test} from "../api/article";
  import CardCourse from "../components/card/CardCourse.vue"

  export default {
    name: "CourseScrollPage",
    props: {
      data:{
        type: Array,
        required: true,
      }
    },
    setup(){
      const loading=ref(true)
      const noData=ref(false)
      const articles=ref()

      /*这下面这一坨暂时没用，但是先别删*/
      getArticles_test().then(data => {
        let newArticles = data.data
        console.log(newArticles)
        if (newArticles && newArticles.length > 0) {
          articles.value = articles.value.concat(newArticles)
          console.log(articles)
        } else {
          noData.value = true
        }

      }).catch(error => {
        if (error !== 'error') {
          ElMessage({type: 'error', message: '主课程加载失败!', showClose: true})
        }
      }).finally(() => {
        loading.value=false
      })

      return {
        loading,
        noData,
        articles: []
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
