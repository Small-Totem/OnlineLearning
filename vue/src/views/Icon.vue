<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-emoji"></i> 文章咨询管理
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div >
                <div style="display: flex;justify-content: space-between">
                    <div class="handle-box">
                        <el-select v-model="query.address" placeholder="搜索方式" class="handle-select mr10">
                            <el-option key="1" label="文章ID" value="id"></el-option>
                            <el-option key="2" label="文章作者" value="userId"></el-option>
                            <el-option key="3" label="文章标题" value="title"></el-option>
                            <el-option key="4" label="文章概要" value="summary"></el-option>
                            <el-option key="5" label="点赞数量" value="praiseCount"></el-option>
                            <el-option key="6" label="发布时间" value="publishTime"></el-option>
                        </el-select>
                        <el-input v-model="query.name" clearable   class="handle-input mr10"></el-input>
                        <el-button type="primary" icon="el-icon-search" @click="getAById(query.name)">搜索</el-button>
                    </div>
                    <div>

                        <el-button type="primary" icon="el-icon-plus" @click="showAddArticle">添加文章</el-button>
                    </div>
                </div>
            </div>


            <el-table :data="backArticleData" border class="table" ref="multipleTable" header-cell-class-name="table-header">
                <el-table-column prop="articleId" label="文章ID"  align="center"></el-table-column>
                <el-table-column prop="userId" label="文章作者" align="center"></el-table-column>
                <!--<el-table-column label="账户余额">
                    <template #default="scope">￥{{ scope.row.money }}</template>
                </el-table-column>-->
                <el-table-column prop="title" label="文章标题" align="center"></el-table-column>
                <el-table-column prop="summary" label="文章概要" align="center"></el-table-column>
                <el-table-column prop="publishTime" label="发布时间"  align="center"></el-table-column>
                <el-table-column prop="clickNum" label="点击数量" width="90" align="center"></el-table-column>
                <!--<template #default="scope">
                    <el-tag :type="
                            scope.row.state === '成功'
                                ? 'success'
                                : scope.row.state === '失败'
                                ? 'danger'
                                : ''
                        ">{{ scope.row.state }}</el-tag>
                </template>
            </el-table-column>-->

                <el-table-column prop="praiseCount" label="点赞数量" align="center"></el-table-column>
                <el-table-column label="操作" width="180" align="center">
                    <template #default="scope">
                        <el-button type="text" icon="el-icon-edit" @click="handleEdit(scope.$index, scope.row)">编辑
                        </el-button>
                        <el-button type="text" icon="el-icon-delete" class="red"
                                   @click="handleDelete(scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>

            <div style="display: flex;justify-content: flex-end">
                <el-pagination
                        background
                        @current-change="currentChange"
                        @size-change="sizeChange"
                        layout="sizes,prev, pager, next, jumper, ->, total"
                        :total="1000">
                </el-pagination>
            </div>
        </div>

        <!-- 编辑弹出框 -->
        <el-dialog title="编辑" v-model="editVisible" width="35%">
            <el-form label-width="100px" style="width:280px;">
                <el-form-item label="文章ID" >
                    <el-input id="articleId" v-model="form.articleId" prefix-icon="el-icon-edit"></el-input>
                </el-form-item>
                <el-form-item label="文章作者">
                    <el-input id="userId2" v-model="form.userId" prefix-icon="el-icon-edit"></el-input>
                </el-form-item>
                <el-form-item label="文章标题" style="width:340px;">
                    <el-input id="title2" v-model="form.title" prefix-icon="el-icon-edit"></el-input>
                </el-form-item>
                <el-form-item label="文章概要" style="width:380px;">
                    <el-input
                            id="summary2"
                            type="textarea"
                            :rows="3"
                            placeholder="请输入内容"
                            v-model="form.summary">
                    </el-input>
                </el-form-item>

                <el-form-item label="文章链接" style="width:380px;">
                    <el-input
                            id="link2"
                            type="textarea"
                            :rows="2"
                            placeholder="请输入内容"
                            v-model="form.link">
                    </el-input>
                </el-form-item>
                <el-form-item label="点击数量">
                    <el-input  id="clickNum2" v-model="form.clickNum"></el-input>
                </el-form-item>
                <el-form-item label="点赞数量">
                    <el-input id="praiseCount2" v-model="form.praiseCount" prefix-icon="el-icon-edit"></el-input>
                </el-form-item>
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="editVisible = false">取 消</el-button>
                    <el-button type="primary" @click="alter();editVisible = false">确 定</el-button>
                </span>
            </template>
        </el-dialog>


        <el-dialog
                title="添加文章"
                :visible.sync="addArticleVisible"
                width="30%"
                v-model="addArticleVisible">

            <el-form label-width="100px" style="width:280px;">
                <el-form-item label="文章作者">
                    <el-input id="userId" v-model="form.userId" prefix-icon="el-icon-edit"></el-input>
                </el-form-item>
                <el-form-item label="文章标题" style="width:340px;">
                    <el-input id="title" v-model="form.title" prefix-icon="el-icon-edit"></el-input>
                </el-form-item>
                <el-form-item label="文章概要" style="width:380px;">
                    <el-input
                            id="summary"
                            type="textarea"
                            :rows="3"
                            placeholder="请输入内容"
                            v-model="form.summary">
                    </el-input>
                </el-form-item>

                <el-form-item label="文章链接" style="width:380px;">
                    <el-input
                            id="link"
                            type="textarea"
                            :rows="2"
                            placeholder="请输入内容"
                            v-model="form.link">
                    </el-input>
                </el-form-item>
                <el-form-item label="点击数量">
                    <el-input  id="clickNum" v-model="form.clickNum"></el-input>
                </el-form-item>
                <el-form-item label="点赞数量">
                    <el-input id="praiseCount" v-model="form.praiseCount" prefix-icon="el-icon-edit"></el-input>
                </el-form-item>
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="addArticleVisible = false">取 消</el-button>
                    <el-button type="primary" @click="a();addArticleVisible = false">确 定</el-button>
                </span>
            </template>
        </el-dialog>
    </div>
</template>

<script>
    import { ref, reactive } from "vue";
    import { ElMessage, ElMessageBox } from "element-plus";
    import { fetchData } from "../api/index";
    import {time_wrap} from "../utils/time";

    import { getArticleData } from "../api/article";
    import { postaddArticle } from "../api/article";
    import {putupdateArticle} from "../api/article";

    import {getArticleById} from "../api/article";
    import {removeArticleById} from "../api/article";


    export default {
        name: "basetable",
        setup() {

            //返回给数据库的参数
            let params = reactive({
                //articleId: "",
                userId: "",
                title: "",
                summary: "",
                //publishTime: "",
                link: "",
                clickNum: "",
                praiseCount: "",
            });

            let params2 = reactive({
                articleId: "",
                userId: "",
                title: "",
                summary: "",
                //publishTime: "",
                link: "",
                clickNum: "",
                praiseCount: "",
            });

            const query = reactive({
                articleId: "",
                userId: "",
                pageIndex: 1,
                pageSize: 10,
            });
            const tableData = ref([]);
            const pageTotal = ref(0);
            // 获取表格数据
            const getData = () => {
                fetchData(query).then((res) => {
                    tableData.value = res.list;
                    pageTotal.value = res.pageTotal || 50;
                });
            };
            getData();

            // 查询操作
            const handleSearch = () => {
                query.pageIndex = 1;
                getData();
            };
            // 分页导航
            const handlePageChange = (val) => {
                query.pageIndex = val;
                getData();
            };

            // 删除操作
            const handleDelete = (row) => {
                // 二次确认删除
                ElMessageBox.confirm("确定要删除吗？", "提示", {
                    type: "warning",
                })
                    .then(() => {
                        removeAById(row.articleId);
                        ElMessage.success("删除成功");
                    })
                    .catch(() => {});
            };

            // 表格编辑时弹窗和保存
            const editVisible = ref(false);
            let form = reactive({
                articleId: "",
                userId: "",
                title: "",
                summary: "",
                publishTime: "",
                link: "",
                clickNum: "",
                praiseCount: "",
            });
            let idx = -1;
            const handleEdit = (index,row) => {
                idx = index;
                Object.keys(form).forEach((item) => {
                    form[item] = row[item];
                });
                editVisible.value = true;
            };
            const saveEdit = () => {
                editVisible.value = false;
                ElMessage.success(`修改第 ${idx + 1} 行成功`);
                Object.keys(form).forEach((item) => {
                    tableData.value[idx][item] = form[item];
                });
            };

            //修改文章
            function alter(){
                params2.articleId = document.getElementById("articleId").value;
                params2.title = document.getElementById("title2").value;
                params2.userId = document.getElementById("userId2").value;
                params2.summary = document.getElementById("summary2").value;
                params2.link = document.getElementById("link2").value;
                params2.clickNum = document.getElementById("clickNum2").value;
                params2.praiseCount = document.getElementById("praiseCount2").value;


                putupdateArticle(params2).then(data => {
                    //res.value = data.data
                    console.log(data)
                    //浏览器按f12 可以看到有success (我修改了全局设置，现在不用wrap也能正常返回东西了)
                }).catch(error => {
                    console.log(error)
                    if (error !== 'error') {
                        ElMessage({type: 'error', message: '失败!', showClose: true})
                    }
                })
            }


            //添加文章
            function a(){

                params.title = document.getElementById("title").value;
                params.userId = document.getElementById("userId").value;
                params.summary = document.getElementById("summary").value;
                params.link = document.getElementById("link").value;
                params.clickNum = document.getElementById("clickNum").value;
                params.praiseCount = document.getElementById("praiseCount").value;


                postaddArticle(params).then(data => {
                    //res.value = data.data
                    console.log(data)
                    //浏览器按f12 可以看到有success (我修改了全局设置，现在不用wrap也能正常返回东西了)
                }).catch(error => {
                    console.log(error)
                    if (error !== 'error') {
                        ElMessage({type: 'error', message: '失败!', showClose: true})
                    }
                })
            }

            //读取数据
            let backArticleData=ref()
            getArticleData().then(_data => {
                backArticleData.value = _data.data;
                for (let i=0; i<backArticleData.value.length; i++){
                    backArticleData.value[i].publishTime=time_wrap(backArticleData.value[i].publishTime);
                }
            }).catch(error => {
                if (error !== 'error') {
                    ElMessage({type: 'error', message: '文章咨询数据加载失败!', showClose: true})
                }
            })


            function getAById(id) {
                let backArticleData=ref()
                getArticleById(id).then(_data => {
                    this.backArticleData=undefined;
                    this.backArticleData=_data;
                    console.log(_data)
                }).catch(error => {
                    if (error !== 'error') {
                        ElMessage({type: 'error', message: '文章咨询数据加载失败!', showClose: true})
                    }
                })
                return{
                  backArticleData,
                };
            };
            function removeAById(id){
                let backArticleData=ref()
                removeArticleById(id).then(_data => {
                    console.log(_data)
                }).catch(error => {
                    if (error !== 'error') {
                        ElMessage({type: 'error', message: '用户数据加载失败!', showClose: true})
                    }
                })
                return{
                    backArticleData,
                };
            };

            return {
                backArticleData,
                query,
                tableData,
                pageTotal,
                editVisible,
                form,
                a,
                time_wrap,
                alter,
                handleSearch,
                handlePageChange,
                handleDelete,
                handleEdit,
                saveEdit,
                getAById,
                removeAById
            };
        },
        data() {
            return {
                pickerOptions: {
                    shortcuts: [{
                        text: '今天',
                        onClick(picker) {
                            picker.$emit('pick', new Date());
                        }
                    }, {
                        text: '昨天',
                        onClick(picker) {
                            const date = new Date();
                            date.setTime(date.getTime() - 3600 * 1000 * 24);
                            picker.$emit('pick', date);
                        }
                    }, {
                        text: '一周前',
                        onClick(picker) {
                            const date = new Date();
                            date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
                            picker.$emit('pick', date);
                        }
                    }]
                },
                createTime: '',
                updateTime: '',
                textarea: '',
                addArticleVisible:false
            };

        },
        methods:{
            showAddArticle() {
                this.addArticleVisible = true;
            }
    }
    };
</script>

<style scoped>
    .handle-box {
        margin-bottom: 20px;
    }

    .handle-select {
        width: 120px;
    }

    .handle-input {
        width: 300px;
        display: inline-block;
    }
    .table {
        width: 100%;
        font-size: 14px;
    }
    .red {
        color: #ff0000;
    }
    .mr10 {
        margin-right: 10px;
    }
    .table-td-thumb {
        display: block;
        margin: auto;
        width: 40px;
        height: 40px;
    }
</style>