<template>
  <el-card  shadow="hover" :body-style="{ padding: '8px 18px' }">
    <div slot="header" class="me-tag-header">
      <span>最热标签</span>
    </div>

    <ul class="me-tag-list">
      <li class="me-tag-item" v-for="t in tags" :key="t.id">
        <!--type="primary"-->
        <el-button size="mini" @click="onButton(t.tagName)" :autofocus="true" type="primary" round plain>{{t.tagName}}</el-button>
      </li>
    </ul>
  </el-card>

</template>

<script>
  export default {
    name: 'CardTag',
    props: {
      tags: Array,
      getFilter :{
        type: Function
      }
    },
    setup(props,context){
      function onButton(filter) {
        props.getFilter(filter)
      }
      return {
        onButton
      }
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
