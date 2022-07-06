<template>


  <el-card class="card" shadow="hover" >
    <div slot="header" class="me-category-header">
      <p style="text-align: center;font-size: 26px">{{source.title}}</p>
      <el-card style="background-color: #f0f0ff" class="card_inner" shadow="hover" >
        <p style="text-align: center;font-size: 16px; margin-bottom: 10px">简介:{{source.summary}}</p>
        <el-col :span="8">
          <i class="el-icon-lx-time">{{ source.publishTime }}</i>
        </el-col>
        <el-col style="float: right" :span="8">
          <i class="el-icon-lx-profile"> {{ source.userId }}</i>
        </el-col>
        <br/>
        <el-col :span="8">
          <i class="el-icon-lx-like">{{ source.praiseCount }}</i>
        </el-col>
        <el-col style="float: right" :span="8">
          <i class="el-icon-lx-attention"> {{ source.clickNum }}</i>
        </el-col>
      </el-card>
      <p style="text-align: left;font-size: 20px">{{source.content}}</p>
    </div>

  </el-card>

</template>

<script>
  export default {
    name: 'CardArticleDetail',
    props: {
      source: Object,
      itemStyle: Object
    },
    data() {
      return {}
    },
    methods: {
      view(id) {
        this.$router.push({path: `/articleDetails/${id}`})
      }
    }
  }
</script>

<style scoped>
  .el-card{
    border-radius: 20px;
    width: 80%;
    margin: 10px auto;
    align-content: center;
  }
  .card_inner{
    width: 60%;
    padding-bottom: 10px;
  }
</style>
