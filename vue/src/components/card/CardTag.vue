<template>
  <el-card  shadow="hover" :body-style="{ padding: '8px 18px' }">
    <div slot="header" class="me-tag-header">
      <span>最热标签</span>
    </div>

    <ul class="me-tag-list">
      <li class="me-tag-item" v-for="t in tags" :key="t.id">
        <!--type="primary"-->
        <el-button size="mini" type="primary" round plain>{{t.tagName}}</el-button>
      </li>
    </ul>
  </el-card>

</template>

<script>
  export default {
    name: 'CardTag',
    props: {
      tags: Array
    },
    setup(){
      return {}
    },
  }
</script>

<style scoped>

  .me-tag-header {
    font-weight: 600;
    padding-bottom: 10px;
    font-size: 22px;
  }

  .me-tag-list {
    list-style-type: none;
  }

  .me-tag-item {
    display: inline-block;
    padding: 4px;
    font-size: 14px;
    color: #5FB878;
  }

  .me-tag-item a:hover {
    text-decoration: underline;
  }
</style>
