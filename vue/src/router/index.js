import {createRouter, createWebHashHistory, createWebHistory} from "vue-router";
import Home from "../views/Home.vue";

const routes = [
    {
        path: '/',
        redirect: '/MainPage',
        name: "MainPage",
        component: () => import("../views/MainPage.vue"),
        children: [
            {
                path: "/MainPage",
                name: "MainPageContent",
                meta: {
                    title: '首页'
                },
                component: () => import ( /* webpackChunkName: "dashboard" */ "../views/MainContent.vue")
            },{

                path: "/Course/:id",
                name: "CourseDetail",
                meta: {
                    title: '课程详情'
                },
                component: () => import ( /* webpackChunkName: "dashboard" */ "../views/Course.vue")
            },{
                path: "/CoursePage",
                name: "CoursePage",
                meta: {
                    title: '课程'
                },
                component: () => import ( /* webpackChunkName: "dashboard" */ "../views/CoursePage.vue")
            },{
                path: "/TeacherPage",
                name: "TeacherPage",
                meta: {
                title: '讲师'
                },
                component: () => import ( /* webpackChunkName: "dashboard" */ "../views/TeacherPage.vue")
            },{
                path: "/Teacher",
                name: "Teacher",
                meta: {
                title: '讲师详情'
                },
                component: () => import ( /* webpackChunkName: "dashboard" */ "../views/Teacher.vue")
            },{
                path: "/ArticlePage",
                name: "ArticlePage",
                meta: {
                title: '文章'
                },
                component: () => import ( /* webpackChunkName: "dashboard" */ "../views/ArticlePage.vue")
            },{
                path: "/Article",
                name: "Article",
                meta: {
                title: '文章详情'
                },
                component: () => import ( /* webpackChunkName: "dashboard" */ "../views/Article.vue")
            },{
                path: "/QuestionPage",
                name: "QuestionPage",
                meta: {
                    title: '问答'
                },
                component: () => import ( /* webpackChunkName: "dashboard" */ "../views/Question.vue")
            },
        ]
    },
    {
        path: "/",
        name: "Home",
        component: Home,
        children: [
            {
                path: "/dashboard",
                name: "dashboard",
                meta: {
                    title: '系统首页'
                },
                component: () => import ( /* webpackChunkName: "dashboard" */ "../views/Dashboard.vue")
            }, {
                path: "/table",
                name: "basetable",
                meta: {
                    title: '表格'
                },
                component: () => import ( /* webpackChunkName: "table" */ "../views/BaseTable.vue")
            }, {
                path: "/charts",
                name: "basecharts",
                meta: {
                    title: '图表'
                },
                component: () => import ( /* webpackChunkName: "charts" */ "../views/BaseCharts.vue")
            }, {
                path: "/form",
                name: "baseform",
                meta: {
                    title: '表单'
                },
                component: () => import ( /* webpackChunkName: "form" */ "../views/BaseForm.vue")
            }, {
                path: "/tabs",
                name: "tabs",
                meta: {
                    title: 'tab标签'
                },
                component: () => import ( /* webpackChunkName: "tabs" */ "../views/Tabs.vue")
            }, {
                path: "/permission",
                name: "permission",
                meta: {
                    title: '权限管理',
                    permission: true
                },
                component: () => import ( /* webpackChunkName: "permission" */ "../views/Permission.vue")
            }, {
                path: "/upload",
                name: "upload",
                meta: {
                    title: '上传插件'
                },
                component: () => import ( /* webpackChunkName: "upload" */ "../views/Upload.vue")
            }, {
                path: "/icon",
                name: "icon",
                meta: {
                    title: '自定义图标'
                },
                component: () => import ( /* webpackChunkName: "icon" */ "../views/Icon.vue")
            }, {
                path: '/table1',
                name: '404',
                meta: {
                    title: '找不到页面'
                },
                component: () => import (/* webpackChunkName: "404" */ '../views/404.vue')
            }, {
                path: '/403',
                name: '403',
                meta: {
                    title: '没有权限'
                },
                component: () => import (/* webpackChunkName: "403" */ '../views/403.vue')
            }, {
                path: '/user',
                name: 'user',
                meta: {
                    title: '个人中心'
                },
                component: () => import (/* webpackChunkName: "user" */ '../views/User.vue')
            }, {
                path: '/editor',
                name: 'editor',
                meta: {
                    title: '富文本编辑器'
                },
                component: () => import (/* webpackChunkName: "editor" */ '../views/Editor.vue')
            }
        ]
    },
    {
        path: "/login",
        name: "Login",
        meta: {
            title: '登录'
        },
        component: () => import ( /* webpackChunkName: "login" */ "../views/Login.vue")
    }
];

const router = createRouter({
    //用hash模式还是history模式,如果用hash模式的话,url会是这样:localhost:3000/#/dashboard
    //history: createWebHashHistory(),
    history: createWebHistory(),
    routes
});

router.beforeEach((to, from, next) => {
    document.title = `${to.meta.title} | 在线教育系统`;
    const role = localStorage.getItem('ms_username');
    if (!role && to.path !== '/login' && to.path !== '/'&& to.path !== '/MainPage') {
        //没有登陆且访问了非主页面则跳转登陆
        next('/login');
    } else if (to.meta.permission) {
        // 如果是管理员权限则可进入
        role === 'admin'
            ? next()
            : next('/403');
    } else {
        next();
    }
});

export default router;
