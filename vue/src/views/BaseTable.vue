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
                    <el-button type="primary" icon="el-icon-search" @click="getUById(query.name)">搜索</el-button>
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
                        <el-image class="table-td-thumb" :src="scope.row.picImg" :preview-src-list="[scope.row.picImg]">
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
                                   @click="handleDelete(scope.row)">删除</el-button>
                    </template>
                </el-table-column>

            </el-table >


            <div style="display: flex;justify-content: flex-end">
                <el-pagination
                        v-model:currentPage="queryInfo.pagenum" :page-size="queryInfo.pagesize" :page-sizes="[1,2,5,10]"
                        background
                        @current-change="handleCurrentChange"
                        @size-change="handleSizesChange"
                        layout="sizes,prev, pager, next, jumper, ->, total"
                        :total="total">
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
                    <el-input id="userId" v-model="form.userId"></el-input>
                </el-form-item>
                <el-form-item label="用户昵称" prop="showName">
                    <el-input id="showName2" v-model="form.showName"  prefix-icon="el-icon-edit"></el-input>
                </el-form-item>
                <el-form-item label="图片链接" prop="picImg" style="width:380px;">
                    <el-input
                            id="picImg2"
                            type="textarea"
                            :rows="2"
                            placeholder="请输入内容"
                            v-model="form.picImg"
                            prefix-icon="el-icon-edit"
                    >
                    </el-input>
                </el-form-item>
                <el-form-item label="性别" prop="sex">
                    男 <input type="radio" name="paytype2" value="男">
                    女 <input type="radio" name="paytype2" value="女">
                </el-form-item>
                <el-form-item label="手机" prop="mobile" style="width:300px;">
                    <el-input id="mobile2" v-model="form.mobile"  prefix-icon="el-icon-edit"></el-input>
                </el-form-item>
                <el-form-item label="邮箱" prop="email" style="width:300px;">
                    <el-input id="email2" v-model="form.email"  prefix-icon="el-icon-edit"></el-input>
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
                title="添加用户"
                :visible.sync="addUserVisible"
                width="30%"
                v-model="addUserVisible">

            <el-form label-width="100px"  style="width:280px;" ref="addUserForm"
                     :model="addUserForm"
                     :rules="addUserFormRules">
                <el-form-item label="用户昵称" prop="showName">
                    <el-input id="showName" v-model="addUserForm.showName"  prefix-icon="el-icon-edit"></el-input>
                </el-form-item>
                <el-form-item label="图片链接" prop="picImg" style="width:380px;">
                    <el-input
                            id="picImg"
                            type="textarea"
                            :rows="2"
                            placeholder="请输入内容"
                            v-model="addUserForm.picImg"
                            prefix-icon="el-icon-edit"
                    >
                    </el-input>
                </el-form-item>
                <el-form-item label="性别" prop="sex">
                    男 <input type="radio" name="paytype" value="男">
                       女 <input type="radio" name="paytype" value="女">
                </el-form-item>
                <el-form-item label="手机" prop="mobile" style="width:300px;">
                    <el-input id="mobile" v-model="addUserForm.mobile"  prefix-icon="el-icon-edit"></el-input>
                </el-form-item>
                <el-form-item label="邮箱" prop="email" style="width:300px;">
                    <el-input id="email" v-model="addUserForm.email"  prefix-icon="el-icon-edit"></el-input>
                </el-form-item>
            </el-form>
            <template  #footer>
                <span slot="footer" class="dialog-footer">
                    <el-button @click="addUserVisible = false">取 消</el-button>
                    <el-button type="primary" @click="a();addUserVisible = false;">确 定</el-button>
                </span>
            </template>
        </el-dialog>
    </div>
</template>

<script>
    import { ref, reactive } from "vue";
    import { ElMessage, ElMessageBox } from "element-plus";

    import {getUserData} from '../api/article';
    import {postaddUser} from '../api/article';
    import {putupdateUser} from '../api/article';
    import {getUserById} from "../api/user";
    import {removeUserById} from "../api/user";

    export default {

        name: "user",

        data(){
            var checkuserId = (rule, value, callback) => {
                if (value==='') {
                    callback(new Error('用户ID不能为空'));
                }else{
                    if(this.addUserForm.userId!==''){
                        this.$refs.addUserForm.validateField('ok!');
                    }
                    callback();
                }
                /*
                setTimeout(() => {
                    if (!Number.isInteger(value)) {
                        callback(new Error('请输入数字值'));
                    }
                    else
                    {
                            callback();
                    }
                }, 1000);*/
            };
            /*var checkEmail = (rule,value,callback) =>{
                //验证邮箱的正则表达式
                const regEmail = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
                if(regEmail.test(value)){
                    return callback(); //合法邮箱
                }
                return callback(new Error("请输入正确的邮箱"));
            }
            var checkMobile = (rule,value,callback) =>{
                //验证手机号的正则表达式
                const regMobile = /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/;
                if(regMobile.test(value)){
                    return callback(); //合法手机号
                }
                return callback(new Error("请输入合法的手机号"));
            }*/
            return{
                //获取用户列表的参数对象
                User:{
                    userId: "",
                    showName: "",
                    picImg: "",
                    sex: "",
                    mobile: "",
                    email: "",
                    createTime:""
                },

                queryInfo: {
                    query: "",
                    pagenum: 1, //当前的页数
                    pagesize: 2, //每页的数量
                },
                userList : [],
                addUserForm: {
                    userId: "",
                    showName: "",
                    picImg: "",
                    sex: "",
                    mobile: "",
                    email: "",
                    createTime:""
                }, //添加用户的表单数据

                //添加表单的验证规则对象
                addUserFormRules: {
                    userId: [{ validator: checkuserId, trigger: 'blur' }],
                    email: [{required:true,message:'请输入邮箱',trigger:'blur'}],
                    mobile: [{required:true,message:'请输入手机号',trigger:'blur'}]
                },
                emps:[],
                loading:false,
                door:false,
                total:0,
                currentPage:1,
                size:10,
                radio: '1',
                addUserVisible: false,
                queryInfo:{
                    query:'',
                    pagenum:1,
                    pagesize:2
                },
                total:0
            }
        },
        methods:{
            currentChange(currentPage){
                this.currentPage=currentPage;
                this.initEmps();
            },

            async getUserList () {
                const { data: res } = await this.$http.get('/queryAllUser', {
                    params: this.queryInfo
                })
                if (res.meta.status !== 200) return this.$message.error('获取用户列表失败')
                this.userlist = res.data.users
                this.total = res.data.total
                console.log(res)
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
                email: "",
                pageIndex: 1,
                pageSize: 10,
            });

            let params = reactive({
                showName: "",
                picImg: "",
                sex: "",
                mobile: "",
                email: "",
                password:5431354
            });

            let params2 = reactive({
                userId:"",
                showName: "",
                picImg: "",
                sex: "",
                mobile: "",
                email: "",
                password:5431354
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
                }).then(() => {
                        removeUById(row.userId);
                        ElMessage.success("删除成功");
                        //this.backUserData.splice(index, 1)
                    })
                    .catch((error) => {
                        console.log(error)
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
                email: "",
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
/*
            const params={
                userId: 10,
                showName: "hhh",
                picImg: "644513154654",
                sex: "男",
                mobile: "3454654621",
                email: "1654541",
                password:135453321,
            }*/


             //修改用户
            function alter(){
                params2.userId = document.getElementById("userId").value;
                params2.showName = document.getElementById("showName2").value;
                params2.picImg = document.getElementById("picImg2").value;
                let temp = document.getElementsByName("paytype2");
                for(let i=0;i<temp.length;i++){
                    if(temp[i].checked){
                        params2.sex=temp[i].value;
                    }
                }
                params2.mobile = document.getElementById("mobile2").value;
                params2.email = document.getElementById("email2").value;
                putupdateUser(params2).then(data => {
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

            //添加用户
            function a(){
                params.showName = document.getElementById("showName").value;
                params.picImg = document.getElementById("picImg").value;
                let temp = document.getElementsByName("paytype");
                for(let i=0;i<temp.length;i++){
                    if(temp[i].checked){
                        params.sex=temp[i].value;
                    }
                }
                params.mobile = document.getElementById("mobile").value;
                params.email = document.getElementById("email").value;
                postaddUser(params).then(data => {
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
            let backUserData=ref()
            getUserData().then(_data => {
                backUserData.value = _data.data
            }).catch(error => {
                if (error !== 'error') {
                    ElMessage({type: 'error', message: '用户数据加载失败!', showClose: true})
                }
            })

            function getUById(id){
                let backUserData=ref()
                getUserById(id).then(_data => {
                    let temp=[_data]
                    this.backUserData=temp;
                    console.log(temp)
                }).catch(error => {
                    if (error !== 'error') {
                        ElMessage({type: 'error', message: '用户数据加载失败!', showClose: true})
                    }
                })
                return{
                    backUserData,
                };
            };
            function removeUById(id){
                let backUserData=ref()
                removeUserById(id).then(_data => {
                    console.log(_data)
                }).catch(error => {
                    if (error !== 'error') {
                        ElMessage({type: 'error', message: '用户数据加载失败!', showClose: true})
                    }
                })
                return{
                    backUserData,
                };
            };



            return {
                backUserData,
                query,
                tableData,
                pageTotal,
                editVisible,
                form,
                a,
                alter,
                handleSearch,
                handlePageChange,
                handleDelete,
                handleEdit,
                saveEdit,
                getUById,
                removeUById
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
