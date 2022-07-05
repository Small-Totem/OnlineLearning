<template>
    <div>
        <el-container>
            <el-header class="select">课程选择</el-header>
            <el-main class="content">
                学科：
                <el-radio-group v-model="radio3">
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
        name: "ArticlePage",
        data () {
            return {
                radio3: ''
            }
        }
    }
</script>

<style >
    .select{
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        line-height: 60px;
    }
    .content {
        background-color: #E9EEF3;
        color: #333;
        text-align: center;
        line-height: 160px;
    }
    body > .el-container {
        margin-bottom: 40px;
    }

</style>
