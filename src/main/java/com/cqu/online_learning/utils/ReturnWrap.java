package com.cqu.online_learning.utils;

/*
在前端用axios调用接口时，如果返回数据为[{...},{...},...]则会报错(后端直接返回List<xxx>时)
原因是似乎不能直接接受数组，只能接受json
所以用ReturnWrap包装一下，其结果为{"code":0,"data":[{...},{...},...]}
update:直接返回json的也要包装下。。。
*/

public class ReturnWrap {
    public ReturnWrap(Object o){
        data=o;
    }
    public int code=0;
    public Object data;
}
