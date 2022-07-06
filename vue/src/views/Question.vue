<template>
<div class="mainbox">
  <el-row type="flex" justify="center">
    <el-col :span="20">

  <div style="width: 70%;background-color: #fff;padding: 10px 20px;float: left;">
    <el-tabs>
      <el-tab-pane label="全部问答" >
        <el-row v-for="question in questions">
          <el-card style="border-radius: 10px; margin-top: 8px" shadow="hover" class="box-card"  @click.native="toDetails(question.id)">
            <el-col>
            <div style="float: left;width: 100px;height: 100px">
              <div style="margin-bottom: 5px">
              <el-avatar :size="large" :src=url></el-avatar>
              </div >
              <span style="margin-left: 15px" >{{question.userId}}</span>
            </div>
            </el-col>

            <el-col>
              <div style="margin-top: 4px" ><i class="el-icon-collection-tag"></i></div>
              <div style="float: left; margin-top: 10px"><i class="el-icon-chat-dot-round"></i></div>
              <div style=" margin-top: 40px"><i class="el-icon-edit"></i> </div>
            </el-col>
            <el-col style="width: 550px;margin-left: 10px">
               <div >
                   <span style="color: #20a0ff">{{question.title}}</span>

                <!-- <el-link href="http://localhost:3000/QuestionDetails/{{question.userId}}" target="_blank" style="color:#20a0ff;">{{question.title}}</el-link>-->
               </div>
               <div style="margin-top: 10px" >
                   <span >{{question.content}}</span>
            </div>
              <div style="margin-top: 10px" >
                <span style="color: #999999">{{question.addTime}}</span>
              </div>
            </el-col>
            <el-col>
            <div style="text-align: center ">
              <span style="color:#adadad">{{ question.replyCount }}</span>
            </div>
            <div style="margin-top: 30px">
              <span style="color: #adadad">{{ "回答数" }}</span>
            </div>
            </el-col>
            <el-col style="float: right">
              <div style="text-align: center ">
                <span style="color: #adadad">{{ question.browseCount }}</span>
              </div>
              <div style="margin-top: 30px">
                <span style="color: #adadad">{{ "浏览数" }}</span>
              </div>
            </el-col>

        </el-card>
        </el-row>
      </el-tab-pane>

      <el-tab-pane label="课程问答" lazy>
        <el-row v-for="tq in type_questions">
          <el-card class="box-card" @click.native="toDetails(tq.id)" >
            <el-col>
              <div style="float: left;width: 100px;height: 100px">
                <div style="margin-bottom: 5px">
                <el-avatar :size="large"  :src=url></el-avatar>
              </div>
                <span style="margin-left: 15px" >{{tq.userId}}</span>
              </div>

            </el-col>
            <el-col>
              <div style="margin-top: 4px" ><i class="el-icon-collection-tag"></i></div>
              <div style="float: left; margin-top: 10px"><i class="el-icon-chat-dot-round"></i></div>
              <div style=" margin-top: 40px"><i class="el-icon-edit"></i> </div>
            </el-col>
            <el-col style="width: 550px;margin-left: 10px">
              <div >
                <span style="color: #20a0ff">{{tq.title}}</span>
              </div>
              <div style="margin-top: 10px">
                <span >{{tq.content}}</span>
              </div>
              <div style="margin-top: 10px" >
                <span style="color: #999999">{{tq.addTime}}</span>
              </div>
            </el-col>
            <el-col>
              <div style="text-align: center ">
                <span style="color:#adadad">{{ tq.replyCount}}</span>
              </div>
              <div style="margin-top: 30px">
                <span style="color: #adadad">{{ "回答数" }}</span>
              </div>
            </el-col>
            <el-col style="float: right">
              <div style="text-align: center ">
                <span style="color: #adadad">{{ tq.browseCount  }}</span>
              </div>
              <div style="margin-top: 30px">
                <span style="color: #adadad">{{ "浏览数" }}</span>
              </div>
            </el-col>

          </el-card>
        </el-row>
      </el-tab-pane>
    </el-tabs>
  </div>
      <div style="width: 300px;background-color: #fff;float: right">
          <div style="width: 10px;text-align: center;padding-top: 20px">
            <el-button
                type="primary"
                style="width: 300px;font-size: 18px"
                icon="el-icon-plus"
                @click="dialogFormVisible=true">
              我要提问
            </el-button>
            
            <el-dialog title="提问" :visible.sync="dialogFormVisible"  v-model="dialogFormVisible" :append-to-body="true" >
              <el-form :model="form">
                <el-form-item label="问题标题" :label-width="formLabelWidth">
                  <el-input v-model="form.title" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="问题内容" :label-width="formLabelWidth">
                  <el-input v-model="form.content" autocomplete="off"  ></el-input>
                </el-form-item>
              </el-form>
              <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false" style="margin-left: 250px">取 消</el-button>
                <el-button type="primary" @click="submitForm">确 定</el-button>
              </div>
            </el-dialog>
          </div>
        <div>
          <CardQuestion style="margin-top: 20px; border-radius: 10px" cardHeader="热门问题" :source="hotQuestions"></CardQuestion>
        </div>
        <el-row v-for="q in hot_questions">
          <el-card style="width: 300px;height: 70px">
            <div style="float: left ;margin-top: 4px;margin-right: 4px">
            <i class="el-icon-collection-tag" ></i>
             </div>

            <el-link href="https://element.eleme.io" target="_blank">{{q.title}}</el-link>
            <div style="float: right">
              <span style="color: #ff876b">{{ q.replyCount }}</span>
            </div>
            <div>
              <span style="color: #adadad;float: right">{{ "回答数" }}</span>
            </div>
          </el-card>
        </el-row>
      </div>
    </el-col>
  </el-row>


</div>

</template>

<script>

import axios from "axios";
import store from '../store'
import {ElMessage} from "element-plus";
import CardQuestion from '../components/card/CardQuestion.vue'
import {getHotQuestion} from "../api/question";
import {ref} from "vue"
import {useRouter} from "_vue-router@4.0.16@vue-router";


export default {
  name: "Question",
  components:{
    CardQuestion
  },
  setup(){
    let hotQuestions=ref()
    getHotQuestion().then(data => {
      hotQuestions.value = data.data
    }).catch(error => {
      if (error !== 'error') {
        ElMessage({type: 'error', message: '加载失败!', showClose: true})
      }
    })
    return  {
      hotQuestions
    }
  },
  data: function () {
    return {
      questions:[],
      type_questions:[],
      hot_questions:[],
      submitFlag:"fail",
      url:"../src/assets/img/img.jpg",
      dialogFormVisible: false,
      form: {
        title: "",
        content: "",
      },
      formLabelWidth: '120px',
    };

    },
  created() {
    this.getQuestionData()
    this.getTypeQuestionData()
    this.getHotQuestionData()
  },

  methods:{
    getQuestionData(){
      const _this = this;
      const url = 'http://localhost:8080/queryAllQuestion'
      axios.get(url).then(function (res) {
        //console.log(res.data.data)
        _this.questions=res.data.data
        //console.log(_this.questions)
    })
  },

    getTypeQuestionData(){
      const _this = this;
      const url = "http://localhost:8080/getQuestionByType/2"
      axios.get(url).then(function (res) {
        //console.log(res.data.data)
        _this.type_questions=res.data.data

      })
    },
    getHotQuestionData(){
      const _this = this;
      const url = "http://localhost:8080/getQuestionByType/1"
      axios.get(url).then(function (res) {
        //console.log(res.data.data)
        _this.hot_questions=res.data.data
      })
    },

    submitForm(){
      const _this = this;
      const url = "http://localhost:8080/addQuestion"
      const queryInfo = new URLSearchParams() ;
      queryInfo.append("title",_this.form.title)
      queryInfo.append("content",_this.form.content)
      queryInfo.append("replyCount",0)
      queryInfo.append("browseCount",0)
      queryInfo.append("userId",store.state.userId)
      if(_this.form.title===""|| _this.form.content==="" ) {
        ElMessage({type: 'error', message: '问题标题与内容不能为空!', showClose: true})
      }else {
        axios.post(url, queryInfo).then(function (res) {
          //处理回传数据
          _this.submitFlag = res.data
          if (_this.submitFlag === "success") {
            ElMessage({type: 'success', message: '提交成功!', showClose: true})
            _this.dialogFormVisible=false

          } else {
            ElMessage({type: 'error', message: '提交失败!', showClose: true})
          }
        })
      }
    },
    toDetails(id){
      const _this = this;
      console.log("1111")
      _this.$router.push('/QuestionDetails/'+id)
    }
  }
}
</script>

<style scoped>

.mainbox{
  background-color: #ffffff;
  width:100%;
  height: 100%;
}

.box-card{
  width:100%;
}



</style>
