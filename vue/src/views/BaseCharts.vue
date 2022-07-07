<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-pie-chart"></i> schart图表
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="plugins-tips">
                最佳课程：假烟发现就跑路，臭要饭的别挡我财路：
                <a href="https://www.bilibili.com/video/BV11g411d7bW?share_source=copy_pc" target="_blank">zood</a>
            </div>
            <div class="schart-box">
                <div class="content-title">柱状图</div>
                <schart class="schart" canvasId="bar" :options="options1"></schart>
            </div>
            <div class="schart-box">
                <div class="content-title">折线图</div>
                <schart class="schart" canvasId="line" :options="options2"></schart>
            </div>
            <div class="schart-box">
                <div class="content-title">饼状图</div>
                <schart class="schart" canvasId="pie" :options="options3"></schart>
            </div>
            <div class="schart-box">
                <div class="content-title">环形图</div>
                <schart class="schart" canvasId="ring" :options="options4"></schart>
            </div>
        </div>
    </div>
</template>

<script>
import Schart from "vue-schart";
export default {
    name: "basecharts",
    components: {
        Schart,
    },
    setup() {
        const options1 = {
            type: "bar",
            title: {
                text: "最近一周各内容浏览量",
            },
            bgColor: "#fbfbfb",
            xRorate: 25,
            labels: ["周一", "周二", "周三", "周四", "周五"],
            datasets: [
                {
                    label: "课程",
                    data: [234, 278, 270, 190, 230],
                },
                {
                    label: "讲师",
                    data: [164, 178, 190, 135, 160],
                },
                {
                    label: "文章",
                    data: [144, 198, 150, 235, 120],
                },
                {
                    label: "问答",
                    data: [99, 96, 57, 124, 89],
                },
            ],
        };
        const options2 = {
            type: "line",
            title: {
                text: "最近几个月各内容学习情况",
            },
            labels: ["6月", "7月", "8月", "9月", "10月"],
            datasets: [
                {
                    label: "课程",
                    data: [960, 1024, 1360, 845, 923],
                },
                {
                    label: "讲师",
                    data: [662, 703, 600, 540, 650],
                },
                {
                    label: "文章",
                    data: [300, 500, 800, 900, 360],
                },
                {
                    label: "问答",
                    data: [400, 380, 245, 600, 390],
                },
            ],
        };
        const options3 = {
            type: "pie",
            title: {
                text: "课程浏览量饼状图",
            },
            legend: {
                position: "left",
            },
            bgColor: "#fbfbfb",
            labels: [
                "java:从入门到入土",
                "php:从入门到入土",
                "围棋:AI是怎么让",
                "c++:从入门到入土",
                "kotlin:从基础到实战",
                "vue:前端开发实战",
                "电子烟的发展史",
                "apex进阶技巧",
            ],
            datasets: [
                {
                    data: [334, 278, 190, 235, 260, 200, 141,150],
                },
            ],
        };
        const options4 = {
            type: "ring",
            title: {
                text: "各文章浏览量",
            },
            showValue: false,
            legend: {
                position: "bottom",
                bottom: 40,
            },
            bgColor: "#fbfbfb",
            labels: ["我是理塘丁真",  "鸡哥篮球速成班","滑雪教学"],
            datasets: [
                {
                    data: [300, 200, 100],
                },
            ],
        };
        return {
            options1,
            options2,
            options3,
            options4,
        };
    },
};
</script>

<style scoped>
.schart-box {
    display: inline-block;
    margin: 20px;
}
.schart {
    width: 600px;
    height: 400px;
}
.content-title {
    clear: both;
    font-weight: 400;
    line-height: 50px;
    margin: 10px 0;
    font-size: 22px;
    color: #1f2f3d;
}
</style>