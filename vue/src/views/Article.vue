<template>
    <div>
        <el-header class="ArticleTitle">{{article_title}}</el-header>
        <el-container>
            <el-main  class="ArticleContent" >{{article_content}}</el-main>
            <el-aside width="200px" class="ArticleAuthor">
               作者：{{article_author}}<br/>
                发布时间：{{article_publish_time}}<br/>
                点击数：{{article_click_num}}<br/>
                点赞数：{{article_praise_num}}
            </el-aside>
        </el-container>

    </div>
</template>

<script>
    export default {
        name: "Article",
        data(){
            return{
                article_title:"国产数据库乱象",
                article_content:"其实这篇文章是我周末开始写的，写这篇文章的这个周末，我的很多时候都是在思考一个数据库国产化替代的建设方案，翻阅了大量的资料。今年正好是我参加工作后的第31个年头，工作的最初十年，我写了十年代码，从汇编、COBOL到C语言，写了几十万行代码；随后的十几年，我一直在帮助用户用好数据库，也在帮助Oracle推广RAC技术；2015年开始，我一边继续从事数据库优化的工作，一边在帮助客户如何从Oracle迁移到成本更低的数据库系统上。所以对国产数据库我一直有一种十分特殊的情感，这是一种爱恨交织的情感。所以今天最后用“乱象”这个题目的时候，还是有些犹豫的，在国产数据库发展如火如荼的时候，泼这盆冷水合适不合适。\n" +
                    "\n" +
                    "根据工信部数据库发展白皮书2021的描述，截止2021年6月底，光是国产关系型数据库厂商就已经高达81家，估计马上要发布的2022版里突破100家甚至150家都是很有可能的。相对于十多年前的寥寥数家，这些年国产数据库产业的发展确实是十分迅猛，用野蛮生长来描述也不为过。这些新兴的国产数据库厂商里，也不乏具有相当强大基因，投资巨大，真正认真在做数据库产业的企业，不过大洪水下肯定也会泥沙俱下。原本就起步较晚，人才储备、资金投入都不太足够的国产数据库产业，再被割裂为这么多的细小单位，每个独立个体的真实能力就很值得怀疑了。无论是CPU，服务器，操作系统，中间件这些IT基础设施，投身于IT基础设施中的王冠的企业没想到有这么多，这不知道是中国数据库之幸还是中国数据库的灾难。\n" +
                    "\n" +
                    "上周五我在一个沙龙上分享了一些关于基于业务场景的国产数据库选型的演讲，并不是开门见山的去讨论业务场景和数据库选型，而是从对国产数据库厂商的分析开始的。这些分析都是基于工信部的产业发展白皮书的内容。",
                article_author:"马文文",
                article_publish_time:"2021-11-11",
                article_click_num:"100",
                article_praise_num:"58"
            }
        }
    }
</script>

<style>
    .ArticleTitle{
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        line-height: 60px;
    }
    .ArticleAuthor {
        background-color: #D3DCE6;
        color: #333;
        text-align: center;
        line-height: 100px;

    }
    .ArticleContent {
        background-color: #E9EEF3;
        color: #333;
        text-align: center;
        line-height: 30px;

    }
    body > .el-container {
        margin-bottom: 40px;
    }
</style>