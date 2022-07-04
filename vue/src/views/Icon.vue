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
                            <el-option key="2" label="文章作者" value="name"></el-option>
                            <el-option key="3" label="文章标题" value="education"></el-option>
                            <el-option key="4" label="文章概要" value="career"></el-option>
                            <el-option key="5" label="点赞数量" value="SubjectId"></el-option>
                            <el-option key="6" label="发布时间" value="updateTime"></el-option>
                        </el-select>
                        <el-input v-model="query.name" clearable   class="handle-input mr10"></el-input>
                        <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
                    </div>
                    <div>

                        <el-button type="primary" icon="el-icon-plus">添加文章</el-button>
                    </div>
                </div>
            </div>

            <el-table :data="tableData" border class="table" ref="multipleTable" header-cell-class-name="table-header">
                <el-table-column prop="articleId" label="文章ID"  align="center"></el-table-column>
                <el-table-column prop="userId" label="文章作者" align="center"></el-table-column>
                <!--<el-table-column label="账户余额">
                    <template #default="scope">￥{{ scope.row.money }}</template>
                </el-table-column>-->
                <el-table-column prop="title" label="文章标题" align="center"></el-table-column>
                <el-table-column prop="summary" label="文章概要" align="center"></el-table-column>
                <el-table-column prop="publishTime" label="发布时间"  align="center"></el-table-column>
                <el-table-column prop="link" label="文章链接" align="center"></el-table-column>
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

                <el-table-column prop="pralseCount" label="点赞数量" align="center"></el-table-column>
                <el-table-column label="操作" width="180" align="center">
                    <template #default="scope">
                        <el-button type="text" icon="el-icon-edit" @click="handleEdit(scope.$index, scope.row)">编辑
                        </el-button>
                        <el-button type="text" icon="el-icon-delete" class="red"
                                   @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="pagination">
                <el-pagination background layout="total, prev, pager, next" :current-page="query.pageIndex"
                               :page-size="query.pageSize" :total="pageTotal" @current-change="handlePageChange"></el-pagination>
            </div>
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
            <el-form label-width="100px" style="width:280px;">
                <el-form-item label="文章ID">
                    <el-input v-model="form.articleId"></el-input>
                </el-form-item>
                <el-form-item label="文章作者">
                    <el-input v-model="form.userId"></el-input>
                </el-form-item>
                <el-form-item label="文章标题" style="width:340px;">
                    <el-input v-model="form.title"></el-input>
                </el-form-item>
                <el-form-item label="文章概要" style="width:380px;">
                    <el-input
                            type="textarea"
                            :rows="3"
                            placeholder="请输入内容"
                            v-model="form.summary">
                    </el-input>
                </el-form-item>
                <el-form-item label="发布时间">
                    <el-date-picker
                            v-model="form.publishTime"
                            type="datetime"
                            placeholder="选择发布日期时间"
                            align="left"
                            :picker-options="pickerOptions"
                            style="width:200px; text-align:center">
                    </el-date-picker>
                </el-form-item>
                <el-form-item label="文章链接" style="width:380px;">
                    <el-input
                            type="textarea"
                            :rows="2"
                            placeholder="请输入内容"
                            v-model="form.link">
                    </el-input>
                </el-form-item>
                <el-form-item label="点击数量">
                    <el-input v-model="form.clickNum"></el-input>
                </el-form-item>
                <el-form-item label="点赞数量">
                    <el-input v-model="form.pralseCount"></el-input>
                </el-form-item>
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="editVisible = false">取 消</el-button>
                    <el-button type="primary" @click="saveEdit">确 定</el-button>
                </span>
            </template>
        </el-dialog>
    </div>
</template>

<script>
    import { ref, reactive } from "vue";
    import { ElMessage, ElMessageBox } from "element-plus";
    import { fetchData } from "../api/index";

    export default {
        name: "basetable",
        setup() {
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
            const handleDelete = (index) => {
                // 二次确认删除
                ElMessageBox.confirm("确定要删除吗？", "提示", {
                    type: "warning",
                })
                    .then(() => {
                        ElMessage.success("删除成功");
                        tableData.value.splice(index, 1);
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
                pralseCount: "",
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

            return {
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
                textarea: ''
            };
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