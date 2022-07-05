<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 会员管理
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div style="display: flex;justify-content: space-between">
                <div class="handle-box">
                    <el-select v-model="query.address"  placeholder="搜索方式" class="handle-select mr10">
                        <el-option key="1" label="用户ID" value="用户ID"></el-option>
                        <el-option key="2" label="用户昵称" value="用户昵称"></el-option>
                    </el-select>
                    <el-input v-model="query.name" clearable   class="handle-input mr10"></el-input>
                    <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
                </div>
                <div>

                    <el-button type="primary" icon="el-icon-plus" @click="showAddUser">添加用户</el-button>
                </div>
            </div>


            <el-table :data="backUserData" border class="table" ref="multipleTable" header-cell-class-name="table-header">
                <el-table-column prop="userId" label="用户ID" width="70" align="center"></el-table-column>
                <el-table-column prop="showName" label="用户昵称" width="250" align="center"></el-table-column>
                <el-table-column prop="picImg" label="图片链接"  width="90" align="center">
                    <template #default="scope">
                        <el-image class="table-td-thumb" :src="scope.row.thumb" :preview-src-list="[scope.row.thumb]">
                        </el-image>
                    </template>
                </el-table-column>
                <el-table-column prop="sex" label="性别" width="55" align="center"></el-table-column>
                <el-table-column prop="mobile" label="手机" align="center"></el-table-column>
                <el-table-column prop="email" label="邮箱" align="center">
                </el-table-column>

                <el-table-column label="操作" width="180" align="center">
                    <template #default="scope">
                        <el-button type="text" icon="el-icon-edit" @click="handleEdit(scope.$index, scope.row)">编辑
                        </el-button>
                        <el-button type="text" icon="el-icon-delete" class="red"
                                   @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                    </template>
                </el-table-column>

            </el-table >
            <div style="display: flex;justify-content: flex-end">
                <el-pagination
                        background
                        @current-change="currentChange"
                        @size-change="sizeChange"
                        layout="sizes,prev, pager, next, jumper, ->, total"
                        :total="1000">
                </el-pagination>
            </div>

            <!--<div class="pagination">
                <el-pagination background layout="total, prev, pager, next" :current-page="query.pageIndex"
                    :page-size="query.pageSize" :total="pageTotal" @current-change="handlePageChange"></el-pagination>
            </div>-->
        </div>

        <!-- 编辑弹出框 -->
        <el-dialog title="编辑" v-model="editVisible" width="30%">
            <el-form label-width="100px"  style="width:280px;">
                <el-form-item label="用户ID">
                    <el-input v-model="form.userId"></el-input>
                </el-form-item>
                <el-form-item label="用户昵称">
                    <el-input v-model="form.showName"></el-input>
                </el-form-item>
                <el-form-item label="图片链接" style="width:380px;">
                    <el-input
                            type="textarea"
                            :rows="2"
                            placeholder="请输入内容"
                            v-model="form.picImg">
                    </el-input>
                </el-form-item>
                <el-form-item label="性别">
                    <el-radio v-model="form.sex" label="男">男</el-radio>
                    <el-radio v-model="form.sex" label="女">女</el-radio>
                </el-form-item>
                <el-form-item label="手机" style="width:300px;">
                    <el-input v-model="form.mobile"></el-input>
                </el-form-item>
                <el-form-item label="邮箱" style="width:300px;">
                    <el-input v-model="form.email"></el-input>
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
                title="添加员工"
                :visible.sync="addUserVisible"
                width="30%"
                v-model="addUserVisible">

            <el-form label-width="100px"  style="width:280px;">
                <el-form-item label="用户ID">
                    <el-input v-model="form.userId" prefix-icon="el-icon-edit"></el-input>
                </el-form-item>
                <el-form-item label="用户昵称">
                    <el-input v-model="form.showName"  prefix-icon="el-icon-edit"></el-input>
                </el-form-item>
                <el-form-item label="图片链接" style="width:380px;">
                    <el-input
                            type="textarea"
                            :rows="2"
                            placeholder="请输入内容"
                            v-model="form.picImg"
                            prefix-icon="el-icon-edit"
                    >
                    </el-input>
                </el-form-item>
                <el-form-item label="性别">
                    <el-radio v-model="form.sex" label="男">男</el-radio>
                    <el-radio v-model="form.sex" label="女">女</el-radio>
                </el-form-item>
                <el-form-item label="手机" style="width:300px;">
                    <el-input v-model="form.mobile"  prefix-icon="el-icon-edit"></el-input>
                </el-form-item>
                <el-form-item label="邮箱" style="width:300px;">
                    <el-input v-model="form.email"  prefix-icon="el-icon-edit"></el-input>
                </el-form-item>
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="addUserVisible = false">取 消</el-button>
                    <el-button type="primary" @click="addUserVisible = false">确 定</el-button>
                </span>
            </template>
        </el-dialog>
    </div>
</template>

<script>
    import { ref, reactive } from "vue";
    import { ElMessage, ElMessageBox } from "element-plus";
    import { fetchData } from "../api/index";

    import {getUserData} from '../api/article';

    export default {

        name: "user",

        data(){
            return{
                emps:[],
                loading:false,
                total:0,
                currentPage:1,
                size:10,
                radio: '1',
                addUserVisible: false
            }
        },

        methods:{
            currentChange(currentPage){
                this.currentPage=currentPage;
                this.initEmps();
            },
            sizeChange(size){
                this.size=size;
                this.initEmps();
            },
            showAddUser(){
              this.addUserVisible = true;
            },
            initEmps(){
                this.loading=true;
                this.getRequest('/queryAllUser/?currentPage='+this.currentPage+'&size='+this.size).then(resp=>{
                    this.loading=false;
                    if(resp){
                        this.emps=resp.data;
                        this.total=resp.total;
                    }
                })

            }
        },
        setup () {
            const query = reactive({
                userId: "",
                showName: "",
                picImg: "",
                sex: "",
                mobile: "",
                emile: "",
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
            const handleDelete = (index) => {
                // 二次确认删除
                ElMessageBox.confirm("确定要删除吗？", "提示", {
                    type: "warning",
                })
                    .then(() => {
                        ElMessage.success("删除成功");
                        tableData.value.splice(index, 1);
                    })
                    .catch(() => {
                    });
            };

            // 表格编辑时弹窗和保存
            const editVisible = ref(false);
            let form = reactive({
                userId: "",
                showName: "",
                picImg: "",
                sex: "",
                mobile: "",
                emile: "",
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



            let backUserData=ref()
            getUserData().then(_data => {
                backUserData.value = _data.data
            }).catch(error => {
                if (error !== 'error') {
                    ElMessage({type: 'error', message: '用户数据加载失败!', showClose: true})
                }
            }).finally(() => {
                loading.value = false
            })

            return {
                backUserData,
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
            };
        },
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
