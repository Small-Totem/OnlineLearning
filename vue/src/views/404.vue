<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-warn"></i> 问答管理
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div >
                <div style="display: flex;justify-content: space-between">
                    <div class="handle-box">
                        <el-select v-model="query.address" placeholder="搜索方式" class="handle-select mr10">
                            <el-option key="1" label="问答ID" value="id"></el-option>
                            <el-option key="2" label="提问者ID" value="userId"></el-option>
                            <el-option key="3" label="标题" value="title"></el-option>
                            <el-option key="4" label="类型" value="type"></el-option>
                            <el-option key="5" label="状态" value="status"></el-option>
                            <el-option key="6" label="添加时间" value="addTime"></el-option>
                            <el-option key="7" label="内容" value="content"></el-option>
                        </el-select>
                        <el-input v-model="query.name" clearable   class="handle-input mr10"></el-input>
                        <el-button type="primary" icon="el-icon-search" @click="getQById(query.name)">搜索</el-button>
                    </div>
                    <div>

                        <el-button type="primary" icon="el-icon-plus" @click="showAddQuestion">添加问答</el-button>
                    </div>
                </div>
            </div>





            <el-table :data="backQuestionData" border class="table" ref="multipleTable" header-cell-class-name="table-header" >
                <el-table-column prop="id" label="问答ID" width="70" align="center"></el-table-column>
                <el-table-column prop="userId" label="提问者ID" width="80" align="center"></el-table-column>
                <el-table-column prop="title" label="标题" width="210" align="center"></el-table-column>
                <el-table-column prop="type" label="类型" align="center"></el-table-column>
                <el-table-column prop="content" label="内容" width="210" align="center"></el-table-column>
                <el-table-column prop="status" label="状态" width="80" align="center"></el-table-column>
                <el-table-column prop="replyCount" label="回复数量" width="80" align="center"></el-table-column>
                <el-table-column prop="browseCount" label="浏览数量" width="80" align="center"></el-table-column>
                <el-table-column prop="praiseCount" label="点赞数量" width="80" align="center"></el-table-column>
                <el-table-column prop="addTime" label="添加时间" width="180" align="center"></el-table-column>
                <el-table-column label="操作" width="180" align="center">
                    <template #default="scope">
                        <el-button type="text" icon="el-icon-edit" @click="handleEdit(scope.$index, scope.row)">编辑
                        </el-button>
                        <el-button type="text" icon="el-icon-delete" class="red"
                                   @click="handleDelete(scope.row)">删除</el-button>
                    </template>
                </el-table-column>

                <!--  -->



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
        <el-dialog title="编辑" v-model="editVisible" width="30%">
            <el-form label-width="100px"  style="width:280px;" >
                <el-form-item label="问答ID">
                    <el-input v-model="form.id"></el-input>
                </el-form-item>
                <el-form-item label="提问者ID">
                    <el-input v-model="form.cusId"></el-input>
                </el-form-item>
                <el-form-item label="标题" style="width:380px;">
                    <el-input
                            type="textarea"
                            :rows="2"
                            placeholder="请输入内容"
                            v-model="form.title">
                    </el-input>
                </el-form-item>
                <el-form-item label="内容" style="width:380px;">
                    <el-input
                            type="textarea"
                            :rows="5"
                            placeholder="请输入内容"
                            v-model="form.content">
                    </el-input>
                </el-form-item>
                <el-form-item label="类型">
                    <el-input v-model="form.type"></el-input>
                </el-form-item>
                <el-form-item label="状态" label-width="100px">
                    <el-select v-model="form.status" placeholder="填写" class="handle-select mr10">
                        <el-option key="1" label="已回复" value="已回复"></el-option>
                        <el-option key="2" label="未回复" value="未回复"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="回复数量" style="width:200px;">
                    <el-input v-model="form.replyCount"></el-input>
                </el-form-item>
                <el-form-item label="浏览数量" style="width:200px;">
                    <el-input v-model="form.browseCount"></el-input>
                </el-form-item>
                <el-form-item label="点赞数量" style="width:200px;">
                    <el-input v-model="form.praiseCount"></el-input>
                </el-form-item>
                <el-form-item label="创建时间" >
                    <el-date-picker
                            v-model="form.addTime"
                            type="datetime"
                            placeholder="选择创建日期时间"
                            align="left"
                            :picker-options="pickerOptions"
                            style="width:200px; text-align:center">
                    </el-date-picker>
                </el-form-item>
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="editVisible = false">取 消</el-button>
                    <el-button type="primary" @click="saveEdit">确 定</el-button>
                </span>
            </template>
        </el-dialog>

        <el-dialog
                title="添加问答"
                :visible.sync="addQuestionVisible"
                width="30%"
                v-model="addQuestionVisible">

            <el-form label-width="100px"  style="width:280px;" >
                <el-form-item label="问答ID">
                    <el-input v-model="form.id" prefix-icon="el-icon-edit"></el-input>
                </el-form-item>
                <el-form-item label="提问者ID">
                    <el-input v-model="form.cusId" prefix-icon="el-icon-edit"></el-input>
                </el-form-item>
                <el-form-item label="标题" style="width:380px;">
                    <el-input
                            type="textarea"
                            :rows="2"
                            placeholder="请输入内容"
                            v-model="form.title">
                    </el-input>
                </el-form-item>
                <el-form-item label="类型">
                    <el-input v-model="form.type" prefix-icon="el-icon-edit"></el-input>
                </el-form-item>
                <el-form-item label="状态" label-width="100px">
                    <el-select v-model="form.status" placeholder="填写" class="handle-select mr10">
                        <el-option key="1" label="已回复" value="已回复"></el-option>
                        <el-option key="2" label="未回复" value="未回复"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="回复数量" style="width:200px;">
                    <el-input v-model="form.replyCount" prefix-icon="el-icon-edit"></el-input>
                </el-form-item>
                <el-form-item label="浏览数量" style="width:200px;">
                    <el-input v-model="form.browseCount" prefix-icon="el-icon-edit"></el-input>
                </el-form-item>
                <el-form-item label="点赞数量" style="width:200px;">
                    <el-input v-model="form.praiseCount" prefix-icon="el-icon-edit"></el-input>
                </el-form-item>
                <el-form-item label="创建时间" >
                    <el-date-picker
                            v-model="form.addTime"
                            type="datetime"
                            placeholder="选择创建日期时间"
                            align="left"
                            :picker-options="pickerOptions"
                            style="width:200px; text-align:center">
                    </el-date-picker>
                </el-form-item>
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="addQuestionVisible = false">取 消</el-button>
                    <el-button type="primary" @click="addQuestionVisible=false">确 定</el-button>
                </span>
            </template>
        </el-dialog>
    </div>
</template>

<script>
    import { ref, reactive } from "vue";
    import { ElMessage, ElMessageBox } from "element-plus";
    import { fetchData } from "../api/index";

    import { getQuestionData } from "../api/article";
    import {getUserById} from "../api/user";
    import {getQuestionById} from "../api/question";
    import {removeQuestionById} from "../api/question";
    export default {
        name: "baseform",
        setup() {
            const query = reactive({
                address: "",
                name: "",
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
                }).then(() => {
                        removeQById(row.id);
                        ElMessage.success("删除成功");

                    })
                    .catch(() => {});
            };

            // 表格编辑时弹窗和保存
            const editVisible = ref(false);
            let form = reactive({
                name: "",
                address: "",
            });
            let idx = -1;
            const handleEdit = (index, row) => {
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

            let backQuestionData=ref()
            getQuestionData().then(_data => {
                backQuestionData.value = _data.data
            }).catch(error => {
                if (error !== 'error') {
                    ElMessage({type: 'error', message: '问答数据加载失败!', showClose: true})
                }
            })
            function  getQById(id){
                let backQuestionData=ref()
                getQuestionById(id).then(_data=>{
                    this.backQuestionData=undefined;
                    this.backQuestionData=_data;
                    console.log(_data)
                }).catch(error=>{
                    if(error!=='error'){
                        ElMessage({type: 'error', message: '问答数据加载失败!', showClose: true})
                    }
                })
                return{
                    backQuestionData,
                };
            };
            function removeQById(id){
                let backQuestionData=ref()
                removeQuestionById(id).then(_data => {
                    console.log(_data)
                }).catch(error => {
                    if (error !== 'error') {
                        ElMessage({type: 'error', message: '用户数据加载失败!', showClose: true})
                    }
                })
                return{
                    backQuestionData,
                };
            };

            return {
                backQuestionData,
                query,
                tableData,
                pageTotal,
                editVisible,
                form,
                handleSearch,
                handlePageChange,
                handleDelete,
                handleEdit,
                saveEdit,
                getQById,
                removeQById
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
                addTime: '',
                addQuestionVisible:false
            };
        },
        methods:{
            showAddQuestion(){
                this.addQuestionVisible=true;
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
