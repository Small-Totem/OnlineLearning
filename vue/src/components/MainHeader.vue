<template>
    <div class="header">
        <div class="header-left">
            <div class="logo">在线教育系统</div>
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
                            <el-dropdown-item divided command="loginout">退出登录</el-dropdown-item>
                        </el-dropdown-menu>
                    </template>
                </el-dropdown>
            </div>
            <div v-if="!role" class="header-user-con">
                <div class="header-login">
                    <el-button @click="toLogin" size="medium" type="info">登陆</el-button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import { useRouter } from "vue-router";
    export default {
        setup() {
            const username = localStorage.getItem("ms_username");
            const message = 2;
            const role = localStorage.getItem('ms_username');
            // 用户名下拉菜单选择事件
            const router = useRouter();
            const handleCommand = (command) => {
                if (command == "loginout") {
                    localStorage.removeItem("ms_username");
                    router.push("/");
                    router.go(0);//刷新页面
                } else if (command == "user") {
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
    font-size: 22px;
    color: #fff;
    background-color: #fd5656;
}

.header .logo {
    float: left;
    width: 250px;
    line-height: 70px;
}
.header-right {
    float: right;
    padding-right: 30px;
}
.header-left {
    float: left;
    padding-left: 30px;
}
.header-user-con {
    display: flex;
    height: 70px;
    align-items: center;
}
.btn-fullscreen {
    transform: rotate(45deg);
    margin-right: 5px;
    font-size: 24px;
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
