<template>
    <div class="header">
        <div class="header-left">
            <div class="logo">在线教育平台</div>
        </div>
        <div class="search">
        <el-input
                placeholder="请输入内容"
                prefix-icon="el-icon-search"
                v-model="input">
        </el-input>
        </div>
        <div class="links">
            <router-link to="/MainPage" > 首页 </router-link>&ensp;
            <router-link to="/CoursePage"> 课程 </router-link>&ensp;
            <router-link to="/TeacherPage"> 讲师 </router-link>&ensp;
            <router-link to="/ArticlePage"> 文章 </router-link>&ensp;
            <router-link to="/QuestionPage"> 问题 </router-link>
        </div>

        <div class="header-right">
            <!-- 如果登陆了 -->
            <div v-if="role" class="header-user-con">
                <!-- 用户头像 -->
                <div class="user-avator">
                    <img src="../assets/img/img.jpg" />
                </div>
                <!-- 用户名下拉菜单 -->
                <el-dropdown class="user-name" trigger="click" @command="handleCommand">
                    <span class="el-dropdown-link">
                        {{username}}
                        <i class="el-icon-caret-bottom"></i>
                    </span>
                    <template #dropdown>
                        <el-dropdown-menu>
                            <el-dropdown-item command="user">个人中心</el-dropdown-item>
                            <el-dropdown-item command="backToMain">回到首页</el-dropdown-item>
                            <el-dropdown-item divided command="loginOut" >退出登录</el-dropdown-item>
                        </el-dropdown-menu>
                    </template>
                </el-dropdown>
            </div>
            <div v-if="!role" class="header-user-con">
                <div class="header-login">
                    <el-button @click="toLogin" size="medium" type="info">登陆/注册</el-button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import { useRouter } from "vue-router";
    export default {
        data() {
            return {
                input: ''
            }
        },
        setup() {
            const username = localStorage.getItem("ms_username");
            const message = 2;
            const role = localStorage.getItem('ms_username');
            // 用户名下拉菜单选择事件
            const router = useRouter();
            const handleCommand = (command) => {
                if (command === "loginOut") {
                    localStorage.removeItem("ms_username");
                    router.push("/");
                    router.go(0);//刷新
                } else if (command === "backToMain") {
                    router.push("/");
                }
                else if (command === "user") {
                    router.push("/user");
                }
            };

            const toLogin = () => {

              router.push('/dashboard')

            };

            return {
                username,
                message,
                handleCommand,
                role,
                toLogin
            };
        },
    };
</script>
<style scoped>
.header {
    position: relative;
    box-sizing: border-box;
    width: 100%;
    height: 70px;
    color: #fff;
    font-size: 18px;
    background-color: #0785fd;
}

.header .logo {
    float: left;
    line-height: 70px;
    font-size: 24px;
}
.header-right {
    padding-right: 20px;
    float: right;
}
.header-left {
    float: left;
    padding-left: 30px;
    padding-right: 30px;
}
.links{
    float: left;
    line-height: 70px;
    color: #ffffff;
}
.router-link-active {
    text-decoration: none;
    color: #1300ff;
}
a{
    text-decoration: none;
    color: white;
}
.search{
    float: left;
    padding-right: 20px;
    line-height: 70px;
}
.el-input {
    width: 260px;
}
.header-user-con {
    display: flex;
    height: 70px;
    align-items: center;
}
.btn-fullscreen {
    transform: rotate(45deg);
    margin-right: 5px;
    font-size: 26px;
}
.btn-fullscreen {
    position: relative;
    width: 30px;
    height: 30px;
    text-align: center;
    border-radius: 15px;
    cursor: pointer;
}
.user-name {
    margin-left: 10px;
}
.user-avator {
    margin-left: 20px;
}
.user-avator img {
    display: block;
    width: 40px;
    height: 40px;
    border-radius: 50%;
}
.el-dropdown-link {
    color: #fff;
    cursor: pointer;
}
.el-dropdown-menu__item {
    text-align: center;
}
</style>
