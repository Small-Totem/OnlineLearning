<template>
    <CardArticleDetail :source="article">
    </CardArticleDetail>

</template>

<script>
    import axios from "axios";
    import {ElMessage} from "element-plus";
    import {ref,reactive} from "vue"
    import {useRouter} from "vue-router";
    import CardArticleDetail from "../components/card/CardArticleDetail.vue";

    export default {
        name: "ArticleDetails.vue",
        components:{
            CardArticleDetail
        },
        setup(){
            const router = useRouter();
            return{
                CardArticleDetail,
                router
            }
        },
        data(){
            return {
                article:[]
            }
        },
        created(){
            this.getArticle()
        },
        activated(){
            this.getArticle()
        },
        methods:{
            getArticle(){
                let _this=this
                const url = 'http://localhost:8080/getArticle/'+_this.$router.currentRoute.value.params.id;
                axios.get(url).then( res => {
                    _this.article = res.data

                    const url = ref()
                    url.value='http://localhost:8080/getUserById/'+_this.article.userId;
                    axios.get(url.value).then(function (res) {
                        //此处直接把userId改为showName了（只是为了显示名字）
                        _this.article.userId=res.data.showName
                    });

                }).catch(error => {
                    if (error !== 'error') {
                        ElMessage({type: 'error', message: '加载失败!', showClose: true})
                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>
