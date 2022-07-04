<template>

  <div class="MainContent">
    <el-container>

      <el-header>好课推荐</el-header>
      <el-main>
        学科：
        <el-radio-group v-model="radio1">
          <el-radio-button label="计算机科学"></el-radio-button>
          <el-radio-button label="软件工程"></el-radio-button>
          <el-radio-button label="大数据"></el-radio-button>
          <el-radio-button label="人工智能"></el-radio-button>
        </el-radio-group>
      </el-main>
    </el-container>

    <el-container>
      <br/>
      <el-header>名师推荐</el-header>
      <el-main>
        学科：
        <el-radio-group v-model="radio2">
          <el-radio-button label="计算机科学"></el-radio-button>
          <el-radio-button label="软件工程"></el-radio-button>
          <el-radio-button label="大数据"></el-radio-button>
          <el-radio-button label="人工智能"></el-radio-button>
        </el-radio-group>

        <div class="edit_delete">
<!--          <el-button-->
<!--                  type="primary"-->
<!--                  icon="el-icon-edit"-->
<!--                  class="edit_btn"-->
<!--                  @click="editItem(item.id)"-->
<!--          ></el-button>-->
<!--          <el-button-->
<!--                  type="danger"-->
<!--                  icon="el-icon-delete"-->
<!--                  class="delete_btn"-->
<!--                  style="width: 220px"-->
<!--                  @click="deleteItem"-->
<!--          ></el-button>-->

          <el-row type="flex" justify="space-around" style="height:500px;">
            <el-col :span="6" class="col-button" v-for="(item,index) in buttonList" :key="index" >
              <el-button class="link-button" style="background:url(item.backgroundUrl);height:144px;width:144px" ></el-button>
              <div>{{item.id}}</div>
              <div>{{item.name}}</div>
            </el-col>
          </el-row>
        </div>
      </el-main>
    </el-container>

    <el-container>
      <br/>
      <el-header>文章推荐</el-header>
      <el-main>
        学科：
        <el-radio-group v-model="radio3">
          <el-radio-button label="计算机科学"></el-radio-button>
          <el-radio-button label="软件工程"></el-radio-button>
          <el-radio-button label="大数据"></el-radio-button>
          <el-radio-button label="人工智能"></el-radio-button>
        </el-radio-group>
      </el-main>
    </el-container>

    <el-container>
      <br/>
      <el-header>热门问答</el-header>
      <el-main>
        学科：
        <el-radio-group v-model="radio4">
          <el-radio-button label="计算机科学"></el-radio-button>
          <el-radio-button label="软件工程"></el-radio-button>
          <el-radio-button label="大数据"></el-radio-button>
          <el-radio-button label="人工智能"></el-radio-button>
        </el-radio-group>
      </el-main>
    </el-container>
  </div>

</template>

<script>
    export default {
        name: "MainContent.vue",
        data () {
            return {
              radio1: '',
              radio2: '',
              radio3: '',
              radio4: '',
              buttonList: [
                {id: '1', name: '请假流程', backgroundUrl: '../../assets/img/logout.png', url: ''},
                {id: '2', name: '会议室', backgroundUrl: '', url: ''},
                {id: '3', name: '日志', backgroundUrl: '', url: ''},
                {id: '4', name: '员工健康码', backgroundUrl: '', url: ''}
              ]
            }
          }

    }
</script>

<style scoped>

.el-header {
  background-color: #B3C0D1;
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-main {
  background-color: #E9EEF3;
  color: #333;
  text-align: center;
  line-height: 160px;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}
.edit_btn {
  min-height: 220px;
  min-width: 220px;
  background: #e6a23c 80%;
  border: #e6a23c;
}
.delete_btn {
  min-height: 220px;
  min-width: 220px;
  margin-left: 15px !important;
  background: #f56c6c 80%;
  border: #f56c6c;
}

</style>
