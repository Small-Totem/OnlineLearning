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
            /* fixme 注意 这个组件有大bug:
            * 当用router.push进这个页面时，没有问题
            * 但是如果刷新页面，就会有东西undefined
            * 没想明白哪有问题，暂时解决不了
            * router.push进页面似乎也有问题，只是（猜测）延迟使得undefined被加载完成，所以看起来没问题*/

            const router = useRouter();

            const url = 'http://localhost:8080/getArticle/'+router.currentRoute.value.params.id;
            const article=ref()
            axios.get(url).then( res => {
                article.value = res.data
            }).catch(error => {
                if (error !== 'error') {
                    ElMessage({type: 'error', message: '加载失败!', showClose: true})
                }
            })

            return{
                article,
                CardArticleDetail
            }
        },
    }
</script>

<style scoped>

</style>
