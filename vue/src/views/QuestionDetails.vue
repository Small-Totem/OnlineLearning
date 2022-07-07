<template >
  <div><div style="float: left;width: 70%">
    <el-row type="flex" justify="center" >
      <el-card style="border-radius: 10px; margin-top: 20px;" shadow="hover" >
        <el-col>
          <div style="float: left;width: 100px;height: 100px">
            <div style="margin-bottom: 5px">
              <el-avatar :size="large" :src=url></el-avatar>
            </div >
            <span style="text-align: center" >{{question.userId}}</span>
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
    <el-row>
      <span style="margin-top:16px;margin-left: 200px;font-size: 30px;color: #0785fd">{{comments.length}}个回答</span>
    </el-row>
    <!--回答开始 -->
    <el-row type="flex" justify="center" v-for="comment in comments">
      <el-card style="border-radius: 10px; margin-top: 20px ;width: 810px" shadow="hover" >
        <el-col>
          <div style="float: left;width: 100px;height: 100px">
            <div style="margin-bottom: 5px">
              <el-avatar :size="large" :src=url></el-avatar>
            </div >
            <span style="text-align: center" >{{comment.userId}}</span>
          </div>
        </el-col>
        <el-col>
          <div style="float: left; margin-top: 4px"><i class="el-icon-chat-dot-round"></i></div>
          <div style=" margin-top: 60px"><i class="el-icon-edit"></i> </div>
        </el-col>
        <el-col style="width: 550px;margin-left: 10px">
          <div >
            <span >{{comment.content}}</span>
          </div>

          <div style="margin-top: 40px" >
            <span style="color: #999999">{{question.addTime}}</span>
          </div>
        </el-col>
      </el-card>
    </el-row>
  </div>
    <div style="background-color: #fff;float: right;margin-right: 150px">
      <div style="text-align: center;padding-top: 20px">
        <el-button
                type="primary"
                style="width: 300px;font-size: 18px"
                icon="el-icon-plus"
                @click="dialogFormVisible=true">
          我要回答
        </el-button>
        <el-dialog title="提问" :visible.sync="dialogFormVisible"  v-model="dialogFormVisible" :append-to-body="true" >
          <el-form :model="form">
            <el-form-item label="回答内容" :label-width="formLabelWidth">
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
        <!--todo <CardQuestion style="margin-top: 20px; border-radius: 10px" cardHeader="热门问题" :source="hotQuestions"></CardQuestion>-->
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
  </div>
</template>

<script>
import axios from "axios";
import store from "../store";
import {ElMessage} from "element-plus";
import {ref} from "vue"


export default {
  name: "QuestionDetails",
  components:{

  },

  data: function () {
    return {
      question:"",
      questionId:-1,
      comments:[],
      type_questions:[],
      hot_questions:[],
      submitFlag:"fail",
      url:"../src/assets/img/img.jpg",
      dialogFormVisible: false,
      form: {

        content: "",
      },
      formLabelWidth: '120px',
    };

  },
  created(){
    this.getData()
    this.getHotQuestionData()
  },
  activated(){ //项目使用了keep-alive,所以用activate监听才会再次刷新数据
    this.getData()
    this.getHotQuestionData()
  },
  methods:{
    getData(){
      const _this = this;
      //console.log(_this.$router.currentRoute.value.params.id)
      _this.questionId=_this.$router.currentRoute.value.params.id
      const url = 'http://localhost:8080/getQuestionById/'+_this.questionId
      axios.get(url).then(function (res) {
        _this.question=res.data
        //console.log(_this.question)
        const url = ref()
        url.value='http://localhost:8080/getUserById/'+_this.question.userId;
        axios.get(url.value).then(function (res) {
          //此处直接把userId改为showName了（只是为了显示名字）
          _this.question.userId=res.data.showName
        });
      })
      const url2 = 'http://localhost:8080/getAllQuestionCommentByQuestionId/'+_this.questionId
      axios.get(url2).then(function (res) {
        _this.comments=res.data.data
        //console.log(_this.comments.length)
        const url = ref()
        for (let i=0; i<_this.comments.length; i++){
          url.value='http://localhost:8080/getUserById/'+_this.comments[i].userId;
          axios.get(url.value).then(function (res) {
            //此处直接把userId改为showName了（只是为了显示名字）
            _this.comments[i].userId=res.data.showName
          });
        }
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
      const url = "http://localhost:8080/addQuesCom"
      const queryInfo = new URLSearchParams() ;
      queryInfo.append("content",_this.form.content)
      queryInfo.append("replyCount",0)
      queryInfo.append("isBest",0)
      queryInfo.append("userId",store.state.userId)
      queryInfo.append("questionId", _this.questionId)

      if(_this.form.content==="" ) {
        ElMessage({type: 'error', message: '内容不能为空!', showClose: true})
      }else {
        axios.post(url, queryInfo).then(function (res) {
          //处理回传数据
          _this.submitFlag = res.data
          if (_this.submitFlag === "success") {
            ElMessage({type: 'success', message: '提交成功!', showClose: true})
            _this.dialogFormVisible=false
            _this.$router.go(0)
          } else {
            ElMessage({type: 'error', message: '提交失败!', showClose: true})
          }
        })
      }
    },
  }
}




</script>

<style scoped>

</style>
