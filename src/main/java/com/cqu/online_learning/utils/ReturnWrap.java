package com.cqu.online_learning.utils;

/*
在前端用axios调用接口时，如果返回数据为[{...},{...},...]则会报错(后端直接返回List<xxx>时)
原因是似乎不能直接接受数组，只能接受json
所以用ReturnWrap包装一下，其结果为{"code":0,"data":[{...},{...},...]}
update:直接返回json的也要包装下。。。

update@2022.7.6:知道原因了，是因为前端axios全局拦截器拦截了不带"code"的返回值。
                现在已改为不拦截
                于是这里就成了屎山，有些wrap，有些不wrap，哈哈
*/

public class ReturnWrap {
    public ReturnWrap(Object o){
        data=o;
    }
    public int code=0;
    public Object data;
}
