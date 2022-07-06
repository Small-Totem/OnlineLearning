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
    import { ref } from 'vue'
    import {post_param_test} from '../api/article'
    import {ElMessage} from 'element-plus'

    export default {
        name: "ArticlePage",
        setup(){


////////////////////////////////////////////////
//以下是无用代码，仅作为post带参数调用例子 todo delete this

            const params={
                userId:2,
                courseId:3
            }
            post_param_test(params).then(data => {
                //res.value = data.data
                console.log(data)
                //浏览器按f12 可以看到有success (我修改了全局设置，现在不用wrap也能正常返回东西了)
            }).catch(error => {
                console.log(error)
                if (error !== 'error') {
                    ElMessage({type: 'error', message: '失败!', showClose: true})
                }
            })
///////////////////////////////////////////////

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
