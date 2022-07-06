<template>
    <div class="login-wrap">
        <div class="ms-login">
            <div class="ms-title">登陆到在线教育系统</div>
          <el-tabs v-model="tabName" type="border-card" :stretch="true">
            <el-tab-pane label="登录" name="login">
              <el-form ref="loginForm" :model="loginForm">
                <el-form-item prop="username">
                  <el-input
                      v-model="loginForm.username"
                      type="text"
                      placeholder="请输入手机号或邮箱"
                      autocomplete="off"
                      prefix-icon="el-icon-user"
                  />
                </el-form-item>
                <el-form-item prop="password">
                  <el-input
                      v-model="loginForm.password"
                      type="password"
                      placeholder="请输入密码"
                      autocomplete="off"
                      prefix-icon="el-icon-lock"
                  />
                </el-form-item>
                <el-form-item>
                  <el-button :loading="loading" type="primary" style="width: 100%" @click="login">登  录</el-button>
                </el-form-item>
              </el-form>
            </el-tab-pane>
            <el-tab-pane label="注册" name="register">
              <el-form ref="regForm" :model="regForm">
                <el-form-item prop="username">
                  <el-input
                      v-model="regForm.username"
                      type="text"
                      placeholder="请输入手机号"
                      autocomplete="off"
                      prefix-icon="el-icon-user"
                  />
                </el-form-item>
                <el-form-item prop="password">
                  <el-input
                      v-model="regForm.password"
                      type="password"
                      placeholder="请输入密码"
                      autocomplete="off"
                      prefix-icon="el-icon-lock"
                  />
                </el-form-item>
                <el-form-item prop="checkPassword">
                  <el-input
                      v-model="regForm.confirmPassword"
                      type="password"
                      placeholder="请确认密码"
                      autocomplete="off"
                      prefix-icon="el-icon-lock"
                  />
                </el-form-item>
                <el-form-item>
                  <el-button :loading="loading" type="primary" style="width: 100%" @click="register">注  册</el-button>
                </el-form-item>
              </el-form>
            </el-tab-pane>
          </el-tabs>
        </div>
    </div>
</template>

<script>

import { ElMessage } from "element-plus";
import axios from 'axios'

export default {
  data() {
    return {
      loginFormVisible: false,
      loginForm: {
        username: '13579246810',
        password: '123abc'
      },
      regForm: {
        username: '',
        password: '',
        confirmPassword: ''
      },
      tabName: 'login',
      loading: false,
      loginflag:-1,
      registerFlag:"fail",
      regParam:{
        mobile:"",
        password:""
      },
    }
  },
  methods: {
    // 点击登录按钮
    async login() {
      const _this = this;
      const url = 'http://localhost:8080/loginVerify/'+_this.loginForm.username+'/'+_this.loginForm.password

      axios.post(url).then(function (res) {
        //处理回传数据。
        //console.log(res)
        _this.loginflag=res.data
        if(_this.loginflag === -1) {
          ElMessage({type: 'error', message: '用户名或密码错误!', showClose: true})
        }
        else{
          ElMessage({type: 'success', message: '登陆成功!', showClose: true})
          localStorage.setItem("ms_username", _this.loginForm.username);
          localStorage.setItem("userId", _this.loginflag);
          _this.$router.push('/')

        }
      });
    },
    //注册
    async register() {
      const _this = this;
      const url = 'http://localhost:8080/addUser'
      if(_this.regForm.password!=_this.regForm.confirmPassword){
        ElMessage({type: 'error', message: '两次输入的密码不一致!', showClose: true})
      }else if(_this.regForm.password===""|| _this.regForm.username===""){
        ElMessage({type: 'error', message: '用户名或密码不能为空!', showClose: true})
      }
      else {
        var queryInfo = new URLSearchParams() ;
        queryInfo.append("mobile",_this.regForm.username)
        queryInfo.append("password",_this.regForm.password)
        //console.log(queryInfo)
        axios.post(url,queryInfo).then(function (res) {
          //处理回传数据。
          _this.registerFlag=res.data
          if(_this.registerFlag ==="success"){
            ElMessage({type: 'success', message: '注册成功!', showClose: true})
            localStorage.setItem("ms_username", _this.regForm.username);
            localStorage.setItem("userId", _this.loginflag);
            _this.$router.push('/MainPage')
          }else{
            ElMessage({type: 'error', message: '服务器连接失败!', showClose: true})
          }
        })
      }
    },
  },
};
</script>

<style scoped>
.login-wrap {
    position: absolute;
    width: 100%;
    height: 100%;
    background-image: url(../assets/img/login-bg.jpg);
    background-size: 100%;
}
.ms-title {
    width: 100%;
    line-height: 50px;
    text-align: center;
    font-size: 20px;
    color: #222222;
    border-bottom: 1px solid #ddd;
    background-color: #cfe9ff;
}
.ms-login {
    position: absolute;
    left: 50%;
    top: 50%;
    width: 350px;
    margin: -190px 0 0 -175px;
    border-radius: 5px;
    background: rgba(255, 255, 255, 0.3);
    overflow: hidden;
}
.ms-content {
    padding: 30px 30px;
}

.login-btn button {
    width: 100%;
    height: 36px;
    margin-bottom: 10px;
}

</style>
