<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-calendar"></i> 课程管理
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div >
                <div style="display: flex;justify-content: space-between">
                <div class="handle-box">
                    <el-select v-model="query.address" placeholder="搜索方式" class="handle-select mr10">
                        <el-option key="1" label="课程ID" value="courseId"></el-option>
                        <el-option key="2" label="课程名称" value="courseName"></el-option>
                        <el-option key="3" label="标题" value="title"></el-option>
                        <el-option key="4" label="项目" value="subject"></el-option>
                        <el-option key="5" label="讲师ID" value="teacherId"></el-option>
                        <el-option key="6" label="添加时间" value="addTime"></el-option>
                    </el-select>
                    <el-input v-model="query.name" clearable   class="handle-input mr10"></el-input>
                    <el-button type="primary" icon="el-icon-search" @click="getCById(query.name)">搜索</el-button>
                </div>
                <div>

                    <el-button type="primary" icon="el-icon-plus" @click="showAddCourse">添加课程</el-button>
                </div>
            </div>



            </div>

            <el-table :data="backCourseData"
                      border class="table" ref="multipleTable" header-cell-class-name="table-header">
                <el-table-column prop="courseId" label="课程ID" width="70" align="center"></el-table-column>
                <el-table-column prop="courseName" label="课程名称" width="130" align="center"></el-table-column>
                <el-table-column prop="logo" label="封面LOGO"  width="100" align="center">
                    <template #default="scope">
                        <el-image class="table-td-thumb" :src="scope.row.logo" :preview-src-list="[scope.row.logo]">
                        </el-image>
                    </template>
                </el-table-column>
                <el-table-column prop="title" label="标题" width="150" align="center"></el-table-column>
                <el-table-column prop="subject" label="项目" width="70" align="center"></el-table-column>
                <el-table-column prop="subjectLink" label="课程链接" width="70" align="center"></el-table-column>
                <el-table-column prop="teacherId" label="讲师ID" width="70" align="center"></el-table-column>
                <el-table-column prop="pageViewcount" label="浏览数量" width="80" align="center"></el-table-column>
                <el-table-column prop="addTime" label="添加时间" align="center"></el-table-column>

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
            <el-form label-width="100px" style="width:280px;">
                <el-form-item label="课程ID" >
                    <el-input v-model="form.courseId"></el-input>
                </el-form-item>
                <el-form-item label="课程名称" style="width:330px;">
                    <el-input v-model="form.courseName"></el-input>
                </el-form-item>
                <el-form-item label="标题" style="width:380px;">
                    <el-input
                            type="textarea"
                            :rows="2"
                            placeholder="请输入内容"
                            v-model="form.title">
                    </el-input>
                </el-form-item>
                <el-form-item label="logo" style="width:380px;">
                    <el-input
                            type="textarea"
                            :rows="2"
                            placeholder="请输入LOGO链接"
                            v-model="form.logo">
                    </el-input>
                </el-form-item>
                <el-form-item label="项目">
                    <el-input v-model="form.subject"></el-input>
                </el-form-item>
                <el-form-item label="课程链接" style="width:380px;">
                    <el-input
                            type="textarea"
                            :rows="2"
                            placeholder="请输入内容"
                            v-model="form.subjectLink">
                    </el-input>
                </el-form-item>
                <el-form-item label="讲师ID">
                    <el-input v-model="form.teacherId"></el-input>
                </el-form-item>
                <el-form-item label="浏览数量" style="width:200px;">
                    <el-input v-model="form.pageViewcount"></el-input>
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
                title="添加课程"
                :visible.sync="addCourseVisible"
                width="30%"
                v-model="addCourseVisible">

            <el-form label-width="100px" style="width:280px;">
                <el-form-item label="课程ID" >
                    <el-input id="courseId" v-model="form.courseId"></el-input>
                </el-form-item>
                <el-form-item  label="课程名称" style="width:330px;">
                    <el-input id="courseName" v-model="form.courseName"></el-input>
                </el-form-item>
                <el-form-item label="标题" style="width:380px;">
                    <el-input
                            id="title"
                            type="textarea"
                            :rows="2"
                            placeholder="请输入内容"
                            v-model="form.title">
                    </el-input>
                </el-form-item>
                <el-form-item label="logo" style="width:380px;">
                    <el-input
                            id="logo"
                            type="textarea"
                            :rows="2"
                            placeholder="请输入LOGO链接"
                            v-model="form.logo">
                    </el-input>
                </el-form-item>
                <el-form-item label="项目">
                    <el-input id="subject" v-model="form.subject"></el-input>
                </el-form-item>

                <el-form-item label="课程链接" style="width:380px;">
                    <el-input
                            id="subjectLink"
                            type="textarea"
                            :rows="2"
                            placeholder="请输入内容"
                            v-model="form.subjectLink">
                    </el-input>
                </el-form-item>


                    <el-upload class="upload-demo" align="center" drag action="http://jsonplaceholder.typicode.com/api/posts/" multiple>
                    <i class="el-icon-upload"></i>
                    <div class="el-upload__text">
                        将文件拖到此处，或
                        <em>点击上传</em>
                    </div>
                </el-upload>


                <el-form-item label="讲师ID">
                    <el-input id="teacherId" v-model="form.teacherId"></el-input>
                </el-form-item>
                <el-form-item label="浏览数量" style="width:200px;">
                    <el-input id="pageViewcount" v-model="form.pageViewcount" prefix-icon="el-icon-edit"></el-input>
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
                    <el-button @click="addCourseVisible = false">取 消</el-button>
                    <el-button type="primary" @click="a();addCourseVisible = false">确 定</el-button>
                </span>
            </template>

        </el-dialog>
    </div>
</template>

<script>
    import { ref, reactive } from "vue";
    import { ElMessage, ElMessageBox } from "element-plus";
    import {time_wrap} from "../utils/time";

    import {getCourseData} from "../api/article";
    import {postaddCourse} from "../api/article";

    export default {
        name: "baseform",
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
                endTime: '',
                addCourseVisible:false
            };

        },
        methods: {
            showAddCourse(){
                this.addCourseVisible =true;
            }
        },
        setup() {
            //返回给数据库的参数
            let params = reactive({
                courseId: "",
                teacherId: "",
                courseName: "",
                subject: "",
                subjectLink: "",
                title: "",
                logo: "",
                pageViewcount:""
            });

            const query = reactive({
                address: "",
                name: "",
                pageIndex: 1,
                pageSize: 10,
            });
            const tableData = ref([]);
            const pageTotal = ref(0);

            // 查询操作
            const handleSearch = () => {
                query.pageIndex = 1;
            };
            // 分页导航
            const handlePageChange = (val) => {
                query.pageIndex = val;
            };

            // 删除操作
            const handleDelete = (row) => {
                // 二次确认删除
                ElMessageBox.confirm("确定要删除吗？", "提示", {
                    type: "warning",
                })
                    .then(() => {
                        removeCById(row.courseId)
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

            //添加课程
            //添加教师
            function a(){

                params.courseId = document.getElementById("courseId").value;
                params.teacherId = document.getElementById("teacherId").value;
                params.courseName = document.getElementById("courseName").value;
                params.subject = document.getElementById("subject").value;
                params.subjectLink = document.getElementById("subjectLink").value;
                params.title = document.getElementById("title").value;
                params.logo = document.getElementById("logo").value;
                params.pageViewcount = document.getElementById("pageViewcount").value;


                postaddCourse(params).then(data => {
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
            let backCourseData=ref()
            getCourseData().then(_data => {
                backCourseData.value = _data.data;
                for (let i=0; i<backCourseData.value.length; i++){
                    backCourseData.value[i].addTime=time_wrap(backCourseData.value[i].addTime);
                }
            }).catch(error => {
                if (error !== 'error') {
                    ElMessage({type: 'error', message: '课程数据加载失败!', showClose: true})
                }
            })

            function getCById(courseId) {
                let backCourseData=ref()
                getCourseById(courseId).then(_data => {
                   this.backCourseData=undefined;
                   this.backCourseData=_data;
                }).catch(error => {
                    if (error !== 'error') {
                        ElMessage({type: 'error', message: '课程数据加载失败!', showClose: true})
                    }
                })
                return{
                    backCourseData,
                };
            };

            function removeCById(id){
                let backCourseData=ref()
                removeCourseById(id).then(_data => {
                    console.log(_data)
                }).catch(error => {
                    if (error !== 'error') {
                        ElMessage({type: 'error', message: '用户数据加载失败!', showClose: true})
                    }
                })
                return{
                    backCourseData,
                };
            };


            return {
                backCourseData,
                query,
                tableData,
                pageTotal,
                editVisible,
                form,
                a,
                time_wrap,
                handleSearch,
                handlePageChange,
                handleDelete,
                handleEdit,
                saveEdit,
                getCById,
                removeCById
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
