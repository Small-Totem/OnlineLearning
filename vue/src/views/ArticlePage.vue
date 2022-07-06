<template>
    <div class="mainbox">
        <el-row type="flex" justify="center">
            <el-col :span="20">
                <div style="width: 70%;background-color: #fff;padding: 10px 20px;float: left;">
                    <el-row v-for="article in articles">
                        <el-card style="border-radius: 10px; margin-top: 8px;cursor:pointer" shadow="hover" class="box-card"
                                 @click.native="toDetails(article.articleId)">
                            <el-col>
                                <div style="float: left;width: 100px;height: 100px">
                                    <div style="margin-bottom: 5px">
                                        <el-avatar :size="large" :src=url></el-avatar>
                                    </div >
                                    <span style="margin-left: 15px" >{{article.userId}}</span>
                                </div>
                            </el-col>

                            <el-col>
                                <div style="margin-top: 4px" ><i class="el-icon-collection-tag"></i></div>
                                <div style="float: left; margin-top: 10px"><i class="el-icon-chat-dot-round"></i></div>
                                <div style=" margin-top: 40px"><i class="el-icon-edit"></i> </div>
                            </el-col>
                            <el-col style="width: 550px;margin-left: 10px">
                                <div >
                                    <span style="color: #20a0ff" >{{article.title}}</span>
                                </div>
                                <div style="margin-top: 10px" >
                                    <span >{{article.summary}}</span>
                                </div>
                                <div style="margin-top: 10px" >
                                    <span style="color: #999999">{{article.publishTime}}</span>
                                </div>
                            </el-col>
                            <el-col>
                                <div style="text-align: center ">
                                    <span >{{ article.praiseCount }}</span>
                                </div>
                                <div style="margin-top: 30px">
                                    <i style="color: #adadad" class="el-icon-lx-like"> 点赞数</i>
                                </div>
                            </el-col>
                            <el-col style="float: right">
                                <div style="text-align: center ">
                                    <span>{{ article.clickNum }}</span>
                                </div>
                                <div style="margin-top: 30px">
                                    <i style="color: #adadad" class="el-icon-lx-attention"> 浏览数</i>
                                </div>
                            </el-col>

                        </el-card>
                    </el-row>
                </div>
                <div style="width: 300px;background-color: #fff;float: right">
                    <div style="width: 10px;text-align: center;padding-top: 20px">
                        <el-button
                                type="primary"
                                style="width: 300px;font-size: 18px"
                                icon="el-icon-plus"
                                @click="dialogFormVisible=true">
                            发表文章
                        </el-button>
                        <el-dialog title="发表文章" :visible.sync="dialogFormVisible" v-model="dialogFormVisible" :append-to-body="true" >
                            <el-form :model="form">
                                <el-form-item label="文章标题" :label-width="formLabelWidth">
                                    <el-input v-model="form.title" autocomplete="off"></el-input>
                                </el-form-item>
                                <el-form-item label="文章摘要" :label-width="formLabelWidth">
                                    <el-input v-model="form.summary" autocomplete="off"></el-input>
                                </el-form-item>
                                <el-form-item label="文章内容" :label-width="formLabelWidth" >
                                    <el-input v-model="form.content" type="textarea" :rows="6" autocomplete="off"></el-input>
                                </el-form-item>
                            </el-form>
                            <div slot="footer" class="dialog-footer">
                                <el-button @click="dialogFormVisible = false" style="margin-left: 250px">取 消</el-button>
                                <el-button type="primary" @click="submitForm">确 定</el-button>
                            </div>
                        </el-dialog>
                    </div>
                    <div>
                        <CardArticle style="margin-top: 20px; border-radius: 10px" cardHeader="热门文章" :source="hotArticles"></CardArticle>
                    </div>
                </div>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    import axios from "axios";
    import store from '../store'
    import {ElMessage} from "element-plus";
    import {getHotArticles} from "../api/article";
    import {ref} from "vue"
    import CardArticle from "../components/card/CardArticle.vue";

    export default {
        name: "Question",
        components:{
            CardArticle
        },
        setup(){
            let hotArticles=ref()
            getHotArticles().then(data => {
                hotArticles.value = data.data
            }).catch(error => {
                if (error !== 'error') {
                    ElMessage({type: 'error', message: '加载失败!', showClose: true})
                }
            })
            return  {
                hotArticles,
                submitFlag:"fail",
                url:"../src/assets/img/img.jpg",
                formLabelWidth: '120px',
            }
        },

        data(){
            return{
                form: {
                    title: "",
                    content: "",
                    summary: ""
                },
                articles:[],
                dialogFormVisible: false
            }
        },


        created() {
            this.getArticleData()

        },
        methods: {
            getArticleData() {
                const _this = this;
                const url = 'http://localhost:8080/queryAllArticle'
                axios.get(url).then(function (res) {
                    _this.articles = res.data.data;
                    //console.log(_this.articles)
                })
            },

            submitForm() {
                const _this = this;
                const url = "http://localhost:8080/addArticle"
                const queryInfo = new URLSearchParams();
                queryInfo.append("title", _this.form.title)
                queryInfo.append("content", _this.form.content)
                queryInfo.append("summary", _this.form.summary)
                queryInfo.append("clickNum", 0)
                queryInfo.append("praiseCount", 0)
                queryInfo.append("userId", store.state.userId)
                if (_this.form.title === "" || _this.form.summary === "" || _this.form.content === "") {
                    ElMessage({type: 'error', message: '输入不能为空!', showClose: true})
                } else {
                    axios.post(url, queryInfo).then(function (res) {
                        //处理回传数据
                        _this.submitFlag = res.data
                        if (_this.submitFlag === "success") {
                            ElMessage({type: 'success', message: '提交成功!', showClose: true})
                            _this.dialogFormVisible = false
                        } else {
                            ElMessage({type: 'error', message: '提交失败!', showClose: true})
                        }
                    })
                }
            },
            toDetails(id){
                const _this = this;
                _this.$router.push('/ArticleDetails/'+id)
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
